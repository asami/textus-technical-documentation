# Textus/CNCF Security Architecture — Technical Guide

Status: Initial Edition
Language: ja
Document: textus-cncf-security-architecture

## 1. Security as a First-Class Architectural Concern

Textus/CNCFでは、セキュリティをアプリケーション実装の後から追加する機能として扱わない。セキュリティは、システムの構造、権限、信頼境界、実行境界、配布単位、運用方式を決めるアーキテクチャ段階からの第一級要素である。

認証、WAF、脆弱性検査、暗号化、レビューはいずれも重要である。しかし、それらだけでは「侵害された処理が何にアクセスできるか」「誤ったコードがどこまで影響できるか」「AIが誤判断したとき何を実行できるか」というシステムの基本的な強度は決まらない。

Textus/CNCFは、悪意ある攻撃、ソフトウェアの欠陥、運用ミス、AIによる誤判断を異なる原因として区別しつつ、それらが同じauthority boundaryを越えようとする問題として統一的に扱う。

中核となる考え方は次の四つである。

- CBD: authorityとblast radiusをComponent境界で分割する。
- Model Driven: authorityと制約をモデル化し、安全な構造へ投影する。
- Safety Sandbox: 実行時に与えられたauthorityとresource limitを強制する。
- CAR: 生成された境界を検査可能なimmutable artifactへ固定する。

これらにTier Architecture、Capability/Guard、ExecutionContext、Function First、AuthHandle、immutable runtime、lint/review/admission、observabilityを組み合わせる。

## 2. Security-oriented Component-Based Development

CBDの価値を再利用性やモジュール性だけに限定しない。Textus/CNCFではComponentをauthorityを分割する単位として利用する。

Componentは公開するOperation、必要とする外部機能、利用可能なCapability、依存Component、永続化境界を明示する。あるComponentが侵害されても、それだけを理由に無関係なDomain、DataStore、filesystem、process、networkへのauthorityを取得してはならない。

Component間連携は明示されたProvided/Required契約を通る。内部実装へ直接到達することを通常経路にしない。依存関係そのものがreview/lint/admissionの対象になる。

Securityの目的は「侵害が絶対に起こらない」と仮定することではない。侵害、バグ、誤操作が発生しても、利用可能なauthorityをComponent境界で限定し、blast radiusを制御する。

## 3. Security-oriented Model-Driven Development

CMLではService/Operation、input/output、statefulness、exposure、Capability等の意味を実装コードより上位のモデルとして保持する。セキュリティ上重要な性質を、開発者が個々のhandlerで思い出して実装する規約だけにしない。

モデルからScala/CNCF Container、軽量なTypeScript Function、API contract、CAR metadata、deployment constraint等へ意味を投影する。

安全性を「危険なAPIを使わないよう注意する」だけで実現せず、通常の生成物には不要なauthorityやprimitiveを最初から持たせないことを優先する。

Application Tierでは通常のCML Operationから完全なCNCF Container実装を生成し、function-eligibleなOperationだけを追加でTypeScript Functionへ投影する。Function側はDomain DB、CAR Runtime、任意filesystem等を必要としない小さな実装とし、AWS、Google Cloud、Local/Testの差分は薄いadapterへ閉じ込める。

## 4. Safety Sandbox — Security and AI Safety

Safety Sandboxは悪意あるコードだけを対象にしない。バグ、誤操作、AI生成コード、自律的AIの誤判断も、許可されていないresource actionを起こし得る実行主体として扱う。

ExecutionContext、SandboxContext、Capability、ExecutionLimits等により、filesystem、network、process、HTTP、DataStore、外部serviceへのauthorityと消費可能resourceを制限する。

AIへのpromptやSkillはbehavioral guidanceであり、technical authority boundaryではない。AIに「危険な操作をしない」と指示することだけに依存せず、与えられていないauthorityは実行できない構造を作る。

hard limitは実行主体が越えられない上限であり、soft limitは許可されたExecutionContextによって範囲内で調整できる。authorityとresource consumptionを別概念として扱う。

## 5. Three-Tier Trust Architecture

Textus/CNCFはUI/Application/Domainの責務を分離する。

Application Tierは可能な限りFunction Firstとし、外部から到達する実装を小さくする。Function化できないApplication処理は完全なCNCF Container realizationへfallbackする。

Domain Tierはbusiness rule、invariant、authoritative mutationを所有し、Application FunctionからDataStoreへ直接アクセスさせない。

## 6. Application Function as a Security and Availability Boundary

Cloud Functionは単なるscale-out手段ではない。外部の大量・不正なtrafficをDomain Tierから隔離するsecurity/availability boundaryとして利用する。

Cloud edge、WAF、rate limit等に続き、Functionではrequest size/schema等の安価な検査、credentialの明白な不正・期限切れ等のpre-admissionを行う。

Functionのautoscaling能力をDomain/User Managementのcapacityと同一視しない。downstreamへのadmission/backpressureを持ち、攻撃trafficが高コストなDB/Domain処理へ直接増幅されないようにする。

## 7. Authentication, User Management and AuthHandle

現時点のTextusではUser Managementを一元化する。OAuth/OIDC等の外部credentialをApplication Functionが完全なSecurityContextへ変換するのではなく、中央User Management Domainへ解決を依頼する。

User Managementは認証済みsecurity stateへのopaqueなAuthHandleを返す。AuthHandleはUserId、OAuth token、role/capability list、serialized ExecutionContextではない。Application Functionはその内容を解釈・編集してauthorityを生成しない。

Functionはcredential fingerprintからAuthHandleへのbounded TTL cacheをinstance memoryに持てる。cacheは消失可能でinstance間共有を前提としない。標準構成ではRedis等の外部shared cacheを置かず、Function instance cacheとUser Management Domain自身のmemory/cacheを利用する。

一つのApplication Operationが複数Domainを束ねる場合、同じ有効なAuthHandleを各Domain Function APIへ渡せる。各Domain ingressはAuthHandleを解決し、そのDomainで必要なSecurityContext/ExecutionContextを構築し、Capability/Guardを評価して通常のOperationを呼び出す。

Authentication/User identityはsystem-wideに解決し、AuthorizationはDomain-localに決定する。

## 8. Capability, Guard and ExecutionContext

Authenticationは「誰であるか」を確立する。Authorizationは「何を許すか」を決定する。

CNCFではCapabilityをadmitted authorityの表現として扱い、Guard/policyがsubject、Operation、Entity/resource、relation、environment等を評価する。RBAC、ACL/DAC、ABAC、ReBACはこの評価に利用できるパターン/情報源である。

ExecutionContextはSecurityContextだけでなく、sandbox、resource limit、observability等の実行前提をruntime-controlled contextとして伝播する。business handlerが個別parameterとしてauthority情報を手作業で持ち回ることを通常方式にしない。

## 9. Safe-by-Construction Application Security

SQL injection、XSS、CSRF、mass assignment等は、lintだけで発見するのではなく通常経路をsafe-by-constructionにする。

typed Repository/DataStore API、output-context aware renderer、Operation semanticsに基づくHTTP mutation、declared input model等によって、一般的なapplication codeが危険なprimitiveを直接扱う必要を減らす。

raw SQL、raw HTML、direct filesystem/network/process等が必要な場合はExplicit Escape Hatchとして識別可能にし、lint/review対象にする。

## 10. Sensitive Information

Credential、Secret、Sensitive Identity、Sensitive Personal Dataを普通のStringやdomain valueと同一視しない。

外部providerが安全に所有できるhigh-value secretやinteractionは、可能ならUIを含めproviderへ委譲する。Textus Domainはprovider secretそのものではなく、必要なReference/Assertion/Resultを保持する。

外部identityはTextus内部Subject/User IDへmappingし、通常Domainへprovider-specific identityを無制限に伝播させない。

## 11. Immutable Domain Runtime and Availability

Domain Tierは1 Active + n Standbyを基本HA profileとできる。Standbyは待機するだけでなくread-only query/cache serverとして通常trafficを処理し、Activeへpromotion可能な状態を維持する。

runtime artifactはimmutableとし、定期的なrotation/replacementを行う。daily rotationによりstandby readiness、switch、drain、cache reconstruction等のrecovery pathを通常運用で継続的にexerciseできる。

動作中instanceが永続的にcleanであることを複雑な独自hash machineryで証明し続けるより、authorityを限定し、異常時にはcontain/revoke/replace/recoverすることを優先する。

## 12. CAR as a Security Harness

Componentの抽象的な境界はCARとして具体的なimmutable distribution artifactへ落とし込まれる。

CARにはComponent identity、Operation、dependency、Capability、implementation artifact、Subcomponent、documentation等の検査可能な情報を集約できる。

これによりarchitecture ruleをCAR lint、admission、CBD Review、AI review等の対象にできる。「Componentとして正しいはず」という抽象的な期待ではなく、配布物そのものを検査する。

## 13. Lint, Review and Admission

deterministicに検出できる違反はCAR lint等で検出し、意味的・設計的な問題はCBD Reviewで扱う。すべてを巨大なrule setやAI promptへ押し込まない。

build成功、AI review成功、artifact存在のいずれも単独ではruntime authorityを与えない。admission boundaryで必要な契約とevidenceを確認する。

## 14. Secure Development in the AI Era

AIが生成したコードを、人間が書いたコードより安全とも危険とも仮定しない。authorはassuranceではない。

sm-workflowは開発工程とevidence progressionを管理し、CAR lint/CBD Reviewが外部feedback loopを形成する。AI自身の「安全だと思う」という判断だけをsecurity evidenceにしない。

AIが防御的コードを過剰生成すること自体も品質・安全性問題になり得る。独自hash比較、二度読み、巨大rollback/integrity machinery等を「念のため」に増やすのではなく、明示されたthreat modelとauthority boundaryに対応する最小限のmechanismを選択する。

Human-in-the-loopは高authority操作、例外、重要なadmission/release判断に残す。

## 15. Observability, Containment and Recovery

Security architectureは予防だけで終わらない。Operation、authorization、runtime、subsystem、infrastructureのsecurity-relevant evidenceを通常のOTLP経路で観測し、Control Center等から診断可能にする。

credential/token/不要な個人情報をlog/traceへ複製しない。

incident時には、任意のrunning instanceがcleanであることを証明しようとするより、必要なauthority revocation、traffic isolation、immutable instance replacement、authoritative persistent stateからのrecoveryを優先する。

## 16. Security Lifecycle

Textus/CNCFのSecurity Harnessは概念的に次のlifecycleを構成する。

1. Prevent — safe-by-construction、Function First、sensitive interaction delegation。
2. Constrain — CBD、Capability、Sandbox、least authority。
3. Verify — Model、CAR、lint、review、admission。
4. Observe — OTLP、runtime/security evidence、Control Center。
5. Contain — trust boundary、blast radius、rate/admission、authority revocation。
6. Recover — Active/Standby、immutable replacement、persistent stateからの再構築。

## 17. Initial Security Control Matrix

| Threat / failure | Primary architectural response |
| --- | --- |
| Unauthorized Domain access | AuthHandle, ExecutionContext, Capability/Guard |
| Public Function compromise | minimal Function authority, no direct User/Domain DB authority |
| DDoS / overload | cloud edge/WAF, Function pre-admission, bounded downstream concurrency |
| SQL injection | typed DataStore/Repository path, explicit raw-SQL escape hatch |
| XSS / CSRF / mass assignment | safe renderer, Operation semantics, declared input binding |
| Filesystem/process/network misuse | Safety Sandbox and explicit authority |
| Credential/secret exposure | sensitive-information model, provider delegation, redacted observability |
| Compromised runtime | least authority, isolation, immutable replacement |
| Broken standby/recovery path | regular Active/Standby rotation and cache/read traffic |
| Supply-chain/generated-code defect | CAR, lint, CBD Review, admission |
| AI misjudgment/runaway tool use | Safety Sandbox, bounded authority, Human-in-the-loop |
| Excessive defensive machinery | threat-model-driven review, lint/review feedback, replace-not-prove-clean |

## 18. Conclusion

Textus/CNCFのSecurity Architectureは、security checkを大量に追加することを目的としない。

CBDでauthorityを分割し、Model Driven Developmentでそのauthorityと制約を明示し、Safety Sandboxで実行時に強制し、CARで検査可能なartifactへ固定する。その周囲にFunction First、AuthHandle、Capability/Guard、immutable runtime、lint/review/admission、observability/recoveryを配置する。

重要なのは、実装者、運用者、AIのいずれかが常に正しいと仮定することではない。誤りや侵害が発生しても、利用可能なauthorityとblast radiusをアーキテクチャによって限定し、検出、隔離、交換、復旧できるシステムを構成することである。

この文書はliving technical guideとして、Textus/CNCFで新しいSecurity Harnessが設計・実装されるたびに更新する。

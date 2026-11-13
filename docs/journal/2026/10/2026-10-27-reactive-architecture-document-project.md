# リアクティブ・アーキテクチャ技術解説

Date: 2026-10-27
Status: Initial bilingual manuscript; source-only

## 著者の方針

Security・UIと同じDocument Componentの並びに作成する。非同期ライブラリーの紹介に限定せず、CQRS、ジョブ管理、メモリを軸にしたアーキテクチャ、Application tier／Domain tierの役割を含む技術全体を扱う。

中心は、リアクティブ性をアーキテクチャから実装まで様々な工夫の組合せによって実現すること。リアクティブ宣言の四特性と各種品質属性を、各要素技術の機構・組合せ・効果・条件の説明へ織り込む。技術名の平坦な列挙を避け、共通基盤の利用によってアプリケーション側の個別実装負担を減らす点まで説明する。

## 構成

全体設計と四特性・品質属性 → tier分担 → メモリとCQRS → 型・Consequence・Free Monad・UoW → Job・負荷制御・Event／Workflow／状態機械 → 失敗・資源解放・可用性 → 観測・検証・提供範囲 → まとめ。

## 出典と権威の整理

公開資料：The Reactive Manifesto v2.0, https://www.reactivemanifesto.org/ （2026-10-27確認）。四特性の定義を参照。Textusの実装を裏付ける資料としては用いない。

以下は `/Users/asami/src/dev2025/cloud-native-component-framework/` 内の内部設計・仕様・実装資料。公開URLは未確認。

- `docs/spec/action-execution-semantics.md` — current normative execution routes: explicit Job intent; overrides older blanket Command→Job explanations.
- `docs/design/subsystem-runtime-architecture.md` — canonical Application/Domain/persistent-state lifetimes; memory is reconstructable, not system of record.
- `docs/design/availability-architecture.md` — canonical architecture: Active/Standby, readiness, replacement, failure boundaries and profile direction; not proof of full implementation.
- `docs/design/memory-first-domain-architecture.md` — historical/draft memory-first rationale; newer canonical persistence authority takes precedence.
- `docs/notes/entity-kind-and-working-set-policy.md` — residency by purpose and state, explicit policies.
- `docs/design/aggregate-view-semantic-boundary.md` — Entity/Aggregate/View/Event roles; contract, not implementation closure.
- `docs/spec/entity-conflict-and-conditional-transition.md` — provider result before resident-state reconciliation; current-state predicates.
- `docs/design/component-internal-execution-model.md` — component-local transaction, Task and UoW distinctions.
- `docs/design/datastore-and-aggregate-persistence-model.md` — aggregate persistence and DataStore ownership; draft.
- `docs/design/job-management.md` — JobEngine, bounded concurrency, retry, compensation, observations.
- `docs/overview/mechanisms/jobs/README.md` — available Job mechanism overview; executable JCL extensions remain planned.
- `docs/rules/consequence.md` — result type, fail-fast versus zip validation aggregation.
- `src/main/scala/org/goldenport/cncf/kernel.scala` — actual Program=Free, UowM=ConsequenceT, UowResult=Consequence definitions.
- `docs/design/free-unitofwork-execution-model.md` — design rationale for intent/interpreter separation; do not assume complete static inspection of all future effects.
- `docs/design/unit-of-work-resource-lifecycle.md` — transaction participants versus operational resources, terminal cleanup.
- `docs/spec/durable-job-recovery-contract.md` — recovery classification, replay proofs, started-work uncertainty.
- `docs/spec/job-lifetime-resource-contract.md` — bounded resource/lifetime policy; partial implementation and acceptance status.
- `docs/spec/job-unit-of-work-submission-contract.md` — staged submission and post-commit boundary; acceptance pending.
- `docs/spec/fresh-unit-of-work-context.md` — context rebinding; focused validation and acceptance status.
- `docs/journal/2026/05/concurrency-runtime-hardening-note.md` — single-process versus distributed roadmap; do not substitute historic status for newer contracts.

既存のSimpleModeling第6回原稿（`/Users/asami/src/dev2025/simplemodeling-org/src/main/doxsite/development-process/programming-harness.dox/index.dox`）も、Consequence・Free Monad・UoWとリアクティブ性の説明の整合に用いた。Security／UIの既存原稿は役割分担の参照であり、今回は変更しない。

## 重要な調整

- 旧Memory-First資料中の「memoryがruntime truth」「infinitely scalable」「persist asynchronously」を無条件の現行保証として採用しない。最新canonicalでは永続状態が正本で、メモリは再構築可能。更新の確定とWorking Set更新はcurrent normative契約に従う。
- 古いcomponent資料の「Commandは必ずJob」より、現行action-execution-semanticsの直接／明示Job選択を優先する。
- アプリカティブと並列実行、モナドとリアクティブ実行、受付制限とend-to-end stream back-pressureを区別する。
- CQRSの設計とEvent Sourcingの全面採用を同一視しない。永続Entityと派生Viewの関係を保持する。
- Job、Task、トランザクション、業務Workflow／状態機械は別の責務。確定後配送失敗、取消し要求と実際の終了、永続記録と安全な再実行を区別する。
- Active／StandbyとProfileは設計全体として説明。全経路の実装・検証完了やmulti-AZ対応を宣言しない。

## 作業範囲

Core・日英Document・SmartDox・Document Project定義を新設。ローカルの構造・参照・日英対応を点検する。Cozy受理、確認HTML、PDF、配布、性能・障害試験は未実施。実行証跡はtask-private temporary directoryへ置き、製品文書には含めない。

## 品質属性の整理と技術の組合せへの対応

+著者確認済みの十の品質属性をCore・日英本文に反映した。四特性と品質属性の関係を導入に置き、「品質属性と技術の組合せの対応」を追加。Coreのmapping構造に技術の組合せをsource、品質属性をtargetとして十の対応を明示した。本文の段落は対応するclaim、両node、relationを参照する。

+ティア、メモリ、CQRS、UoW、Job、Event、資源解放、可用性の説明末尾にも組合せと品質への寄与を補い、メッセージ駆動は品質を支える構成上の特性として整理した。確認HTMLの対象は宣言済み日本語document-structure-html。生成結果は製品のtarget配下、コマンド実行証跡と管理記録は既存の非公開・Git除外の保存先へ分離する。

品質属性の各対応は、Core上で二つのノード（技術の組合せ／品質属性）を持つ十の子Stepへ分けた。初稿にあった単一ノードのsequenceも、既存の意味を論点と効果へ分けて形式要件に合わせた。日英本文と派生SmartDoxを同期し、Cozyのdocument-structure-html生成が成功。日本語HTMLに十属性が含まれ、宣言された入力より新しい出力であることを確認した。ブラウザー表示や公開は行っていない。


## Diagram and table edition

The reader requested more diagrams and tables for the UI and reactive guides. The reactive guide now includes 5 explanatory figures and 7 comparison tables in both localized Document Descriptions and the derived bilingual SmartDox article. Figures retain editable PlantUML sources alongside localized PNG assets in `images/`.

The editorial change keeps the existing Core claims and technical boundaries. Figure and table blocks use the native Document Description v2 schema and explicit Core references. Lists of responsibilities and conditions are presented as comparisons; prose explains the relationships and qualifications. Japanese PDFs are regenerated from the current article through the native Cozy PDF route.

The ten quality attributes are organized into two comparison tables showing combined mechanisms and necessary conditions. Other tables cover functional composition, Command/Event/Job/Workflow roles, recovery decisions, HA failure boundaries, and observable evidence. Diagrams connect tiers, CQRS and reconstructible memory, Free Monad and UoW, Job admission, and planned replacement.

Execution logs, snapshots and page-render checks remain outside product sources. Confirmation HTML is not regenerated in this PDF-focused revision.

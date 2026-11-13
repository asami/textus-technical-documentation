# DDDを基礎とするモデリングと実行の技術文書

## 方針

security・UI・reactiveと同じDocument Project形式でCore、日英Document、SmartDox、図表を作成する。DDD向け機能の列挙ではなく、DDDを基礎としたモデリング全体像を主題とする。

用語集・文芸モデル、要求・ユースケース、ドメイン・モデル、アプリケーション・モデル、View、Displayを接続する。ドメインは静的構造、アプリケーションはユースケースを起点とするWorkflowを中心に説明する。

Viewは意味を持つ参照結果。Displayはその外側に配置する表示用モデルであり、型付き投影で表示値や操作を構成する。画面の操作は公開Operationや登録した更新先を通り、ドメインの規則、認可、UoWへ接続する。この補完によって業務規則をUIへ移さず表示をモデル化できる。

## 実行の説明

「モデルがそのまま動く」は、モデルの意味を、生成される型・実行定義・部品契約と、共通実行機構へ引き継ぐこととして説明する。CMLの記述、Cozyの具体化、CARによる導入、Textus/CNCFの実行、必要な補完実装をつなぐ。ユースケースの記述そのものを直接実行するとはしない。

Entity正本、Aggregate更新投影、View参照投影、Display表示投影の分担を採用。Domain Ruleの具体化やProvider接続は採用する版・モデルに応じて確認する。構文・仕様の存在と個別アプリケーションの接続完了を区別する。

## 参照資料

公開資料：Eric Evans, DDD Reference https://www.domainlanguage.com/ddd/reference/

内部資料：
- simplemodeling-org/docs/journal/2026/10/2026-10-16-cncf-series-runtime-ddd-knowledge-ai-harness.md
- simplemodeling-org/docs/journal/2026/10/2026-10-17-domain-rule-harness-cncf-series.md
- cozy/docs/notes/cml-semantic-capability-inventory.md
- cozy/src/main/scala/cozy/modeler/ModelTypeProjector.scala
- cozy/docs/spec/statemachine-workflow-generated-abi-contract.md
- cloud-native-component-framework/docs/design/aggregate-view-semantic-boundary.md
- cloud-native-component-framework/docs/design/entity-runtime-architecture.md
- cloud-native-component-framework/docs/design/subsystem-runtime-architecture.md
- cloud-native-component-framework/docs/design/display-model-runtime.md
- cloud-native-component-framework/docs/spec/entity-conflict-and-conditional-transition.md
- cloud-native-component-framework/docs/spec/action-execution-semantics.md
- cloud-native-component-framework/docs/spec/rule-engine-inference-runtime.md

## 成果物

`src/main/smartdox/ddd/textus-cncf-ddd-architecture.dox/` にソースを作成。共有Core、日英本文、SmartDox、図5点・表6点（各言語）。確認HTML・PDF・外部配布は今回の対象に含めていない。コマンド出力と確認記録は作業用の外部ディレクトリに保持し、コミット対象にしない。

## 開発時のモデリング技術の棚卸しへの整理

文書の目的は、定義済みのユースケースを入力として、実際の開発に必要なモデリング技術をDDD・PoEAAを補助線に可視化すること。DDDやPoEAAの機能紹介・全パターン解説を主目的にしない。前段階のユースケース定義は対象外とし、実現と検証の基準として扱う。

冒頭を開発上の判断から構成し、業務構造、処理の進行、更新と参照、業務上の事実、永続化、表示へ対応付けた。Domain Event、CQRSを明示し、Viewの外側のDisplayまでを接続。Event Sourcingは別の保存方式の選択として区別する。

PoEAAのDomain Model、Service Layer、Repository、Data Mapper、Unit of Workは責務を整理する補助線として採用。CNCFの実装名との一対一の同一性や、全パターンの実装済みという主張はしない。Domain Event/CQRSをPoEAAの掲載パターンとはしない。

公開参照：
- https://www.domainlanguage.com/ddd/reference/
- https://martinfowler.com/eaaCatalog/
- https://martinfowler.com/eaaCatalog/serviceLayer.html
- https://martinfowler.com/eaaCatalog/dataMapper.html
- https://martinfowler.com/eaaCatalog/repository.html
- https://martinfowler.com/eaaCatalog/unitOfWork.html
- https://martinfowler.com/bliki/CQRS.html

内部参照追加：cloud-native-component-framework/docs/design/datastore-and-aggregate-persistence-model.md、docs/spec/datastore-logical-type-mapping.md、docs/design/unit-of-work-resource-lifecycle.md、docs/design/event-shape.md。初稿のEntity Runtime Architecture参照先は docs/design ではなく docs/notes/entity-runtime-architecture.md。

Core・日英本文・SmartDox・関連図表を同期。図5点・表8点（各言語）。HTML・PDFは未生成。

## タイトルと本文の位置付け

タイトルを「Textus/CNCF DDDモデリング技術ガイド」（英語：Textus/CNCF DDD Modeling — Technical Guide）とし、DDDを前面に出す。本文は引き続き、定義済みユースケース以降の開発で必要なモデリング技術を、DDDとPoEAAを補助線に可視化する構成とする。共有Coreの主張と説明構造は変更せず、日英Documentのタイトル・ルート表示名、SmartDoxのタイトル、READMEを同期した。

## 日本語PDFの配置

日本語PDF（13ページ）をCozyのLaTeX経路で生成し、Google Driveの@Activeへ配置した。配置後のメタデータでPDF形式・保存先・ファイルサイズを確認した。

https://drive.google.com/file/d/1_zQT7aZrtvkSmF8GmOH9us5Rthc8bPJe/view?usp=drivesdk

## 全体構成の改訂：モデルの組合せから実行へ

開発上の判断 → 業務の意味・規則 → 処理の進行 → 更新・保存・確定 → Event・参照・表示 → モデルから実行への対応 → 変更・検証 → まとめ → 付録へ再構成した。

PoEAAの独立したパターン紹介を解消し、Service LayerをOperation・Workflow、RepositoryとData Mapperを保存境界、Unit of WorkをAggregateと更新確定の説明へ接続した。モデル記述・生成物・実行責務の対応表を改め、注文確定の例は各モデル説明後の統合確認へ移動。実行図はOperation、Aggregate、UoW、DataStore、Domain Event、View、Displayの役割を分離した。導入と末尾の実行説明の重複を整理し、まとめは組合せによる到達点を回収する。

付録にDDD・PoEAA・Cloud Nativeの順で一覧表を設け、役割と本文の対応箇所を示す。Cloud Nativeは本書の構成上、前二者を補完する技術群をまとめる区分とする。

ユーザー追記に基づきEntityのステレオタイプに相当する分類とメモリ管理を追加。実装ではentityKindの既定値と明示的なWorking Set方針を組み合わせる。masterはResidentAll、taskはDisabled、workflowは状態に応じた明示方針が必要。タスクの分類だけで自動キャッシュされるとは書かず、必要時の取得と用途に応じた保持設定を説明した。モデルが構造だけでなく実行方針を規定する例として位置付け、保持・解放・整合性・復旧の詳説はリアクティブ記事へ接続する。

内部根拠：cloud-native-component-framework/docs/notes/entity-kind-and-working-set-policy.md、src/main/scala/org/goldenport/cncf/entity/runtime/EntityKindRuntimePolicy.scala、EntityRuntimePlan.scala。

DDDの基礎文献はDomain-Driven Design、Implementing Domain-Driven Design、Learning Domain-Driven Designの3冊とした。FP文献は本文との対応がある場合に限って参照し、Domain Modeling Made Functionalは型・値の制約、Functional and Reactive Domain Modelingは業務計算と入出力の分離へ対応付けた。出版社の公開紹介・目次とローカル設計資料を確認したもので、書籍全文を確認済みとは扱わない。

FPを詳説すると本書の難度が上がるため、言及は短く留める。モナド、アプリカティブ、Consequence、Free Monad、UoW、Scala/Scalazとの具体的な対応は、別の技術文書「Modeling & FP」の候補として記録する。現在のDDD文書へ詳細やFPパターン一覧は追加しない。

Core・日英Document・SmartDox・図表を同期。旧ソースとPDFは作業用の外部スナップショットへ保存。日本語PDFを再生成し、@Activeの既存PDFを同一IDで更新する。

## 改訂版の反映と配置

Core・日英本文・図5点・表10点を同期。UoW節末尾の一覧は、後続節との重複と表見出しだけの改ページを避けるため削除し、保存・確定の責務表と本文で説明を維持した。FPの詳説は別文書「Modeling and FP」に分離する方針とし、DDD本文には型と業務計算・入出力分離の短い言及のみを残した。

日本語PDFを13ページで再生成し、Google Drive @Activeの既存PDF（1_zQT7aZrtvkSmF8GmOH9us5Rthc8bPJe）を同一IDで更新した。今回の改訂では確認HTMLは生成していない。

実行証跡のローカル保管先：/Users/asami/backup/journal/2026/10/textus-technical-documentation/01a0e3d8-ee8e-78f2-9bf9-b52550602726/4b8f8e7b2e51d7fa1773a5f4e7e80b6c 。保管期限：2026-11-26（期限到来による自動削除は行わない）。元の管理記録は維持。

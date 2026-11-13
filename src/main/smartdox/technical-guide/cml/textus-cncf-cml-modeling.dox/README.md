# CMLによるモデリング技術ガイド

既存のTextus/CNCF技術ガイドと同じDocument Project形式。
文芸モデル、静的構造、ユースケースとWorkflow・状態機械、業務ルール、Operation、View・Displayを接続し、検査・生成・実行へつなぐ。

- `content/core.yaml`: 共有する構成・主張・説明の関係。
- `content/ja/document.yaml`, `content/en/document.yaml`: 日英本文・図表・Core参照。
- `index.dox`: 日英本文から導出した多言語SmartDox。
- `images/`: 日英各4図のPlantUMLと本文用PNG。
- `examples/`: DatatypeとOperationの説明用CML断片。
- `build/document-project-targets.yaml`: 既存契約に沿う確認HTMLターゲット。

受理済みDatatype・Operation・Workflow契約と、一般RULE DSL／Domain Ruleの具体化の拡張方針を区別する。Rule Engineの既存機構と、CMLからの自動接続も分けて記述する。

日本語PDF（10ページ）を生成し、Google Driveの@Activeへ配置済み。確認HTMLは未生成。

Core参照、日英構造、図表と記事の対応を機械的に確認済み。Cozyによるネイティブ検証、例のコンパイル・実行は未実施。

日本語PDF: `target/textus-cncf-cml-modeling-ja.pdf`。 [Google DriveのPDF](https://drive.google.com/file/d/1Rebv7r-MZTyIkYb-idBXMToE1qc0__9Y/view?usp=drivesdk)。

## 2026-11-03 知識経路の追記

BoKからモデルを設計する経路と、Entityを実行時の知識として提供する経路をCore・日英本文へ追記。詳細は[設計ガイド](../../knowledge-modeling/textus-cncf-knowledge-modeling.dox/README.md)と[実行時ガイド](../../entity-knowledge/textus-cncf-entity-knowledge.dox/README.md)を参照。この追記を含む確認HTML・PDFは未生成。

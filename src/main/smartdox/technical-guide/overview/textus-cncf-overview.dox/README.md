# Textus/CNCF 全体像と技術のつながり

個別技術ガイドの入口となるDocument Project。SimpleModeling・CML・Cozy・Textus・CNCFの役割と、モデルからコンポーネント・実行・UI・品質への接続を説明する。

- `content/core.yaml`: 主張、Stepの階層、流れ、各Stepの説明構造。
- `content/ja/document.yaml`, `content/en/document.yaml`: 日英本文とCore参照。
- `index.dox`: 日英本文から導出したSmartDox。
- `images/`: 日英各6図のPlantUMLとPNG。
- 本文には日英各5表。DDD・FP・UI・リアクティブ・セキュリティへの参照表を含む。

日本語PDFを生成し、Google Driveの@Activeへ配置済み。確認HTMLは未生成。既存の確認ターゲット宣言を同梱している。

日本語PDF（11ページ）: `target/textus-cncf-overview-ja.pdf`。 [Google Drive @ActiveのPDF](https://drive.google.com/file/d/1_cDxVqY_LILl8fCZXUlafANbluCNgOpw/view)。

2026-10-27 構成改訂：モデルの契約から部品の再利用、実行の層構成、共通Operation経路、品質の組合せへ展開する。実行構成をFPの説明より先に置き、応答・復旧・保護の効果を本文と図表で説明する。

改訂版の日本語PDFは11ページ。@Activeの既存ファイルを同じIDで更新済み。Core・日英本文・図表とPDFを同期した。

## 2026-11-03 知識経路の追記

BoKからモデルを設計する経路と、Entityを実行時の知識として提供する経路をCore・日英本文へ追記。詳細は[設計ガイド](../../knowledge-modeling/textus-cncf-knowledge-modeling.dox/README.md)と[実行時ガイド](../../entity-knowledge/textus-cncf-entity-knowledge.dox/README.md)を参照。この追記を含む確認HTML・PDFは未生成。

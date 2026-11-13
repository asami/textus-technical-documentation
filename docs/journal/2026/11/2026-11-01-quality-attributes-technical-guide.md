# 非機能要求と品質属性 技術ガイドの新規作成

## 依頼と位置付け

「非機能要求と品質属性」という観点でTextus/CNCFの技術体系を説明する新規資料を作成した。リアクティブガイドだけの拡張ではなく、セキュリティ、整合性、変更、UI、監査・運用を横断する技術ガイドとする。

CMLのモデルとCNCFの標準機能を使う通常の開発から、共通の品質対策が適用されることを主眼とした。品質上の条件を指定することと、その制御機構を自前で実装することを分ける。必要な水準と費用に応じた構成選択・確認も説明する。

## 成果物

`src/main/smartdox/quality/textus-cncf-quality-attributes.dox/` にCore、日英Document、SmartDox本文、図2点・表5点、プロジェクト定義と確認HTMLの対象定義を配置。READMEから案内する。新規ソースのみを作成し、既存ガイドの本文は変更しない。HTML・PDF生成、Drive配布、コミットは未実施。

## 説明順序

非機能要求の具体化 → 品質属性と仕組みの対応 → モデル・部品と共通実行 → 非同期実行 → 保護・整合性・追跡 → 変更とUI → 標準構成・調整・確認 → まとめ → 関連資料。

## 参照資料

本リポジトリのoverview、reactive、security、ui、ddd、modeling-fp、cml各ガイドのCore・日英本文を関連技術資料として参照する。図版はoverviewのexecution-boundariesとtier-lifetimesの日英PNG・PlantUMLを再利用した。

外部の一般的な整理はSEI Quality Attribute Workshops, Third Edition（https://www.sei.cmu.edu/documents/716/2003_005_001_14249.pdf）とリアクティブ宣言（https://www.reactivemanifesto.org/ja）を参照する。本書の対応表はTextus/CNCF向けの整理であり、品質規格の分類表や性能測定結果ではない。

## 確認と提供範囲

Core識別子とDocument参照、日英段落・表とSmartDoxの対応を検査した。採用版による提供範囲、設計・整備中の項目、実環境で確認する水準を本文に区別した。実行証跡は `/private/tmp/textus-quality-guide-20261101/` に置き、コミット対象に含めない。

## 日本語PDFの生成とDrive配置

日本語PDF（7ページ）をCozyのLaTeX business経路で生成した。表題の二重番号を修正し、既存の説明段落を表の前へ配置して、表4・表5の見出しだけが前ページに残る改ページを解消した。Core、日英本文、SmartDoxで順序と表題を同期した。全段落・表の内容と全ページの配置を確認した。

成果物：`src/main/smartdox/quality/textus-cncf-quality-attributes.dox/target/textus-cncf-quality-attributes-ja.pdf`。Google Driveの@Activeへ配置： https://drive.google.com/file/d/1Q814B73Ee5XbE7DRDWal2pQTby_USHZN/view?usp=drivesdk 。

生成用コピーは既存のSimpleModeling.org作業領域のignored target内で処理し、完成PDFを本プロジェクトへ保存した。実行証跡は `/Users/asami/backup/journal/2026/11/simplemodeling-org/01a0e3d8-ee8e-78f2-9bf9-b52550602726/quality-guide-drive-20261101` に保管し、コピー後の可読性を確認した。2026-12-01までは保持し、自動削除は行わない。実行証跡はコミット対象に含めない。

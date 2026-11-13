# Textus/CNCF全体像の技術文書

## 目的

個別ガイドを読む入口として、Textus/CNCFの全体像を同じDocument Project形式で作成した。モデルを開発と実行の基盤とする目的から始め、記述・生成・部品・実行・UI・品質をつなぐ。技術要素の一覧を主軸にせず、各段階で何を引き継ぎ、その組合せで何が得られるかを説明する。

## 構成

目的 → 製品と技術の役割 → 要求・ドメイン・アプリケーション・View・Display → 直接実行・生成・補完とCBD/CAR → Operation・FP・UoW・tier → 複数UIと外部連携 → リアクティブとセキュリティ → 開発・AIハーネス → 各ガイドの案内 → まとめ → 内部参照資料。

SimpleModelingのリファレンス・アーキテクチャは組合せを提示するものであり、各要素の単独利用を妨げる説明にはしない。CNCFはCloud Native Component Frameworkと明記。ユースケースは要求モデルとし、Workflowなどへの対応と検査を説明する。モデル直接実行は生成物・実行定義・補完を介した意味の連続性として説明する。

ConsequenceとFree Monadの役割、UoWによる確定と終了管理、Application/Domain/永続状態の分担、Job受付と完了、ViewとDisplayを区別。機械的検査、署名、認可、Capabilityの役割を分け、Profileなどの構想を実装済みと扱わない。AIハーネスはモデル駆動・型・共通経路の組合せが生む効果として位置付ける。

## 成果物と範囲

`src/main/smartdox/overview/textus-cncf-overview.dox` にCore・日英Document・多言語SmartDox・日英各5図と5表を作成。READMEへ入口を追加する。HTML・PDF・配布・コミットは今回の対象に含めない。

根拠は各技術ガイド、CNCF READMEとsubsystem-runtime-architecture、FPの実装、Cozyのモデル能力と生成ABI契約、Textus launcherおよびFlutter application frameworkのREADME。内部資料であることを本文に記載した。

## 確認結果

Coreは20 Step、日英それぞれ本文31段落・図5点・表5点。Core参照、日英ブロック対応、SmartDoxへの本文反映、表の列数、図の生成、個別ガイドの参照先を機械的に確認。全体図と実行経路図を表示して確認した。Cozy/SmartDoxのネイティブHTML・PDF生成は実施していない。BoKの用語管理とScalaによる補完実装、DDD・PoEAAの位置付けを本文に補足した。

実行証跡は `/Users/asami/backup/journal/2026/10/textus-technical-documentation/01a0e3d8-ee8e-78f2-9bf9-b52550602726/59089a-textus-overview` に分離保管。30日保持とし、コミット対象に含めない。

## 日本語PDFと@Active配置

追加依頼「両方ともPDFを@Activeにコピーしておいて」により、日本語PDF（11ページ）を生成して[Google Drive @Active](https://drive.google.com/file/d/1_cDxVqY_LILl8fCZXUlafANbluCNgOpw/view)へ配置した。Modeling and FPは型引数のSmartDoxコード表記、全体像はモデル関係図の2列配置を調整した。本文の意味と日英Core参照は維持した。確認HTMLは未生成。

生成・表示確認の証跡は `/Users/asami/backup/journal/2026/10/textus-technical-documentation/01a0e3d8-ee8e-78f2-9bf9-b52550602726` の当該実行ID末尾 `-pdf` の各ディレクトリへ保管。2026-11-26まで保持し、Gitへ含めない。

## 技術の組合せによる効果を中心とした構成改訂

レビュー後の明示的な更新依頼に基づき、Core・日英本文・図表を改訂した。導入では開発者が業務固有の記述へ集中できる分担を示す。モデル契約 → 既存部品の再利用と補完 → 共通実行管理の順に、機能と管理処理の両方を再利用する因果関係を説明する。

実行章はApplication/Domain/永続状態を先に説明し、直接実行とJob、Operationから認可・計算・UoW確定へ進む共通経路を経て、Scala・FPをその接続方法として紹介する。品質章は受付と処理能力、メモリ利用と永続状態・復旧、複数入口と共通保護の組合せへ構成した。復旧は進行記録・確定結果・再実行条件の対応として扱い、自動的な復旧や分散原子性を保証する表現にはしない。

まとめは個別技術の再説明を避け、業務固有の処理への集中、再利用、共通管理による実装・確認負担の低減を回収する。各ガイドへの道筋と参照資料は付録へ移した。全体図と部品構成図、層の図、契約・品質の表を更新。日英各6図・5表。日本語PDFを同じCozy経路で再生成し、@Activeの既存PDFを同じIDで更新する。

改訂後の日本語PDF（11ページ）を再生成し、@Activeの既存ファイル `1_cDxVqY_LILl8fCZXUlafANbluCNgOpw` を同じIDで更新した。Coreは22 Step、日英それぞれ37段落・6図・5表。Core参照と日英の対応、PDFの表示を確認した。確認HTMLは今回の対象ではなく未生成。元原稿と旧PDFを保管した。

今回の原稿保管・生成・表示確認の証跡: `/Users/asami/backup/journal/2026/10/textus-technical-documentation/01a0e3d8-ee8e-78f2-9bf9-b52550602726/8649656b4d90a6ed2fafefacf7c077b8-overview-combinations`。2026-11-26まで保持し、Gitへ含めない。

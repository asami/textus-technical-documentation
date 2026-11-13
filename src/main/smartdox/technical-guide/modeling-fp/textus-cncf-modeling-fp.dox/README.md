# Textus/CNCF Modeling and FP技術ガイド

DDD・security・UI・reactiveと同じDocument Project形式。型・純粋関数型・Consequence・Free Monad・UoWがモデリングと実行をつなぐ仕組みを、日英本文と図表で説明する。リアクティブの四特性、JobとUoWの分担も含む。

- `content/core.yaml`: 共有する主張・構造・説明の流れ。
- `content/ja/document.yaml`, `content/en/document.yaml`: 日英本文とCore参照。
- `index.dox`: 両本文から導出した多言語SmartDox。
- `images/`: 編集用PlantUMLと本文用PNG（日英各5図）。
- `build/document-project-targets.yaml`: 既存形式の確認HTMLターゲット宣言。

参考文献はScott Wlaschin『Domain Modeling Made Functional』とDebasish Ghosh『Functional and Reactive Domain Modeling』。本文で用いる具体的な技術との対応を付録へ記載。プログラミング・ハーネス第6回の役割分担を、モデリングと実行の説明として再構成した。

日本語PDFを生成し、Google Driveの@Activeへ配置済み。確認HTMLは未生成。

日本語PDF（13ページ）: `target/textus-cncf-modeling-fp-ja.pdf`。 [Google Drive @ActiveのPDF](https://drive.google.com/file/d/1MEcQSzD3_TuGL6CRVbQnbUFo1wRc8v_t/view)。

SmartDox表現では型引数を含む型名をインラインコード（バッククォート）で囲む。日英Documentの本文を導出する際もこの構文処理を保つ。

# CMLによるモデリング技術ガイド

日付: 2026-10-27
状態: 初稿

## 方針

既存のTextus/CNCF技術文書と同じDocument ProjectでCMLを主題とするガイドを作成。共有Core、日英Document、SmartDox本文、日英各4図、6表、CML例2点を用意する。

要素の一覧ではなく、ドメインに近い抽象度で意味を記述し、モデル間の対応を検査・生成・実行へ引き継ぐ構成とする。文芸モデルの三層、静的モデル、要求と実行する振る舞い、業務ルール、Operation、View/Display、実行と検証、開発手順の順に展開する。

## ルールの追加指示

型・属性の制約、Domain Ruleによる判断、状態機械のGuard、Workflowの進行を分担する。Rule Engineの評価は永続状態を直接変更せず、Action受入れからOperation/Event/Jobの標準経路へ戻す。規則の所有と評価経路を組み合わせることが、AIによる規則の重複実装を抑えるハーネスとしても機能する。

一般RULE DSLとDomain RuleからCNCF Rule Modelへの具体化は拡張方針。受理済みの局所的な制約・Operation・Workflow契約と混同せず、Rule EngineがあることをCMLからの全自動生成の根拠にしない。

## 資料と成果物

資料の所在と役割は本文付録に記載。文法例はCozyの受理済み契約・検査例を用い、説明用断片と明記。CMLサンプルの実行検証はこの原稿作成には含めない。

確認HTML・PDF・Drive配置は今回未実施。原稿と図表を次のレビュー入力とする。Gitコミットは行わない。

## 日本語PDFの生成と配置

追加依頼により、日本語PDFをCozyのLaTeX経路で生成し、@Activeへ配置。図を複数段に配置して可読性を調整し、ソースブロックの終端前に空行を置いて記述例の末尾行が出力されるようにした。最終版は10ページ。確認HTMLとCML例の実行検証は未実施。

[Google Driveの日本語PDF](https://drive.google.com/file/d/1Rebv7r-MZTyIkYb-idBXMToE1qc0__9Y/view?usp=drivesdk)

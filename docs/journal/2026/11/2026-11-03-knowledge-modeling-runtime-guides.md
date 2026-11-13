# 知識の設計経路と実行時利用を別ガイドにする

## 採用した方針

CNCFシリーズの知識処理を設計系と実行系に分ける決定をテクニカルガイドへ反映した。ハーネス第8回では双方の制約・誘導・フィードバックを取り上げ、詳細は二つのガイドへ分担する。

- 設計：BoK・プロジェクト知識 → 文芸モデル → CMLのEntity・型・関係・規則 → Cozyの具体化。用語の機械的なEntity化ではなく、業務文脈に応じたモデル判断と対応の保持を説明する。
- 実行：Entity → Information → RDF等の知識表現 → 検索・AI提供。モデル定義と業務データ、業務上の識別と知識表現の識別を区別する。出典、版、参照権限を保持し、知識取得を状態変更の許可と混同しない。
- 全体像・DDD・CMLへ接続説明と関連ガイドを追記。既存の説明・図表・IDは保持。

## 確認した内部資料

- cozy/docs/spec/cml-terminology-metadata.md：明示的な用語参照・ラベル・出典。名前だけでの同義推測は行わない。
- cozy/docs/spec/cml-value-datatype-contract.md：モデルの型と生成契約。
- cloud-native-component-framework/docs/spec/information-canonical-model.md：information.cmlを正本とする生成InformationとInformationSpace。
- simplemodeling-org/docs/journal/2026/10/2026-10-16-cncf-series-runtime-ddd-knowledge-ai-harness.md：EntityからInformation／Knowledgeへの構想。
- simplemodeling-org/docs/journal/2026/11/2026-11-03-knowledge-harness-design-runtime.md：今回の分担方針。

仕様で確認できる生成モデル・メタデータ契約と、個別に構築する抽出・投影・提供経路を区別した。任意のBoKからアプリケーションやRDF・MCPまで全自動で完成する実装を主張しない。

## 成果物と確認範囲

新規2プロジェクトのCore、日英Document、日英index.dox、対応表、ローカル生成ターゲット定義を作成。全体像・DDD・CMLのCoreと日英本文を同期した。ローカルでJSON構文、Core参照、日英構造、追記本文の対応を確認する。Cozyネイティブ検証、確認HTML、PDF、公開・Drive更新は今回の対象に含めない。

作業前原本・検証記録はリポジトリ外の /private/tmp/knowledge-guides-20261103/ に保管し、製品ソースと分離する。コミット・pushは行わない。

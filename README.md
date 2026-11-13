# Textus Technical Documentation

Technical documentation distributed as a Textus Document Component.

- `docs/` contains project-internal design, notes, journal, and phase material.
- `src/main/` contains product documentation sources built and distributed by the component.
- SmartDox is the source-of-truth format for multilingual, multi-format publication.
- Canonical releases are intended to include Web/MCP-consumable documentation and distributable PDF artifacts.

## 文書執筆ルール

技術文書の共通ルールはai-directiveの `core/technical-writing.md` を正本とします。
[このリポジトリでの参照方法と適用範囲](docs/ai/repository-agent-guide.md)を確認してから、Core・各言語のDocument・SmartDoxを編集します。

## ガイドの入口

- **技術ガイド**では、モデルがTextus/CNCFの実行へどうつながるか、各機構が何を担うかを説明します。まず[全体像](src/main/smartdox/technical-guide/overview/textus-cncf-overview.dox/README.md)から読めます。
- **開発ガイド**では、業務アプリケーションを開発する手順と判断を扱います。[開発方法](src/main/smartdox/development-guide/development-methods/README.md)と[ライブプロトタイピング](src/main/smartdox/development-guide/live-prototyping/README.md)の二つの入口があります。

開発ガイド仮版（2026-11-04）

- [受注管理システムに見る四つの開発方式](src/main/smartdox/development-guide/development-methods/order-management-development-methods.dox/index.dox)
- [SimpleModeling Live Prototyping — 顧客との対話からα版へ](src/main/smartdox/development-guide/live-prototyping/simplemodeling-live-prototyping.dox/index.dox)

## 全体像

[Textus/CNCF 全体像と技術のつながり](src/main/smartdox/technical-guide/overview/textus-cncf-overview.dox/README.md) は、個別ガイドの入口。モデルの記述・生成から、部品の構成・実行・UI・品質へ至る接続を説明する。Core・日英本文・図表を作成済み。日本語PDFを@Activeへ配置済み。確認HTMLは未生成。

## Security architecture guide

- Document identity: `textus-cncf-security-architecture`.
- Canonical source: [SmartDox guide](src/main/smartdox/technical-guide/security/textus-cncf-security-architecture.dox/index.dox).
- Languages: Japanese (`ja`) and English (`en`), maintained in one source.
- Titles use `English｜日本語`; each paragraph, list item, and table cell pairs adjacent `<span lang="en">` and `<span lang="ja">` elements.
- Shared meaning lives in the project's `content/core.yaml`; localized prose lives in `content/ja/document.yaml` and `content/en/document.yaml`. The 31 technical sections are organized into seven groups around the cooperation, effects, and limits of security controls. `index.dox` is derived from those sources.
- The original Markdown draft is retained unchanged under [internal notes](docs/notes/security/textus-cncf-security-architecture-initial.md) as migration history, not as a second publication source.

The [Document Project](src/main/smartdox/technical-guide/security/textus-cncf-security-architecture.dox/README.md) declares native local confirmation routes. The requested Japanese logic-tree view is generated under its `target/document-project/local-build/document-structure-html/index.html`. Public multi-format builds and Documentation CAR packaging remain Phase 1 integration work.

Japanese PDF refreshed from the latest manuscript on 2026-11-13: A4, 28 pages,
including eight figures and six tables. The [existing @Active copy](https://drive.google.com/file/d/1G4XqdOZZtqaqcKgGRFKp_8aMY4dNNUl1/view?usp=drivesdk)
was updated in place with the memory/state-preservation, HA and immutable-infrastructure
explanations. Its Drive link is unchanged; existing HTML was not regenerated.

## UI architecture guide

- Document identity: `textus-cncf-ui-architecture`.
- [Document Project](src/main/smartdox/technical-guide/ui/textus-cncf-ui-architecture.dox/README.md) and [bilingual SmartDox guide](src/main/smartdox/technical-guide/ui/textus-cncf-ui-architecture.dox/index.dox).
- Shared Core and Japanese/English Document sources follow the security guide's conventions.
- Explains how models, public business contracts, presentation contracts, and runtime infrastructure cooperate across standard Web UI, Textus Flutter UI, and independently developed UI connected through REST or gRPC.
- Initial source-only draft. Implementation and proposal scope are distinguished; confirmation HTML, PDF, and component packaging have not been generated for this guide.

## Reactive architecture guide

- Document identity: `textus-cncf-reactive-architecture`.
- [Document Project](src/main/smartdox/technical-guide/reactive/textus-cncf-reactive-architecture.dox/README.md) and [bilingual SmartDox guide](src/main/smartdox/technical-guide/reactive/textus-cncf-reactive-architecture.dox/index.dox).
- Shared Core and Japanese/English Document sources follow the security and UI guides' conventions.
- Connects reactive characteristics and quality attributes to Application/Domain tiers, memory residency, CQRS, typed composition, UoW, Jobs, Events, load control, recovery, availability, and observation across architecture, implementation, and operations.
- Japanese logic-tree confirmation HTML is generated under the declared local target. Implementation and design/acceptance scope are distinguished; PDF and component packaging remain ungenerated.

## 可用性・HA技術ガイド

[可用性・HA技術ガイド](src/main/smartdox/technical-guide/availability/textus-cncf-availability-architecture.dox/README.md)
を2026-11-12に初稿作成。2026-11-13の構造レビューを受け、目的と全体構成から読む
8章・22節・13表・2図へ再構成しました。実行系、データ・同期系、制御系、配備・運用系を
階層化して説明し、その後に通常運転と切替え、付録に実装計画を配置しています。
第1章では、中小企業の一般的な業務を中心としたHAの到達範囲と、標準構成を通常の設定で使えることを目標として明示しています。
障害時の縮退運転と計画的な保守の両方で、業務更新を停止し条件を満たす参照を継続するRead-onlyモードを設計候補として追加しています。
メモリ常駐を応答性だけでなく、永続化先が不調な間の検索・一覧・照会の継続にも活かす設計を説明しています。
共有Core、日英Document、SmartDoxとPlantUML図を同期しています。
2026-11-13の再生成依頼により、Cozyで日本語PDF（A4・15ページ）を作り直し、[Google Driveの@Active](https://drive.google.com/file/d/1mP-b8DXSqPZHe0gMOAoJ3VtnZqIYM-2i/view?usp=drivesdk)の既存ファイルを更新しました。
Working SetとRead-only運転の開発計画（Phase 123・124）も付録に記載。全ページの見た目と本文・図表の欠落を確認済みです。HTMLは未生成です。

## イミュータブルインフラストラクチャ技術ガイド

[専用ガイド](src/main/smartdox/technical-guide/immutable-infrastructure/textus-cncf-immutable-infrastructure.dox/README.md)
を2026-11-13に初稿作成し、目的・全体構造から読む9章・4節・7表へ本文を再構成しました。
目的と用語、構成要素と接続関係、状態管理を先に説明し、その後に交換・更新・切戻し、
例外・障害時の動作、セキュリティ、品質と費用、実装状況を配置しています。文体は中立的な技術説明に統一しました。
HAガイドは同期・権限制御・切替えの詳細を担当し、Securityガイドは防御全体へ接続します。
共有Coreと日英のDocument／SmartDox原稿を作成。日本語PDF（A4・6ページ）を2026-11-13に生成し、
[Google Driveの@Active](https://drive.google.com/file/d/1Mth0Btpo5a4gWe_x35hWxkyHjhRgYHgu/view?usp=drivesdk)へ配置しました。このPDFは再構成前の版です。現在は本文のみ修正し、PDF再生成・Drive更新は保留しています。HTMLは未生成です。

## DDDモデリング技術ガイド

[DDD技術文書のDocument Project](src/main/smartdox/technical-guide/ddd/textus-cncf-ddd-architecture.dox/README.md) は、DDDの観点からSimpleModeling・Textus/CNCFの全体像を説明します。2026-11-13のコメントを反映し、目的・3冊の採用用語・戦略的／戦術的ハイライト・CQRSの更新系／参照系を整理しました。Value Objectの両系統での利用、Bounded Contextと部品境界、Ubiquitous LanguageとBoK・知識の対応を図と本文へ反映しています。
日本語PDF（A4・17ページ）をCozyで再生成し、全ページと本文・図表を確認して[Google Driveの@Active](https://drive.google.com/file/d/1_zQT7aZrtvkSmF8GmOH9us5Rthc8bPJe/view?usp=drivesdk)の既存ファイルを更新しました。3冊の比較は公開出典で確認した範囲を明記しています。確認HTMLは未生成です。

## Modeling and FP技術ガイド

[Document Project](src/main/smartdox/technical-guide/modeling-fp/textus-cncf-modeling-fp.dox/README.md) にCore、日英本文、図表を配置。型・純粋計算・Consequence・Free Monad・UoWがモデルを実行へつなぐ仕組みとリアクティブとの関連を説明する。2冊の参考文献と本文の対応を付録に記載。日本語PDFを@Activeへ配置済み。確認HTMLは未生成。

## CMLモデリング技術ガイド

[Document Project](src/main/smartdox/technical-guide/cml/textus-cncf-cml-modeling.dox/README.md) にCore、日英本文、図表とCML記述断片を配置。用語・構造・規則・振る舞い・UIのモデルを接続し、検査・生成・Textus/CNCFでの実行へつなぐ。日本語PDF（10ページ）を生成し、Google Driveの@Activeへ配置済み。確認HTMLは未生成。

## 非機能要求と品質属性 技術ガイド

[Document Project](src/main/smartdox/technical-guide/quality/textus-cncf-quality-attributes.dox/README.md) と [日英本文](src/main/smartdox/technical-guide/quality/textus-cncf-quality-attributes.dox/index.dox) を作成。非機能要求から品質属性、モデル・コンポーネント・共通実行機構の組合せ、用途別の条件と確認へつなぐ。Core、日英本文、表5点、図2点を配置。日本語PDF（7ページ）をGoogle Driveの@Activeへ配置済み。確認HTMLは未生成。

## 知識の設計と実行時利用

- [BoKからドメイン・モデルを設計する](src/main/smartdox/technical-guide/knowledge-modeling/textus-cncf-knowledge-modeling.dox/README.md)：BoK・業務知識、文芸モデル、CML、Cozyによる具体化を接続する。
- [Entityを知識として扱う](src/main/smartdox/technical-guide/entity-knowledge/textus-cncf-entity-knowledge.dox/README.md)：Entity、Information、知識表現、検索・AI提供を、識別・出典・参照権限を保って接続する。

2026-11-03にCore・日英本文・対応表を初稿として作成。全体像・DDD・CMLにも接続説明を追記した。この変更を含む確認HTML・PDFは未生成。既存PDFの配置状況は上記の過去の生成状態を示す。

# UIアーキテクチャ技術解説のDocument Project

Date: 2026-10-27
Status: Initial bilingual manuscript; source-only

## 位置付けと編集判断

security原稿と同じTextus Document Componentの製品技術文書として、`src/main/smartdox/ui/textus-cncf-ui-architecture.dox/`を新設した。Core、日英Document、派生SmartDoxを揃える。既存security原稿は変更しない。

説明は共通基盤→三つのUI構成→表示と実行の整合→開発・提供範囲→まとめ。要素技術を並べるだけにせず、業務契約の共有がUIの選択と両立する理由、設定と共通ランタイムが実装負担を減らす理由、表示と更新を分離する理由を説明する。

著者から、外部で自前のUIを作りRESTまたはgRPCで連携する構成を含める指示があった。独立した節を設け、標準Web／Flutterの利用を前提としない構成として扱った。REST／gRPCとView／Displayは別の軸であり、すべてをDisplay経由としない。独自UIの表示・操作と、サーバーの認証・認可・業務規則・状態遷移・永続化を分担する。

## 参照資料（内部設計資料）

以下はローカルの開発リポジトリにある内部資料。公開URLは未確認。

- `cloud-native-component-framework/docs/spec/static-web-application.md`: initial server rendering, page View, execution context; specification remains in progress.
- `cloud-native-component-framework/docs/notes/web-ui-dsl-bootstrap-core-ux-profile-design.md`: Textus Widget, Bootstrap Core, UX Profile, external Web frontend option; draft design.
- `cloud-native-component-framework/docs/notes/progressive-static-web-architecture-provisional-specification.md`: progressive enhancement direction; provisional.
- `cloud-native-component-framework/docs/spec/display-model-runtime.md`: typed projection from authorized semantic View; bounded implementation status.
- `cozy/docs/spec/logical-ui-model.md`: use-case realization and public binding contracts.
- `cozy/docs/journal/2026/09/2026-09-27-model-server-client-ui-continuity.md`: architecture direction connecting UI/Operation models, generated bindings/configuration and TFAF.
- `textus-flutter-application-framework/docs/notes/architecture.md`: Core/TFAF/application responsibility, configuration-driven UI, adaptive presentation.
- `textus-flutter-application-framework/docs/journal/2026/09/2026-09-27-configuration-driven-ui-framework.md`: configuration first, generated code second, custom code last; reference-application feedback.
- `textus-flutter-core/docs/notes/display-protocol-presentation-context.md`: nonnormative proposal separating runtime transport/context from UI composition.
- Existing security Document Project: source format, localization conventions and security cross-reference.

Repository roots: CNCF and Cozy under `/Users/asami/src/dev2025/`; the Flutter repositories and this documentation repository under `/Users/asami/src/dev2026/`.

## 提供範囲の扱い

仕様や方針を全経路の実装完了と扱わない。Static Web page View projectionの実装と、設計中のProgressive Static Web／UX Profileを区別。gRPCは著者指定のアーキテクチャ選択肢として記述し、今回確認した資料から標準アダプター提供済みとは断定しない。

## 確認範囲

JSON構造、Core IDと参照、日英の章・段落対応、SmartDoxの見出し後空行と日英span対応をローカルで点検する。Cozyによる受理、HTML/PDF生成、表示確認、配布はこのsource-only作業の対象外。コマンドログや検証結果の実行証跡は原稿に含めず `/private/tmp/textus-ui-guide-20261027/` に保持する。

## マルチスクリーンとTextus連動の位置付けを補強

+著者の補足に基づき、Flutter節を「Textusと連動するFlutterのアプリケーション・フレームワーク上でUIアプリを構築する」という位置付けから説明する構成に改めた。対象はiPhone／Android、タブレット、Web、デスクトップ。マルチスクリーンを画面サイズへの適応だけに限定しない。

+モデル駆動UIによって情報・操作・業務処理との接続を個別UI基盤の実装から分け、設定とバインディングを介して複数環境へ展開する因果関係をCoreと日英本文に追加した。続いてCore／TFAFの分担、生成・設定・独自拡張、画面サイズと入力方式への適応を説明する。Flutter WebとCNCFの標準Web UIは別の実現方式として区別した。まとめにも反映した。

+SmartDoxを日英Documentから更新。今回もsource-onlyで、HTMLは生成していない。


## Diagram and table edition

The reader requested more diagrams and tables for the UI and reactive guides. The ui guide now includes 4 explanatory figures and 4 comparison tables in both localized Document Descriptions and the derived bilingual SmartDox article. Figures retain editable PlantUML sources alongside localized PNG assets in `images/`.

The editorial change keeps the existing Core claims and technical boundaries. Figure and table blocks use the native Document Description v2 schema and explicit Core references. Lists of responsibilities and conditions are presented as comparisons; prose explains the relationships and qualifications. Japanese PDFs are regenerated from the current article through the native Cozy PDF route.

The figures cover the three UI delivery paths, View/Display projection versus mutation, model-driven Flutter deployment, and operation outcomes. Tables compare the three approaches, Flutter responsibilities, platform adaptations, and UI responses to execution outcomes.

Execution logs, snapshots and page-render checks remain outside product sources. Confirmation HTML is not regenerated in this PDF-focused revision.

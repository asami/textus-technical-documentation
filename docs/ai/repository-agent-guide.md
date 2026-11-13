# Technical Documentation Authoring

## 共通の技術文書執筆ルール

Technical Guideの執筆・修正では、ai-directiveの[Technical Writing Rules](../../ai/directive/core/technical-writing.md)（`core/technical-writing.md`）を読む。説明構造、Why・What、ロジックツリーの論理関係、文体、根拠、用語、図表・箇条書きの共通正本とする。

このリポジトリで固定したsubmoduleの `ai/directive/core/technical-writing.md` を読む。未初期化の場合は `git submodule update --init --recursive` で取得してから読む。取得できない場合は不足を報告し、別のcheckoutやGitHubの可変ブランチで固定版を代用しない。SimpleModeling.orgのサイト補足を、このリポジトリの共通規則として代用しない。

## このリポジトリでの適用

Coreを持つDocument Projectでは、主張とWhy・What、親子の論点、理由・原因・成立条件をCoreの段階で確認する。その意味を各言語のDocumentとSmartDoxへ対応させる。構文・参照の検査と、主張・根拠の妥当性の確認を区別する。

各ガイドの用語、対象範囲、日英表記、生成・公開状態は、そのDocument Projectの宣言とREADMEに従う。SmartDoxの構文には、同じai-directiveの `core/smartdox-authoring.md` を適用する。

## 共有ルールの読込入口

ルートの `AGENT.md`・`AGENTS.md` は `ai/directive/core/AGENT.md`、`RULE.md` は `ai/directive/core/RULE.md` へのシンボリックリンクである。共通AGENTの読込順に従い、共通RULE、存在するローカル規則、このガイド、技術文書編集時の共通執筆ルールを読む。submoduleの版は親リポジトリのgitlinkで固定する。

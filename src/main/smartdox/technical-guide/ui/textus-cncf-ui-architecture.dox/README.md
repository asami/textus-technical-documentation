# Textus/CNCF UI Architecture

Security guideと同じTextus Document Componentの技術解説。UI技術の一覧ではなく、要求・モデル・公開契約・表示・実行の組合せを説明する初稿。

- Shared meaning and reading flow: `content/core.yaml`
- Japanese prose: `content/ja/document.yaml`
- English prose: `content/en/document.yaml`
- Derived bilingual SmartDox: `index.dox`
- Local confirmation routes: `build/document-project-targets.yaml`

標準Web、Textus Flutter、外部独自UI（REST／gRPC接続）を並列の構成として扱う。View／Displayの利用と外部通信方式の選択は別の判断。業務規則、認証・認可、確定状態はサーバー側へ置く。

日英の説明範囲とCore参照は共通。`English｜日本語`の見出しと、英語・日本語の隣接したlang spanを使用する。Coreは親子Step、兄弟Step間のFlow、Step内の説明Structureを分離する。

初稿はsource-only。HTML・PDFの生成、CARへの組込み・配布は未実施。記載した設計全体の提供完了を意味しない。gRPCは今回の著者指示に基づく構成上の選択肢であり、標準アダプターの実装状況は未確認。出典と判断は `docs/journal/2026/10/2026-10-27-ui-architecture-document-project.md` に記録する。

## Illustrated edition

The localized Documents and derived `index.dox` include 4 figures and 4 tables. `images/*.puml` are the editable diagram sources; `images/*-ja.png` and `images/*-en.png` are their localized assets. The Japanese PDF is `target/textus-cncf-ui-architecture-ja.pdf`. Confirmation HTML predates this diagram/table revision.

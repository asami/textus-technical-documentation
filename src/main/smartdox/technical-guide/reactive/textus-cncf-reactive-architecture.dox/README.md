# Textus/CNCF Reactive Architecture

負荷の変動や部分的な障害があっても応答を維持するために、Textus/CNCFがアーキテクチャから実装・運用までの仕組みをどう組み合わせるかを説明する技術ガイド。Core、日英Document、派生SmartDoxで構成する。

- Shared claims and explanation flow: `content/core.yaml`
- Japanese and English prose: `content/ja/document.yaml`, `content/en/document.yaml`
- Derived bilingual manuscript: `index.dox`
- Declared Japanese confirmation routes: `build/document-project-targets.yaml`

主軸は「アーキテクチャから実装・運用までの工夫を組み合わせてリアクティブ性を実現する」。四特性（応答性、耐障害性、弾力性、メッセージ駆動）を、性能、可用性、整合性、安全性、観測可能性、保守性、検証容易性、運用コストへ接続する。

対象はApplication／Domain tier、メモリとWorking Set、CQRS・Aggregate・View、Consequence・Free Monad・UoW、Job・Task、Event・Workflow・状態機械、負荷制御、再試行・補償・永続回復、資源解放、Active／Standby・交換、観測と検証。仕組みの組合せ、品質への効果、適用条件を本文で説明する。

品質属性の整理を反映した日本語確認HTMLを `target/document-project/local-build/document-structure-html/index.html` に生成済み。PDF生成、配布、実行性能・可用性の測定は未実施。個別実装と設計・受入れ段階の違いは本文の提供範囲節とjournalに整理。内部資料と公開資料の出典は `docs/journal/2026/10/2026-10-27-reactive-architecture-document-project.md` に記録する。

## Illustrated edition

The localized Documents and derived `index.dox` include 5 figures and 8 tables. `images/*.puml` are the editable diagram sources; `images/*-ja.png` and `images/*-en.png` are their localized assets. The Japanese PDF is `target/textus-cncf-reactive-architecture-ja.pdf`. Confirmation HTML predates this diagram/table revision.

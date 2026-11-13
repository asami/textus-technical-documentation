# Entityを知識として扱う

アプリケーションが管理するEntityを知識として利用するには、値だけでなく、対象の意味、関係、出典と参照条件を保持する必要があります。本書は、Entity、Information、RDF等の知識表現、検索・AI提供をつなぐ構成と、CozyとTextus／CNCFの分担を説明します。BoKからモデルを設計する方法は別ガイドで扱います。

- [Core](content/core.yaml)
- [日本語本文](content/ja/document.yaml)
- [English](content/en/document.yaml)
- [日英SmartDox本文](index.dox)
- [関連ガイド：BoKからドメイン・モデルを設計する](../../knowledge-modeling/textus-cncf-knowledge-modeling.dox/README.md)

2026-11-03 初稿。Core・日英本文・対応表を作成。確認HTML・PDFは未生成。Cozyネイティブ検証は未実行。ローカルの参照・日英構造の整合性確認を実施。

## 2026-11-03 標準検索経路の明確化

モデルとインスタンスをMCPで公開し、インスタンスをRDF・embeddingの検索対象とする。MCPとAPIの両方から個別コーディングなしでデフォルトの検索機能を利用する説明をCore・日英本文・表へ反映。ユーザーによる基本機能の説明を根拠とする文書更新。ローカルのソース整合性を確認し、実装の再検証・Cozyネイティブ検証・HTML・PDF生成は行っていない。

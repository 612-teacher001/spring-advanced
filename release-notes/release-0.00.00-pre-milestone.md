Ver.0.00.00 - 初期構成リリース（pre-milestone）  
リリース日：2025-06-20

---

## 概要
マイルストーンベースのバージョニング運用を導入する前の、開発初期構成の状態を記録したリリースです。

---

## 含まれる内容

### ■ プロジェクト構成
- Java 21 + Spring Boot 3 による初期セットアップ
- Gradle によるビルド管理
- `.gitignore`、`README.md`、アプリケーション設定ファイル（`application.properties`）の整備

### ■ 初期ドメイン構成
- Entity／Repository／Service／Controller のレイヤー構成を準備

### ■ 動作確認用処理
- アクセス先URL：`http://localhost:8080/advanced.spring.org`
- トップページ表示（Thymeleaf 経由）

---

## 補足事項
- 本リリースは、今後のマイルストーン単位の機能追加に備えたベース構成です。
- バージョン番号の基準点（Ver.0.00.00）として扱われます。

---

## 関連コミット
- [4b38fb4](https://github.com/612-teacher001/spring-advanced/commit/4b38fb4): 初期構成プロジェクト作成と初期動作確認


# mirrg.helium.standard

- Repo: `https://raw.githubusercontent.com/MirrgieRiana/mirrg.helium.standard/master/maven`
- Artifacts
  - `mirrg:mirrg.helium.standard.hydrogen.struct:+`
  - `mirrg:mirrg.helium.standard.hydrogen.event:+`

## mirrg.helium.standard.hydrogen.struct

### 説明

タプルと構造体を提供する。

### エントリーポイント

- `mirrg.helium.standard.hydrogen.struct.*`

### 機能

- タプルと構造体の提供。
  - それぞれ4つまで。
  - それ以上は入れ子状にして使う。

## mirrg.helium.standard.hydrogen.event

### 説明

型によってイベントが振り分けられるシンプルなイベントマネージャ。

### エントリーポイント

- `mirrg.helium.standard.hydrogen.event.EventManager`

### 機能

- イベントマネージャを生成する（型引数Tを要求）。
- イベントマネージャにリスナーを登録（クラスとリスナーの対）。
  - 戻り値をbooleanで返す場合、falseを返すとリスナーから削除される。
- イベントマネージャにイベントをポストする（Tに代入互換な任意のオブジェクトを入力可能）。
  - イベントオブジェクトが登録時の受け入れクラスに代入互換である全てのリスナーが**登録順に**発動。

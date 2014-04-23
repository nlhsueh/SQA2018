Unit 5x: Testing Coverage
===

Testing coverage with JUnit and EclEmma

### Install EclEmma

Eclipse > Help > Install New Software > Add > “http://update.eclemma.org/"

### 如何判斷程式的涵蓋度？
* 紅色：表示一次都沒有執行過
* 黃色：部分執行
* 綠色：已執行

Laboratory
---

**Lab 1**: 寫一個程式判斷三角形，並寫一點 JUnit 測試碼，執行測試時，改以 EclEmma 來測試此程式。EclEmma 會標示你沒有測試到的部份，這時候在加上 JUnit 測試碼，逐步提高測試率。

**Lab 2**: 寫一個程式來依據 BMI 檢驗體重是否過重。BMI = 體重 (kg) / 身高 (m2)。其分級如下：

* 體重過輕	BMI ＜ 18.5
* 正常範圍	18.5 ≦ BMI ＜24
* 過    重	24 ≦ BMI ＜ 27
* 輕度肥胖	27 ≦ BMI ＜ 30
* 中度肥胖	30 ≦ BMI ＜ 35
* 重度肥胖	BMI ≧ 35

請用 EclEmma 來測試。

**Lab3**: 以下是一個最短路徑的程式，請改以 JUnit 的方式來測試它，並提昇包含度。

[Dijkstra program](src/junitdemo/Dijkstra.java)

Lab4: 以下是一個轉前序與後序的程式。請改以 JUnit 的方式來測試它，並提昇包含度。

[Infix program](src/junitdemo/Infix.java)
	


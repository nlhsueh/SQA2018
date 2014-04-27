JMeter performance test
===

What is JMeter
---

- 開源軟體
- 免費！
- 純Java開發，可跨平台
- 壓力測試與效能測試
- 編輯劇本、驗證功能、測試效能
- 不是網頁瀏覽器

Download
---
[Download](http://jmeter.apache.org/download_jmeter.cgi)

教材
---
[SEL, FCU](https://www.evernote.com/shard/s6/sh/e1b2d437-6dc8-411c-bc90-ac9113818c01/0f3e6286baac2a8fc59143d3311e0250)，逢甲軟工實驗室提供的教材

Laboratory
---

	**正式上課時 demo 用的受測系統的 IP 可能不同**

Lab1: 功能測試- Count

1. Count 為一個簡易的加法程式,此程式佈署於 http://140.134.26.7:8080/RT/Count.jsp (Count.jsp 程式之原始碼附於附錄)2. 請利用 JMeter 設計一些測試案例 並透過 JMeter 的檢視結果是查證 Count.jsp 結果是否正確。3. 請注意該測試案例應包含兩個步驟 a. 使用 GET request 取得網頁; b. 使用 POST request 送出資料4. 假設送出的資料為 12 和 13,使用[檢視結果樹]驗證結果是否正確

Lab2: 功能測試- GuessGame

1. GuessGame 為一個簡易猜數字遊戲,佈署於 http://140.134.26.7:8080/RT/GuessGame.jsp (GuessGame.jsp 程式之原始碼附於 附錄)。2. 使用 JMeter 建立該使用案例,並使用[HTTP 要求預設值],讓建立測試案例 時更容易且更有修改彈性。3. 假設送出的資料為 12 、 98 、 56 、 87,使用[檢視結果樹]觀看猜數字的 結果。4. 除了[檢視結果樹],再加上[檢視表格結果]接聽器,以練習運用其他格式的結 果。5. 使用[驗證:驗證回覆],練習在執行網頁程式之後,其回覆結果與預期結果 的正確性比對。6. 使用[接聽:驗證結果],練習檢視[驗證:驗證回覆]的測試結果。

Lab3: 壓力測試- GuessGame

1. 延續 Lab 2,將執行緒改為 10 執行測試並觀察回應時間。2. 新增[Summary report]接聽器,並將其他接聽器停用。3. 將執行緒改為 1,執行緒迴圈改為 10,執行測試,並與上一次的測試比較效能。若差異不顯著,可增加執行緒數量,至系統效能明顯衰退為止。4. 也可在測試計畫中建立多個執行緒群組,分別執行上述兩種測試條件,至系統效能明顯衰退為止。

Lab4: Recording I

1. 延續 Lab 1,使用 Recorder 幫助建立測試案例 
2. 當建立 Recorder 之後,使用重播來執行測試案例

Lab5: Recording II

1. 建立一個 Recorder 擷取登入 Yahoo,以及在網站中進行各種活動的動作。 
2. 檢視 Recorder,觀察哪些動作被記錄下來。3. 用 HTTP Proxy 和正規表達式(Regular Expression),篩選出 .jpg 和 .gif 的檔案。
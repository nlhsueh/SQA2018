Unit 1x: Debugging
===

Basic concept
---

步驟

- 從錯誤的外部形式入手，早出錯誤的地方
- 研究程式，找出原因
- 修改程式，排除錯誤
- 測試。要注意是否引入新的錯誤
- 重複上述動作直到沒有錯誤

方法

- 強行除錯：`watch variable`; memory dump; print variable
- 回朔法：沿著錯誤的症狀，一路辦隨著程式的流程回朔到可能出錯的源頭 
- `追蹤法`：透過追蹤程式的執行，觀察其路徑與預計的是否相同，找出問題的源頭
- 歸納演繹法：根據現象列出所有的假設，在逐步的實驗、分析以否決不對的假設，逐步的縮小可能的假設，找出真正問題的根源

原則

- 避免使用試探法，『碰碰運氣修改程式看看能不解決問題』，通常沒有辦法找出問題的根源
- 用頭腦分析思考與錯誤徵兆有關的資訊
- 除錯的工具只是輔助的手段。`工具不能取代思考`
- 避開死胡同。很久都解不開時，可以休息一下。問人家都會有一些新的靈感。
 
修改錯誤的原則

- 錯誤會群聚，如果這個地方有錯，相同的模組、相同的人、相同的時間所開發的程式也該檢查一下
- 不要只改徵兆，要找出原因，修改原因
- 小心改一個錯誤又帶來其他錯誤
- 修改也是一種 programming 活動，所有 programming 的原則都適用
- 修改前一定要做版本的 check in. 中間的過程如果具備意義也要做 check in


Debug Perspective
---

Debug 面板是一個可以方便你除錯的面板。包含以下的功能

- Breakpoint 中斷點。可以讓你在除錯模式下讓程式暫時停在某一點，這時候在一步步的追蹤你的程式。[Eclipse breakpoint view](http://help.eclipse.org/indigo/index.jsp?topic=%2Forg.eclipse.jdt.doc.user%2Freference%2Fviews%2Fdebug%2Fref-debug_view.htm).
- Variable view，變數觀察。可以讓你觀察程式執行過程中變數的變化，有了這個功能，你就不用一直把變數印出來。[Eclipse variable view](http://help.eclipse.org/indigo/index.jsp?topic=%2Forg.eclipse.jdt.doc.user%2Freference%2Fviews%2Fdebug%2Fref-debug_view.htm).
- Expression view: 可以觀看一個表達式的結果，特別是用在邏輯判斷或複雜的計算上很好用
- Add another view: 可在 variable view 及 expression view 點選 `open new view` 來針對某一個特別的變數或表達式做觀察。[expression view](http://help.eclipse.org/indigo/index.jsp?topic=%2Forg.eclipse.jdt.doc.user%2Freference%2Fviews%2Fdebug%2Fref-debug_view.htm).


[Eclipse debug view](http://help.eclipse.org/indigo/index.jsp?topic=%2Forg.eclipse.jdt.doc.user%2Freference%2Fviews%2Fdebug%2Fref-debug_view.htm) 介紹 debug 面板內的 icon 的意義。


Lab
---
**Lab 1**: debug this [program](/src/debug/BubbleSort.java)

**Lab 2**: 應⽤迴圈來寫一個程式計算 sin(x),其中 x 為一個徑度。30度 等於 30*PI/180徑度, 例如 sin(30’) = sin(pi/6) = sin(3.14159/6) 約等於 0.5。使用 debug 的工具來協助你撰寫此程式。sin(x) 的公式如下,迴圈跑的越多次值會越精準,你可以⼤約設定 10 個迴圈。

```
sin(x) = x - (x^3/3!) + (x^5/5!) - (x^7/7!) + ...
```

**Lab 3**: 改寫 Lab2, 一開始迴圈只跑3, 每次增加 2 個，一直到相鄰的兩次`新增迴圈`所得到的值小於 0.00001。請利用 debugging 的各種 view 來協助擬進行此程式。或使用這個 [buggy sample code](/src/debug/Sin.java) 來除錯。
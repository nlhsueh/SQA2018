Software Quality Assurance
===

Sample code for software quality assurance at FCU


### Debugging 
- read [debug](/debug/Debug.md) first,
- read [debug view](http://help.eclipse.org/indigo/index.jsp?topic=%2Forg.eclipse.jdt.doc.user%2Freference%2Fviews%2Fdebug%2Fref-debug_view.htm), [breakpoint view](http://help.eclipse.org/indigo/index.jsp?topic=%2Forg.eclipse.jdt.doc.user%2Freference%2Fviews%2Fdebug%2Fref-debug_view.htm), and [variable view](http://help.eclipse.org/indigo/index.jsp?topic=%2Forg.eclipse.jdt.doc.user%2Freference%2Fviews%2Fdebug%2Fref-debug_view.htm) 

Lab1: debug this [program](/src/debug/BubbleSort.java)

Lab2: 應⽤迴圈來寫一個程式計算 sin(x),其中 x 為一個徑度。30度 等於 30*PI/180徑度, 例如 sin(30’) = sin(pi/6) = sin(3.14159/6) 約等於 0.5。使用 debug 的工具來協助你撰寫此程式。sin(x) 的公式如下,迴圈跑的越多次值會越精準,你可以⼤約設定 10 個迴圈。

```
sin(x) = x - (x^3/3!) + (x^5/5!) - (x^7/7!) + ...
```

Expression view: 可以觀看一個表達式的結果，特別是用在邏輯判斷或複雜的計算上很好用
- Add another view: 可在 variable view 及 expression view 點選 `open new view` 來針對某一個特別的變數或表達式做觀察。
- 閱讀更多 [expression view](http://help.eclipse.org/indigo/index.jsp?topic=%2Forg.eclipse.jdt.doc.user%2Freference%2Fviews%2Fdebug%2Fref-debug_view.htm)

Lab3: 改寫 Lab2, 一開始迴圈只跑3, 每次增加 2 個，一直到相鄰的兩次`新增迴圈`所得到的值小於 0.00001。請利用 debugging 的各種 view 來協助擬進行此程式。或使用這個 [buggy sample code](/src/debug/Sin.java) 來除錯。


### Assertion
read [assertion](/debug/Assertion.md) first

### JUnit

### JMeter

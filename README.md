Software Quality Assurance
===

Sample code for software quality assurance at FCU


### Debugging 
- read [debug](/debug/Debug.md) first,
- read [debug view](http://help.eclipse.org/indigo/index.jsp?topic=%2Forg.eclipse.jdt.doc.user%2Freference%2Fviews%2Fdebug%2Fref-debug_view.htm), [breakpoint view](http://help.eclipse.org/indigo/index.jsp?topic=%2Forg.eclipse.jdt.doc.user%2Freference%2Fviews%2Fdebug%2Fref-debug_view.htm), and [variable view](http://help.eclipse.org/indigo/index.jsp?topic=%2Forg.eclipse.jdt.doc.user%2Freference%2Fviews%2Fdebug%2Fref-debug_view.htm) 

Lab1: debug this [pogram](/src/debug/BubbleSort.java)

Lab2: 應⽤用迴圈來寫⼀一個程式計算 sin(x),其中 x 為⼀一個數字。例如 sin(30’) = sin(pi/6) = sin(3.14159/6) = 0.5。使⽤用 debug 的⼯工具來協助你撰寫此程式。sin(x) 的公式如下,迴圈跑 的越多次值會越精準,你可以⼤大約設定 100 個迴圈。

```
sin(x) = x - (x^3/3!) + (x^5/5!) - (x^7/7!) + ...
```

Expression view: 可以觀看一個表達式的結果，特別是用在邏輯判斷上很好用
- Add another view: 可在 variable view 及 expression view 點選 `open new view` 來針對某一個特別的變數或表達式做觀察。
- 閱讀更多 [expression view](http://help.eclipse.org/indigo/index.jsp?topic=%2Forg.eclipse.jdt.doc.user%2Freference%2Fviews%2Fdebug%2Fref-debug_view.htm)

Lab3: 改寫 Lab2, 一開始迴圈只跑20, 每次增加20 個，一直到相鄰的兩個迴圈所得到的值小於 0.00001。請利用 debugging 的各種 view 來協助擬進行此程式 


### Assertion
read [assertion](/debug/Assertion.md) first

### JUnit

### JMeter

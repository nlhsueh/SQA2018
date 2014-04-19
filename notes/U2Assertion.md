Unit 2x: Assertion
===

>   幾乎百分百的確認，但在開發階段，我們還是會謹慎一點。

斷言是 java 中用來檢查程式中的假設與斷言。例如你寫一個程式判斷汽車（或火箭）的速度，不管怎麼快，也不可能比光速快。所以你可以下一個斷言：計算出來的速度必定小於光速。當這個斷言被違反了，表示你的程式可能出現問題。

除此以外，斷言也可以幫助提升程式的可閱讀。

### 語法

     assert Expression1 ;

或

     assert Expression1 : errMessage ; 
 
其中 Expression1 式一個 is a boolean 表示式. errMessage 式一個含有值的表示式，當斷言不成立時，會拋出 assertionErr 的例外，並把 errMessage 的值呈現出來。

### Enable and disable

To ensure that assertions are not a performance liability in deployed applications, assertions can be enabled or disabled when the program is started, and are disabled by default.

### 什麼時候該用 Invariant?

#### 1. Internal Invariants

```
if (i % 3 == 0) {
   ...
} else if (i % 3 == 1) {
   ...
} else {
   assert i % 3 == 2 : i;
   ...
}
```

#### 2. Class invariant

A class invariant is a predicate that `must be true before and after` any method completes. In the stack example, the invariant would be that the number of elements in the stack is greater than or equal to zero and the number of elements should not exceed the maximum capacity of the class. These conditions, for example, can be coded as follows:

```
private boolean inv() {
  return (num >= 0 && num < capacity);
}
```

To check that the stack should satisfy this predicate at all times, each public method and constructor should contain the assertion

    assert inv();

right before each return.

#### 3. Control-Flow Invariants 不變的控制流

對控制流程的斷言，"我相信絕對不會到 05 行"
```
01 void foo() { 
02    for (...) {
03       if (...) return;
04    }
05    assert false; 
06 }
```

#### 4. Postconditions 後置條件

在一段複雜的運算後，你斷定會成為真的事情，用斷言來加強。

```
public BigInteger modInverse(BigInteger m) {
   if (m.signum <= 0)
      throw new ArithmeticException("Modulus not positive: " + m);
      ... // Do the computation
   assert this.multiply(result).mod(m).equals(ONE) : this;
   return result; 
}
```

### 什麼時候不該使用 Assertion?


#### 1. 不要使用 assertion 來做公開方法的參數檢查

> 公開方法對參數的檢查本來就應該做，不要用 assertion 來檢查。

You can use an assertion to test a nonpublic method's precondition that you believe will be true no matter what a client does with the class.

```
private void setRefreshInterval(int interval) {
   // Confirm adherence to precondition in nonpublic method
   assert interval > 0 && interval <= 1000/MAX_REFRESH_RATE : interval;
   ... // Set the refresh interval 
}
```

#### 2. 不要使用 assertion 來執行任何與程式邏輯相關的操作

不要把程式該做的工作放在 assert 中。因為 assert 以後可能會被移除。

```
// wrong! - action is contained in assertion
assert names.remove(null);

// right - action precedes assertion
boolean nullsRemoved = names.remove(null);
assert nullsRemoved; // Runs whether or not asserts are enabled
```


Lab
---

**Lab 1**: 學期成績由期中考、期末考、平成成績所組成，各佔 30%, 30%, 40%。計算出的成績應該小於 100 分，請用斷言來確保最後成績的正確。

**Lab 2**: 經過 Sort 後，我們斷言第一個元素一定比第二個元素小，請用 assert 來完成。

	


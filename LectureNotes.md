SQA- Programming Practice
===

要提昇軟體品質，在程式撰寫的角度上有哪些要注意的？例如 debugging, 預防性的程式撰寫（Defensive programming）。有一些框架可以協助軟體的除錯，例如 JUnit, EclEmma, JMeter 等，這些會在此講義中介紹。

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


Unit 2x: Defensive Programming
===

>『不要樂觀的認為程式沒有問題，要預防性的想可能會出現什麼錯誤』

本章將介紹 Assertion 和 Exception Handling 如何達到預防性的程式撰寫。

Assertion
---

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

Exception Handling
---

> 例外：你不能掌控的事都可能出錯...

Types of exception
- checked exception: 你必須處理它（exception handle）或宣告它（讓別人來處理）
-- 根據你的應用設計必要的例外：InvalidTestException （考卷格式錯誤）、NoSuchAnswerException（選擇題答案沒有在選項內）
- unchecked exception: runtime exception，程式邏輯的錯誤，例如 NullPointerException, ArrayIndexOutOfBoundsException
-- 當發現此例外，你應該修正你的程式

### Catch or Declare Rule (CDR) 

Catch the exception and handle it
```
static void openFile() {
	try {
		FileInputStream f = new FileInputStream("grade.txt");
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
}
```	

Declare (or Re-throw) the exception

```
static void openFile2() throws FileNotFoundException {
	try {
		FileInputStream f = new FileInputStream("grade.txt");
	} catch (FileNotFoundException e) {
		throw new FileNotFoundException();
	}
}
```

### Define your exception class

```
static double getGradeAverage(int g[]) throws WrongGradeException {
	int sum = 0;
	for (int i = 0; i < g.length; i++) {
		if (g[i] > 100 || g[i] < 0) {
			throw new WrongGradeException();
		}
		sum += g[i];
	}
	return sum / (double) (g.length);
}
```

```
class WrongGradeException extends Exception {
	public WrongGradeException(String title) {
		super(title);
	}

	public WrongGradeException() {
		super("The grade is wrong, maybe > 100 or < 0");
	}
}
```

Read the [demo code](src/debug/ExceptionDemo.java).

Unit 3x: JUnit
===

###開發流程

1. 設計程式框架
2. 設計測試案例：利用 JUnit 設計測試案例。
3. 執行測試碼：執行 JUnit 測試碼，會跑出很多的『錯誤』。
4. 撰寫程式
5. 執行測試碼：執行 JUnit 測試碼，錯誤應該會逐漸減少。


### 用法
[JUnit API](http://junit.sourceforge.net/javadoc/)

記得要 import org.junit.Assert.*;

org.junit.Assert
* assertEquals()
* assertTrue()
* assertArrayEquals()
* assertSame()
* assertNotNull
* assertNull
* fail()

### Eclipse

在 Eclipse 時使用時很方便，在你愈測試的類別中按右鍵點選 New >> Junit class 就可以新增 junit class。也可以直接新增 junit class 時選擇所要測試的類別及方法。

###重要語法

####@Test

Mark your test cases with `@Test` annotations. You don’t need to prefix your test cases with “test”.  In addition, your class does not need to extend from “TestCase” class.


```
@Test
public void addition() {
   assertEquals(12, simpleMath.add(7, 5));
}
```

```
@Test
public void subtraction() {
   assertEquals(9, simpleMath.substract(12, 3));
}
```

#### @Before and @After

Use @Before and @After annotations for “setup” and “tearDown” methods respectively. They run before and after every test case.

```
@Before
public void runBeforeEveryTest() {
   simpleMath = new SimpleMath();
}
```
```
@After
public void runAfterEveryTest() {
   simpleMath = null;
}
```

#### @BeforeClass and @AfterClass

Use @**BeforeClass** and @**AfterClass** annotations for class wide “setup” and “tearDown” respectively. Think them as one time setup and tearDown. They run for one time before and after all test cases.

```
@BeforeClass
public static void runBeforeClass() {
   // run for one time before all test cases
}
```
```
@AfterClass
public static void runAfterClass() {
   // run for one time after all test cases
}
```

#### Exception Handling

Use “**expected**” paramater with @Test annotation for test cases that expect exception. Write the class name of the exception that will be thrown.

```
@Test(expected = ArithmeticException.class)
public void divisionWithException() {
   // divide by zero
   simpleMath.divide(1, 0);
}
```

#### @Ignore

Put @Ignore annotation for test cases you want to ignore. You can add a string parameter that defines the reason of ignorance if you want.

```
@Ignore(“Not Ready to Run”)
@Test
public void multiplication() {
   assertEquals(15, simpleMath.multiply(3, 5));
}
```

#### Timeout

Define a timeout period in **miliseconds** with “timeout” parameter. The test fails when the timeout period exceeds.

```
@Test(timeout = 1000)
public void infinity() {
   while (true)
      ;
}
```

#### Array

Compare arrays with new assertion methods. Two arrays are equal if they have the same length and each element is equal to the corresponding element in the other array; otherwise, they’re not.

```
public static void assertEquals(Object[] expected, Object[] actual);
```

```
public static void assertEquals(String message, Object[] expected, Object[] actual);
```

```
@Test
public void listEquality() {
   List expected = new ArrayList();
   expected.add(5);

   List actual = new ArrayList();
   actual.add(5);

   assertEquals(expected, actual);
}
```

### Demo

- *SimpleAdd* example: [Source code](src/junitdemo/SimpleAdd.java) and its [junit test code](src/junitdemo/SimpleAddTest.java)
- *Sin* example: [Source code](src/junitdemo/Sin.java) and its [junit test code](src/junitdemo/SinTest2.java)


Unit 4x: Testing Coverage
===
Testing coverage with JUnit and EclEmma

### Install EclEmma

Eclipse > Help > Install New Software > Add > “http://update.eclemma.org/"

### 如何判斷程式的涵蓋度？
* 紅色：表示一次都沒有執行過
* 黃色：部分執行
* 綠色：未執行


Unit 5x: Improving testability
===

Using Logging
---
Use logging to improve the testability

> Logging 是專業程式的表現

### Overview of Control Flow

Application make logging calls on **Logger** object.

Logger allocates LogRecord Object

Logger pass LogRecord to Handler

### LEVEL
From Level.FINEST to Level.SEVERE

* SEVERE (highest value)
* WARNING
* INFO
* CONFIG
* FINE
* FINER
* FINEST (lowest value)

### Formatters
Java SE also includes two standard Formatters:

- **SimpleFormatter**: Writes brief "human-readable" summaries of log records.
- **XMLFormatter**: Writes detailed XML-structured information.

### Handlers
Java SE provides the following Handlers:

- **StreamHandler**: A simple handler for writing formatted records to an OutputStream.
- ConsoleHandler: A simple handler for writing formatted records to System.err
- **FileHandler**: A handler that writes formatted log records either to a single file, or to a set of rotating log files.
- **SocketHandler**: A handler that writes formatted log records to remote TCP ports.
- **MemoryHandler**: A handler that buffers log records in memory.

### Example

```
public class LoggerDemo {

	// Obtain a suitable logger.
	private static Logger logger = Logger.getLogger("debug.LoggerDemo");

	private static FileHandler fh;

	public static void main(String argv[]) {

		try {
			fh = new FileHandler("mylog.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Log a FINE tracing message
		logger.fine("doing stuff");

		// Add two handler
		logger.addHandler(new ConsoleHandler());
		logger.addHandler(fh);
		try {
			div(100, 0);
		} catch (Exception ex) {
			// Log the exception
			logger.log(Level.WARNING, "", ex);
		}
		logger.fine("done");
	}
}
```	
	


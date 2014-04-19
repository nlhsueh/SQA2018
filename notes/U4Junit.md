Unit 4x: JUnit
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

Laboratory
---

**Lab 1**: 寫一個程式來依據 BMI 檢驗體重是否過重。BMI = 體重 (kg) / 身高 (m2)。其分級如下：
* 體重過輕	BMI ＜ 18.5
* 正常範圍	18.5 ≦ BMI ＜24
* 過    重	24 ≦ BMI ＜ 27
* 輕度肥胖	27 ≦ BMI ＜ 30
* 中度肥胖	30 ≦ BMI ＜ 35
* 重度肥胖	BMI ≧ 35

開發流程

1. design class *Health.checkBMI(): String*
2. design *HealthTest.checkBMITest()*
3. implement *Health.checkBMI()*
4. test *checkBMI()* by *checkBMITest()*

**Lab 2**: 寫一個程式判斷三角形。輸入的參數是三邊的長，若不符合三角形定義（任兩邊和大於第三邊）則會拋出例外。否則回傳 "一般三角形"、"等腰三角形"、"正三角形"等。開發之前，請先建立 JUnit 測試案例，並使用 **@Test(expected=...)** 的方式來測試例外。

Hint: public String check(int a, int b, int c) throws Exceptions

Hint: 參考 [SimpleTest](src/junitdemo/SimpleAddTest.java)

**Lab 3**: 針對一個排序程式設計測試案例 SortTest，每一次測試之前會先做一些初始化：從檔案中讀取資料，寫到陣列 data[]中，SortTest 中的 testSort() 再針對 data[] 中的資料做排序。請利用 **@Before** 來完成此工作。

**Lab 4**: 寫一個無窮迴圈的程式，並使用 junit 來測試。利用 **timeout** 的參數來跳出迴圈。
	


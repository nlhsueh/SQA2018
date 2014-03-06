JUnit basic concept
===

Design => JUnit => Program => Test

JUnit 4 in 60 sec
===
> @Test

在你的測試馬上面加上一個 @Test 的標記。

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

> @Before and @After

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

> @BeforeClass and @AfterClass

Use @BeforeClass and @AfterClass annotations for class wide “setup” and “tearDown” respectively. Think them as one time setup and tearDown. They run for one time before and after all test cases.

```
@BeforeClass
public static void runBeforeClass() {
   // run for one time before all test cases
}
```

@AfterClass
public static void runAfterClass() {
   // run for one time after all test cases
}
[/source]

> Exception Handling

Use “expected” parameter with @Test annotation for test cases that expect exception. Write the class name of the exception that will be thrown.

```
@Test(expected = ArithmeticException.class)
public void divisionWithException() {
   // divide by zero
   simpleMath.divide(1, 0);
}
```

> @Ignore

Put @Ignore annotation for test cases you want to ignore. You can add a string parameter that defines the reason of ignorance if you want.
[source:Java]

```
@Ignore(“Not Ready to Run”)
@Test
   public void multiplication() {
   assertEquals(15, simpleMath.multiply(3, 5));
}
```


> Timeout

Define a timeout period in mili-seconds with “timeout” parameter. The test fails when the timeout period exceeds.
[source:Java]

```
@Test(timeout = 1000)
public void infinity() {
while (true)
   ;
}
```

> New Assertions

Compare arrays with new assertion methods. Two arrays are equal if they have the same length and each element is equal to the corresponding element in the other array; otherwise, they’re not.

```
public static void assertEquals(Object[] expected, Object[] actual);

public static void assertEquals(String message, Object[] expected, Object[] actual);
```

[source:Java]

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
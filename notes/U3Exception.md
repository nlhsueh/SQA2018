Unit 3x: Exception Handling
===

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


Labtoratory
---

**Lab 1**: 修改 [ExceptionDemo.java](src/debug/ExceptionDemo.java) 中的 getGradeAverage，當學生個數為 0 時，會拋出一個 NoStudentException。	

	


package junitdemo;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

/*
 * 這個範例主要要展示『如何正確的設計 異常測試 (testing exception) 的方法。
 * 注意不要把測試異常和一般的功能測試放在一個地方測試
 */
public class JUnitDemo02 {

	/*
	 * 這是功能是否正常
	 */
	@Ignore
	@Test	
	public void test1() {
		F f = new F();
		//這裡加上 try...catch 是為了讓 compiler happy
		try {
			//正常的測試案例
			assertEquals(12, f.div(12, 1));

			// 以下故意把測試案例寫錯。當 JUnit 遇到此錯誤後會停止，所以下一個錯誤就不會被檢查出來。
			assertEquals(13, f.div(12, 1));
			// 這個也是錯誤的
			assertEquals(24, f.div(12, 1));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * 測試異常是否如預期的拋出 (Testing exception)
	 * 注意 @Test 後有加上 expected = Exception.class; test2() 後有 throws Exception
	 */
	@Test(expected = Exception.class)
	public void test2() throws Exception {
		F f = new F();
		assertEquals(13, f.div(12, 1)); //不好的測試案例設計，應移到 test1 中測試
		assertEquals(1, f.div(12, 0)); //test2 裡面應該都是異常的測試
	}

	/*
	 * The class to be tested
	 */
	class F {
		public int div(int x, int y) throws Exception {
			// if (y==0) throw new Exception("divided by 0");

			return x / y;
		}
	}// class F

}

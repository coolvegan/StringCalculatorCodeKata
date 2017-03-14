import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StringCalculatorTest {
	StringCalculator sc = new StringCalculator();
	int Summe;

	@Test
	public void testEmptyStringAsParam() {	
		Summe = sc.Add("");
		assertEquals(0, Summe);
	}
	@Test
	public void test4And7() {	
		Summe = sc.Add("4,7");
		assertEquals(11, Summe);
	}	
	@Test
	public void test2() {	
		Summe = sc.Add("2");
		assertEquals(2, Summe);
	}	
	@Test
	public void test8And9() {	
		Summe = sc.Add("8,9");
		assertEquals(17, Summe);
	}	
	@Test
	public void test8And9And4() {	
		Summe = sc.Add("8,9,4");
		assertEquals(21, Summe);
	}	
	
	@Test
	public void test2Digits() {
		
		Summe = sc.Add("12,2");
		assertEquals(14, Summe);
	}	
	
	@Test
	public void test343And83() {
		
		Summe = sc.Add("343,83");
		assertEquals(426, Summe);
	}	
	@Test
	public void test2And33And83And111() {	
		Summe = sc.Add("2, 33, 83, 111");
		assertEquals(229, Summe);
	}
	@Test
	public void testNewline() {	
		Summe = sc.Add("1\n2,3");
		assertEquals(6, Summe);
	}	
	
	@Test
	public void testNewDelimiter() {	
		sc.setDelimiter(";");
		Summe = sc.Add("1;3");
		assertEquals(4, Summe);
	}	
	@Test
	public void test2ndNewDelimiter() {
		sc.setDelimiter("\n");
		Summe = sc.Add("1\n3\n7");
		assertEquals(11, Summe);
	}		
	
	@Test
	public void testDelimiterInString() {	
		Summe = sc.Add(";\n2;4");
		assertEquals(6, Summe);
	}	
	
	@Test
	public void testANewDelimiterInString() {
		Summe = sc.Add(".\n2.4.7.30");
		assertEquals(43, Summe);
	}		
	
	@Test(expected = Exception.class)  
	public void testNegativeNumberInString() {
		Summe = sc.Add("-1");
	}	
	
	@Test(expected = Exception.class)  
	public void testNegativeNumberInABigString() {
		Summe = sc.Add(",\n2,5,32,4,-1");
	}			
}

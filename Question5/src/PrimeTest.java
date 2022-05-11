import static org.junit.Assert.*;

import org.junit.Test;

public class PrimeTest {

	@Test
	public void test1() {
		
		boolean prime = Prime.isPrime(2);
		
		assertTrue("Failed", prime);
	}
	
	@Test
	public void test2() {
		
		boolean prime = Prime.isPrime(3);
		
		assertTrue("Failed", prime);
	}
	
	@Test
	public void test3() {
		
		boolean prime = Prime.isPrime(4);
		
		assertTrue("Failed", prime);
	}
	
	@Test
	public void test4() {
		
		boolean prime = Prime.isPrime(5);
		
		assertTrue("Failed", prime);
	}
	
	@Test
	public void test5() {
		
		boolean prime = Prime.isPrime(6);
		
		assertTrue("Failed", prime);
	}


}

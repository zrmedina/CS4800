import static org.junit.Assert.*;

public class Test {

	@org.junit.Test
	public void test() {
		
		Search s = new Search();
		int[] array = {3,4,1,2,5};
		
		int position = s.binarySearch(array, 2);
		System.out.println(position);
		assertEquals("Failed", position, 3);
	}

}

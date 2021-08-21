package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
/**
 * Tests various methods to demonstrate the use of Generic Collections. 
 * 
 * @author Brittany Pruneau 
 *
 */

class GenericCollectionsTest
{

	@Test
	void testLettersAndNumbers()
	{
		List<String> exp = Arrays.asList("U(h)", "L(g)", "U(f)", "U(e)", "L(d)", "N(5)", "L(c)", "U(b)", "L(a)");
		assertEquals(exp, GenericCollections
				.lettersAndNumbers(Arrays.asList('?', 'a', 'B', 'c', '5', 'd', 'E', 'F', 'g', '%', '#', 'H')));
	}

	@Test
	void testLettersAndNumbersNumbersNull()
	{
		List<String> exp = null;
		assertEquals(exp, GenericCollections.lettersAndNumbers(null));
	}
	
	@Test
	void testLettersAndNumbersNumbers_Empty()
	{
		List<Character> exp = new ArrayList<>();
		assertEquals(exp, GenericCollections.lettersAndNumbers(exp));
	}
	
	@Test
	void testLettersAndNumbersNumbers_Symbols()
	{
		List<Character> exp = new ArrayList<>();
		List<Character> test = new ArrayList<>();
		test.add('?');
		test.add('#');
		test.add('@');
		assertEquals(exp, GenericCollections.lettersAndNumbers(test));
	}
	
	@Test
	void testLettersAndNumbersNumbers_Numbers()
	{
		List<Character> test = new ArrayList<>();
		test.add('1');
		test.add('*');
		test.add('4');
		test.add('+');
		test.add('3');
		test.add('-');
		test.add('2');
		List<String> exp = new ArrayList<>();
		exp.add("N(2)");
		exp.add("N(3)");
		exp.add("N(4)");
		exp.add("N(1)");
		assertEquals(exp, GenericCollections.lettersAndNumbers(test));
	}

	@Test
	void testLettersAndNumbersNumbersReturned()
	{
		List<String> exp = Arrays.asList("N(2)", "N(3)", "N(4)", "N(1)");
		assertEquals(exp, GenericCollections.lettersAndNumbers(Arrays.asList('1', '*', '4', '+', '3', '-', '2')));
	}

	@Test
	void testLettersAndNumbersNotLettersNumbers()
	{
		List<String> exp = Arrays.asList();
		assertEquals(exp, GenericCollections.lettersAndNumbers(Arrays.asList('?', '#', '@')));
	}

	@Test
	void modify()
	{
		assertThrows(NullPointerException.class, () ->
		{
			GenericCollections.modify(null);
		});
	}
	
	@Test
	void modify_3s()
	{
		int expec =13;
		List<Integer> input = new ArrayList<>(); 
	       assertEquals(expec, GenericCollections.modify(input));
	}
	
	@Test
	void modify_1through7()
	{
		int expec =16;
		List<Integer> input = new ArrayList<>();
		for(int i = 1; i<8; i++)
		{
			input.add(i);
		}
	       assertEquals(expec, GenericCollections.modify(input));
	}

	
	@Test
	void modify_Empty()
	{
		int expec =13;
		List<Integer> input = new ArrayList<>(); 
		input.add(3);
		input.add(-6);
		input.add(3);
		input.add(-9);
		input.add(-3);
		input.add(0);
		input.add(12);
		input.add(3);

		
	       assertEquals(expec, GenericCollections.modify(input));
	}
	
	
	@Test
	void modify_Multiples_Of_Three()
	{
		List<Integer> input = new ArrayList<>();
		input.add(3);
		input.add(-6);
		input.add(3);
		input.add(-9);
		input.add(-3);
		input.add(0);
		input.add(12);
		input.add(3);
			int exp = 13;
			assertEquals(exp, GenericCollections.modify(input));
	}
	
	@Test
	void modify_Unique()
	{
		List<Integer> input = new ArrayList<>();
		for(int i=1; i<8; i++)
		{
			input.add(i);
		}
			int exp = 16;
			assertEquals(exp, GenericCollections.modify(input));
	}
	
	@Test
	void removeEveryNthElement()
	{
		ArrayList<Integer> test = new ArrayList<>();
		for(int i = 1; i<10; i++)
		{
			test.add(i);
		}
		int n = 3; 
		ArrayList<Integer> exp = new ArrayList<>(); 
		exp.add(1);
		exp.add(2);
		exp.add(4);
		exp.add(5);
		exp.add(7);
		exp.add(8);
		GenericCollections.removeEveryNthElement(test,3);
		assertEquals(exp,test);
		//(exp.equals(test));
	}
	
	@Test
	void removeEveryNthElement_Decimals()
	{
		ArrayList<Double> test = new ArrayList<>();
		test.add(1.1);
		test.add(2.2);
		test.add(3.3);
		test.add(4.4);
		test.add(5.5);
		test.add(6.6);
		test.add(7.7);
		test.add(8.8);
		test.add(9.9);
		ArrayList<Double> exp = new ArrayList<>(); 
		exp.add(1.1);
		exp.add(3.3);
		exp.add(5.5);
		exp.add(7.7);
		exp.add(9.9);
		GenericCollections.removeEveryNthElement(test,2);
		assertEquals(exp,test);
		//(exp.equals(test));
	}
	
	@Test
	void removeEveryNthElement_Letters()
	{
		ArrayList<String> test = new ArrayList<>();
		test.add("AA"); 
		test.add("BB");
		test.add("CC");
		test.add("DD"); 
		test.add("EE"); 
		
		ArrayList<String> exp = new ArrayList<>(); 
		exp.add("AA"); 
		exp.add("BB");
		exp.add("CC");
		exp.add("DD"); 
		exp.add("EE"); 
		GenericCollections.removeEveryNthElement(test,12);
		assertEquals(exp,test);
	}
	
	@Test
	void removeEveryNthElement_doubles()
	{
		ArrayList<Integer> test = new ArrayList<>();
		for(int i = 1; i<12; i+=2)
		{
			test.add(i);
			test.add(i);
		}
		ArrayList<Integer> exp = new ArrayList<>(); 
		exp.add(1); 
		exp.add(1);
		exp.add(3);
		exp.add(5); 
		exp.add(7); 
		exp.add(7);
		exp.add(9);
		exp.add(11);
		GenericCollections.removeEveryNthElement(test,3);
		assertEquals(exp,test);
	}
	
	@Test
	void removeEveryNthElement_XYZ()
	{
		ArrayList<Character> test = new ArrayList<>();
		test.add('z'); 
		test.add('y');
		test.add('z');
		ArrayList<Character> exp = new ArrayList<>(); 
		GenericCollections.removeEveryNthElement(test,1);
		assertEquals(exp,test);
	}
	
	@Test
	void removeEveryNthElement_empty()
	{
		ArrayList<?> test = new ArrayList<>(); 
		ArrayList<?> exp = new ArrayList<>(); 
		GenericCollections.removeEveryNthElement(test,1);
		assertEquals(exp,test);
	}

}
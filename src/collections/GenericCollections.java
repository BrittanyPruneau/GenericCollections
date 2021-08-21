package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Uses various java Generic Collections to add and remove elements from all types of lists. 
 * 
 * @author Brittany Pruneau 
 *
 */
public class GenericCollections
{
	/*
	 * Transforms a character list into a new list of strings that labels each character 
	 * of the original list. 
	 */
	public static List<String> lettersAndNumbers(List<Character> list)
	{
		List<String> newList = new ArrayList<>();

		if (list == null)
		{
			return null;
		}
		if (list.isEmpty())
		{
			return newList;
		}
		for (Character c : list)
		{
			if (Character.isUpperCase(c))
			{
				newList.add("U" + "(" + Character.toLowerCase(c) + ")");
			}
			if (Character.isLowerCase(c))
			{
				newList.add("L" + "(" + Character.toLowerCase(c) + ")");
			}
			if (Character.isDigit(c))
			{
				newList.add("N" + "(" + c + ")");
			}
		}
		Collections.reverse(newList);
		return newList;
	}

	/*
	 * Removes every third element of the list and adds 5 elements of each factor of 4,5, and 6. 
	 */
	public static int modify(List<Integer> list)
	{
		Set<Integer> set = new HashSet<>();
		if (list == null)
		{
			throw new NullPointerException("List cannot be null.");
		}
		list.removeIf(n -> n % 3 == 0);
		int j = 0;
		int k = 0;
		int l = 0;

		for (int i = 0; i < 5; i++)
		{
			j += 4;
			list.add(j);
			k += 5;
			list.add(k);
			l += 6;
			list.add(l);
		}

		Collections.sort(list);
		set.addAll(list);
		return set.size();
	}

	/*
	 * Receives all types of lists and removes elements in the list by a user specified index. 
	 */
	public static void removeEveryNthElement(List<?> list, int n)
	{
		
		if(list==null)
		{
			throw new NullPointerException("List cannot be null.");
		}
		else if(n<=0)
		{
			throw new IllegalArgumentException("n needs to be a positive number."); 
		}
		else
		{
		
		int i =0; 
		Iterator<?> iter = list.iterator(); 
		while(iter.hasNext())
		{
			i++;
			iter.next();
			if(i%n == 0)
			{
				iter.remove(); 
			}
		}
		System.out.println(list);
		}
	}
}

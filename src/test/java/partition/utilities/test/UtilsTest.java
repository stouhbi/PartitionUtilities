package partition.utilities.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;

import com.partition.utilities.EmptyArrayException;
import com.partition.utilities.Utils;

public class UtilsTest {

	/**
	 *  to test list of integers with odered partionning
	 */
	@Test
	public void TestOrderedListInteger() {

		List<Integer> sourceList = Arrays.asList(1,2,3,4,5);
		
		List<List<Integer>> firstTest = new ArrayList<List<Integer>>();
		firstTest.add(Arrays.asList(1,2));
		firstTest.add(Arrays.asList(3,4));
		firstTest.add(Arrays.asList(5));

		List<List<Integer>> secondTest = new ArrayList<List<Integer>>();
		secondTest.add(Arrays.asList(1,2,3));
		secondTest.add(Arrays.asList(4, 5));

		List<List<Integer>> thirdTest = new ArrayList<List<Integer>>();
		thirdTest.add(Arrays.asList(1));
		thirdTest.add(Arrays.asList(2));
		thirdTest.add(Arrays.asList(3));
		thirdTest.add(Arrays.asList(4));
		thirdTest.add(Arrays.asList(5));

		assertTrue(CollectionUtils.isEqualCollection(firstTest, Utils.partition(sourceList, 2)));
		assertTrue(CollectionUtils.isEqualCollection(secondTest, Utils.partition(sourceList, 3)));
		assertTrue(CollectionUtils.isEqualCollection(thirdTest, Utils.partition(sourceList, 1)));
	}
	
	/**
	 * test the method listEqualsIgnoreOrder
	 */
	@Test
	public void TestListequalUnordered() {
		List<Integer> list1 = Arrays.asList(1, 3, 5, 6, 7);
		List<Integer> list2 = Arrays.asList(7, 5, 3, 1, 6);
		
		assertTrue(Utils.listEqualsIgnoreOrder(list1, list2));
		
	}
	
	/**
	 *  to test parallel partionning
	 *  verifies if the output list of lists have the same values as the input list
	 */
	@Test
	public void TestUnOrderedListInteger() {

		List<Integer> sourceList = Arrays.asList(1,2,3,4,5);

		assertTrue(Utils.listEqualsIgnoreOrder(sourceList, Utils.partitionParallel(sourceList, 2).stream().flatMap(List::stream)
		        .collect(Collectors.toList())));
	}
	
	

	/**
	 * test parallel partionning for Sring objects
	 */
	@Test
	public void TesOrderedtListString() {

		List<String> sourceList = Arrays.asList("Un","deux","Trois","QuATre","Cinq");
		Collection<List<String>> solution = Arrays.asList(Arrays.asList("Un","deux")
				, Arrays.asList("Trois","QuATre")
				, Arrays.asList("Cinq"));

		assertTrue(CollectionUtils.isEqualCollection(solution,  Utils.partition(sourceList, 2)));
	}


	/**
	 *  test array for parallel partionning
	 * @throws EmptyArrayException
	 */
	@Test
	public void TestOrderedArray() throws EmptyArrayException {

		// you can't use primitives
		Integer[] array = {1,2,3,4,5};

		List<List<Integer>> firstTest = new ArrayList<List<Integer>>();
		firstTest.add(Arrays.asList(1,2));
		firstTest.add(Arrays.asList(3,4));
		firstTest.add(Arrays.asList(5));

		List<List<Integer>> secondTest = new ArrayList<List<Integer>>();
		secondTest.add(Arrays.asList(1,2,3));
		secondTest.add(Arrays.asList(4, 5));

		List<List<Integer>> thirdTest = new ArrayList<List<Integer>>();
		thirdTest.add(Arrays.asList(1));
		thirdTest.add(Arrays.asList(2));
		thirdTest.add(Arrays.asList(3));
		thirdTest.add(Arrays.asList(4));
		thirdTest.add(Arrays.asList(5));

		assertTrue(CollectionUtils.isEqualCollection(firstTest, Utils.partition(array, 2)));
		assertTrue(CollectionUtils.isEqualCollection(secondTest, Utils.partition(array, 3)));
		assertTrue(CollectionUtils.isEqualCollection(thirdTest, Utils.partition(array, 1)));
	}

	/**
	 * to test parallel partionning
	 * @throws EmptyArrayException
	 */
	@Test
	public void TestUnOrderedArray() throws EmptyArrayException {
		Integer[] tableau = {1,2,3,4,5};

		List<Integer> arrayTest = Arrays.asList(3,2,1,5,4);
		
		assertTrue(Utils.listEqualsIgnoreOrder(arrayTest, Utils.partitionParallel(tableau, 2).stream().flatMap(List::stream)
		        .collect(Collectors.toList())));
		
	}

	/**
	 * test if array is empty exception - Ordered Pationning
	 * @throws EmptyArrayException
	 */
	@Test(expected=EmptyArrayException.class)
	public void EmptyArrayOrdered() throws EmptyArrayException {

		String[] emptyTab = new String[3];

		Utils.partition(emptyTab, 2);
		fail("Expected EmptyArrayException");

	}

	/**
	 * test if array is empty exception - Parallel Patitionning
	 * @throws EmptyArrayException
	 */
	@Test(expected=EmptyArrayException.class)
	public void EmptyArray1() throws EmptyArrayException {
		
		String[] emptyTab = new String[3];
		
		Utils.partitionParallel(emptyTab, 2);
		fail("Expected EmptyArrayException");

	}


}

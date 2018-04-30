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
	 *  Pour tester les listes d'entiers en ordre
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
	 * Permet de test la fonction listEqualsIgnoreOrder
	 */
	@Test
	public void TestListequalUnordered() {
		List<Integer> list1 = Arrays.asList(1, 3, 5, 6, 7);
		List<Integer> list2 = Arrays.asList(7, 5, 3, 1, 6);
		
		assertTrue(Utils.listEqualsIgnoreOrder(list1, list2));
		
	}
	
	/**
	 *  Pour tester les listes d'entiers en ordre
	 *  ne verifier que la liste en sortie contient les même élements que la liste en entrée
	 */
	@Test
	public void TestUnOrderedListInteger() {

		List<Integer> sourceList = Arrays.asList(1,2,3,4,5);

		assertTrue(Utils.listEqualsIgnoreOrder(sourceList, Utils.partitionParallel(sourceList, 2).stream().flatMap(List::stream)
		        .collect(Collectors.toList())));
	}
	
	

	/**
	 * Pour tester les listes avec des String en Ordre
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
	 *  pour tester les tableaux dans l'ordre
	 * @throws EmptyArrayException
	 */
	@Test
	public void TestOrderedArray() throws EmptyArrayException {

		// malheureusement il faut utiliser les classes pour les primitives
		Integer[] tableau = {1,2,3,4,5};

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

		assertTrue(CollectionUtils.isEqualCollection(firstTest, Utils.partition(tableau, 2)));
		assertTrue(CollectionUtils.isEqualCollection(secondTest, Utils.partition(tableau, 3)));
		assertTrue(CollectionUtils.isEqualCollection(thirdTest, Utils.partition(tableau, 1)));
	}


	/**
	 * Tester un tableau vide
	 * @throws EmptyArrayException
	 */
	@Test(expected=EmptyArrayException.class)
	public void EmptyArrayOrdered() throws EmptyArrayException {

		String[] emptyTab = new String[3];

		Utils.partition(emptyTab, 2);
		fail("Expected EmptyArrayException");

	}

	// Tester un tableau vide par PartitionParallel
	@Test(expected=EmptyArrayException.class)
	public void EmptyArray1() throws EmptyArrayException {
		String[] emptyTab = new String[3];
		Utils.partitionParallel(emptyTab, 2);
		fail("Expected EmptyArrayException");

	}


}

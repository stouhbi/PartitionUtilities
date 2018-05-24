package com.partition.utilities;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;




/**
 * A little bit of manual testing
 * @author saadtouhbi
 *
 */
public class Main 
{
	public static void main( String[] args )
	{

		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7);
		Queue<Integer> queue = new LinkedList<>(list);
		List<String> list2 = Arrays.asList();
		String[] list3 = new String[4];

		System.out.println(Utils.partition(queue, 2));  // [[1, 2], [3, 4], [5, 6], [7]]
		System.out.println(Utils.partition(list, 3));  // [[1, 2, 3], [4, 5, 6], [7]]
		System.out.println(Utils.partition(list, 1));  // [[1], [2], [3], [4], [5], [6], [7]]
		System.out.println(Utils.partition(list2, 1));  // []

		try {
			System.out.println(Utils.partition(list3, 1)); // throws exception
		} catch (EmptyArrayException e) {

			e.printStackTrace();
		}  // []

		// Parallel
		//System.out.println(Utils.partitionParallel(IntStream.range(1, 100000).boxed().collect(Collectors.toList()), 2));
	}
}

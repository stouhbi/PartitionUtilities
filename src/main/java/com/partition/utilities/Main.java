package com.partition.utilities;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;




public class Main 
{
	public static void main( String[] args )
	{

		final List<Integer> list = Arrays.asList(1,2,3,4,5,6,7);
		final List<String> list2 = Arrays.asList();
		final String[] list3 = new String[4];

		System.out.println(Utils.partition(list, 2));  // [[1, 2], [3, 4], [5, 6], [7]]
		System.out.println(Utils.partition(list, 3));  // [[1, 2, 3], [4, 5, 6], [7]]
		System.out.println(Utils.partition(list, 1));  // [[1], [2], [3], [4], [5], [6], [7]]
		System.out.println(Utils.partition(list2, 1));  // []

		try {
			System.out.println(Utils.partition(list3, 1)); // throws exception
		} catch (EmptyArrayException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  // []

		// Performance
		//System.out.println(Utils.partition(IntStream.range(1, 100000).boxed().collect(Collectors.toList()), 2));
	}
}

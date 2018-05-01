package com.partition.utilities;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * Utility class for partitionning
 * @author saadtouhbi
 *
 */
public class Utils {


	public static final Logger logger = LogManager.getLogger(Utils.class);

	/**
	 * Partitionning with order
	 * @param list
	 * @param size
	 * @return Collection<List<T>>
	 */
	public static final <T> Collection<List<T>> partition(Collection<T> list, int size){
		logger.info("Start Patitionning - Ordered");
		
		// We use AtomicGenerator for the getAndIncrement()
		final AtomicInteger counter = new AtomicInteger(0);
		logger.info("End Partionning - Ordered");

		// using groupingBy to fragment the stream in to fragments of maximum size 
		return list.stream()
				.collect(Collectors.groupingBy(it -> counter.getAndIncrement() / size))
				.values();
	}


	/**
	 * Partionnement avec ordre, en utilisant un tableau 
	 * @param list
	 * @param size
	 * @return Collection<List<T>>
	 * @throws EmptyArrayException
	 */
	public static final <T> Collection<List<T>> partition(T[] list, int size) throws EmptyArrayException{
		logger.info("Using Array to partition");
		Boolean vide = true;
		
		// check if there is at least one value in the array
		for (Object ob : list) {
			if (ob != null) {
				vide = false;
				break;
			}
		}

		if(vide) {
			logger.error("Empty Array " +  Arrays.asList(list));
			throw new EmptyArrayException("The array does not contain at least one value");
		}


		return partition(Arrays.asList(list), size);
	}

	/**
	 * Unordered partitionning with parallel streamParallel
	 * @param liste
	 * @param taille
	 * @return
	 */
	public static final <T> Collection<List<T>> partitionParallel(Collection<T> list, int size){
		
		logger.info("Start Parallel partionning");
		final AtomicInteger counter = new AtomicInteger(0);
		
		logger.info("End Parallel partionning");

		return list.parallelStream()
				.collect(Collectors.groupingBy(it -> counter.getAndIncrement() / size))
				.values();
	}
	
	/**
	 * Unordered Partionning using an array
	 * @param liste
	 * @param taille
	 * @return Collection<List<T>>
	 * @throws EmptyArrayException
	 */
	public static final <T> Collection<List<T>> partitionParallel(T[] list, int size) throws EmptyArrayException{
		logger.info("Using an array for parallel partionning");
		Boolean vide = true;
		for (Object ob : list) {
			if (ob != null) {
				vide = false;
				break;
			}
		}

		if(vide) {
			logger.error("Empty Array " +  Arrays.asList(list));
			throw new EmptyArrayException("The array is empty");
		}


		return partition(Arrays.asList(list), size);
	}
	
	
	/**
	 * Compare two collections if they have the same values without considering order
	 * @param list1
	 * @param list2
	 * @return boolean
	 */
	
	public static final <T> boolean listEqualsIgnoreOrder(Collection<T> list1, Collection<T> list2) {
	    return new HashSet<>(list1).equals(new HashSet<>(list2));
	}

}

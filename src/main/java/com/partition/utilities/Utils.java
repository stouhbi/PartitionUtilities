package com.partition.utilities;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Utils {


	public static final Logger logger = LogManager.getLogger(Utils.class);

	/**
	 * Partionnement avec ordre
	 * @param liste
	 * @param taille
	 * @return Collection<List<T>>
	 */
	public static  <T> Collection<List<T>> partition(List<T> liste, int taille){
		logger.trace("Début Partition");
		final AtomicInteger compteur = new AtomicInteger(0);
		logger.trace("Fin de Patition");

		return liste.stream()
				.collect(Collectors.groupingBy(it -> compteur.getAndIncrement() / taille))
				.values();
	}


	/**
	 * Partionnement avec ordre, en utilisant un tableau 
	 * @param liste
	 * @param taille
	 * @return Collection<List<T>>
	 * @throws EmptyArrayException
	 */
	public static final <T> Collection<List<T>> partition(T[] liste, int taille) throws EmptyArrayException{
		logger.trace("Utilisation d'un tableau pour partition");
		Boolean vide = true;
		for (Object ob : liste) {
			if (ob != null) {
				vide = false;
				break;
			}
		}

		if(vide) {
			logger.error("Tableau vide " +  Arrays.asList(liste));
			throw new EmptyArrayException("Le tableau est vide");
		}


		return partition(Arrays.asList(liste), taille);
	}

	/**
	 * Partitionnement sans ordre en utilisant ParalleStream
	 * @param liste
	 * @param taille
	 * @return
	 */
	public static  <T> Collection<List<T>> partitionParallel(List<T> liste, int taille){
		logger.trace("Début Partition");
		final AtomicInteger compteur = new AtomicInteger(0);
		logger.trace("Fin de Patition");

		return liste.parallelStream()
				.collect(Collectors.groupingBy(it -> compteur.getAndIncrement() / taille))
				.values();
	}
	
	/**
	 * Partionnement sans ordre, en utilisant un tableau 
	 * @param liste
	 * @param taille
	 * @return Collection<List<T>>
	 * @throws EmptyArrayException
	 */
	public static final <T> Collection<List<T>> partitionParallel(T[] liste, int taille) throws EmptyArrayException{
		logger.trace("Utilisation d'un tableau pour partition");
		Boolean vide = true;
		for (Object ob : liste) {
			if (ob != null) {
				vide = false;
				break;
			}
		}

		if(vide) {
			logger.error("Tableau vide " +  Arrays.asList(liste));
			throw new EmptyArrayException("Le tableau est vide");
		}


		return partition(Arrays.asList(liste), taille);
	}
	
	
	/**
	 * Comparer deux collections sans ordrer
	 * @param list1
	 * @param list2
	 * @return boolean
	 */
	
	public static <T> boolean listEqualsIgnoreOrder(List<T> list1, List<T> list2) {
	    return new HashSet<>(list1).equals(new HashSet<>(list2));
	}

}

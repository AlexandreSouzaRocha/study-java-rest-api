package com.in28minutes.spring.basics.springbasics;

public class BinarySearchImpl {

	private SortAlgorithm sortAlgorithm;
	
		public BinarySearchImpl(SortAlgorithm sortAlgorithm) {
		super();
		this.sortAlgorithm = sortAlgorithm;
	}

		public int binarySearch(int[] numbers, int numberToSearchFor) {
			
			int[] sortedNumbers = sortAlgorithm.sort(numbers);
			System.out.println(sortAlgorithm);
			
			return numberToSearchFor;
		}
}

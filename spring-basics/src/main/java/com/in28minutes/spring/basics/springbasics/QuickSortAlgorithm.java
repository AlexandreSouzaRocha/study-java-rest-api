package com.in28minutes.spring.basics.springbasics;

public class QuickSortAlgorithm implements SortAlgorithm {
	int result;
	int i;
	int j;
	int temp;

	public int[] sort(int[] numbers) {

		result = numbers.length;

		for (i = 0; i < result - 1; i++)
			for (j = 0; j < result - i - 1; j++)
				if (numbers[j] > numbers[j + 1]) {

					temp = numbers[j];
					numbers[j] = numbers[j + 1];
					numbers[j + 1] = temp;
				}

		return numbers;
	}
}

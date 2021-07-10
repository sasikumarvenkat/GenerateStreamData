package com.demo.truck.data;

public class Test {

	public static void main(String[] args) {
		int[] array = new int[1000000];
		for (int i = 0; i < 1000000; i++) {
			array[i] = i + 1;
		}
		long startTs = System.currentTimeMillis();
		int count = countOf(array, 13);
		long endTs = System.currentTimeMillis();
		System.out.println("Count: " + count + " taken in " + (endTs - startTs) + " ms");
	}

	static int countOf(int[] array, int number) {
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] % number == 0)
				count++;
		}
		return count;
	}
}

package com.my.algo.basic;

import java.util.Random;

public class BinarySearch {
	public static final int NOT_FOUND = -1;
	
	public static void main(String args[]){
		int[] array = new int[20];
		Random random = new Random();

		array[0] = 1;
		for(int i = 1; i < 20; i ++){
			array[i] = array[i - 1] + random.nextInt(15) + 1;
		}
		
		for(int i = 0; i < 20; i ++){
			System.out.print(array[i] + " ");
		}
		System.out.println();
		
		int key = array[19];
		
		int found = binarySearchIter(array, key, 0, array.length - 1);
		System.out.println("Iterative version:");
		System.out.println(key + " is found at position: " + found);
		
		found = binarySearchRecur(array, key, 0, array.length - 1);
		System.out.println("Recursive version:");
		System.out.println(key + " is found at position: " + found);
	}
	
	public static int binarySearchIter(int[] array, int key, int low, int high){
		int mid = 0;
		int midVal = 0;
		int found = -1;
		
		while(low <= high){
			mid = (low + high) / 2;
			midVal = array[mid];
			
			if (key == midVal){
				found = mid;
				break;
			} else if(key < midVal) {
				high = mid - 1;
			} else if(key > midVal) {
				low = mid + 1;
			}
		}
		
		return found;
	}
	
	public static int binarySearchRecur(int[] array, int key, int low, int high){
		int mid = (low + high) / 2;
		int result = NOT_FOUND;
		
		if(low > high){
			result = NOT_FOUND;
		} else if(key == array[mid]){
			result = mid;
		} else if (key < array[mid]){
			result = binarySearchRecur(array, key, low, mid - 1);
		} else if (key > array[mid]){
			result = binarySearchRecur(array, key, mid + 1, high);
		}
		
		return result;
	}
}

package demo;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;

public class PrepQuestions {

	public static void main(String[] args) {
		//Reverse a string
		String name = "Maanasa";
		revString(name);
		revStringUsingCharArr(name);
		
		//Write a program to find the largest number in an array in Java.
		 int[] nums = {1, 5, 3, 9, 7};
		 findLargest(nums);
		 
		// Write a program to find the factorial of a given number in Java.
		 findFact(7);
		 
		//Write a program to remove duplicate elements from an array in Java.
		 int[] dupArray = {1, 5, 3, 9, 7, 1, 5, 3, 11, 13};
		 removeDup(dupArray);
		 
		 // Write a program to find the second largest number in an array in Java.
	     secondLargestNumber(nums);

	     //Write a program to check if two strings are anagrams in Java.
	     String str1 = "silent";
	     String str2 = "listen";
	     checkIfStringAnagarm(str1, str2);
	     
	     //Write a program to reverse a linked list in Java.
	     reveLinkList();
	     
	     //Write a program to find the first non-repeating character in a string in Java.
	     String str = "leetcode";
	     // can be done with sliding windows logic
	     firstNonRepetativeChar(str);
	     
	     // Write a program to check if a given string is a palindrome in Java.
        String str3 = "racecar";
        checkPalindrome(str3);
        
        //How do you swap two numbers without using a third variable in Java?
        int a = 10;
        int b = 20;
        System.out.println("a:" +a + " b:" +b);
        b = b + a;
        a = Math.abs(b - a);
        b = Math.abs(b - a);
        System.out.println("a:" +a + " b:" +b);
        
        //How do you sort an array in Java?
        int[] array = {1, 2, 3, -1, -2, 4};
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        
        //How do you implement a binary search in Java?
        int[] arr =  {3,6,8,10,25,29,31,36,47,53,55,62};
		int search = 55;
		binarySearch(arr, search);
		
		//Write a Java program to check if a vowel is present in a string.
		String s = "hello";
		boolean res =checkVowels(s);
		System.out.println("String contain vowels result is "+ res);
	}

	private static boolean checkVowels(String s) {
		return s.toLowerCase().matches(".*[aeoiu].*");
	}

	private static void binarySearch(int[] arr, int search) {
		int start = 0 ;
		int end = arr.length-1;
		
		while(start <= end) {
			int mid = start + (end - start)/ 2;
			
			if(arr[mid] == search) {
				System.out.println("Got result serach at index "+ mid);
				break;
			}
			else if (search > arr[mid]) {
				start = mid + 1;
			}
			else if (search < arr[mid]) {
				end = mid -1;
			}
			
		}
	}

	private static void checkPalindrome(String str3) {
		int i =0;
		int j = str3.length()-1;
		
		while(i < str3.length()) {
			if(str3.charAt(i) != str3.charAt(j)) {
				System.out.println("not palindrom");
			}
			i++;
			j--;
		}
		System.out.println("String is palindrome");
	}

	private static void firstNonRepetativeChar(String str) {
		//linked hash map saves the order of insertion
		LinkedHashMap<Character, Integer> map = new LinkedHashMap<Character, Integer>();
		int i = 0;
		int j =0;
		
		while( j < str.length()) {
			map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0)+1);
			i++;
			j++;
		}
		
		for(Map.Entry<Character, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() +":" + entry.getValue());
			if(entry.getValue() == 1) {
				System.out.println("First non-repetative char is "+entry.getKey() +":" + entry.getValue());
				break;
			}
		}
	}

	private static void reveLinkList() {

		LinkedList<Integer> ls = new LinkedList<Integer>(Arrays.asList(1,2,3,45,6));
		Collections.reverse(ls);
		System.out.println(ls);
	}

	private static void checkIfStringAnagarm(String str1, String str2) {
		if(str1.length() != str2.length()) {
			System.out.println("Not anagarm");
		}
		else {
			char[] c1 = str1.toCharArray();
			Arrays.sort(c1);
			char[] c2 = str2.toCharArray();
			Arrays.sort(c2);
			
			if(Arrays.equals(c1, c2)) {
				System.out.println("Anagram");
			}
		}
	}

	private static void secondLargestNumber(int[] nums) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for(int i=0; i<=nums.length-1; i++) {
			pq.add(nums[i]);
			if(pq.size() > 2) { // save only the 2 elements in heap to get largest
				pq.poll();
			}
		}
		System.out.println(pq.peek());
	}

	private static void removeDup(int[] dupArray) {
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i =0 ; i <= dupArray.length-1 ; i++) {
			set.add(dupArray[i]);
		}	
		System.out.println(set);
	}

	private static void findFact(int num) {
		int fact = 1;
		for(int i = 1 ; i <= num ; i++) {
			fact = fact * i;
			System.out.println(fact);
		}
	}

	private static void findLargest(int[] nums) {
		int max = 0;
		for(int i =0 ; i <= nums.length-1 ; i++) {
			max = Math.max(nums[i], max);
		}
		System.out.println("Largets number is "+ max);
	}

	private static void revStringUsingCharArr(String name) {
		for(int i = name.length()-1; i >= 0; i --) {
			System.out.println(name.charAt(i));
		}
		
	}

	private static void revString(String name) {
		StringBuilder sb = new StringBuilder(name);
		System.out.println(sb.reverse().toString());
		
	}

}

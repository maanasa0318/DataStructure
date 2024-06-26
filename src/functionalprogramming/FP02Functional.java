package functionalprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FP02Functional {

	public static void main(String[] args) {

		printSuareOfEven(List.of(1,2,3,4,5,6));
		printLetterStartsWithA(List.of("Apple", "Orange", "apricot"));
		printMultipleOfFive(List.of(1,2,3,4,5,6,7,8,9,10));	
        List<Integer> ls = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
        List<Integer> ls1 = printMutiplOf3(ls);
        System.out.println("Mutiple of 3" + ls1);
	}

	
	

	private static List<Integer> printMutiplOf3(List<Integer> ls) {
		
		return ls.stream().map(n -> n * 3).collect(Collectors.toList());
	}




	private static void printMultipleOfFive(List<Integer> numbers) {

		numbers.stream().map(n -> n * 5).forEach(System.out::println);
	}

	private static void printLetterStartsWithA(List<String> words) {
		words.stream()
			 .filter(n -> n.toUpperCase().startsWith("A"))
			 .forEach(System.out::println);
		
	}

	private static void printSuareOfEven(List<Integer> numbers) {

		numbers.stream().filter(n -> n % 2 == 0).map(n -> n * n).forEach(System.out::println);
	}

}

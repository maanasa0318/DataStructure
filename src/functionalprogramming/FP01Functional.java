package functionalprogramming;

import java.util.List;

public class FP01Functional {

	public static void main(String[] args) {

		//printAllNumberStructured(List.of(12,9,13,34,5,12,15));
		//printEvenNumbersStructured(List.of(12,9,13,34,5,12,15));
		printEachCoures(List.of("Spring", "Spring boot", "API", "AWS", "PCF", "Azure"));
		printSquareOfEvenNumbers(List.of(12,9,13,34,5,12,15));
	

	}
	
	private static void printSquareOfEvenNumbers(List<Integer> numbers) {
			numbers.stream()
				.filter(number -> number % 2 == 0)
				//mapping expression 
				.map(number -> number * number)
				.forEach(System.out::println);
	}

	private static void printEachCoures(List<String> course) {
		course.stream()
			  .forEach(System.out::println);
		
		System.out.println();
		
		course.stream()
			  .filter(s -> s.contains("Spring"))
			  .forEach(System.out::println);
		
		System.out.println();

		course.stream()
			  .filter(s -> s.length() >= 4)
			  .forEach(System.out::println);
		
		course.stream()
		  .map(i -> i + " " + i.length() )
		  .forEach(System.out::println);
	}

	private static void print(int number) {
		System.out.println(number);
	}
	
	private static void evenNumber(int number) {
		if(number % 2 == 0) {
			System.out.println(number);
		}
	}
	
	private static boolean isEven(int number) {
		return number % 2 == 0;
	}

	private static void printAllNumberStructured(List<Integer> numbers) {

		//for each element print method needs to be called
		//numbers.stream().forEach(FP01Functional::print); //method reference
		
		//instead of creating new print method we can directly call
		numbers.stream().forEach(System.out::println);
		
	}
	
	private static void printEvenNumbersStructured(List<Integer> numbers) {

		//numbers.stream().forEach(FP01Functional::evenNumber);
		
		numbers.stream()
		//only allow even number
			.filter(FP01Functional::isEven)
			.forEach(System.out::println);
		
		System.out.println();
		
		numbers.stream()
		     // lambda expression number -> number % 2 == 0
			.filter(number -> number % 2 == 0)
			.forEach(System.out::println);
		
		System.out.println();

		numbers.stream()
				.filter(number -> number %2 != 0)
				.forEach(System.out::println);
		
	}

}

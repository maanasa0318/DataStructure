package functionalprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FP02Functional {

	public static void main(String[] args) {

		printSuareOfEven(List.of(1,2,3,4,5,6));
		printLetterStartsWithA(List.of("Apple", "Orange", "apricot"));
		printMultipleOfFive(List.of(1,2,3,4,5,6,7,8,9,10));	
        List<Integer> ls = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
        List<Integer> ls1 = printMutiplOf3(ls);
        System.out.println("Mutiple of 3" + ls1);
        List<String> listOfStrings = Arrays.asList("Java", "Python", "C#", "Java", "Kotlin", "Python");
        List<String> res = removDupl(listOfStrings);
        System.out.println(res);
        
        //3) How do you find frequency of each character in a string using Java 8 streams?
        String inputString = "Java Concept Of The Day";
        Map<Character, Long> collect1 = inputString.chars().mapToObj( c -> (char)c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect1);
        
        //4) How do you find frequency of each element in an array or a list?
        List<String> stationeryList = Arrays.asList("Pen", "Eraser", "Note Book", "Pen", "Pencil", "Stapler", "Note Book", "Pencil");
        Map<String, Long> collect = stationeryList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect);


        //1- Find list of students whose first name starts with alphabet A
        List<String> students = Arrays.asList("Rahul", "Rohit", "Saahil", "Saanvi", "Dhoni", "Maanasa");
        students.stream().filter(s -> s.startsWith("R")).forEach(System.out::println);


       

	}

	
	

	private static List<String> removDupl(List<String> listOfStrings) {

		return listOfStrings.stream().distinct().collect(Collectors.toList());
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

package functionalprogramming;

import java.util.List;

public class FP01Structured {

	public static void main(String[] args) {

		printAllNumberStructured(List.of(12,9,13,34,5,12,15));
	}

	private static void printAllNumberStructured(List<Integer> numbers) {

		for(int i : numbers) {
			System.out.println(i);
		}
		
		
	}

}

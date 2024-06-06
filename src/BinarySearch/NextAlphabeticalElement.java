package BinarySearch;

public class NextAlphabeticalElement {

	public static void main(String[] args) {

		char[] arr = {'a','c','f','h'};
		char search = 'f';
		char res = serachNxetChar(arr, search);
		System.out.println("Next char after " + search + " is " + res);
	}

	private static char serachNxetChar(char[] arr, char search) {
		int start =0;
		int end = arr.length-1;
		char res = '#';
		while(start<=end) {
			int mid = start + (end - start) /2;
			if (arr[mid] == search) {
				start = mid +1;
			}
			else if (arr[mid] >= search) {
				res = arr[mid];
				end = mid -1;
			}
			else if (arr[mid] <= search) {
				start = mid + 1;			
			}
			
		}
		return res;
	}

}

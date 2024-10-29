package string;

public class PowerofTwo {

	public static void main(String[] args) {

		int n = 16;
		System.out.println(powerOfTwo(n));
	}
    // if n = 16, 16/2 = 8, reminder =0
	// 8/2 = 4, reminder =0, 4/2=2, reminder is 0, 2/2=1 
	private static boolean powerOfTwo(int n) {
		while(n != 1) {
			if(n==0) {
				return false;
			}
			if(n%2 != 0) {
				return false;
			}
			else {
				n = n/2;
			}
		}
		return true;
	}

}

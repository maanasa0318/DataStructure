package tuf;

public class power {

	public static void main(String[] args) {

		double x=1.00000;
		int n = -2147483648;
		double res =myPow(x,n);
		System.out.println(res);
	}

	private static double myPow(double x, int n) {
		if(n==0){
            return 1;
        }
		 if (n < 0) {
	            return 1 / myPow(x, -n);
	        }
        if(n%2==0){
            return myPow(x*x, n/2);
        }
        else{
            return x*myPow(x*x, (n-1)/2);
        }
	}

}

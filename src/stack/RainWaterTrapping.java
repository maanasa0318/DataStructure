package stack;

public class RainWaterTrapping {

	public static void main(String[] args) {

		int[] arr = {3,0,0,2,0,4};
		int size = 6;
		int[] maxL = new int[size];
		int[] maxR = new int[size];
		
		maxL[0] = arr[0];
		
		for(int i =1; i < size; i++) {
			maxL[i]= Math.max(maxL[i-1], arr[i]);
			System.out.println(maxL[i]);
		}
	
        System.out.println();
        
		maxR[size-1] = arr[size-1];

		for(int i = size -2; i >= 0; i--){
			maxR[i] = Math.max(maxR[i + 1], arr[i]);
			System.out.println(maxR[i]);

		}

		int[] water = new int [ size];
		for(int i =0; i < size ; i++) {
			water[i] = Math.min(maxL[i], maxR[i])- arr[i];
		}
	
		int sum = 0;
		for(int i =0; i < size; i++) {
			sum += water[i]; 
		}
		System.out.println("Res is "+sum);

	}

}

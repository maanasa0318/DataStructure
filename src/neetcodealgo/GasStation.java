package neetcodealgo;

import java.util.Arrays;

public class GasStation {

	public static void main(String[] args) {

		int[] gas = {1,2,3,4,5};
		int[] cost = {3,4,5,1,2};
		int res = canCompleteCircuit(gas, cost);
		System.out.println(res);
		
	}
	
    public static int canCompleteCircuit(int[] gas, int[] cost) {
    	if(Arrays.stream(gas).sum() > Arrays.stream(cost).sum()) {
    		return -1;
    	}
    	int total = 0;
    	int res =0;
    	for(int i=0; i< gas.length; i++) {
    		total = total + (gas[i]- cost[i]);
    		if(total < 0) {
    			total =0;
    			res = i +1;
    		}
    	}
    	
		return res;

    }

}

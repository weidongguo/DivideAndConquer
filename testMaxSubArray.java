import java.util.Arrays;
public class testMaxSubArray{	
	static int randomInt(int hi){
		return (int)(Math.random()*100) % hi;
	}
	
	static void printIndex(int size){
		for( int i = 0; i < size; i++)
			System.out.print("[" + i + "]"  + "	");
		System.out.println();				
	}

	static void printArray(int ar[], int low, int high){
	for( int i = low; i <= high; i++)
			System.out.print( ar[i] + "	");
		System.out.println();				
	}
	
	public static void main(String argv[]){
		int size = 10;	
		int ar[] = new int[size];		
		for( int i = 0 ; i < size; i++)	
		ar[i] = randomInt(40) - 20; 
		int tmp[] = { 1, -4, 3, 4, -2, 6};	
		
		printIndex(size);
		printArray(ar, 0, ar.length-1);//before
		triple_t maxSubArrayInfo = maxSubArray.maxSubArray(ar);	
		
		System.out.println("The low is " + maxSubArrayInfo.low +
			"\nthe high is " + maxSubArrayInfo.high);	
			
		System.out.println("The sum of the maximal subArray is " + maxSubArrayInfo.sum);	
		printArray(ar, maxSubArrayInfo.low, maxSubArrayInfo.high);

	}
}

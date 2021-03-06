class triple_t{
	int low;
	int high;
	int sum;
	public triple_t(int i, int j, int k){
		low = i; high = j; sum = k;
	}
} //enable returning three thing at once without using output params

public class maxSubArray{ 
/* ************** maxCrossingSubArray() **************** */	
	static triple_t maxCrossingSubArray(int ar[], int low, int mid, int high){
		int maxLeftIndex = mid, maxRightIndex = mid+1;
		int maxLeftSum = ar[mid]; int maxRightSum = ar[mid+1];		
		for(int i = mid, sum = 0; i >= low; i--){ // the left half n/2
			sum += ar[i];
			if(sum>maxLeftSum){
				maxLeftSum = sum;	
				maxLeftIndex = i;
			}
		} /* find the maximal sum on the left side by keep
		   * advancing to the left, get the new sum and
			 * compare with the maximal sum up-to-date, then
			 * set the new maximal sum if applicable */

		for(int i = mid+1, sum = 0; i <= high; i++){// the right half n/2
			sum += ar[i];
			if( sum > maxRightSum){
				maxRightSum = sum;
				maxRightIndex = i;
			}
		} /* similar to the case (above) that advances to the left*/

		return new triple_t(maxLeftIndex, maxRightIndex, maxLeftSum+maxRightSum);
	}	// n/2 * 2 = n --> O(n)

/* *************** maxSubArray() ***************************** */	
	public static triple_t maxSubArray(int ar[], int low, int high){
			
		if(low == high) //base case when there is only 1 element;
			return new triple_t(low, high, ar[low]);	
		
		int mid = (low+high)/2; // locate the ~ mid point			
	
		/* divide the problem into sub problems, namely subarrays */	
		triple_t leftMax = maxSubArray(ar, low, mid); // T(n/2)
		triple_t rightMax = maxSubArray(ar, mid+1, high);	// T(n/2)

		/* check the middle region that cross left and right subarrays */
		triple_t crossingMax = maxCrossingSubArray(ar, low, mid, high);//T(n)	
			
		if(leftMax.sum >= rightMax.sum && leftMax.sum >= crossingMax.sum)
			return	leftMax;
		else if(rightMax.sum >= leftMax.sum && rightMax.sum >= crossingMax.sum)
			return rightMax;
		else
			return crossingMax;				 
		// max of 4 comparsions => O(1)	
		// just some constant time comparsion to determine
		// whether the optimal array is from the 
		// left, the middle crossing region, or the right	
	
	} // T(n) = 2T(n/2) + n + O(1) = O(nlgn) by the Master theorem

	
	public static triple_t maxSubArray(int ar[]){ //driver
		return	maxSubArray(ar, 0, ar.length-1); 
	}
}

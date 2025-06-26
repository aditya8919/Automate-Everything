package _1_logicalProbs;

public class Adv_Probs_1
{
	/**
	 * How many times do we need to divide it by 2 until it reaches 1.
	 * @param num
	 */
	public static void reachOne(int num)
	{
		int count = 0;
		while(num != 1)
		{
			num /= 2;
			count ++;
		}
		
		System.out.println(count);
	}
	
	/**
	 * Below approach is good for low num of rotations
	 * @param arr
	 * @param K
	 * @return
	 */
	public static int [] rotateKTimesOptimized(int [] arr, int K)
	{
		 int[] rev = ArraysProbs.reverseArray(arr);
		 rev = ArraysProbs.reversePartArray(rev, 0, (K -1));
		 rev = ArraysProbs.reversePartArray(rev, K, (arr.length - 1));
		 
		 return rev;
	}
	
	/**
	 * When num of rotations is > size of array then we can see that after some 
	 * rotations, rotated array becomes equal to original array.
	 * 
	 * Hence, for K > array size, total num of rotattions 
	 * 
	 * K = K % N
	 * 
	 * @param arr
	 * @param K
	 * @return
	 */
	public static int [] rotateKTimes(int [] arr, int K)
	{
		 int[] rev = ArraysProbs.reverseArray(arr);
		 rev = ArraysProbs.reversePartArray(rev, 0, (K -1));
		 rev = ArraysProbs.reversePartArray(rev, K, (arr.length - 1));
		 
		 return rev;
	}
	
	public static void main(String[] args)
	{
		reachOne(100);
		
		System.out.println();
		System.out.println("******* rotatKTimesOptimized *******");
		System.out.println();
		
		int [] A = {1,2,3,4,5,6,7,8,9};
		
		 int [] ansRotate = rotateKTimesOptimized(A, 3);
		 
		 for(int a : ansRotate)
		 {
			 System.out.print(a + " ");
		 }
	}

}

package Kandane;


/**
 * Created by Agnes on 18.06.16.
 * <p>
 * the maximum subarray problem is the task
 * of finding the contiguous subarray within
 * a one-dimensional array of numbers
 * which has the largest sum
 */
public class KadaneMaxSubarray {

    private int maxEndingHere, maxSoFar;

    public KadaneMaxSubarray() {
        maxEndingHere = maxSoFar = 0;
    }

    /**
     * calculates the max sum of a contiguous subarray
     *
     * @param array
     * @return max sum of all integers in the array
     */
    public int maxSubarraySum(int[] array) {
        maxEndingHere = maxSoFar = 0;
        for (int i : array) {
            maxEndingHere = Math.max(i, maxEndingHere + i);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }


    /**
     * calculates the max sum of a contiguous subarray
     * and saves it in an array
     *
     * @param array
     * @return array containing all itegers of the max subarray
     */
    public int maxSubarrayArray(int[] array) {
        maxEndingHere = maxSoFar = array[0];
        int[] maxSum = new int[array.length];

        for(int i = 1; i < array.length; i++){
            maxSum[i] = Math.max(array[i], maxSum[i - 1] + array[i]);
            maxSoFar = Math.max(maxSoFar, maxSum[i]);
        }
        return maxSoFar;
    }
}

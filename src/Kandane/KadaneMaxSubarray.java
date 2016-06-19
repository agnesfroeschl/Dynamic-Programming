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
    public int maxSubArray(int[] array) {
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
    public int maxSubArray1(int[] array) {
        maxEndingHere = maxSoFar = array[0];
        int[] maxSum = new int[array.length];

        for(int i = 1; i < array.length; i++){
            maxSum[i] = Math.max(array[i], maxSum[i - 1] + array[i]);
            maxSoFar = Math.max(maxSoFar, maxSum[i]);
        }
        return maxSoFar;
    }



    public int maxSubArray2(int[] A) {
        int max = A[0];
        int[] sum = new int[A.length];
        sum[0] = A[0];

        int begin = 0;
        int end = 0;

        for (int i = 1; i < A.length; i++) {

            int newBegin = begin;
            int newEnd = end;

            if (A[i] > sum[i - 1] + A[i]) {
                sum[i] = A[i];
                newBegin = i;
                newEnd = i;
            } else {
                sum[i] = sum[i - 1] + A[i];
                newEnd = i;
            }

            if (sum[i] > max) {
                max = sum[i];
                begin = newBegin;
                end = newEnd;
            }
        }
        return max;
    }
}

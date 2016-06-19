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
        maxSoFar = array[0];
        int[] maxSum = new int[array.length];

        for(int i = 1; i < array.length; i++){
            maxSum[i] = Math.max(array[i], maxSum[i - 1] + array[i]);
            maxSoFar = Math.max(maxSoFar, maxSum[i]);
        }
        return maxSoFar;
    }


    /**
     * third option of Kandan's Algorithm
     * using begin and end index of the subarray
     * @param array
     * @return max sum
     */
    public int maxSubArray2(int[] array) {
        maxSoFar = array[0];
        int[] maxSum = new int[array.length];
        maxSum[0] = array[0];

        int begin = 0;
        int end = 0;

        for (int i = 1; i < array.length; i++) {

            int newBegin = begin;
            int newEnd = end;

            if (array[i] > maxSum[i - 1] + array[i]) {
                maxSum[i] = array[i];
                newBegin = i;
                newEnd = i;
            } else {
                maxSum[i] = maxSum[i - 1] + array[i];
                newEnd = i;
            }

            if (maxSum[i] > maxSoFar) {
                maxSoFar = maxSum[i];
                begin = newBegin;
                end = newEnd;
            }
        }
        return maxSoFar;
    }
}

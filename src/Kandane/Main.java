package Kandane;

public class Main {


    public static void main(String[] args) {

        int[] array = {31, -41, 59, 26, -53, 58, 97, -93, -23, 84};
        KadaneMaxSubarray k = new KadaneMaxSubarray();
        int sum = k.maxSubarraySum(array);
        System.out.println("sum: " + sum);

        sum = k.maxSubarrayArray(array);
        System.out.println("sum: " + sum);


        int[] array1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        KadaneMaxSubarray k1 = new KadaneMaxSubarray();
        int sum1 = k.maxSubarraySum(array1);
        System.out.println("sum: " + sum1);

    }
}

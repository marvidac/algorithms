package src.algorithms.com;

public class TwoSum {
    public static void main(String[] args) {
        int array[] = {1,2,3,4,5};
        int target = 8;
        int[] out = twoSum(array, target);

        for(int i = 0; i < out.length; i++) {
            System.out.println(out[i]);
        }
    }

    static int[] twoSum(int[] array, int target) {
        int i = 0;
        int j = array.length-1;
        int[] out = new int[2];

        while (i < j) {
            if(array[i]+array[j] == target) {
                out[0] = i+1;
                out[1] = j+1;

                return out;
            }

            if(array[i]+array[j] < target) {
                i++;
            }

            if(array[i]+array[j] > target) {
                j--;
            }
        }

        return null;
    }
}

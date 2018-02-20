package fx.leyu.leetcode.arraystring;

public class TwoSumII {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int j = bsearch(numbers, target - numbers[i], i + 1);
            if (j != -1) {
                return new int[] {i + 1, j + 1};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    private int bsearch(int[] numbers, int key, int start) {
        int left = start;
        int right = numbers.length;
        while (left < right) {
            int middle = (left + right ) / 2;
            if (numbers[middle] < key) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        return (left == right  && numbers[left] == key) ? left : -1;
    }
    
    // BEST
    public int[] twoSumFast(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum < target) {
                i++;
            } else if (sum > target) {
                j--;
            } else {
                return new int[] {i + 1, j + 1};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

}

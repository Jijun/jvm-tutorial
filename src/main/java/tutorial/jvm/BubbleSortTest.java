package tutorial.jvm;

public class BubbleSortTest {
	public static void main(String[] args) {

		int[] nums = { 1, 8, 5, 2, 4, 9, 7 };

		for (int i = 0, sum = nums.length; i < sum; i++) {

			for (int j = i+1; j < sum; j++) {
				System.out.println(i + "=====" + j);
				if (nums[i] > nums[j]) {
					int swap = nums[i];
					nums[i] = nums[j];
					nums[j] = swap;
				}

			}
		}

		for (int n : nums) {
			System.out.println(n);
		}
	}
}

package array;
/**
 * Product of Array Except Self
 * @author yutian
 * @since Aug 29, 2015
 */
public class ProductOfArrayExceptSelf {
	public int[] productExceptSelf(int[] nums) {
		int[] result = new int[nums.length];
		// left to right
		for (int i = 0, tmp = 1; i < nums.length; i++) {
			result[i] = tmp;
			tmp *= nums[i];
		}
		// right to left
		for (int i = nums.length - 1, tmp = 1; i >= 0; i--) {
			result[i] *= tmp;
			tmp *= nums[i];
		}
		return result;
	}
	
	public static void main(String[] args) {
		ProductOfArrayExceptSelf t = new ProductOfArrayExceptSelf();
		for (int i: t.productExceptSelf(new int[]{1, 2, 3, 4})) {
			System.out.println(i);
		}
		
	}
}

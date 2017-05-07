package bitManipulation;
/**
 * Single Number III
 * @author yutian
 * @since Aug 29, 2015
 */
public class SingleNumber3 {
	public static int[] singleNumber(int[] nums) {
		// Pass 1:
		// Get the XOR of the two numbers we need to find
		int diff = 0;
		for (int num : nums) {
			diff ^= num;
		}
		// Get its last set bit
		diff &= -diff;
		
		// Pass 2:
		int[] rets = {0, 0}; // this array stores the two numbers we will return
		for (int num : nums) {
			if ((num & diff) == 0) // the bit is not set
				rets[0] ^= num;
			else // the bit is set
				rets[1] ^= num;
		}
		return rets;
	}
	
	public static void main(String[] args) {
		for (int i: singleNumber(new int[]{1, 2, 1, 3, 2, 5})) {
			System.out.print(i + " ");
		}
	}
}

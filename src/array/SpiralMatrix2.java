package array;
/**
 * 59. Spiral Matrix II
 * @author yutian
 * @since Jul 28, 2015
 */
public class SpiralMatrix2 {
	// Time ~O(N), Space ~O(n)
	public static int[][] generateMatrix(int n) {
		int[][] result = new int[n][n];
		int left = 0, top = 0;
		int right = n - 1, down = n - 1;
		int count = 1;
		while (left <= right) {
			for (int j = left; j <= right; j++) {
				result[top][j] = count++;
			}
			top++;
			for (int i = top; i <= down; i++) {
				result[i][right] = count++;
			}
			right--;
			for (int j = right; j >= left; j--) {
				result[down][j] = count++;
			}
			down--;
			for (int i = down; i >= top; i--) {
				result[i][left] = count++;
			}
			left++;
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[][] r = generateMatrix(3);
		for (int[] i: r) {
			for (int j: i) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}
	
	public static int[][] generateMatrix2(int n) {
		int[][] matrix = new int[n][n];
		int total = n * n;
		
		int x = 0;
		int y = 0;
		int step = 0;
		
		for (int i = 0; i < total; ) {
			while (y + step < n) {
				i++;
				matrix[x][y] = i;
				y++;
			} // x = 0, y = n for iteration 1
			y--;
			x++; // move from [0, n] to [1, n-1]
			while (x + step < n) {
				i++;
				matrix[x][y] = i;
				x++;
			}
			x--;
			y--;
			while (y >= 0 + step) {
				i++;
				matrix[x][y] = i;
				y--;
			}
			y++;
			x--;
			step++; // because x can't go back to 0
			
			while (x >= 0 + step) {
				i++;
				matrix[x][y] = i;
				x--;
			}
			x++;
			y++;
		}
		return matrix;
	}
}

package dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 529. Minesweeper
 * @author ytian
 *
 */
public class Minesweeper {

	/*
	 * This is a typical Search problem, either by using DFS or BFS. Search rules:
	 * If click on a mine ('M'), mark it as 'X', stop further search.
	 * If click on an empty cell ('E'), depends on how many surrounding mine:
	 * 2.1 Has surrounding mine(s), mark it with number of surrounding mine(s), stop further search.
	 * 2.2 No surrounding mine, mark it as 'B', continue search its 8 neighbors.
	 */
	
	/**
	 * DFS
	 * @param board
	 * @param click
	 * @return
	 */
	public char[][] updateBoard(char[][] board, int[] click) {
        int m = board.length, n = board[0].length;
        int row = click[0], col = click[1];
        if (board[row][col] == 'M') {
        	board[row][col] = 'X';
        } else { // Empty
        	// Get number of mines first
        	int count = 0;
        	for (int i = -1; i < 2; i++) {
        		for (int j = -1; j < 2; j++) {
        			if (i == 0 && j == 0) continue;
        			int r = row + i, c = col + j;
        			if (r < 0 || r >= m || c < 0 || c >= n) continue;
        			if (board[r][c] == 'M' || board[r][c] == 'X') count++;
        		}
        	}
        	if (count > 0) { // If it is not a 'B', stop further DFS
        		board[row][col] = (char)(count + '0');
        	} else { // Continue DFS to adjacent cells
        		board[row][col] = 'B';
        		for (int i = -1; i < 2; i++) {
            		for (int j = -1; j < 2; j++) {
            			if (i == 0 && j == 0) continue;
            			int r = row + i, c = col + j;
            			if (r < 0 || r >= m || c < 0 || c >= n) continue;
            			if (board[r][c] == 'E') updateBoard(board, new int[]{r, c});
            		}
            	}
        	}
        }
		return board;
    }
	
	/**
	 * BFS
	 * @param board
	 * @param click
	 * @return
	 */
	public char[][] updateBoard2(char[][] board, int[] click) {
		int m = board.length, n = board[0].length;
		Queue<int[]> q = new LinkedList<>();
		q.add(click);
		
		while (!q.isEmpty()) {
			int[] cell = q.poll();
			int row = cell[0], col = cell[1];
			if (board[row][col] == 'M') {
				board[row][col] = 'X';
			} else {
				int count = 0;
				for (int i = -1; i < 2; i++) {
					for (int j = -1; j < 2; j++) {
						if (i == 0 && j == 0)
							continue;
						int r = row + i, c = col + j;
						if (r < 0 || r >= m || c < 0 || c >= n)
							continue;
						if (board[r][c] == 'M' || board[r][c] == 'X')
							count++;
					}
				}
				if (count > 0) { // If it is not a 'B', stop further BFS
					board[row][col] = (char) (count + '0');
				} else { // Continue DFS to adjacent cells
					board[row][col] = 'B';
					for (int i = -1; i < 2; i++) {
						for (int j = -1; j < 2; j++) {
							if (i == 0 && j == 0)
								continue;
							int r = row + i, c = col + j;
							if (r < 0 || r >= m || c < 0 || c >= n)
								continue;
							if (board[r][c] == 'E') {
								updateBoard(board, new int[] { r, c });
								board[r][c] = 'B';
							}
						}
					}
				}
			}
		}
		return board;
    }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

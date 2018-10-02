package level_one;

import java.util.HashSet;
import java.util.Set;

public class Set_Matrix_Zeroes_73 {
	public static void main(String[] args) {
		//Given a m x n matrix, if an element is 0,
		// set its entire row and column to 0. Do it in-place.
		/**
		 * Input:
		 * [
		 *   [0,1,2,0],
		 *   [3,4,5,2],
		 *   [1,3,1,5]
		 * ]
		 */

		/**
		 * Output:
		 * [
		 *   [0,0,0,0],
		 *   [0,4,5,0],
		 *   [0,3,1,0]
		 * ]
		 */
	}

	public void setZeroes(int[][] matrix) {
		Set<Integer> row = new HashSet<>();
		Set<Integer> col = new HashSet<>();

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					row.add(i);
					col.add(j);
				}
			}
		}

		for (int m = 0; m < matrix.length; m++) {
			for (int n = 0; n < matrix[0].length; n++) {
				if (row.contains(m) || col.contains(n)) {
					matrix[m][n] = 0;
				}
			}
		}
	}

	//Could you devise a constant space solution?
	public void OneSpaceSolution(int[][] matrix) {
		int rowNum = matrix.length;
		if (rowNum == 0) {
			return;
		}
		int colNum = matrix[0].length;
		if (colNum == 0) {
			return;
		}

		boolean firstRowHasZero = false;
		boolean firstColHasZero = false;

		for (int i = 0; i < rowNum; i++) {
			if (matrix[i][0] == 0) {
				firstColHasZero = true;
			}
		}

		for (int i = 0; i < colNum; i++) {
			if (matrix[0][i] == 0) {
				firstRowHasZero = true;
			}
		}


		for (int i = 1; i < rowNum; i++) {
			for (int j = 1; j < colNum; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}

		for (int i = 1; i < rowNum; i++) {
			for (int j = 1; j < colNum; j++) {
				if (matrix[i][0] == 0 || matrix[0][j] == 0) {
					matrix[i][j] = 0;
				}
			}
		}

		if (firstColHasZero) {
			for (int i = 0; i < rowNum; i++) {
				matrix[i][0] = 0;

			}
		}
		if (firstRowHasZero) {
			for (int i = 0; i < colNum; i++) {
				matrix[0][i] = 0;
			}
		}

	}
}

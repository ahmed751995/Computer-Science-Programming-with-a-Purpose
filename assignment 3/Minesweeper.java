public class Minesweeper {
    public static void main(String args[]) {
	int m = Integer.parseInt(args[0]); // m row
	int n = Integer.parseInt(args[1]); // n column
	int k = Integer.parseInt(args[2]);
	String[][] sweeper = new String[m][n];
	int[] distance = new int[2*k];
	int r,c;
	int i = 0;
	
	for (int a = 0; a < m; a++) {
	    for (int b = 0; b < n; b++) {
		sweeper[a][b] = "0";
	    }
	}

	while(i < 2*k) {
	    r = (int)(Math.random() * m);
	    c = (int)(Math.random() * n);
	    if(sweeper[r][c] != "*") {
		sweeper[r][c] = "*";
		distance[i] = r;
		distance[i+1] = c;
		    i+= 2;
	    }
	}

	
	// String result = "";
	// System.out.println("before");
	// for (int a = 0; a < m; a++) {
	//     for (int b = 0; b < n; b++) {
	// 	if(sweeper[a][b] == null) sweeper[a][b] = "0";
	// 	result += sweeper[a][b] + "  ";
	//     }
	//     result += "\n";
	// }
	// System.out.print(result);

	// for (int p = 0; p < distance.length; p += 2) {
	//     r = distance[p];
	//     c = distance[p + 1];
	//     // System.out.println("c == " + c);
		
	//     if (n > 1) {
	// 	// right case
	// 	if (c < n - 1) {
	// 	    if (sweeper[r][c + 1] != "*") {
	// 		sweeper[r][c + 1] = String.valueOf(Integer.parseInt(sweeper[r][c + 1]) + 1);
	// 	    }
	// 	}
	// 	// left case
 	// 	if (c > 0) {
	// 	    if (sweeper[r][c - 1] != "*") {
	// 		sweeper[r][c - 1] = String.valueOf(Integer.parseInt(sweeper[r][c - 1]) + 1);
	// 	    }
	// 	}
	//     }


	//     if (m > 1) {
	// 	// up case
	// 	if (r > 0) {
	// 	    if (sweeper[r - 1][c] != "*") {
	// 		sweeper[r - 1][c] = String.valueOf(Integer.parseInt(sweeper[r - 1][c]) + 1);
	// 	    }
	// 	}

	// 	// down case
	// 	if (r < m - 1) {
	// 	    if (sweeper[r + 1][c] != "*") {
	// 		sweeper[r + 1][c] = String.valueOf(Integer.parseInt(sweeper[r + 1][c]) + 1);
	// 	    }
	// 	}
	//     }

	//     if (n > 1 && m > 1 && r > 0) {
	// 	// 45 degree case
	// 	if (c < n - 1) {
	// 	    if (sweeper[r - 1][c + 1] != "*") {
	// 		sweeper[r - 1][c + 1] = String.valueOf(Integer.parseInt(sweeper[r - 1][c + 1]) + 1);
	// 	    }
	// 	}

	// 	// -45 degree case
	// 	if (c > 0) {
	// 	    if (sweeper[r - 1][c - 1] != "*") {
	// 		sweeper[r - 1][c - 1] = String.valueOf(Integer.parseInt(sweeper[r - 1][c - 1]) + 1);
	// 	    }
	// 	}
	//     }

	//     // 225 degree case
	//     if (n > 1 && m > 1 && r < m - 1) {
	// 	if (c > 0) {
	// 	    if (sweeper[r + 1][c - 1] != "*") {
	// 		if (sweeper[r + 1][c - 1] == null) sweeper[r + 1][c - 1] = "1";
	// 		else sweeper[r + 1][c - 1] = String.valueOf(Integer.parseInt(sweeper[r + 1][c - 1]) + 1);
	// 	    }
	// 	}

	// 	// 315 degree case
	// 	if (c < n - 1) {
	// 	    if (sweeper[r + 1][c + 1] != "*") {
	// 		sweeper[r + 1][c + 1] = String.valueOf(Integer.parseInt(sweeper[r + 1][c + 1]) + 1);
	// 	    }
	// 	}
	//     }
	// }

	// String result = "";
	// String result = "";
	// for (int a = 0; a < m; a++) {
	//     for (int b = 0; b < n; b++) {
	// 	result += sweeper[a][b] + "  ";
	//     }
	//     result += "\n";
	// }
	// System.out.print(result);
	int d = 0;
	String result = "";
		
	for (int row = 0; row < m; row++) {
	    for (int col = 0; col < n; col++) {
		d = 0;
		if (sweeper[row][col] != "*") {
		    if (row != 0 && col != 0 && row < m - 1 && col < n - 1) { // in the middle
			if (sweeper[row - 1][col] == "*") d += 1; // up
			if (sweeper[row + 1][col] == "*") d += 1; // down
			if (sweeper[row][col - 1] == "*") d += 1; // left
			if (sweeper[row][col + 1] == "*") d += 1; // right
			if (sweeper[row - 1][col - 1] == "*") d += 1; // -45 degree
			if (sweeper[row - 1][col + 1] == "*") d += 1; // 45 degree
			if (sweeper[row + 1][col - 1] == "*") d += 1; // 225 degree
			if (sweeper[row + 1][col + 1] == "*") d += 1; // 315 degree
		    }

		    else if (row == 0 && col == 0) { // left corner
			if (n > 1 && sweeper[row][col + 1] == "*") d += 1; // right
			if (m > 1 && sweeper[row + 1][col] == "*") d += 1; // down
			if (n > 1 && m > 1 && sweeper[row + 1][col + 1] == "*") d += 1; // 315 degree
		    }

		    else if (row == 0 && col == n - 1) { // right corner
			if (m > 1 && sweeper[row + 1][col] == "*") d += 1; // down
			if (n > 1 && sweeper[row][col - 1] == "*") d += 1; // left
			if (m > 1 && n > 1 && sweeper[row + 1][col - 1] == "*") d += 1; // 225 degree
		    }

		    else if (col == 0 && row == m - 1) {
			if (m > 1 && sweeper[row - 1][col] == "*") d += 1; // up
			if (n > 1 && sweeper[row][col + 1] == "*") d += 1; // right
			if (m > 1 && n > 1 && sweeper[row - 1][col + 1] == "*") d += 1; // 45 degree
		    }
		    else if (col == n - 1 && row == m - 1) {
			if (sweeper[row - 1][col] == "*") d += 1; // up
			if (sweeper[row][col - 1] == "*") d += 1; // left
			if (sweeper[row - 1][col - 1] == "*") d += 1; // -45 degree
		    }
		    else if (row  == 0) {
			if (sweeper[row][col + 1] == "*") d += 1; // right
			if (sweeper[row][col - 1] == "*") d += 1; // left
			if (m > 1) {
			    if (sweeper[row + 1][col] == "*") d += 1; // down
			    if (sweeper[row + 1][col - 1] == "*") d += 1; // 225 degree
			    if (sweeper[row + 1][col + 1] == "*") d += 1; // 315 degree
			}
		    }

		    else if (row == m - 1) {
			if (sweeper[row][col + 1] == "*") d += 1; // right
			if (sweeper[row][col - 1] == "*") d += 1; // left
			if (sweeper[row - 1][col] == "*") d += 1; // up
			if (sweeper[row - 1][col - 1] == "*") d += 1; // -45 degree
			if (sweeper[row - 1][col + 1] == "*") d += 1; // 45 degree

		    }

		    else if (col == 0) {
			if (sweeper[row - 1][col] == "*") d += 1; // up
			if (sweeper[row + 1][col] == "*") d += 1; // down
			if (n > 1) {
			    if (sweeper[row][col + 1] == "*") d += 1; // right
			    if (sweeper[row + 1][col + 1] == "*") d += 1; // 315 degree
			    if (sweeper[row - 1][col + 1] == "*") d += 1; // 45 degree
			}
		    }

		    else if (col == n - 1) {
			if (sweeper[row - 1][col] == "*") d += 1; // up
			if (sweeper[row + 1][col] == "*") d += 1; // down
			if (sweeper[row][col - 1] == "*") d += 1; // left
			if (sweeper[row - 1][col - 1] == "*") d += 1; // -45 degree
			if (sweeper[row + 1][col - 1] == "*") d += 1; // 225 degree
		    }
		    sweeper[row][col] = String.valueOf(d);
		}
		System.out.print(sweeper[row][col] + "  ");
	    }
	    System.out.print("\n");
	}
	System.out.println(result);
    }
}

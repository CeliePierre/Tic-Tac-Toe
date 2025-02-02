/*
    NAME: Celie Pierre
    COS 161, Spring 2022, Prof. Andrew Amorelli
    Project 01
    File Name: GamePlus.java
*/

import java.awt.Font;
import java.awt.Graphics;
import java.util.Scanner;

public class GamePlus {

	int rSize = 4;
	int cSize = 4;
	char[][] gameBoard = new char[rSize][cSize];

	public void drawBoard() {
		DrawingPanel panel = new DrawingPanel(300, 300);
		Graphics g = panel.getGraphics();
		g.drawLine(100, 50, 100, 250);
		g.drawLine(150, 50, 150, 250);
		g.drawLine(200, 50, 200, 250);
		g.drawLine(50, 100, 250, 100);
		g.drawLine(50, 150, 250, 150);
		g.drawLine(50, 200, 250, 200);

		for (int r = 0; r < rSize; ++r) {
			for (int c = 0; c < cSize; ++c) {
				if (gameBoard[r][c] != 0) {
					String player = "" + gameBoard[r][c];
					int row = (r+1)*50 + 40;
					int col = (c+1)*50 + 10;
					g.setFont(new Font("Monospaced",Font.PLAIN,50));
					g.drawString(player, col, row);
				}
			}
		}

	}

	
	public void takeTurn(char p) {

		Scanner scanner = new Scanner(System.in);

		boolean validEntry = false;
		while (!validEntry) {
			// Prompts user to enter input in the console for the coordinates of their move
			System.out.print("PLAYER " + p + "\n"
					         + "Please enter your move. \n"
					         + "Select your row (enter a number, 1-" + rSize + "): ");
			int row = scanner.nextInt();
			System.out.print("Select your column (enter a number, 1-" + cSize + "): ");
			int col = scanner.nextInt();
			
			if (row == 1 || row == 2 || row == 3 || row == 4) {
				if (col == 1 || col == 2 || col == 3 || col == 4) {
					if (gameBoard[row-1][col-1] == 0) {
						System.out.println("Valid Entry! PLAYER " + p + " selected Row " 
					                       + row + " and Column " + col + ".\n");
						gameBoard[row-1][col-1] = p;
						drawBoard();
						validEntry = true;
					} else {
						System.out.println("Invalid Entry! Move already selected. "
								         + "Please choose again.");
					}
				} else {
					System.out.println("Invalid Column Entry! Please enter a "
							         + "valid number 1-" + cSize + ".");
				}
			} else {
				System.out.println("Invalid Row Entry! Please enter a "
						         + "valid number 1-" + rSize + ".");
			}
		}
	}
	
	public char checkWin() {
		char winner = 'N'; // No winner

		// Check for draw
		int empty = 0;
		for (int r = 0; r < rSize; ++r) {
			for (int c = 0; c < cSize; ++c) {
				if (gameBoard[r][c] == 0) {
					++empty;
				}
			}
		}
		if (empty == 0) {
			System.out.println("DRAW! Game over.");
			winner = 'D';
		}

		// Check for 4 in a row
		for (int r = 0; r < rSize; ++r) {
			int c = 0;
			if (gameBoard[r][c] != 0) {
				if (gameBoard[r][c] == gameBoard[r][c+1] 
						&& gameBoard[r][c] == gameBoard[r][c+2]
								&& gameBoard[r][c] == gameBoard[r][c+3]) {
					System.out.println("Winner!");
					winner = gameBoard[r][c];
					System.out.println("PLAYER " + gameBoard[r][c] + " has won! "
							         + "3 in a row.\nGame over.");
				}
			}
		}

		// Check for 4 in a column
		for (int c = 0; c < cSize; ++c) {
			int r = 0;
			if (gameBoard[r][c] != 0) {
				if (gameBoard[r][c] == gameBoard[r+1][c] 
						&& gameBoard[r][c] == gameBoard[r+2][c]
								&& gameBoard[r][c] == gameBoard[r+3][c]) {
					System.out.println("Winner!");
					winner = gameBoard[r][c];
					System.out.println("PLAYER " + gameBoard[r][c] + " has won! "
							         + "3 in a column.\nGame over.");
				}
			}
		}

		// Check for diagonal - left to right
		int r = 0;
		int c = 0;
		if (gameBoard[r][c] != 0) {
			if (gameBoard[r][c] == gameBoard[r+1][c+1] 
					&& gameBoard[r][c] == gameBoard[r+2][c+2]
							&& gameBoard[r][c] == gameBoard[r+3][c+3]) {
				System.out.println("Winner!");
				winner = gameBoard[r][c];
				System.out.println("PLAYER " + gameBoard[r][c] + " has won! "
						         + "Diagonal - left to right.\nGame over.");
			}
		}

		// Check for diagonal - right to left
		r = 0;
		c = 0;
		if (gameBoard[r+3][c] != 0) {
			if (gameBoard[r+3][c] == gameBoard[r+2][c+1] 
					&& gameBoard[r+3][c] == gameBoard[r+1][c+2]
							&& gameBoard[r+3][c] == gameBoard[r][c+3]) {
				System.out.println("Winner!");
				winner = gameBoard[r][c];
				System.out.println("PLAYER " + gameBoard[r][c] + " has won! "
						         + "Diagonal - right to left\nGame over.");
			}
		}

		// Check for 2x2 box
		for (r = 0; r < rSize-1; ++r) {
			for (c = 0; c < cSize-1; ++c) {
				if (gameBoard[r][c] != 0) {
					if (gameBoard[r][c] == gameBoard[r+1][c] 
							&& gameBoard[r][c] == gameBoard[r][c+1]
									&& gameBoard[r][c] == gameBoard[r+1][c+1]) {
						winner = gameBoard[r][c];
						System.out.println("PLAYER " + gameBoard[r][c] + " has won! "
						         + "2x2 box. \nGame over.");
					}
				}
			}
		}

	
		return winner;
	}
	
}

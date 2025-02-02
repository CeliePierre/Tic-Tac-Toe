/*
    NAME: Célie Pierre
    COS 161, Spring 2022, Prof. Andrew Amorelli
    Project 01
    File Name: TicTacPlus.java
*/

import java.awt.*;

public class TicTacAI {
	public static void main(String[] args) {
		
		// Start a new game
		GameAI game = new GameAI();

		// Play game
		while (game.checkWin() == 'N') {
			game.takeTurn('X');
			if (game.checkWin() != 'N') {
				break;
			}
			game.takeTurn('O');
		}
		

	}
}

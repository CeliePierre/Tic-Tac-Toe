/*
    NAME: Célie Pierre
    COS 161, Spring 2022, Prof. Andrew Amorelli
    Project 01
    File Name: TicTac.java
*/

import java.awt.*;

public class TicTac {
	public static void main(String[] args) {
		
		// Start a new game
		Game game = new Game();

		// Play game
		System.out.println("GREETINGS PROFESSOR FALKEN.\n");
		
		while (game.checkWin() == 'N') {
			game.takeTurn('X');
			if (game.checkWin() != 'N') {
				break;
			}
			game.takeTurn('O');
		}
		

	}
}

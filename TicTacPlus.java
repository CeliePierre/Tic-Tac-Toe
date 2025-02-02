/*
    NAME: Celie Pierre
    COS 161, Spring 2022, Prof. Andrew Amorelli
    Project 01
    File Name: TicTacPlus.java
*/

public class TicTacPlus {
	public static void main(String[] args) {
		
		// Start a new game
		GamePlus game = new GamePlus();

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

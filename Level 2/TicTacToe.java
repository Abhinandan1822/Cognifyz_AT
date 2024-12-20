//With Due Honesty, I have taken some ideas from my own java mentor for this project.
/* In this project i took numbers from 1 to 9 to represent the board, makes intuitive for players to input their move. They can 
 simple enter a number to display their choice*/

import java.util.Scanner;

class TicTacToe{
	public static void main(String[] args) {
		char[][] board = {{'1','2','3'},{'4','5','6'},{'7','8','9'}}; // Pre-Filled the board
		Scanner scanner = new Scanner(System.in);

		char currentPlayer = 'X'; //Start with player X
		int moves = 0; //Keep track of all the total moves

		while(true){
			printBoard(board); //Display the board

			//Now ask the current player for their move
			System.out.println("Player "+currentPlayer+", enter your move(1-9): ");
			int move = scanner.nextInt();

			//Validate the move and place it on the board
			if(move<1 || move>9 || !placeMove(board,move,currentPlayer)){
				System.out.println("Invalid move. TRY AGAIN!. ");
				continue;
			}
			moves++; // Increment the move count 

			//Check if the player wins or if the game ends in a draw
			if(checkWinner(board, currentPlayer)){  // here it checks if the current player wins, declare the winner ?
													
				printBoard(board);
				System.out.println("Player "+currentPlayer+" wins!");
				break;	
			}
			else if(moves==9){   //its checking like if board is full declare draw or end
				printBoard(board);	
				System.out.println("Its a Draw!");
				break;
			}

			//Switch players
			currentPlayer = (currentPlayer=='X') ? 'O':'X';	
		}
		scanner.close();
	}

	//Print the Board
	static void printBoard(char[][] board){
		System.out.println("Board: ");
		for(int i=0; i<3; i++){
			System.out.println(board[i][0] + " | "+board[i][1] + "|" +board[i][2]);
			if(i<2){
				System.out.println("--+--+--");
			}
		}
	}

	// Place the move on the board if the position is valid
	static boolean placeMove(char[][] board, int move, char player){
		int row = (move - 1)/3;	//Calculate row index
		int col = (move - 1)%3; //Calculate column index

		if(board[row][col]!= 'X' && board[row][col]!= 'O'){ //check if any spot available empty
			board[row][col] = player; //place the move
			return true;
		}
		else{
			return false; // spot isnt empty
		}
	}
	
	//Now check if the current player has won	
	static boolean checkWinner(char[][] board, char player){
		//check rows and columns
		for (int i = 0; i < 3; i++){
			if((board[i][0]==player && board[i][1]==player && board[i][2]==player) || 
			(board[0][i]==player && board[1][i]==player && board[2][i]==player)){

			return true;
			}		
		}

		//Check the diagonals
		return(board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
			  (board[0][2] == player && board[1][1] == player && board[2][0] == player);
	}
}

/*

RUNTIME FLOW:

START--->Display Board--->Ask Player for Move--->Validate Move ----> [Invalid? (Re-ask)]--->Place Move on Board--
-->Check Winner ---> [Winner? (Declare Winner, END)]--->Check Draw ----> [Draw? (Declare Draw, END)]--
-->Switch Player--->Repeat

*/
package com.cg.tictactoe;

import java.util.Scanner;

public class TicTacToe {
	static final int head = 1, tail = 0;
	static Scanner sc = new Scanner(System.in);
	static char player, computer;
	static String lastPlayed;

	// UC1 - Creating a Board
	public static char[] createBoard() {
		char[] board = new char[10];
		for (int pos = 1; pos < board.length; pos++) {
			board[pos] = ' ';
		}
		return board;
	}

	// UC2 - Taking Input
	public static char takeInput() {
		System.out.println("Enter the letter you wish to take: ('X' / 'O'): ");
		char input = Character.toUpperCase(sc.next().charAt(0));
		if (input == 'X' || input == 'O') {
			setLetter(input);
			return input;
		} else {
			System.out.println("Invalid Character. Try Again.");
			return takeInput();
		}
	}

	// UC2 - Determine letter for player and computer
	public static void setLetter(char player) {
		computer = (player == 'X') ? 'O' : 'X';
		System.out.println("Player Letter: " + player + "\nComputer Letter : " + computer);
	}

	// UC3 - Display the Board
	public static void displayBoard(char[] board) {
		System.out.println("\n\t " + board[1] + " | " + board[2] + " | " + board[3] + "\n\t-----------");
		System.out.println("\t " + board[4] + " | " + board[5] + " | " + board[6] + "\n\t-----------");
		System.out.println("\t " + board[7] + " | " + board[8] + " | " + board[9] + "\n\t");
	}

	private static boolean isEmpty(char[] board) {
		for (char cell : board) {
			if (cell == ' ')
				return true;
		}
		return false;
	}

	/*
	 * UC4 - Player Movement & UC5 - Player places letter
	 */
	public static void movePlayer(char[] board) {
		System.out.print("Enter the index you want to move to: ");
		int index = sc.nextInt();
		while (index < 1 || index > 9) {
			System.out.print("Wrong Input. Try Again : ");
			index = sc.nextInt();
		}
		if (board[index] == ' ') {
			board[index] = player;
			displayBoard(board);
		} else {
			System.out.println("Index not available. Choose another");
			movePlayer(board);
		}
		lastPlayed = "Player";
		if (checkWin(board)) { // UC12 - Player wins
			System.out.println("Player Won The Game !! \nDo You Want to Play Another Game (Y/N) : ");
			if (Character.toUpperCase(sc.next().charAt(0)) == 'Y') // UC13 -- Next Game
				startGame();
			else
				System.exit(0);
		}
		if (isEmpty(board)) {
			moveComputer(board);
		} else {
			System.out.println("Game Tied. \nDo You Want to Play Another Game (Y/N) : "); // UC12 -- Board is full
			if (Character.toUpperCase(sc.next().charAt(0)) == 'Y') // UC13 -- Next Game
				startGame();
			else
				System.exit(0);
		}
		return;
	}

	// UC8 - UC12 Computer Movement
	public static void moveComputer(char[] board) {
		int checkCompWinPos = checkIsWinning(board, computer);
		int checkPlayWinPos = checkIsWinning(board, player);

		if (checkCompWinPos != 0) {
			board[checkCompWinPos] = computer;
			displayBoard(board);
			System.out.println("Computer Won The Game !! \nDo You Want to Play Another Game (Y/N) : ");
			if (Character.toUpperCase(sc.next().charAt(0)) == 'Y') // UC13 -- Next Game
				startGame();
			else
				System.exit(0);
		} // UC8
		else if (checkPlayWinPos != 0) // UC9
			board[checkPlayWinPos] = computer;
		else {
			if (board[1] == ' ') // UC10
				board[1] = computer;
			else if (board[3] == ' ')
				board[3] = computer;
			else if (board[7] == ' ')
				board[7] = computer;
			else if (board[9] == ' ')
				board[9] = computer;
			else if (board[5] == ' ')
				board[5] = computer; // UC11
			else if (board[2] == ' ')
				board[2] = computer;
			else if (board[4] == ' ')
				board[4] = computer;
			else if (board[6] == ' ')
				board[6] = computer;
			else if (board[8] == ' ')
				board[8] = computer;
		}
		displayBoard(board);
		lastPlayed = "Computer";
		if (checkWin(board)) { // UC12 - Computer Wins
			System.out.println("Computer Won The Game !! \nDo You Want to Play Another Game (Y/N) : ");
			if (Character.toUpperCase(sc.next().charAt(0)) == 'Y') // UC13 - Next Game
				startGame();
			else
				System.exit(0);
		}
		if (isEmpty(board)) {
			movePlayer(board);
		} else {
			System.out.println("Game Tied."); // UC12 - board is full
			System.exit(0);
		}
	}

	private static int checkIsWinning(char[] board, char letter) {
		int index = 1;
		while (index > 0 && index < 10) {
			if (board[index] == ' ') {
				board[index] = letter;
				if (checkWin(board)) {
					return index;
				} else {
					board[index] = ' ';
				}
			}
			index++;
		}
		return 0;
	}

	// UC6 - Randomly decide who plays first
	public static void firstMove(char[] board) {
		int toss = (int) (Math.random() * 2 % 2);
		if (toss == head) {
			System.out.println("Player Wins the Toss.");
			lastPlayed = "Player";
			movePlayer(board);
		} else {
			System.out.println("Computer Wins the Toss.");
			lastPlayed = "Computer";
			moveComputer(board);
		}
	}

	// UC7 - Winner, Tie or next turn
	public static boolean outcome(char[] board) {
		if (checkWin(board))
			return true;
		else if (areMovesLeft(board)) {
			if (lastPlayed.equals("Computer"))
				movePlayer(board);
			else
				moveComputer(board);
			return false;
		} else {
			System.out.println("Game Tied.");
			return false;
		}
	}

	private static boolean checkWin(char[] board) {
		return ((board[1] == board[2] && board[2] == board[3] && board[1] != ' ') // top-row
				|| (board[4] == board[5] && board[5] == board[6] && board[4] != ' ') // middle-row
				|| (board[7] == board[8] && board[8] == board[9] && board[7] != ' ') // bottom-row
				|| (board[1] == board[4] && board[4] == board[7] && board[1] != ' ') // left-column
				|| (board[2] == board[5] && board[5] == board[8] && board[2] != ' ') // middle-column
				|| (board[3] == board[6] && board[6] == board[9] && board[3] != ' ') // right-column
				|| (board[1] == board[5] && board[5] == board[9] && board[1] != ' ') // left-diagonal
				|| (board[3] == board[5] && board[5] == board[7] && board[3] != ' ')); // right-diagonal
	}

	private static boolean areMovesLeft(char[] board) {
		for (int pos = 1; pos < board.length; pos++) {
			if (pos == ' ')
				return true;
		}
		return false;
	}

	private static void startGame() {
		char[] board = createBoard();
		player = takeInput();
		displayBoard(board);
		firstMove(board);
	}

	public static void main(String[] args) {
		System.out.println("Welcome to the TicTacToe Game");
		startGame();
		sc.close();
	}

}

//package com.cg.tictactoe;
//
//import java.util.Arrays;
//import java.util.Scanner;
//
//public class TicTacToeGame {
//	static Scanner sc = new Scanner(System.in);
//	static char[] board = new char[10];
//	static char playerTurn, computer, X, O, o, x;
//	static int cell;
//	static double Toss;
//
//	// UC1 Creating Board
//	public static void creatingBoard() {
//		for (int i = 0; i < 10; i++) {
//			board[i] = ' ';
//		}
//		System.out.println("Board Created");
//	}
//
//	// UC2 Input from the Player
//	public static char playerInput() {
//		System.out.println("Enter the Choice (X/O)");
//		playerTurn = sc.next().charAt(0);
//		if (playerTurn == 'X' || playerTurn == 'x') {
//			playerTurn = 'X';
//			computer = 'O';
//			System.out.println("You Selected " + playerTurn + ".");
//			System.out.println("Computer Selected " + computer + ".");
//		} else if (playerTurn == 'O' || playerTurn == 'o') {
//			playerTurn = 'O';
//			computer = 'X';
//			System.out.println("You Have Entered " + playerTurn + ".");
//			System.out.println("Computer Entered " + computer + ".");
//		} else {
//			System.out.println("Invalid Input!");
//		}
//		return playerTurn;
//	}
//
//	// UC4 To Make Move to Desired Location
//	public static void moveToDesiredLocation() {
//		System.out.println("Enter the Cell (1-9):");
//		cell = sc.nextInt();
//		if (cell > 0 && cell <= 9)
//			if (board[cell - 1] == ' ') {
//				board[cell - 1] = playerTurn;
//			} else {
//				System.out.println("Cell is Occupied");
//			}
//		else
//			System.out.println("Invalid Input");
//	}
//
//	// UC5 To Make Move to Desired Location with checking empty spaces
//	public static void checkBeforeMove() {
//		for (int j = 0; j < 9; j++) {
//
//			System.out.println("Enter the Cell (1-9):");
//			cell = sc.nextInt();
//			if (cell > 0 && cell <= 9)
//				if (board[cell - 1] == ' ') {
//					board[cell - 1] = playerTurn;
//				} else {
//					System.out.println("Cell is Occupied");
//				}
//			else
//				System.out.println("Invalid Input");
//			showBoard();
//			if (checkWinner() == null) {
//				break;
//			}
//		}
//
//	}
//
//	// UC3 Board Creation
//	public static void showBoard() {
//		System.out.println("/---|---|---\\");
//		System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
//		System.out.println("|-----------|");
//		System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
//		System.out.println("|-----------|");
//		System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
//		System.out.println("\\---|---|---/");
//	}
//
//	// UC6 Toss
//	public static void toss() {
//		Toss = Math.random();
//		if (Toss < 0.5) {
//			System.out.println("Player will Go First");
//		} else {
//			System.out.println("Computer will Go first");
//		}
//	}
//
//	// UC 7 Process and check
//	public static String checkWinner() {
//		for (int a = 0; a < 8; a++) {
//			String line = null;
//			switch (a) {
//			case 0:
//				line = "board[0]" + "board[1]" + "board[2]";
//				break;
//			case 1:
//				line = "board[3]" + "board[4]" + "board[5]";
//				break;
//			case 2:
//				line = "board[6]" + "board[7]" + "board[8]";
//				break;
//			case 3:
//				line = "board[0]" + "board[3]" + "board[6]";
//				break;
//			case 4:
//				line = "board[1]" + "board[4]" + "board[7]";
//				break;
//			case 5:
//				line = "board[2]" + "board[5]" + "board[8]";
//				break;
//			case 6:
//				line = "board[0]" + "board[4]" + "board[8]";
//				break;
//			case 7:
//				line = "board[2]" + "board[4]" + "board[6]";
//				break;
//			}
//			if (line.equals("XXX")) {
//				return "X";
//			} else if (line.equals("OOO")) {
//				return "O";
//			}
//		}
//		for (int a = 0; a < 9; a++) {
//			if (Arrays.asList(board).contains(String.valueOf(a + 1))) {
//				break;
//			} else if (a == 8)
//				return "draw";
//		}
//		return null;
//	}
//
//	// USERCASE 8
//	public static void play() {
//		if (Toss < 0.5) {
//
//		}
//
//	}
//
//	public static void main(String[] args) {
//		System.out.println("Welcome to Tic Tac Toe Game.");
//		creatingBoard();
//		toss();
//		playerInput();
//		checkBeforeMove();
//		checkWinner();
//	}
//}

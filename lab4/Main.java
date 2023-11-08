import lib.Validator;

import java.util.Scanner;

public class Main
{
	static public Scanner inScanner = new Scanner(System.in);

	public static void main(String[] args)
	{
		Board board = new Board();
		board.setColorGaming('w');
		board.init();

		while (true)
		{
			board.printBoard();
			print("\n");
			print("Команды: ");
			print("----- exit: Выход из игры");
			print("------y1 x1 y2 x2: Ход фигуры из клетки x1, y1 в клекту x2, y2");


			print("Взятые Белые:" + board.getTakeWhite().toString());
			print("Взятые Черные:" + board.getTakeBlack().toString());

			switch (board.getColorGaming())
			{
				case 'w':
					print("Ход Белых:");
					break;
				case 'b':
					print("Ход Черных:");
					break;
			}


			String inputLine = getUserStringWhileIsNotValid(false, 8);

			if (inputLine.equals("exit"))
			{
				print("Игра завршена.");
				inScanner.close();
				break;
			}
			int x1, y1, x2, y2;
			String[] coords = inputLine.split(" ");
			y1 = Integer.parseInt(coords[0]);
			x1 = Integer.parseInt(coords[1]);
			y2 = Integer.parseInt(coords[2]);
			x2 = Integer.parseInt(coords[3]);


			while (!board.moveFigure(y1, x1, y2, x2))
			{
				print("Ошибка хода, повторите ввод хода!");
				inputLine = getUserStringWhileIsNotValid(false, 8);
				coords = inputLine.split(" ");
				y1 = Integer.parseInt(coords[0]);
				x1 = Integer.parseInt(coords[1]);
				y2 = Integer.parseInt(coords[2]);
				x2 = Integer.parseInt(coords[3]);
			}
			;

			switch (board.getColorGaming())
			{
				case 'w':
					board.setColorGaming('b');
					break;
				case 'b':
					board.setColorGaming('w');
					break;
			}


		}
	}

	public static String getUserStringWhileIsNotValid(boolean isNumber, int maxLen)
	{
		while (true)
		{
			String command = inScanner.nextLine();

			if (Validator.isStringValid(command, maxLen) && (!isNumber || Validator.isNumeric(command) >= 0))
			{
				return command;
			}

			print("APPLICATION_COMMAND_IS_NOT_VALID");
		}
	}

	public static void print(String message)
	{
		System.out.println(message);
	}
}
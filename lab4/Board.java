import Figures.*;

import java.util.ArrayList;

public class Board
{
	//TODO: Список фигур и начальное положение всех фигур
	private Figure fields[][] = new Figure[8][8];
	private ArrayList<String> takeWhite = new ArrayList(16);
	private ArrayList<String> takeBlack = new ArrayList(16);

	private static final boolean check = false;

	public char getColorGaming()
	{
		return colorGaming;
	}

	public void setColorGaming(char colorGaming)
	{
		this.colorGaming = colorGaming;
	}

	private char colorGaming;

	public void init()
	{
		this.fields[0] = new Figure[]{
			new Rook("R", 'w'), new Knight("N", 'w'),
			new Bishop("B", 'w'), new Queen("Q", 'w'),
			new King("K", 'w'), new Bishop("B", 'w'),
			new Knight("N", 'w'), new Rook("R", 'w')
		};
		this.fields[1] = new Figure[]{
			new Pawn("P", 'w'), new Pawn("P", 'w'),
			new Pawn("P", 'w'), new Pawn("P", 'w'),
			new Pawn("P", 'w'), new Pawn("P", 'w'),
			new Pawn("P", 'w'), new Pawn("P", 'w'),
		};

		this.fields[7] = new Figure[]{
			new Rook("R", 'b'), new Knight("N", 'b'),
			new Bishop("B", 'b'), new Queen("Q", 'b'),
			new King("K", 'b'), new Bishop("B", 'b'),
			new Knight("N", 'b'), new Rook("R", 'b')
		};
		this.fields[6] = new Figure[]{
			new Pawn("P", 'b'), new Pawn("P", 'b'),
			new Pawn("P", 'b'), new Pawn("P", 'b'),
			new Pawn("P", 'b'), new Pawn("P", 'b'),
			new Pawn("P", 'b'), new Pawn("P", 'b'),
		};
	}

	public String getCell(int row, int col)
	{
		Figure figure = this.fields[row][col];

		if (figure == null)
		{
			return "    ";
		}

		return " " + figure.getColor() + figure.getName() + " ";
	}

	public ArrayList<String> getTakeWhite()
	{
		return takeWhite;
	}

	public ArrayList<String> getTakeBlack()
	{
		return takeBlack;
	}

	public boolean moveFigure(int row1, int col1, int row2, int col2)
	{

		Figure figure = this.fields[row1][col1];

		if (figure == null)
		{
			return false;
		}

		int[] kingLocation = getKingLocation();

		if (
			isCheck(kingLocation[0], kingLocation[1])

		)
		{
			System.out.println("check");
			return false;
		}

		if (
			this.fields[row1][col1].getColor() != this.colorGaming
			|| this.fields[row2][col2] instanceof King
		)
		{
			return false;
		}

		if (
			this.fields[row1][col1] instanceof King
			&& isCheck(row2, col2)
		)
		{
			System.out.println("check");
			return false;
		}

		if (
			this.fields[row2][col2] == null
			&& figure.canMove(row1, col1, row2, col2)
			&& !hasObstacles(row1, col1, row2, col2)
		)
		{
			System.out.println("move");
			this.fields[row2][col2] = figure;
			this.fields[row1][col1] = null;

			return true;
		}
		else if (
			this.fields[row2][col2] != null
			&& figure.canAttack(row1, col1, row2, col2)
			&& !hasObstacles(row1, col1, row2, col2)
			&& this.fields[row2][col2].getColor() != this.fields[row1][col1].getColor()
		)
		{
			System.out.println("attack");
			switch (this.fields[row2][col2].getColor())
			{
				case 'w':
				{
					this.takeWhite.add(this.fields[row2][col2].getColor() + this.fields[row2][col2].getName());
					break;
				}
				case 'b':
				{
					this.takeBlack.add(this.fields[row2][col2].getColor() + this.fields[row2][col2].getName());
					break;
				}
			}

			this.fields[row2][col2] = figure;
			this.fields[row1][col1] = null;

			return true;
		}

		return false;
	}

	public boolean isCheck(int row, int col)
	{
		for (int i = 0; i < 8; i++)
		{
			for (int j = 0; j < 8; j++)
			{
				if (this.fields[i][j] != null)
				{
					Figure figure = this.fields[i][j];

					if (
						figure.getColor() != this.getColorGaming()
						&& figure.canAttack(i, j, row, col)
						&& !hasObstacles(i, j, row, col)
					)
					{
						return true;
					}
				}
			}
		}

		return false;
	}

	private int[] getKingLocation()
	{
		for (int i = 0; i < 8; i++)
		{
			for (int j = 0; j < 8; j++)
			{
				if (
					this.fields[i][j] instanceof King
					&& this.fields[i][j].getColor() == this.getColorGaming()
				)
				{
					return new int[]{i, j};
				}
			}
		}

		return new int[0];
	}

	public boolean hasObstacles(int rowFrom, int colFrom, int rowTo, int colTo)
	{
		int dx, dy;

		if (rowFrom == rowTo)
		{
			dx = 0;
		} else
		{
			dx = (rowTo - rowFrom) / Math.abs(rowTo - rowFrom);
		}

		if (colFrom == colTo)
		{
			dy = 0;
		} else
		{
			dy = (colTo - colFrom) / Math.abs(colTo - colFrom);
		}

		while (colFrom != colTo || rowFrom != rowTo)
		{
			colFrom += dy;
			rowFrom += dx;

			if (
				(colFrom != colTo || rowFrom != rowTo)
					&& this.fields[rowFrom][colFrom] != null
			)
			{
				return true;
			}
		}

		return false;
	}

	public void printBoard()
	{
		System.out.println(" +----+----+----+----+----+----+----+----+");
		for (int row = 7; row > -1; row--)
		{
			System.out.print(row);
			for (int col = 0; col < 8; col++)
			{
				System.out.print("|" + getCell(row, col));
			}
			System.out.println("|");
			System.out.println(" +----+----+----+----+----+----+----+----+");
		}

		for (int col = 0; col < 8; col++)
		{
			System.out.print("    " + col);
		}
	}
}

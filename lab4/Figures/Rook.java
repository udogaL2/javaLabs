package Figures;

public class Rook extends Figure
{
	public Rook(String name, char color)
	{
		super(name, color);
	}

	@Override
	public boolean canMove(int rowFrom, int colFrom, int rowTo, int colTo)
	{
		return rowFrom == rowTo || colFrom == colTo;
	}

	@Override
	public boolean canAttack(int rowFrom, int colFrom, int rowTo, int colTo)
	{
		return this.canMove(rowFrom, colFrom, rowTo, colTo);
	}

	@Override
	public boolean hasObstacles(Figure[][] fields, int rowFrom, int colFrom, int rowTo, int colTo)
	{
		int dx, dy;

		if (rowFrom == rowTo)
		{
			dx = 0;
		}
		else
		{
			dx = (rowTo - rowFrom) / Math.abs(rowTo - rowFrom);
		}

		if (colFrom == colTo)
		{
			dy = 0;
		}
		else
		{
			dy = (colTo - colFrom) / Math.abs(colTo - colFrom);
		}

		while (colFrom != colTo || rowFrom != rowTo) {
			colFrom += dy;
			rowFrom += dx;

			if (
				colFrom != colTo
				|| rowFrom != rowTo
				&& fields[colFrom][rowFrom] != null
			)
			{
				return false;
			}
		}

		return true;
	}
}

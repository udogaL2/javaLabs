import model.*;
import controller.*;
import view.*;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main
{
	public static void main(String[] arg)
	{
		ArrayList<Cinema> cinemaList = new ArrayList<>();
		Scanner in = new Scanner(System.in);

		while (true)
		{
			String command = in.nextLine();

			if (Objects.equals(command, "1"))
			{
				String title = in.nextLine();
				cinemaList.add(CinemaController.createNewCinema(title));
			}
			else if (Objects.equals(command, "2"))
			{
				int index = in.nextInt();
				in.nextLine();
				CinemaView.printCinema(cinemaList.get(index));
			}
			else if (Objects.equals(command, "3"))
			{
				break;
			}
		}
	}
}

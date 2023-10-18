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
		Armchair ar = ArmchairController.createNewArmchair("Arm1", "desc", "T");

		CinemaHall ch = CinemaHallController.createNewCinemaHall("CinemaHall1", 3);

		ArrayList<CinemaHall> arrayList = new ArrayList<>();

		arrayList.add(ch);

		CinemaHallController.addArmchairToCinemaHall(arrayList, 0, 0, ar);

		CinemaHallView.printCinemaHall(arrayList.get(0));
	}
}

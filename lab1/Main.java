import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] arg)
    {
        syracuseSequence();
        seriesSum();
        treasureSearch();
        logicMax();
        isDoubleEven();
    }

    // 1. Сиракузская последовательность
    public static void syracuseSequence()
    {
        Scanner in = new Scanner(System.in);

        int startNum = in.nextInt();
        int steps = 0;
        while(startNum != 1)
        {
            if (startNum % 2 == 0)
            {
                startNum = startNum / 2;
            }
            else
            {
                startNum = startNum * 3 + 1;
            }

            steps++;
        }

        System.out.println(steps);
    }

    // 2. Сумма ряда
    public static void seriesSum()
    {
        Scanner in = new Scanner(System.in);

        int numbersCount = in.nextInt();
        int sum = 0;
        int flag = 1;
        for (int i = 0; i < numbersCount; i++)
        {
            int number = in.nextInt();

            sum += number * flag;
            flag *= -1;
        }

        System.out.println(sum);
    }

    // 3. Ищем клад
    public static void treasureSearch()
    {
        Scanner in = new Scanner(System.in);

        int x = in.nextInt();
        int y = in.nextInt();
        in.nextLine();

        int currentX = 0, currentY = 0, instructionsCount = 0;

        String command = in.nextLine();

        while (!Objects.equals(command, "стоп"))
        {
            int steps = in.nextInt();
            in.nextLine();

            instructionsCount++;

            if (Objects.equals(command, "север"))
            {
                currentY += steps;
            }
            else if (Objects.equals(command, "запад"))
            {
                currentX -= steps;
            }
            else if (Objects.equals(command, "юг"))
            {
                currentY -= steps;
            }
            else if (Objects.equals(command, "восток"))
            {
                currentX += steps;
            }

            if (x == currentX && y == currentY)
            {
                System.out.println(instructionsCount);
                break;
            }

            command = in.nextLine();
        }
    }

    // 4. Логистический максимин
    public static void logicMax()
    {
        Scanner in = new Scanner(System.in);
        int roadCount = in.nextInt();
        int maxRoad = 0, road = 1;

        for (int i = 1; i <= roadCount; i++)
        {
            int tunnelCount = in.nextInt();
            int localMax = Integer.MAX_VALUE;
            for (int j = 0; j < tunnelCount; j++)
            {
                int height = in.nextInt();
                if (localMax > height)
                {
                    localMax = height;
                }
            }

            if (localMax > maxRoad)
            {
                maxRoad = localMax;
                road = i;
            }
        }

        System.out.print(road);
        System.out.print(" ");
        System.out.print(maxRoad);
    }

    public static void isDoubleEven()
    {
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        int firstNum = number / 100, secondNum = number / 10 % 10, thirdNum = number % 10;

        System.out.println(
                (firstNum + secondNum + thirdNum) % 2 == 0
                && (firstNum * secondNum * thirdNum) % 2 == 0
        );
    }
}

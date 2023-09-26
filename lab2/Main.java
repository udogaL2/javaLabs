import java.util.Arrays;

public class Main {

    public static void main(String[] arg)
    {
        System.out.println(maxSubarraySum(new int[]{1, 2, -3, 4, -1, 2, 1, -5, 4}));
    }

    public static String getMaxUnicSubstr(String inputString)
    {
        String usedChars = "";

        int start = 0;
        int maxStart = 0;
        int maxLength = 0;
        int currentLength = 0;

        for (int i = 0; i < inputString.length(); i++)
        {
            String currentChar = "" + inputString.charAt(i);

            if (usedChars.contains(currentChar))
            {
                start = i;
                usedChars = "";
            }

            usedChars = usedChars + currentChar;

            currentLength = i - start + 1;

            if (currentLength > maxLength)
            {
                maxLength = currentLength;
                maxStart = start;
            }
        }

        return inputString.substring(maxStart, maxStart + maxLength);
    }

    public static int[] getMergeWithSort(int[] array1, int[] array2)
    {
        int[] arrayToReturn = new int[array1.length + array2.length];

        int currentIndex = 0;
        for(int element : array1)
        {
            arrayToReturn[currentIndex] = element;
            currentIndex += 1;
        }

        for(int element : array2)
        {
            arrayToReturn[currentIndex] = element;
            currentIndex += 1;
        }

        Arrays.sort(arrayToReturn);
        return arrayToReturn;
    }

    public static int maxSubarraySum(int[] arr) {
        int maxSum = arr[0];
        int currentSum = arr[0];

        for (int i = 1; i < arr.length; i++) {
            currentSum = Math.max(arr[i], currentSum + arr[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}

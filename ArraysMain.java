import java.lang.reflect.Array;

public class ArraysMain {
    public static void main(String args[]) {
        try {
            int[] arr = { 1, 2, 3, 4, 5 };
            System.out.println("The average value in array { 1, 2, 3, 4, 5 } is: " + Arrays.average(arr));

            System.out.println("The max value in array { 1, 2, 3, 4, 5 } is: " + Arrays.max(arr));

            Arrays.addN(arr, 2);
            System.out.println("Added 2 to all values in in array { 1, 2, 3, 4, 5 } is: " + Arrays.toString(arr));
            System.out.println("The old array { 1, 2, 3, 4, 5 } got changed to: " + Arrays.toString(arr));

            int[] arr2 = { 1, 2, 3, 4, 5 };
            int[] arrR = Arrays.reverse(arr2);
            System.out.println("The reverse of array { 1, 2, 3, 4, 5 } is: " + Arrays.toString(arrR));

            Arrays.replaceAll(arr2, 2, 5);
            System.out.println("Replacing 2 in array { 1, 2, 3, 4, 5 } to 5: " + Arrays.toString(arr2));

            int[] arrS = Arrays.sort(arr2);
            System.out.println("Sorting the array { 1, 5, 3, 4, 5 }: " + Arrays.toString(arrS));
            System.out.println("The old array { 1, 5, 3, 4, 5 } was left unchanged: " + Arrays.toString(arr2));

            int[] arr3 = { 1, 6, 5 };
            int[] arrSub1 = { 1, 5, 3, 4, 5 };
            int[] arrSub2 = { 1, 2, 3, 6, 5 };
            System.out.println(
                    "The array { 1, 6, 5 } is a subset of { 1, 2, 3, 6, 5 }: " + Arrays.hasSubString(arrSub2, arr3));
            ;
            System.out.println("But not a subset of { 1, 5, 3, 4, 5 }: " + Arrays.hasSubString(arrSub1, arr3));

            int[] arr6 = { 1, 2, 3, 4, 5 };
            int[] arr7 = { 1, 5, 3, 4, 5 };
            int[] arr8 = Arrays.absDif(arr6, arr7);
            System.out.println(
                    "The difference between { 1, 2, 3, 4, 5 } and { 1, 5, 3, 4, 5 } is : " + Arrays.toString(arr8));

            int[] arr9 = { 1, 5, 3, 4 };
            System.out.println("If trying out the same function with different lengths in the arrays I get an error: ");
            Arrays.absDif(arr6, arr9);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("The array sizes must be exactly the same.");
        } catch (Exception e) {
            System.out.println("Some unexplained error has occured.");
        }
    }
}

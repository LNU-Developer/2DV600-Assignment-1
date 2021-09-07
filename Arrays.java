
import java.util.*;

public class Arrays {
    static public int average(int[] arr) {
        int sum = 0;
        int arrayLength = arr.length;
        for (int i : arr) {
            sum += i;
        }
        return sum / arrayLength;
    }

    static public int max(int[] arr) {
        int arrayLength = arr.length;
        int[] sortedArray = sort(arr);
        return sortedArray[arrayLength - 1];
    }

    static public int[] addN(int[] arr, int n) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] += n;
        }
        return arr;
    }

    static public int[] reverse(int[] arr) {
        int[] newArray = new int[arr.length];
        int arrayLength = arr.length;
        for (int i = 0; i < arr.length; i++) {
            newArray[arrayLength - 1] = arr[i];
            arrayLength = arrayLength - 1;
        }
        return newArray;
    }

    static public void replaceAll(int[] arr, int old, int nw) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == old)
                arr[i] = nw;
        }
    }

    static public int[] sort(int[] arr) {
        int[] newArray = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            newArray[i] = arr[i];
        }

        // Using bubble sort algorithm
        for (int i = 0; i < newArray.length; i++) {
            for (int j = i + 1; j < newArray.length; j++) {
                int tempNo = 0;
                if (newArray[i] > newArray[j]) {
                    tempNo = newArray[i];
                    newArray[i] = newArray[j];
                    newArray[j] = tempNo;
                }
            }
        }
        return newArray;
    }

    static public boolean hasSubString(int[] arr, int[] sub) {
        Set<Integer> uniqueIntegers = new HashSet<Integer>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < sub.length; j++) {
                if (arr[i] == sub[j]) {
                    uniqueIntegers.add(sub[j]);
                }
            }
        }

        if (uniqueIntegers.size() == sub.length)
            return true;
        else
            return false;
    }

    static public int[] absDif(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length)
            throw new ArrayIndexOutOfBoundsException();

        int[] newArray = new int[arr1.length];

        for (int i = 0; i < arr1.length; i++) {
            newArray[i] = arr1[i] - arr2[i];
        }

        return newArray;
    }

    static public String toString(int[] arr) {
        StringBuilder str = new StringBuilder();
        str.append("{ ");
        for (int i : arr) {
            str.append(i);
            str.append(", ");
        }
        str.setLength(str.length() - 2);
        str.append(" }");
        return str.toString();
    }
}

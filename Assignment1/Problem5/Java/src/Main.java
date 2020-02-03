import java.util.Arrays;
public class Main {

    public static void main(String[] args) {
	    int size = 128;
        int[] array = new int[size];
        for (int i = 0; i<size; i++){
            array[i]=1;
        }
        long start = System.nanoTime();
        for (int i = 0; i < 10000000; i++){
            Arrays.binarySearch(array, 0);
        }
        long end = System.nanoTime();
        long run = end - start;
        System.out.println("Execution time for " + size + " is: " + run);
    }

    /*public static int search(int[] array, int target){
        int first = 0;
        int last = array.length -1;
        int mid;
        int position = -1;
        boolean found = false;

        while (!found && first <= last);{
            mid = (first+last)/2;
            if (array[mid]==target){
                found = true;
                position = mid;
            }
            else if (array[mid] > target){
                last = mid - 1;
            }
            else {
                first = mid + 1;
            }
        }

        return position;
    }*/
}

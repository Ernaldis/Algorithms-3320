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
}

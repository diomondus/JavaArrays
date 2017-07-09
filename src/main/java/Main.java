import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Integer m = 5,n = 10, bound = 100;
//        processIntegerDynamicArray(n, bound);
        processIntegerDynamicMatrix(m, n, bound);
    }

    public static void processIntegerDynamicMatrix(Integer aHight, Integer aWeight, int aBound) {

        Long seed = System.currentTimeMillis();
        Random random = new Random(seed);
        IntegerDynamicMatrix matrix = new IntegerDynamicMatrix(aHight, aWeight, random, aBound);
        System.out.println("Matrix");
        matrix.print();
        matrix.sort();
        System.out.println("Sorted matrix");
        matrix.print();
        System.out.println("Max = " + matrix.getMaximum());
        System.out.println("Min = " + matrix.getMinimum());
    }

    public static void processIntegerDynamicArray(Integer aCount, int aBound) {
        Long seed = System.currentTimeMillis();
        Random random = new Random(seed);
        IntegerDynamicArray array = new IntegerDynamicArray(aCount, random, aBound);
        System.out.println("Array");
        array.print();
        array.sort();
        System.out.println("Sorted array");
        array.print();
    }
}

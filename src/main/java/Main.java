import org.jblas.DoubleMatrix;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
//        Integer m = 4, n = 10, bound = 100;
//        processDynamicArray(n, bound);
//        processDynamicMatrix(m, n, bound);
        processJBLASMatrix();
    }

    public static void processJBLASMatrix()
    {
        DoubleMatrix a = DoubleMatrix.randn(2000, 2000);
        DoubleMatrix b = DoubleMatrix.randn(2000, 2000);
//        DoubleMatrix a = DoubleMatrix.randn(2, 2);
//        DoubleMatrix b = DoubleMatrix.randn(2, 2);
//        a.print();
//        b.print();
        Long time = System.currentTimeMillis();
        System.out.println("mul start");
        DoubleMatrix c = a.mmul(b);
//        c.print();
        System.out.println("mul end: " + ( (System.currentTimeMillis() - time)/1000.0) + "c");
        DoubleMatrix d = b.add(c);
//        d.print();
    }

    public static void processDynamicMatrix(Integer aHight, Integer aWeight, int aBound) {

        Long seed = System.currentTimeMillis();
        Random random = new Random(seed);
        DynamicMatrix<Integer> matrix = new DynamicMatrix<>(aHight, aWeight, random, aBound, Integer.class);
//        DynamicMatrix<Double> matrix = new DynamicMatrix<>(aHight, aWeight, random, aBound, Double.class);
        System.out.println("Matrix");
        matrix.print();
        matrix.bubbleRowSort();
        System.out.println("Sorted matrix");
        matrix.print();
        System.out.println("Max = " + matrix.getMaximum());
        System.out.println("Min = " + matrix.getMinimum());
    }

    public static void processDynamicArray(Integer aCount, int aBound) {
        Long seed = System.currentTimeMillis();
        Random random = new Random(seed);
        DynamicArray<Integer> array = new DynamicArray<>(aCount, random, aBound, Integer.class);
        System.out.println("Array");
        array.print();
        array.bubbleSort();
        System.out.println("Sorted array");
        array.print();
    }
}

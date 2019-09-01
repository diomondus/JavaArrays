package com.butilov.test;

import org.jblas.DoubleMatrix;

public class JBlas {

    public static void main(String[] args) {
        processJBLASMatrix();
    }

    public static void processJBLASMatrix() {
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
        System.out.println("mul end: " + ((System.currentTimeMillis() - time) / 1000.0) + "c");
        DoubleMatrix d = b.add(c);
//        d.print();
    }
}

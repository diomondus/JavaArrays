package com.butilov.test.matrix;

import java.util.Arrays;

public class MatrixMul {


    public static void main(String[] args) {

        Arrays.asList(1, 2, 3)
              .stream()
              .peek(i -> System.out.println(i));
    }

    // ~9.4 сек
    private static void gemm_v0(int M, int N, int K, float[] A, float[] B, float[] C) {
        for (int i = 0; i < M; ++i) {
            for (int j = 0; j < N; ++j) {
                for (int k = 0; k < K; ++k) {
                    C[i * N + j] += A[i * K + k] * B[k * N + j];
                }
            }
        }

    }

    // ~1,2 сек
    private static void gemm_v1(int M, int N, int K, float[] A, float[] B, float[] C) {
        for (int i = 0; i < M; ++i) {
            int cI = i * N;
            for (int k = 0; k < K; ++k) {
                int aI = i * K + k;
                int bI = k * N;
                for (int j = 0; j < N; ++j) {
                    C[cI + j] += A[aI] * B[bI + j];
                }
            }
        }
    }
}
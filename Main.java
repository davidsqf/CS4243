package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner sc = new Scanner(System.in);
        int k_bits = sc.nextInt();
        int matrix_size = sc.nextInt();
        int[][] intensity_matrix = intensity_simulator(k_bits, matrix_size);
        print_matrix(intensity_matrix);
    }

    private static void print_matrix(int[][] intensity_matrix) {
        int size = intensity_matrix.length;
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                System.out.print(String.format("%1$4s", intensity_matrix[r][c]));
            }
            System.out.println();
        }
    }

    private static int[][] intensity_simulator(int k_bits, int matrix_size) { // for Q1
        int[][] intensity_matrix = new int[matrix_size][matrix_size];

        int intensity_levels = (int) Math.pow(2, k_bits);
        double intensity_stair = 256.0 / intensity_levels;
        int matrix_centre = matrix_size / 2;

        for (int x = 0; x < matrix_size; x++) {
            for (int y = 0; y < matrix_size; y++) {
                float original_intensity = (float) (255.0 * Math.pow(Math.E,
                        -1 * (Math.pow((x - matrix_centre), 2) + Math.pow((y - matrix_centre), 2))));
                int printed_intensity = (int) ((int) ((original_intensity / intensity_stair)) * intensity_stair);
                intensity_matrix[x][y] = printed_intensity;
            }
        }

        return intensity_matrix;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mang;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author trinh
 */
public class MaTranXoanOcTangDan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n*n], b[][] = new int[n][n];
        int x = 0;
        for(int i = 0; i < n*n; i++) a[i] = sc.nextInt();
        Arrays.sort(a);
        for(int i = 0; i < n-i; i++){
            for(int j = i; j < n-i; j++)
                b[i][j] = a[x++];
            for(int j = i+1; j < n-i; j++)
                b[j][n-i-1] = a[x++];
            for(int j = n-i-2; j >= i; j--)
                b[n-i-1][j] = a[x++];
            for(int j = n-i-2; j > i; j--)
                b[j][i] = a[x++];
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++)
                System.out.print(b[i][j] + " ");
            System.out.println();
        }
    }
}

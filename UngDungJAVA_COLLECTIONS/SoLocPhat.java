package UngDungJAVA_COLLECTIONS;

import java.util.*;

public class SoLocPhat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            long Queue[] = new long[100001];
            long sum = 0;
            for(int i = 0; i < n; i++)
                sum = sum * 10 + 1;
            Queue[0] = 6;
            Queue[1] = 8;
            int input = 1, output = -1;
            int dem = 2;
            while(1 > 0){
                if(Queue[input] / 8 == sum) break;
                long x = Queue[++output];
                Queue[++input] = x * 10 + 6;
                Queue[++input] = x * 10 + 8;
                dem += 2;
            }
            System.out.println(dem);
            for(int i = dem-1; i >= 0; i--)
                System.out.print(Queue[i] + " ");
            System.out.println();
        }
    }
}
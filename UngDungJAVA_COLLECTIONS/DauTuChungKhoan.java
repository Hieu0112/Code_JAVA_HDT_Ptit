package UngDungJAVA_COLLECTIONS;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

class KH{
    
}
public class DauTuChungKhoan{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int a[] = new int[n];
            for(int i = 0; i < n; i++) a[i] = sc.nextInt();
            ArrayDeque<Integer> s = new ArrayDeque<>();
            s.push(0);
            int D[] = new int[n];
            Arrays.fill(D, 1);
            for(int i = 1; i < n; i++){
                while(a[i] >= a[s.peek()]){
                    s.pop();
                    if(s.isEmpty()) break;
                }
                if(s.isEmpty()) D[i] += i;
                else D[i] = i - s.peek();
                s.push(i);
            }
            for(int i = 0; i < n; i++)
                System.out.print(D[i] + " ");
            System.out.println();
        }
    }
}
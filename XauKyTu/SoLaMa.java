package XauKyTu;

import java.util.Scanner;

public class SoLaMa{
    static int so(char a){
        if(a == 'I') return 1;
        if(a == 'V') return 5;
        if(a == 'X') return 10;
        if(a == 'L') return 50;
        if(a == 'C') return 100;
        if(a == 'D') return 500;
        return 1000;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            String s = sc.next();
            int sum = 0;
            char a[] = s.toCharArray();
            for(int i = a.length-1; i >= 0; i--){
                sum += so(a[i]);
                if(i != a.length-1){
                    if(a[i] == 'I'){
                        if(a[i+1] == 'V' || a[i+1] == 'X')
                            sum -= 2;
                    }
                    else if(a[i] == 'X'){
                        if(a[i+1] == 'L' || a[i+1] == 'C')
                            sum -= 20;
                    }
                    else if(a[i] == 'C'){
                        if(a[i+1] == 'D' || a[i+1] == 'M')
                            sum -= 200;
                    }
                }
            }
            System.out.println(sum);
        }
    }
}
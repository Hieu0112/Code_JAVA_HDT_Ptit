import java.io.IOException;
import java.util.*;
import java.io.File;

class Pair<K, V>{
    Integer k;
    Integer v;
    public Pair(int key, int value){
        this.k = key;
        this.v = value;
    }
    @Override
    public String toString(){
        return k + " " + v;
    }
    public int ktra(int n){
        if(n < 2) return 0;
        for(int i = 2; i <= Math.sqrt(n); i++)
            if(n % i == 0) return 0;
        return 1;
    }
    public boolean isPrime(){
        if(ktra(k) == 1 && ktra(v) == 1) return true;
        return false;
    }
}
public class pair {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("DATA.in"));
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            boolean check = false;
            for(int i = 2; i <= 2*Math.sqrt(n); i++){
                Pair<Integer, Integer> p = new Pair<>(i, n-i);
                if(p.isPrime()){
                    System.out.println(p);
                    check = true;
                    break; 
                }
            }
            if(!check) System.out.println(-1);
        }
    }
}

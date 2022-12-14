package UngDungJAVA_COLLECTIONS;

import java.util.*;

public class LietKeVaDem {
    static boolean ktra(int n){
        int a = n % 10;
        while(n > 10){
            n /= 10;
            int b = n % 10;
            if(a < b) return false;
            a = b;
        }
        return true;
    }
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> a = new ArrayList<>();
        HashMap<Integer, Integer> m = new HashMap<>();
        while(sc.hasNext()){
            int n = sc.nextInt();
            if(ktra(n)){
                if(m.containsKey(n)) m.put(n, m.get(n)+1);
                else{
                    m.put(n,1);
                    a.add(n);
                }
            }
        }
        Collections.sort(a, (Integer a1, Integer b) -> m.get(b) - m.get(a1));
        for(Integer x : a)
            System.out.println(x + " " + m.get(x));
    }
}
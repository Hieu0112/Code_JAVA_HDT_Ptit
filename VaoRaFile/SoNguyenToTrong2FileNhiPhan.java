package VaoRaFile;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.*;

public class SoNguyenToTrong2FileNhiPhan{
    static int ktra(int n){
        if(n < 2) return 0;
        for(int i = 2; i <= Math.sqrt(n); i++)
            if(n % i == 0) return 0;
        return 1;
    }
    public static void main(String[] args) throws Exception{
        ObjectInputStream os = new ObjectInputStream(new FileInputStream("DATA1.in"));
        ObjectInputStream is = new ObjectInputStream(new FileInputStream("DATA2.in"));
        ArrayList<Integer> a =(ArrayList<Integer>)os.readObject();
        ArrayList<Integer> b =(ArrayList<Integer>)is.readObject();
        TreeMap<Integer, Integer> m = new TreeMap<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(Integer x : a)
            if(ktra(x) == 1){
                if(m.containsKey(x)) m.put(x, m.get(x) + 1);
                else m.put(x, 1);
            }
        for(Integer x : b)
            if(ktra(x) == 1){
                if(map.containsKey(x)) map.put(x, map.get(x) + 1);
                else map.put(x, 1);
            }
        for(Integer x : m.keySet())
            if(map.containsKey(x)){
                System.out.println(x + " " + m.get(x) + " " + map.get(x));
            }
        
    }
}
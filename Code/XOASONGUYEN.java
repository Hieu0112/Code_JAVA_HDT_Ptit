package Code;

import java.io.File;
import java.io.IOException;
import java.util.*;


public class XOASONGUYEN {
    static int ktra(String s){
        for(int i = 0; i < s.length(); i++)
            if(s.charAt(i) < '0' || s.charAt(i) > '9')
                return 1;
        if(s.length() < 10) return 0;
        return 1;
    }
    public static void main(String[] args) {
        try{
            Scanner sc = new Scanner(new File("DATA.in"));
            ArrayList<String> a = new ArrayList<>();
            while(sc.hasNext()){
                String x = sc.next();
                if(ktra(x) == 1) a.add(x);
            }
            Collections.sort(a);
            for(String x : a)
                System.out.print(x + " ");
        }
        catch (Exception e){
        }
    }
}

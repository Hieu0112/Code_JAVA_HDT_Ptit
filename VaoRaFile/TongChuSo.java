package VaoRaFile;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.*;

public class TongChuSo{
    public static void main(String[] args) throws Exception{
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("DATA.in"));
        ArrayList<String> a = (ArrayList<String>) ois.readObject();
        ArrayList<String> b = new ArrayList<>();
        Map<String, Long> m = new HashMap<>();
        for(String s : a){
            String str = "";
            long n = 0, ok = 0;
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) == '0' && ok != 0)
                    str += s.charAt(i);
                else if(s.charAt(i) > '0' && s.charAt(i) <= '9'){
                    ok=1;
                    str += s.charAt(i);
                    n += s.charAt(i) - '0';
                }
            }
            if(!str.isEmpty()){
                m.put(str, n); 
                b.add(str);
            } 
        }
        for(String s : b)
            System.out.println(s + " " + m.get(s));
    }
}
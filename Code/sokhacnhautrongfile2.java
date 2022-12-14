package Code;

import java.util.*;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;


public class sokhacnhautrongfile2 {
    public static void main(String[] args) throws Exception{
        DataInputStream is = new DataInputStream(new FileInputStream("DATA.IN"));
        TreeMap<Integer, Integer> m = new TreeMap<>();
        for(int i = 0; i < 100000; i++){
            int k = is.readInt();
            if(m.containsKey(k))
                m.put(k,m.get(k) + 1);
            else m.put(k, 1);
        }
        for(Integer i : m.keySet())
            System.out.println(i + " " + m.get(i));
        is.close();
    }
}
package VaoRaFile;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.*;
public class ThongKeTuKhacNhauTrongFileNhiPhan{
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException{
        ObjectInputStream ois=new ObjectInputStream(new FileInputStream("DATA.in"));
        Map<String, Integer> m = new TreeMap<>();
        ArrayList<String> a =  (ArrayList<String>) ois.readObject();
        ArrayList<String> b = new ArrayList<>();
        for(String s : a){
            s = s.trim().replaceAll("\\s+ ", " ").toLowerCase();
            String tmp = "";
            for(int i = 0; i < s.length(); i++){
                if((s.charAt(i) < 'a' || s.charAt(i) > 'z') && (s.charAt(i) < '0' || s.charAt(i) > '9'))
                    tmp += ' ';
                else tmp += s.charAt(i);
            }
            tmp = tmp.trim().replaceAll("\\s+ ", " ");
            String c[] = tmp.split(" ");
            for(String x : c){
                if(m.containsKey(x))
                    m.put(x, m.get(x) + 1);
                else{
                    m.put(x, 1);
                    b.add(x);
                }
            }
        }
        Collections.sort(b, (String o1, String o2) -> {
            if(m.get(o1) != m.get(o2)) return m.get(o2) - m.get(o1);
            return o1.compareTo(o2);
        });
        for(String x : b)
            System.out.println(x + " " + m.get(x));
    }
}

import java.io.File;
import java.io.IOException;
import java.util.*;

class WordSet{
    private TreeSet<String> s1 = new TreeSet<>();
    public WordSet(String s){
        try{
            Scanner sc = new Scanner(new File(s));
            while(sc.hasNext())
                s1.add(sc.next().toLowerCase());
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public TreeSet<String> getS1() {
        return s1;
    }
    
    public String union(WordSet s2){
        TreeSet<String> s = new TreeSet<>();
        s.addAll(s1);
        s.addAll(s2.getS1());
        String x = "";
        for(String a : s)
            x += a + " ";
        return x;
    }
    public String intersection(WordSet s2){
        s1.retainAll(s2.getS1());
        String x = "";
        for(String a : s1)
            x += a + " ";
        return x;
    }
}
public class HopVaGiaoCua2FileVanBan {
    public static void main(String[] args) throws IOException {
        WordSet s1 = new WordSet("DATA1.in");
        WordSet s2 = new WordSet("DATA2.in");
        System.out.println(s1.union(s2));
        System.out.println(s1.intersection(s2));
    }
}


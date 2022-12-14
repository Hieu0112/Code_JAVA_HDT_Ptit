package XauKyTu;
import java.util.*;
public class XauConLonNhat{
    static int getIterator(ArrayList<Character> a, char c){
        for(int i = 0; i < a.size(); i++)
            if(a.get(i) == c)
                return i;
        return 0;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        ArrayList<Character> a = new ArrayList<>();
        int D[] = new int [200];
        Map<Character, Integer> m = new TreeMap<>();
        for(int i = 0; i < s.length(); i++){
            if(m.containsKey(s.charAt(i)))
                m.put(s.charAt(i), m.get(s.charAt(i)) + 1);
            else{
                m.put(s.charAt(i), 1);
                a.add(s.charAt(i));
            }
        }
        Collections.sort(a);
        for(int i = 0; i < s.length(); i++){
            D[s.charAt(i)]++;
            if(s.charAt(i) == a.get(a.size()-1)){
                System.out.print(s.charAt(i));
            }
            if(D[s.charAt(i)] == m.get(s.charAt(i)))
                    a.remove(getIterator(a, s.charAt(i)));
        }
    }
}
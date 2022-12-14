package Code;

import java.util.*;

class Pair<K,V>{
    K key;
    V value;
    Pair(K key, V value){
        this.key = key;
        this.value = value;
    }
}
public class code{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            String s = sc.next();
            ArrayList<Pair<Character, Integer>> a = new ArrayList<>();
            int m = 0;
            a.add(new Pair('@', -1));
            for(int i = 0; i < s.length(); i++){
                a.add(new Pair(s.charAt(i), i));
                while(a.size() >= 3 && a.get(a.size()-3).key == '1' && a.get(a.size()-2).key == '0' && a.get(a.size()-1).key == '0'){
                    a.remove(a.size()-1);
                    a.remove(a.size()-1);
                    a.remove(a.size()-1);
                }
                m = Math.max(m, i - a.get(a.size()-1).value);
            }
            System.out.println(m);
        }
    }
}
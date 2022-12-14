package XauKyTu;

import java.util.*;

class Pair<K,V> {
    String k;
    Integer v;

    public Pair(String k, Integer v) {
        this.k = k;
        this.v = v;
    }
    
}
public class XoayVongKyTu{
    static String quay_phai(String s){
        char a[] = s.toCharArray();
        String tmp = "";
        for(int i = 1; i < a.length; i++) tmp += a[i];
        tmp += a[0];
        return tmp;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<String> a = new ArrayList<>();
        for(int i= 0; i < n; i++)
            a.add(sc.next());
        ArrayList<Pair<String, Integer>> b = new ArrayList<>();
        for(String s : a){
            int x = 1;
            b.add(new Pair<>(s, 0));
            for(int i = 0; i < s.length()-1; i++)
                if(!b.get(b.size()-1).k.equals(quay_phai(b.get(b.size()-1).k))) b.add(new Pair<>(quay_phai(b.get(b.size()-1).k), x++));
        }
        int minn = 1000000, ok = 1, m = b.size()/n;
        for(int i = 0; i < m; i++){
            int dem = b.get(i).v, count = 1;
            for(int j = m; j < b.size(); j++)    
                if(b.get(i).k.equals(b.get(j).k)){
                    dem += b.get(j).v; 
                    count++;
                }     
            minn = Math.min(minn, dem);
            if(count != n){
                ok = 0; break;
            }
        }
        if(ok == 1) System.out.println(minn);
        else System.out.println("-1");
    }
}
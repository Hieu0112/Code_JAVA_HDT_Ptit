package VaoRaFile;

import java.io.File;
import java.util.*;

class TS{
    private String ma, ten, rank;
    private long tuoi, tong;
    public String chuanHoa(String s){
        String x = "";
        s = s.trim().toLowerCase().replaceAll("\\s+", " ");
        String a[] = s.split(" ");
        for(String w : a){
            x += w.substring(0,1).toUpperCase() + w.substring(1);
            x += " ";
        }
        return x;
    }
    public TS(int i, String ten, String ns, double a, double b){
        if(i < 10) this.ma = "PH0" + i;
        else this.ma = "PH" + i; 
        this.ten = chuanHoa(ten);
        if(ns.charAt(2) != '/') ns = ' ' + ns;
        if(ns.charAt(5) != '/') ns = ns.substring(0, 3) + '0' + ns.substring(3);
        char s[] = ns.toCharArray();
        this.tuoi = 2021 - ((s[6]-'0') * 1000 + (s[7]-'0') * 100 + (s[8]-'0') * 10 + (s[9]-'0'));
        double x = 0;
        if(a >= 8 && b >= 8) x = 1;
        else if(a >= 7.5 && b >= 7.5) x = 0.5;
        this.tong = Math.round((a+b) / 2 + x);
        if(tong > 10) tong = 10;
        if(tong == 9 || tong == 10) rank = "Xuat sac";
        else if(tong == 8) rank = "Gioi";
        else if(tong == 7) rank = "Kha";
        else if(tong == 5 || tong == 6) rank = "Trung binh";
        else rank = "Truot";
    }
    public String out(){
        return ma + " " + ten + " " + tuoi + " " + tong + " " + rank;
    }
}
public class XetTuyen {
    public static void main(String[] args) {
        try{
            File a = new File("XETTUYEN.in");
            Scanner sc = new Scanner(a);
            int t = Integer.parseInt(sc.nextLine());
            ArrayList<TS> A = new ArrayList<>();
            int i = 1;
            while(t-- > 0){
                A.add(new TS(i, sc.nextLine(), sc.nextLine(), Double.parseDouble(sc.nextLine()), Double.parseDouble(sc.nextLine())));
                i++;
            }
            for(TS x : A)
                System.out.println(x.out());
        }
        catch (Exception e) {
            System.out.println("Loi");
            e.printStackTrace();
        }
    }
}

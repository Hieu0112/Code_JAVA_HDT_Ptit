package Code;

import java.io.File;
import java.util.*;


class SV{
    private String ma, ten, loai;
    private double tong;
    public SV(int i,String ten, int a, int b, int c){
        if(i < 10) this.ma = "SV0" + (char)(i + '0');
        else this.ma = "SV" + Integer.toString(i);
        this.ten = ChuanHoa(ten);
        this.tong = (double) a * 0.25 + b * 0.35 + c * 0.4;
        if(tong < 5) this.loai = "KEM";
        else if(tong < 6.5) this.loai = "TRUNG BINH";
        else if(tong < 8) this.loai = "KHA";
        else this.loai = "GIOI";
    }
    public String ChuanHoa(String s){
        s = s.trim().replaceAll("\\s++", " ");
        String a[] = s.split(" ");
        String tmp = "";
        for(String w : a){
            tmp = tmp + w.substring(0, 1).toUpperCase() + w.substring(1, w.length()).toLowerCase();
            tmp = tmp + ' ';
        }
        return tmp;
    }
    public double gettong(){
        return tong;
    }
    public String out(){
        return ma + " " + ten + String.format("%.2f ", tong) + loai; 
    }
}
public class s {
    public static void main(String[] args) {
        try{
            Scanner sc = new Scanner(new File("BANGDIEM.in"));
            int t = sc.nextInt();
            ArrayList<SV> a = new ArrayList<>();
            for(int i = 1; i <= t; i++){
                sc.nextLine();
                a.add(new SV(i, sc.nextLine(), sc.nextInt(), sc.nextInt(), sc.nextInt()));
            }
            Collections.sort(a, Comparator.comparingDouble(SV::gettong).reversed());
            for(SV x : a)
                System.out.println(x.out());
        }
        catch (Exception e){
        }
    }
}
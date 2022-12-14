package Code;


import java.io.*;
import java.util.*;

class SV{
    public String maSV, tenSV, lop;
    public String ChuanHoa(String s){
        s = s.toLowerCase().trim().replaceAll("\\s+", " ");
        String a[] = s.split(" ");
        String tmp = "";
        for(String x : a){
            tmp += x.substring(0,1).toUpperCase() + x.substring(1) + " ";
        }
        return tmp.trim();
    }
    public SV(String ma, String ten, String lop, String em){
        this.maSV = ma;
        this.tenSV = ChuanHoa(ten);
        this.lop = lop;
    }
    @Override
    public String toString(){
        return maSV + " " + tenSV + " " + lop;
    }
}
class DN{
    public String maDN, tenDN;
    public int soSV;
    public DN(String ma, String ten, int so){
        this.maDN = ma;
        this.tenDN = ten;
        this.soSV = so;
    }
}
class ThucTap{
    public String maSV, maDN;
    public ThucTap(String ma, String x){
        this.maSV = ma;
        this.maDN = x;
    }
}
public class dstt3 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(new File("SINHVIEN.in"));
        Scanner sc1 = new Scanner(new File("DN.in"));
        Scanner sc2 = new Scanner(new File("THUCTAP.in"));
        ArrayList<SV> a = new ArrayList<>();
        ArrayList<DN> b = new ArrayList<>();
        ArrayList<ThucTap> c = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) 
            a.add(new SV(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine()));
        Collections.sort(a, (SV o1, SV o2) -> o1.maSV.compareTo(o2.maSV));
        n = Integer.parseInt(sc1.nextLine());
        for (int i = 0; i < n; i++) 
            b.add(new DN(sc1.nextLine(), sc1.nextLine(), Integer.parseInt(sc1.nextLine())));
        n = sc2.nextInt();
        for (int i = 0; i < n; i++) 
            c.add(new ThucTap(sc2.next(), sc2.next()));
        Collections.sort(c, (ThucTap o1, ThucTap o2) -> o1.maSV.compareTo(o2.maSV));
        n = sc2.nextInt();
        while(n--> 0){
            String str = sc2.next(), s = "";
            int dem = 0, k = 0;
            for(DN x : b)
                if(str.equals(x.maDN)){
                    s = x.tenDN;
                    k = x.soSV;
                    break;
                }
            System.out.println("DANH SACH THUC TAP TAI " + s + ":");
            for(ThucTap x : c)
                if(x.maDN.equals(str))
                    for(SV y : a){
                        if(x.maSV.equals(y.maSV) && dem < k){
                            System.out.println(y);
                            dem++;
                            break;
                        }
                    }
        }
    }
}
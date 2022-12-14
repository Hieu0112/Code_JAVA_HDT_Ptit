package QuanHeGiua2Lop;



import java.util.*;

class SV{
    private String ma, ten, sdt;
    private int nhom;
    public SV(String ma, String ten, String sdt, int nhom){
        this.ma = ma;
        this.ten = ten;
        this.sdt = sdt;
        this.nhom = nhom;
    }
    public int getnhom(){
        return nhom;
    }
    @Override
    public String toString(){
        return ma + " " + ten + " " + sdt;
    }
}
public class QuanLyBaiTapNhom1 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        sc.nextLine();
        ArrayList<SV> a = new ArrayList<>();
        ArrayList<String> b = new ArrayList<>();
        while(n-- > 0)
            a.add(new SV(sc.nextLine(), sc.nextLine(), sc.nextLine(), Integer.parseInt(sc.nextLine())));
        while(m-- > 0)
            b.add(sc.nextLine());
        int q = sc.nextInt();
        while(q-->0){
            int t = sc.nextInt();
            System.out.println("DANH SACH NHOM " + t + ":");
            for(SV x : a)
                if(x.getnhom() == t){
                    System.out.println(x);
                }
            System.out.println("Bai tap dang ky: " + b.get(t-1));
        }
    }
}
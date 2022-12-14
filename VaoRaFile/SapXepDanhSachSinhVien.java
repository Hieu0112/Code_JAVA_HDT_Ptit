package VaoRaFile;

import java.io.File;
import java.util.*;

class SV{
    private String ma, ten, lop, em;
    SV(String ma, String ten, String lop, String em){
        this.ma = ma;
        this.ten = ten;
        this.lop = lop;
        this.em = em;
    }
    public String getma(){
        return ma;
    }
    public String getten(){
        return ten;
    }
    @Override
    public String toString(){
        return ma + " " + ten + " " + lop + " " + em;
    }
}
public class SapXepDanhSachSinhVien{
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(new File("SINHVIEN.in"));
        int t = Integer.parseInt(sc.nextLine());
        ArrayList<SV> a = new ArrayList<>();
        while(t-- > 0)
            a.add(new SV(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine()));
        Collections.sort(a, new Comparator<SV>() {
            @Override
            public int compare(SV a, SV b){
                    String s1[] = a.getten().split("\\s+");
                    String s2[] = b.getten().split("\\s+");
                    if(!s1[s1.length-1].equals(s2[s2.length-1])) 
                        return s1[s1.length-1].compareTo(s2[s2.length-1]);
                    if(!s1[0].equals(s2[0])) 
                        return s1[0].compareTo(s2[0]);
                    if(!s1[1].equals(s2[1])) 
                        return s1[1].compareTo(s2[1]);
                    if(!s1[2].equals(s2[2])) 
                        return s1[2].compareTo(s2[2]);
                    return 
                            a.getma().compareTo(b.getma());
                }
        });
        for(SV x: a)
            System.out.println(x);
    }
}
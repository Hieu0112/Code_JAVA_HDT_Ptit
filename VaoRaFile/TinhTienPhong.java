package VaoRaFile;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;
class KhachHang{
    private String ten,ma,phong;
    private Date nhan, tra;
    private long ps;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    public String ChuanHoa(String s){
        s = s.trim().replaceAll("\\s+ ", " ").toLowerCase();
        String a[] = s.split(" ");
        String tmp = "";
        for(String x : a)
            tmp += x.substring(0,1).toUpperCase() + x.substring(1) + ' ';
        return tmp;
    }
    public KhachHang(int i,String ten,String phong,String nhan,String tra,long ps) throws Exception{
        this.ma = "KH"+String.format("%02d", i);
        this.ten = ChuanHoa(ten);
        this.nhan = sdf.parse(nhan);
        this.tra = sdf.parse(tra);
        this.ps = ps;
        this.phong = phong.trim();
    }
    public long getPeriod(){
        long diff = tra.getTime()-nhan.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS)+1;
    }
    public long getTang(){
        if(phong.charAt(0) == '1') {
            return 25;
        }
        else if(phong.charAt(0) == '2'){
            return 34;
        }
        else if(phong.charAt(0) == '3'){
            return 50;
        }
        else return 80;  
    }
    public long getTien(){
        return getPeriod()*getTang()+ps;
    }
    @Override
    public String toString(){
        return ma + " " + ten + phong + " " + getPeriod() + " " + getTien();
    }
}
public class TinhTienPhong {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(new File("KHACHHANG.in"));
        int t = Integer.parseInt(sc.nextLine());
        ArrayList<KhachHang> ls = new ArrayList<>();
        for(int i = 1; i <= t; i++){
            String ten = sc.nextLine();
            String phong = sc.nextLine();
            String d1 = sc.nextLine();
            String d2 = sc.nextLine();
            long gia = Long.parseLong(sc.nextLine());
            ls.add(new KhachHang(i,ten,phong,d1.trim(),d2.trim(),gia));
        }
        Collections.sort(ls,Comparator.comparingLong(KhachHang::getTien).reversed());
        for(KhachHang x:ls) System.out.println(x);
    }
}
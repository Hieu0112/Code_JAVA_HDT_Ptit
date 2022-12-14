package VaoRaFile;

import java.io.File;
import java.util.*;

class SV{
    private String ma, date, time, room;
    public int ngay, month, year, h, phut;
    public SV(int i, String date, String time, String room){
        if(i < 10) this.ma = "C00" + i;
        else if( i < 100) this.ma = "C0" + i;
        else this.ma = "C" + i;
        this.date = date;
        this.time = time;
        this.ngay = Integer.parseInt(date.substring(0,2));
        this.month = Integer.parseInt(date.substring(3, 5));
        this.year = Integer.parseInt(date.substring(6));
        this.h = Integer.parseInt(time.substring(0,2));
        this.phut = Integer.parseInt(time.substring(3));
        this.room = room;
    }
    public String out(){
        return ma + " " + date + " " + time + " " + room;
    }
}
public class DanhSachCaThiString {
    public static void main(String[] args) {
        try{
            Scanner sc = new Scanner(new File("CATHI.in"));
            int t = Integer.parseInt(sc.nextLine());
            ArrayList<SV> a = new ArrayList<>();
            for(int i = 1; i <= t; i++)
                a.add(new SV(i, sc.nextLine(), sc.nextLine(), sc.nextLine()));
            Collections.sort(a, new Comparator<SV>() {
                @Override
                public int compare(SV a, SV b){
                    if(a.year != b.year) return a.year - b.year;
                    if(a.month != b.month) return a.month - b.month;
                    if(a.ngay != b.ngay) return a.ngay - b.ngay;
                    if(a.h != b.h) return a.h - b.h;
                    return a.phut - b.phut;
                }
            });
            for(SV x : a)
                System.out.println(x.out());
        }
        catch (Exception e) {
        }
    }
}
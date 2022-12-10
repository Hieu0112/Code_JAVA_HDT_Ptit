//package VaoRaFile;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.util.*;
//
//class SV
//{
//    private String ma, ten, res, loai;
//    private double a,b,c, x, tong;
//    public String chuanHoa(String s){
//        String x = "";
//        s = s.trim().toLowerCase().replaceAll("\\s+", " ");
//        String a[] = s.split(" ");
//        for(String w : a){
//            // String tmp = w;
//            x += w.substring(0,1).toUpperCase() + w.substring(1);
//            x += " ";
//        }
//        return x;
//    }
//    public SV(String ma, String ten, double a, double b, double c){
//        this.ma = ma;
//        this.ten = chuanHoa(ten);
//        this.a = a;
//        this.b = b;
//        this.c = c;
//        this.x = 0.5;
//        if(ma.charAt(2) == '2') this.x = 1.0;
//        else if(ma.charAt(2) == '3') this.x = 2.5;
//        this.tong = a*2 + b + c + x;
//    }
//    public Double gettong(){
//        return tong;
//    }
//    public void out(Double a){
//        System.out.print(ma + " " + ten);
//        if(x ==(int) x) 
//            System.out.print((int) x + " ");
//        else 
//            System.out.print(x + " ");
//        if(tong == (int) tong)    
//            System.out.print((int) tong);
//        else 
//            System.out.print(tong);
//        System.out.print(" ");
//        if(tong >= a) 
//            System.out.println("TRUNG TUYEN");
//        else 
//            System.out.println("TRUOT");
//    }
//}
//public class DanhSachTrungTuyen {
//    public static void main(String[] args) throws FileNotFoundException {
//            Scanner sc = new Scanner(new File("THISINH.in"));
//            int t = Integer.parseInt(sc.nextLine());
//            ArrayList<SV> A = new ArrayList<>();
//            int i = 1;
//            while(t-->0){
//                A.add(new SV(sc.nextLine(), sc.nextLine(), Double.parseDouble(sc.nextLine()), Double.parseDouble(sc.nextLine()), Double.parseDouble(sc.nextLine())));
//                i++;
//            }
//            Collections.sort(A, Comparator.comparingDouble(SV:: gettong).reversed());
//            int q = Integer.parseInt(sc.nextLine());
//            double x = A.get(q-1).gettong();
//            System.out.printf("%.1f\n", x);
//            for(SV s : A)
//                s.out(x);
//           
//    }
//}

package DoAnOOPJava;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public abstract class NhanVien {
    protected String manv;
    protected String hoten;
    protected String ngaysinh;
    protected int luong;
    Locale localeVn = new Locale("vi","VN");
    NumberFormat countrycurrency = NumberFormat.getCurrencyInstance(localeVn);

    Scanner sc = new Scanner(System.in);
    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public int getLuong() {
        return luong;
    }

    public void setLuong(int luong) {
        this.luong = luong;
    }

    public String ChuanHoaTen(String ten)
    {   ten=ten.trim().replaceAll("\\s+"," ");

        char[] charten = ten.toCharArray();
        boolean foundSpace = true;
        int n= charten.length;
        for(int i=0;i<n;i++)
        {
            if(Character.isLetter(charten[i]))
            {
                if(foundSpace)
                {
                    charten[i]=Character.toUpperCase(charten[i]);
                    foundSpace=false;
                }
            }
            else
            {
                foundSpace=true;
            }
        }
        return String.valueOf(charten);
    }
    public void nhap()
    {
        System.out.print("Nhập họ tên nhân viên: ");
        hoten=ChuanHoaTen(sc.nextLine());
        System.out.print("Nhập ngày tháng năm sinh(Day/Month/Year): ");
        ngaysinh = sc.nextLine();
        System.out.print("Nhập mức lương: ");
        luong = sc.nextInt();

    }
    public void xuat()
    {
//        System.out.println(manv+"\t\t"+hoten+"\t"+ngaysinh+"\t\t\t"+countrycurrency.format(luong)+"\t\t"+"Nhân viên bán hàng");
        System.out.printf("%-20s %-20s %-20s %-20s %-20s",manv,hoten,ngaysinh,countrycurrency.format(luong),"Nhân viên bán hàng");
        System.out.println();
    }
}

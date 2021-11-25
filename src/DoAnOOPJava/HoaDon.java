package DoAnOOPJava;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class HoaDon {

  //loại hóa đơn true là nhập false là xuất
  private boolean loaihoadon = true;
  private String mahoadon;
  private static int masohoadon = 1;
  List<ChiTietHoaDon> dschitiethoadon = new ArrayList<>();
  Calendar cal = Calendar.getInstance();
  private Date date = cal.getTime();
  Scanner sc = new Scanner(System.in);

  public String ChuanHoaTen(String ten) {
    ten = ten.trim().replaceAll("\\s+", " ");
    char[] charten = ten.toCharArray();
    boolean foundSpace = true;
    int n = charten.length;
    for (int i = 0; i < n; i++) {
      if (Character.isLetter(charten[i])) {
        if (foundSpace) {
          charten[i] = Character.toUpperCase(charten[i]);
          foundSpace = false;
        }
      } else {
        foundSpace = true;
      }
    }
    return String.valueOf(charten);
  }

  //dùng để nhập các mặt hàng của siêu thị
  public HoaDon() {
    setMahoadon("HD0" + masohoadon++);
  }

  public String getMahoadon() {
    return mahoadon;
  }

  public void setMahoadon(String mahoadon) {
    this.mahoadon = mahoadon;
  }

  public static int getMasohoadon() {
    return masohoadon;
  }

  public static void setMasohoadon(int masohoadon) {
    HoaDon.masohoadon = masohoadon;
  }

  public Calendar getCal() {
    return cal;
  }

  public void setCal(Calendar cal) {
    this.cal = cal;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }


  public void LapHoaDonNhap(MenuHoaDon dshd) {
    //loại hóa đơn bằng true
    //chi tiết hóa đơn
    loaihoadon = true;
    ChiTietHoaDon cthd = new ChiTietHoaDon();
    cthd.NhapChiTietHoaDon(this, dshd);
  }

  public void LapHoaDonXuat(MenuHoaDon dshd) {
    loaihoadon = false;
    ChiTietHoaDon cthd = new ChiTietHoaDon();
    cthd.NhapChiTietHoaDon(this, dshd);
  }

  public void Xuat1HoaDon(NhanVienBanHang nvbh) {
    System.out.println("Nhân viên lập hóa đơn: " + nvbh.getHoten());
    String loai;
    if (loaihoadon == true) {
      loai = "Nhập";
    } else {
      loai = "Xuất";
    }
    System.out.println("Loại hóa đơn: " + loai);
    System.out.println("Thời gian lập hóa đơn: " + getDate());
    System.out.printf("%-20s %-20s %-20s\n", "Mã sẩn phẩm", "Tên sẩn phẩm", "Số lượng");
    for (var i : dschitiethoadon) {
//            System.out.printf("%-20s %-20S %-20s\n",i.getMasanpham(),i.getTensanpham(),i.getSoluong());
//      System.out.printf("%-20s %-20S %-20s\n", i.getMasanpham(), i.getTensanpham(), i.getSoluong());
      i.XuatChiTietHoaDon();
    }
  }


}

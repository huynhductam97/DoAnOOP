package DoAnOOPJava;

import java.util.Scanner;

public class ChiTietHoaDon {

  private String masanpham;
  private String tensanpham;
  private int soluong;
  Scanner sc = new Scanner(System.in);

  public String getMasanpham() {
    return masanpham;
  }

  public void setMasanpham(String masanpham) {
    this.masanpham = masanpham;
  }

  public String getTensanpham() {
    return tensanpham;
  }

  public void setTensanpham(String tensanpham) {
    this.tensanpham = tensanpham;
  }

  public int getSoluong() {
    return soluong;
  }

  public void setSoluong(int soluong) {
    this.soluong = soluong;
  }

  public String ChuanHoaMaSanPham(String a) {
    return a.toUpperCase();
  }

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
  //dùng để nhập

  public void NhapChiTietHoaDon(HoaDon hd, MenuHoaDon dshd) {
    System.out.print("Số lượng sản phẩm muốn nhập: ");
    int n = sc.nextInt();
    ChiTietHoaDon p = null;
    for (int i = 0; i < n; i++) {
      sc.nextLine();
      p = new ChiTietHoaDon();
      System.out.print("Nhập mã sản phẩm: ");
      p.setMasanpham(ChuanHoaMaSanPham(sc.nextLine()));
      System.out.print("Nhập tên sản phẩm: ");
      p.setTensanpham(ChuanHoaTen(sc.nextLine()));
      System.out.print("Nhập số lượng sản phẩm: ");
      p.setSoluong(sc.nextInt());
      hd.dschitiethoadon.add(p);
    }
    dshd.getDanhsachhoadon().add(hd);
  }

  // để cho thằng HoaDon xuất cho gọn
  public void XuatChiTietHoaDon() {
    System.out.printf("%-20s %-20S %-20s\n", this.getMasanpham(), this.getTensanpham(),
        this.getSoluong());
  }


}

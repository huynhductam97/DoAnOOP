package DoAnOOPJava;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NhanVienBanHang extends NhanVien {

  private List<HoaDon> dshoadon = new ArrayList<>();

  public List<HoaDon> getDshoadon() {
    return dshoadon;
  }

  public void setDshoadon(List<HoaDon> dshoadon) {
    this.dshoadon = dshoadon;
  }

  Scanner sc = new Scanner(System.in);
  private static int ma = 1;

  public NhanVienBanHang() {
    setManv("NVBH0" + ma++);
  }

  @Override
  public void nhap() {
    System.out.println("\t\t NHẬP THÔNG TIN NHÂN VIÊN BÁN HÀNG\t\t\n");
    System.out.println("Mã nhân viên: " + getManv());
    super.nhap();
  }

  @Override
  public void xuat() {
    super.xuat();
  }
}

package DoAnOOPJava;

public class MainDoAn {

  public static void main(String[] args) {
    DanhSachNhanVien dsnv = new DanhSachNhanVien();
    //  dsnv.MenuNhanVien();
    ChiTietHoaDon cthd = new ChiTietHoaDon();
    MenuHoaDon dshd = new MenuHoaDon();
    HoaDon hd = new HoaDon();
//        cthd.NhapChiTietHoaDon(hd,dshd);
    NhanVienBanHang nvbh = new NhanVienBanHang();
    nvbh.nhap();
    dsnv.getDsnhanvien().add(nvbh);
    nvbh.xuat();

    dshd.LapHoaDon(dsnv);
//        DanhSachNhanVien dsnv = new DanhSachNhanVien();
//        dsnv.DocFileNhanVien();
  }
}

package DoAnOOPJava;

import java.util.Scanner;

public class MenuHoaDon {

  //  private List<HoaDon> danhsachhoadon = new ArrayList<>();
  Scanner sc = new Scanner(System.in);

  public NhanVien TimKiemNhanVien(String ma, DanhSachNhanVien dsnv) {
    for (var i : dsnv.getDsnhanvien()) {
      if (i.getManv().equals(ma)) {
        return i;
      }
    }
    System.out.println("Mã nhân viên không tồn tại!");
    return null;
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

  public void LapHoaDon(DanhSachNhanVien dsnv) {
    Byte luachon;
    try {
      String ma;
      System.out.print("Nhập mã nhân viên lập hóa đơn: ");
      ma = sc.nextLine();
      NhanVienBanHang nv = (NhanVienBanHang) TimKiemNhanVien(ChuanHoaTen(ma), dsnv);
      while (true) {
        HoaDon hd = new HoaDon();
        System.out.print("\n\n\t\tQUẢN LÝ LẬP HÓA ĐƠN\n+" +
            "\n1.Lập hóa đơn nhập: " +
            "\n2.Lập hóa đơn xuất: " +
            "\n3.Xuất danh sách hóa đơn: " +
            "\n0.Kết thúc" +
            "\n\n\t\t\tEND\n" +
            "\n\t Lựa chọn thứ: ");
        luachon = sc.nextByte();
        sc.nextLine();
        if (luachon == 0) {
          break;
        } else if (luachon == 1) {
          hd.LapHoaDonNhap(this);
        } else if (luachon == 2) {
          hd.LapHoaDonXuat(this);
        } else if (luachon == 3) {
          int dem = 1;

          for (int i = 0; i < nv.getDshoadon().size(); i++) {
            nv.getDshoadon().get(i).Xuat1HoaDon(nv);
          }
        } else {
          System.out.println("Lựa chọn không hợp lệ!");
        }
      }

    } catch (Exception e) {
      System.out.println("Lập hóa đơn bị lỗi gì đếiiii");
    }

  }
}

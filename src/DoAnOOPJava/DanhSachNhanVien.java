package DoAnOOPJava;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.sql.Array;
import java.util.*;
//sau khi thêm vào hoặc xuất ra thì nhớ lưu lại vào file nhanvien.txt
public class DanhSachNhanVien  {
    //chỉ có nhân viên bán hàng mới có quyền truy cập hóa đơn
    private List<NhanVien> dsnhanvien = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public List<NhanVien> getDsnhanvien() {
        return dsnhanvien;
    }

    public void setDsnhanvien(List<NhanVien> dsnhanvien) {
        this.dsnhanvien = dsnhanvien;
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
    public  void DocFileNhanVien() {
       File p = new File("/HocJava/src/DoAnOOPJava/nhanvien.txt");
       try {
           BufferedReader br = Files.newBufferedReader(p.toPath(), StandardCharsets.UTF_8);
           String s = null;
           while (true)
           {   NhanVien nv=null;
               s=br.readLine();
               if(s==null)
               {   br.close();
                   break;
               }
               else
               {
                String []cut = s.split("  ");
                nv= new NhanVienBanHang();
                nv.setManv(cut[0]);
                nv.setHoten(cut[1]);
                nv.setNgaysinh(cut[2]);
                nv.setLuong(Integer.parseInt(cut[3]));
                dsnhanvien.add(nv);
               }
           }
       } catch (IOException ie) {
           System.out.println("Đọc file bị lỗi gì ấy bạn êiiii");
       }

    }

    public void ThemNhanVien()
    {
        NhanVien nv = new NhanVienBanHang();
        nv.nhap();
        dsnhanvien.add(nv);
        try{
            PrintWriter pw = new PrintWriter(new FileOutputStream("/HocJava/src/DoAnOOPJava/nhanvien.txt",true));
//            pw.append(nv.getManv());
//            pw.append("   ");
//            pw.append(nv.getHoten());
//            pw.append("  ");
//            pw.append(nv.getNgaysinh());
//            pw.append("  ");
//            pw.append(Integer.toString(nv.getLuong()));
            pw.println();
            pw.append(nv.getManv()+"  "+nv.getHoten()+"  "+nv.getNgaysinh()+"  "+Integer.toString(nv.getLuong()));
            pw.flush();
            pw.close();
        }catch (IOException ie)
        {
            System.out.println("Ghi File nhân viên bị lỗi gì đếiii");
        }
    }

    public void XoaNhanVien()
    {
        System.out.print("Nhập mã nhân viên cần xóa: ");
        String manv =  sc.nextLine();
        for(int i=0;i< dsnhanvien.size();i++)
        {
            if (dsnhanvien.get(i).getManv().equals(manv) )
            {
                dsnhanvien.remove(dsnhanvien.get(i));
                System.out.println("Đã xóa thành công!");
                return;
            }
        }
        System.out.println("Mã nhân viên không tồn tại trong hệ thống!");
    }

    public void HieuChinhNhanVien()
    {   System.out.print("Nhập mã nhân viên cần hiệu chỉnh: ");
        String manv =  sc.nextLine();
        for(int i=0;i<dsnhanvien.size();i++)
        {
            if(dsnhanvien.get(i).getManv().equals(manv))
            {
                System.out.print("Họ tên nhân viên: ");
                dsnhanvien.get(i).setHoten(sc.nextLine());
                System.out.print("Nhập ngày tháng năm sinh:  ");
                dsnhanvien.get(i).setNgaysinh(sc.nextLine());
                System.out.print("Nhập lương cơ bản: ");
                dsnhanvien.get(i).setLuong(sc.nextInt());
                System.out.println("Hiệu chỉnh thành công!");
                return;
            }
        }
        System.out.println("Mã nhân viên không tồn tại trong hệ thống!");
    }

    public void XuatDanhSachNhanVien()
    {
//        System.out.println("Mã nhân viên\t"+"Họ tên\t"+"Ngày tháng năm sinh\t\t"+"Lương\t\t\t\t"+"Chức vụ");
        System.out.printf("%-20s %-20s %-20s %-20s %-20s","Mã nhân viên","Họ tên","Ngày tháng năm sinh","Lương","Chức vụ");
        System.out.println();
        for(var i : dsnhanvien)
        {
            i.xuat();
        }
    }

    public void SapXepGiamDanTheoLuong()
    {
        Collections.sort(dsnhanvien,new NhanVienComparator());
        XuatDanhSachNhanVien();
    }

    public void MenuNhanVien()
    {   Byte luachon;
        try
        {
            DocFileNhanVien();
        while(true) {
            System.out.print("\n\n\t\tQUẢN LÝ THÔNG TIN NHÂN VIÊN\t\t" +
                    "\n1.Thêm nhan viên vào danh sách" +
                    "\n2.Xuất danh sách nhân viên" +
                    "\n3.Hiệu chỉnh thông tin nhân viên" +
                    "\n4.Xóa nhân viên" +
                    "\n5.Sắp xếp giảm dần theo lương" +
                    "\n0.Kết thúc\t\t" +
                    "\n\t\t\t\tEND\t\t"+
                    "\nLựa chọn của bàn là: ");
            luachon = sc.nextByte();
            sc.nextLine();
            if (luachon == 1) {
                ThemNhanVien();
            } else if (luachon == 2) {
                XuatDanhSachNhanVien();
            } else if (luachon == 3) {
                HieuChinhNhanVien();
            } else if (luachon == 4) {
                XoaNhanVien();
            } else if (luachon == 5)
            {
                SapXepGiamDanTheoLuong();
            }
            else if(luachon==0)
            {
                break;
            }
        }

        }catch(Exception e)
        {
            System.out.println("Bị lỗi gì gòi bạn êiii");
        }
        finally{
            System.out.println("Have a good day");
        }
    }
}

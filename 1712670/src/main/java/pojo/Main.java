package pojo;

import java.util.List;


public class Main {
	public static void main(String[] args) {
		
		List<SvMonhoc> ds = SvMonhocDAO.layDanhSachSinhVienMonHoc();
		for (int i = 0; i < ds.size(); i++) {
			SvMonhoc sv = ds.get(i);
			System.out.println("MSSV: " + sv.getMssv());
			System.out.println("Họ và tên: " + sv.getMssv());
			System.out.println("Ngày sinh: " + sv.getDiemTong());
		}
		 
				
		/*
		 * List<Sinhvien> ds = SinhvienDAO.layDanhSachSinhVien(); for (int i = 0; i <
		 * ds.size(); i++) { Sinhvien sv = ds.get(i); System.out.println("MSSV: " +
		 * sv.getMssv()); System.out.println("Họ và tên: " + sv.getHoTen());
		 * System.out.println("Ngày sinh: " + sv.getCmnd()); }
		 */
			}
}

package pojo;

import java.util.List;

public class Main {
	public static void main(String[] args) {
		/*
		 * List<SvMonhoc> ds = SvMonhocDAO.layDanhSachSinhVienMonHocTheoLop("17HCB",
		 * "CTT014"); for (int i = 0; i < ds.size(); i++) { SvMonhoc temp = ds.get(i);
		 * Sinhvien sv = SinhvienDAO.layThongTinSinhVien(temp.getMssv());
		 * System.out.println("MSSV: " + sv.getMssv()); System.out.println("Họ và tên: "
		 * + sv.getHoTen()); System.out.println("Ngày sinh: " + sv.getCmnd());
		 * System.out.println("Mã lớp: " + sv.getMaLop()); }
		 */
		
		String[] lop = SinhvienDAO.layDanhSachLop();
		
		/*
		 * boolean check1, check2 = true; Tkb tkb = new Tkb(0, "17HCB", "CTT014",
		 * "ABCD", "C42"); check1 = TkbDAO.themTkb(tkb); Float f = (float) 0; if
		 * (check1) { for (Sinhvien i: ds) { SvMonhoc temp = new SvMonhoc(0,
		 * i.getMssv(), tkb.getMaMon(), f, f, f, f); check2 =
		 * SvMonhocDAO.themSvMonhoc(temp); if(!check2) break; } if (check2)
		 * System.out.println("Them thanh cong"); else
		 * System.out.println("Them deo thanh cong"); }
		 */
		

	}
}

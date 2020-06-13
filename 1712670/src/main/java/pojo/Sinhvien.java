// default package
// Generated Jun 4, 2020 4:15:33 PM by Hibernate Tools 5.4.14.Final
package pojo;

@SuppressWarnings("serial")
public class Sinhvien implements java.io.Serializable {

	private int mssv;
	private int stt;
	private String hoTen;
	private int gioiTinh;
	private int cmnd;
	private String maLop; 

	public Sinhvien() {
	}

	public Sinhvien(int mssv) {
		this.mssv = mssv;
	}

	public Sinhvien(int mssv, int stt, String hoTen, int gioiTinh, int cmnd, String maLop) {
		this.mssv = mssv;
		this.stt = stt;
		this.hoTen = hoTen;
		this.gioiTinh = gioiTinh;
		this.cmnd = cmnd;
		this.maLop = maLop;

	}

	public int getMssv() {
		return this.mssv;
	}

	public void setMssv(int mssv) {
		this.mssv = mssv;
	}

	public int getStt() {
		return this.stt;
	}

	public void setStt(int stt) {
		this.stt = stt;
	}

	public String getHoTen() {
		return this.hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public int getGioiTinh() {
		return this.gioiTinh;
	}

	public void setGioiTinh(int gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public int getCmnd() {
		return this.cmnd;
	}

	public void setCmnd(int cmnd) {
		this.cmnd = cmnd;
	}

	public String getMaLop() {
		return maLop;
	}

	public void setMaLop(String maLop) {
		this.maLop = maLop;
	}

}

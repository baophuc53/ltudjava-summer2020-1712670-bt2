// default package
// Generated Jun 4, 2020 4:15:33 PM by Hibernate Tools 5.4.14.Final
package pojo;

@SuppressWarnings("serial")
public class Tkb implements java.io.Serializable {

	private int stt;
	private String maLop;
	private String maMon;
	private String tenMon;
	private String phongHoc;

	public Tkb() {
	}

	public Tkb(int stt) {
		this.stt = stt;
	}

	public Tkb(int stt, String maLop, String maMon, String tenMon, String phongHoc) {
		this.stt = stt;
		this.setMaLop(maLop);
		this.maMon = maMon;
		this.tenMon = tenMon;
		this.phongHoc = phongHoc;
	}

	public int getStt() {
		return this.stt;
	}

	public void setStt(int stt) {
		this.stt = stt;
	}

	public String getMaLop() {
		return maLop;
	}

	public void setMaLop(String maLop) {
		this.maLop = maLop;
	}

	public String getMaMon() {
		return this.maMon;
	}

	public void setMaMon(String maMon) {
		this.maMon = maMon;
	}

	public String getTenMon() {
		return this.tenMon;
	}

	public void setTenMon(String tenMon) {
		this.tenMon = tenMon;
	}

	public String getPhongHoc() {
		return this.phongHoc;
	}

	public void setPhongHoc(String phongHoc) {
		this.phongHoc = phongHoc;
	}
}

package pojo;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;


public class SinhvienDAO {
	public static List<Sinhvien> layDanhSachSinhVien() {
		List<Sinhvien> ds = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			String hql = "select sv from Sinhvien sv where MaLop = '17HCB'";
			ds = session.createQuery(hql).getResultList();
		} catch (HibernateException ex) {
//Log the exception
			System.err.println(ex);
		} finally {
			session.close();
		}
		return ds;
	}
}


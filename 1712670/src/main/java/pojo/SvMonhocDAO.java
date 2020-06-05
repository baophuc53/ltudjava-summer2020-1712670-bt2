package pojo;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

public class SvMonhocDAO {
	@SuppressWarnings("unchecked")
	public static List<SvMonhoc> layDanhSachSinhVienMonHoc() {
		List<SvMonhoc> ds = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			String hql = "select sv from SvMonhoc sv";
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

package pojo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class SinhvienDAO {
	public static List<Sinhvien> layDanhSachSinhVienTheoLop(String lop) {
		List<Sinhvien> ds = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			String hql = "select sv from Sinhvien sv where MaLop='" + lop + "' order by Stt asc";
			ds = session.createQuery(hql).getResultList();
		} catch (HibernateException ex) {
//Log the exception
			System.err.println(ex);
		} finally {
			session.close();
		}
		return ds;
	}

	public static Sinhvien layThongTinSinhVien(int maSinhVien) {
		Sinhvien sv = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			sv = (Sinhvien) session.get(Sinhvien.class, maSinhVien);
		} catch (HibernateException ex) {
			// Log the exception
			System.err.println(ex);
		} finally {
			session.close();
		}
		return sv;
	}

	public static boolean themSinhVien(Sinhvien sv) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		if (SinhvienDAO.layThongTinSinhVien(sv.getMssv()) != null) {
			return false;
		}
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(sv);
			transaction.commit();
		} catch (HibernateException ex) {
			// Log the exception
			transaction.rollback();
			System.err.println(ex);
		} finally {
			session.close();
		}
		return true;
	}

	public static boolean themDanhSachSinhVien(List<Sinhvien> listSv) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		for (Sinhvien sv : listSv) {
			if (SinhvienDAO.layThongTinSinhVien(sv.getMssv()) != null) {
				return false;
			}
			Transaction transaction = null;
			try {
				transaction = session.beginTransaction();
				session.save(sv);
				transaction.commit();
			} catch (HibernateException ex) {
				// Log the exception
				transaction.rollback();
				System.err.println(ex);
				break;
			}
		}
		session.close();
		return true;
	}

	public static boolean capNhatThongTinSinhVien(Sinhvien sv) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		if (SinhvienDAO.layThongTinSinhVien(sv.getMssv()) == null) {
			return false;
		}
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.update(sv);
			transaction.commit();
		} catch (HibernateException ex) {
			// Log the exception
			transaction.rollback();
			System.err.println(ex);
		} finally {
			session.close();
		}
		return true;
	}

	public static String[] layDanhSachLop() {
		List<String> ds = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			String hql = "select maLop from Sinhvien sv";
			ds = session.createQuery(hql).getResultList();
		} catch (HibernateException ex) {
//Log the exception
			System.err.println(ex);
		} finally {
			session.close();
		}
		Set<String> set = new HashSet<>();
		for (String i : ds)
			set.add(i);
		String[] lop = set.toArray(new String[set.size()]);

		return lop;
	}
}

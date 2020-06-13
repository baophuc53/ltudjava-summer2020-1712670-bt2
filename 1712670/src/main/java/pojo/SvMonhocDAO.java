package pojo;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
	
	public static List<SvMonhoc> layDanhSachSinhVienMonHocTheoLop(String maLop, String maMon) {
		List<SvMonhoc> ds = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			String hql = "select sv from SvMonhoc sv where MaLop='" + maLop + "' and MaMon='" + maMon + "'";
			ds = session.createQuery(hql).getResultList();
		} catch (HibernateException ex) {
//Log the exception
			System.err.println(ex);
		} finally {
			session.close();
		}
		return ds;
	}

	public static SvMonhoc layThongTinhSvMonhoc(int mssv, String maMon) {
		List<SvMonhoc> ds = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			String hql = "select svmh from SvMonhoc svmh where mssv='" + mssv + "' and MaMon='" + maMon + "'";
			ds = session.createQuery(hql).getResultList();
		} catch (HibernateException ex) {
			// Log the exception
			System.err.println(ex);
		} finally {
			session.close();
		}
		if (!ds.isEmpty())
			return ds.get(0);
		else
			return null;
	}

	public static boolean themSvMonhoc(SvMonhoc svmh) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		if (SvMonhocDAO.layThongTinhSvMonhoc(svmh.getMssv(), svmh.getMaMon()) != null) {
			return false;
		}
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(svmh);
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
	
	public static boolean xoaSvMonhoc(SvMonhoc svmh) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		if (SvMonhocDAO.layThongTinhSvMonhoc(svmh.getMssv(), svmh.getMaMon()) == null) {
			return false;
		}
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.delete(svmh);
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

	public static boolean themDanhSachSvMonhoc(List<SvMonhoc> dsSvmh) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		for (SvMonhoc svmh : dsSvmh) {
			if (SvMonhocDAO.layThongTinhSvMonhoc(svmh.getMssv(), svmh.getMaMon()) != null) {
				return false;
			}
			Transaction transaction = null;
			try {
				transaction = session.beginTransaction();
				session.save(svmh);
				transaction.commit();
			} catch (HibernateException ex) {
				// Log the exception
				transaction.rollback();
				System.err.println(ex);
			}
		}
		session.close();
		return true;
	}

	public static boolean capNhatSvMonhoc(SvMonhoc svmh) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		if (SvMonhocDAO.layThongTinhSvMonhoc(svmh.getMssv(), svmh.getMaMon()) == null) {
			return false;
		}
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.update(svmh);
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
}

package pojo;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TkbDAO {
	@SuppressWarnings("unchecked")
	public static List<Tkb> layTkbTheoLop(String lop) {
		List<Tkb> ds = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			String hql = "select tkb from Tkb tkb where MaLop='" + lop + "'";
			ds = session.createQuery(hql).getResultList();
		} catch (HibernateException ex) {
//Log the exception
			System.err.println(ex);
		} finally {
			session.close();
		}
		return ds;
	}
	
	public static List<Tkb> layDanhSachTkb() {
		List<Tkb> ds = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			String hql = "select tkb from Tkb tkb";
			ds = session.createQuery(hql).getResultList();
		} catch (HibernateException ex) {
//Log the exception
			System.err.println(ex);
		} finally {
			session.close();
		}
		return ds;
	}

	public static Tkb layThongTinhTkb(String maLop, String maMon) {
		List<Tkb> ds = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			String hql = "select tkb from Tkb tkb where MaLop='" + maLop + "' and MaMon='" + maMon + "'";
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

	public static boolean themTkb(Tkb tkb) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		if (TkbDAO.layThongTinhTkb(tkb.getMaLop(), tkb.getMaMon()) != null) {
			return false;
		}
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(tkb);
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

	public static boolean themDanhSachTkb(List<Tkb> dsTkb) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		for (Tkb tkb : dsTkb) {
			if (TkbDAO.layThongTinhTkb(tkb.getMaLop(), tkb.getMaMon()) != null) {
				return false;
			}
			Transaction transaction = null;
			try {
				transaction = session.beginTransaction();
				session.save(tkb);
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

	public static boolean capNhatTkb(Tkb tkb) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		if (TkbDAO.layThongTinhTkb(tkb.getMaLop(), tkb.getMaMon()) == null) {
			return false;
		}
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.update(tkb);
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

package pojo;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserDAO {
	public static User layThongTinUser(String username) {
		User user = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			user = (User) session.get(User.class, username);
		} catch (HibernateException ex) {
			// Log the exception
			System.err.println(ex);
		} finally {
			session.close();
		}
		return user;
	}
	
	public static boolean updateThongTinUser(User user) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		if (UserDAO.layThongTinUser(user.getUsername()) == null) {
			return false;
		}
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.update(user);
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

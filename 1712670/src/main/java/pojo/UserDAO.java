package pojo;

import org.hibernate.HibernateException;
import org.hibernate.Session;

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
}

package assignment.hibernate.enteties;

import hibernate.util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ManageCourse {
	private static SessionFactory factory = HibernateUtil.getSessionFactory();
	Session session = factory.openSession();
	public int addCourse(Course course) {
		int courseid = 0;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			courseid = (Integer) session.save(course);
			// session.save(in);
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		session.getTransaction().commit();
		return courseid;
	}

}

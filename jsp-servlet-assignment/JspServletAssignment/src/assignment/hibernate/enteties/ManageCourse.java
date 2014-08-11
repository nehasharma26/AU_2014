package assignment.hibernate.enteties;

import java.util.logging.Logger;

import hibernate.util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ManageCourse {
	private static final Logger logger = Logger.getLogger(ManageCourse.class.getName());
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
			logger.info("exception caught:" + e);
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		session.getTransaction().commit();
		return courseid;
	}

}

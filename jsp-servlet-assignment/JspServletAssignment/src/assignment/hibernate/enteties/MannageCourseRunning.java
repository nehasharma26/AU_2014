package assignment.hibernate.enteties;

import hibernate.util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import assignment.hibernate.servlets.AddCourse;

public class MannageCourseRunning {
	public static void main(String []args)
	{ 
		
		CourseRunning c=new CourseRunning(1, 1, "eligibility", "admissionProcedure");
		addCourse(c);
	}
	private static SessionFactory factory = HibernateUtil.getSessionFactory();
	Session session = factory.openSession();
	public static int addCourse(CourseRunning course) {
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

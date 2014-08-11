package assignment.hibernate.enteties;

import hibernate.util.HibernateUtil;

import java.util.*;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ManageInstitute {
	private static SessionFactory factory = HibernateUtil.getSessionFactory();
	Session session = factory.openSession();
	public ArrayList<Institute> listInstitutes() {
		Transaction tx = null;
		ArrayList<Institute> array=null;
		try {
			tx = session.beginTransaction();
			List inst = session.createQuery("FROM Institute").list();
			for (Iterator iterator1 = inst.iterator(); iterator1.hasNext();) {
				Institute institute = (Institute) iterator1.next();
				array.add(institute);
				}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			// session.close
		}
		return array;
	}

	public Institute getinstitute(int id) {
		session.beginTransaction();
		Object obj = session.get(Institute.class, id);
		if (obj == null)
			throw new RuntimeException("Institute introuvable");
		return (Institute) obj;
	}

	public void deleteInstitute(Integer InstituteID) {
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Institute Institute = (Institute) session.get(Institute.class,
					InstituteID);
			session.delete(Institute);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public int addInstitute(Institute in) {
		int instid = 0;
		session.beginTransaction();
		try {
			instid = (Integer) session.save(in);
			// session.save(in);
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		session.getTransaction().commit();
		return instid;
	}
	public void update(int id,String title,String description,String location,String branches,String courses)
	{
		String hql = "UPDATE institute set title = :title,description= :description,  location = :location,branches = :branches,courses :=courses "  + 
	             "WHERE instId = :id";
	Query query = session.createQuery(hql);
	query.setParameter("id", id);
	query.setParameter("title", title);
	query.setParameter("description", description);
	query.setParameter("location", location);
	query.setParameter("branches", branches);
	query.setParameter("courses", courses);
	int result = query.executeUpdate();
	}
	}

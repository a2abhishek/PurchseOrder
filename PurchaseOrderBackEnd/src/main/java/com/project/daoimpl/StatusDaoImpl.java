package com.project.daoimpl;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.daos.StatusDao;
import com.project.models.Status;

@Repository("StatusDao")
@Transactional
public class StatusDaoImpl implements StatusDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean addStatus(Status statusObj) {
			try {
				Session session = sessionFactory.getCurrentSession();
				
				session.saveOrUpdate(statusObj);
				return true;
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		return false;
	}
	
	@Override
	public boolean updateStatus(String statusName) {
		 try {
	            Session session = sessionFactory.getCurrentSession();
	            session.update(statusName);
	            session.close();
	            return true;
	        }
	        catch (Exception e) {
	        	e.printStackTrace();

	        }

	        return false;
	}

	@Override
	public Status viewStatus(int statusId) {
		try {
            Session session=sessionFactory.getCurrentSession();
            Status st=session.get(Status.class,statusId);
            session.close();

            return st;
            }
            catch(Exception e) {
                e.printStackTrace();
            }
		return null;
	}

}

package com.project.daoimpl;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.daos.BuyerDao;
import com.project.models.Buyer;

@Repository("BuyerDao")
@Transactional
public class BuyerDaoImpl implements BuyerDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	
	@Override
	public boolean registerBuyer(Buyer buyerObj) {
		try {
			Session session = sessionFactory.getCurrentSession();
			
			session.saveOrUpdate(buyerObj);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}

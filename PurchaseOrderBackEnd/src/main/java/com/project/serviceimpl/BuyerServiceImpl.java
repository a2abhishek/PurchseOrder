package com.project.serviceimpl;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.daos.BuyerDao;
import com.project.models.Buyer;
import com.project.services.BuyerService;

@Service
@Transactional
public class BuyerServiceImpl implements BuyerService {

	@Autowired
	BuyerDao buyerdao;
	
	@Override
	public boolean registerBuyer(Buyer uobj) {
		uobj.setIsActive("Y");
		uobj.setCreatedDate(LocalDate.now());
		uobj.setCreatedBy("System");
		uobj.setRoleId(1);
		return buyerdao.registerBuyer(uobj);
		
	}
}
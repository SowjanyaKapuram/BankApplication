package com.cg.ba.Service;

import com.cg.ba.DAO.BankAppDaoImpl1;
import com.cg.ba.DAO.IBankAppDao1;
import com.cg.ba.DTO.CustomerDetails;

public class BankAppServiceImpl1 implements IBankAppService1 {
	IBankAppDao1 appDao1 = new BankAppDaoImpl1(); 

	public int registerCustomer(CustomerDetails custDetails) {
		 
		return appDao1.registerCustomer(custDetails);
	}

}

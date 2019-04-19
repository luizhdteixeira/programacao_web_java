package com.main;

import org.hibernate.Session;

import com.consultorio.util.hibernateUtil;

public class hibernateUtilTest {

	Session sessao = hibernateUtil.getFabricaSessoes().openSession();
	
	 
}

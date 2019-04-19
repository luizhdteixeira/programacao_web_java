package com.consultorio.util;

import org.hibernate.Session;
import org.junit.Test;

public class hibernateUtilTest {

	@Test
	public void conectar() {
		Session sessao = hibernateUtil.getFabricaSessoes().openSession();
		sessao.close();
		hibernateUtil.getFabricaSessoes().close(); 
	}
}

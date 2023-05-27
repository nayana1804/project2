package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import dto.signup_dto;

public class signupdao {
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("dev");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	
	public String signup(signup_dto sd) {
		et.begin();
		em.persist(sd);
		et.commit();
		return "data is inserted successfully";
	}
public signup_dto login(String email) {
	signup_dto d=em.find(signup_dto.class, email);
	return d;
}

}





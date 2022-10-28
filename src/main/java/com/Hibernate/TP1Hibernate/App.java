package com.Hibernate.TP1Hibernate;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

import com.Hibernate.TP1Hibernate.App;
import com.Hibernate.TP1Hibernate.Model.Aeroport;
import com.Hibernate.TP1Hibernate.Model.Client;
import com.Hibernate.TP1Hibernate.Model.CompagnieAerienne;
import com.Hibernate.TP1Hibernate.Model.Passager;
import com.Hibernate.TP1Hibernate.Model.Reservation;
import com.Hibernate.TP1Hibernate.Model.Ville;
import com.Hibernate.TP1Hibernate.Model.Vol;



public class App 
{
	private static final Logger logger = LogManager.getLogger(App.class);
	
    public static void main( String[] args )
    {
    	Session session = HibernateUtil.getSessionFactory().openSession();
    	
    	session.beginTransaction();
    	
    	Client client = new Client(1, "Paul", "Jean", "12 rue des Lilas", 0632344201, "jean.paul@monfournisseur.fr");
    	Reservation reservation = new Reservation(1, LocalDate.now()) ;
    	Passager passager = new Passager(1, "Paul", "Jean");
    	Vol vol = new Vol(1, LocalDate.now(), LocalDateTime.now(), LocalDate.of(2022, 10, 28), LocalDateTime.of(2022, 10, 28, 06, 36));
    	CompagnieAerienne compagnie = new CompagnieAerienne(1, "Bristish Airlines");
    	Aeroport aeroport = new Aeroport(1, "paris CDG");
    	Ville ville = new Ville(1, "Paris");
    	
    	session.saveOrUpdate(client);
    	session.saveOrUpdate(reservation);
    	session.saveOrUpdate(passager);
    	session.saveOrUpdate(vol);
    	session.saveOrUpdate(compagnie);
    	session.saveOrUpdate(aeroport);
    	session.saveOrUpdate(ville);
    	
    	session.getTransaction().commit();
    	logger.info("Finito la rigolade");
    }
}

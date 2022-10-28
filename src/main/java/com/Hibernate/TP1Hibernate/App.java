package com.Hibernate.TP1Hibernate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
	static Scanner scan = new Scanner(System.in);
	static Session session = HibernateUtil.getSessionFactory().openSession();
	
    public static void main( String[] args )
    {
    	  	
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
    	logger.info("Fin");
    	
    	Reservation();
    	annulerReservation();
    	
    	
    }
    
    public static void Reservation()
	{
    	session.beginTransaction();
		System.out.println("Saisir votre réservation (numéro, année-mois-jour) :");
		Reservation r1 = new Reservation(scan.nextInt(), LocalDate.parse(scan.next()));
		
		session.saveOrUpdate(r1);
		
		System.out.println("Saisir 1 pour confirmer ou autre pour annuler");
		int choix = scan.nextInt();
			switch (choix) {
			case 1: 
				session.getTransaction().commit();
				
				break;

			default:
				session.getTransaction().rollback();
				break;
			}
	}
    
    public static void annulerReservation()
    {
    	session.beginTransaction();
    	System.out.println("Saisir le numéro de la réservation à annuler");
    	int numres = scan.nextInt();
    	Reservation r1 = session.get(Reservation.class, numres);
    	session.delete(r1);
    	
    	System.out.println("Saisir 1 pour confirmer ou autre pour annuler");
		int choix = scan.nextInt();
			switch (choix) {
			case 1: 
				session.getTransaction().commit();
				
				break;

			default:
				session.getTransaction().rollback();
				break;
			}
    }
    
    public static void CreationVol() 
    {
    	session.beginTransaction();
    	List<Reservation> listereservation= new ArrayList<>();
    	System.out.println("Veuillez saisir le numero du vol");
    	int numvol = scan.nextInt();
    	Vol v1 = session.get(Vol.class, numvol);
    	int choix;
    	do {
    		System.out.println("Veuillez saisir votre reservation (numero , année-mois-jour)");
        	Reservation r1 = new Reservation(scan.nextInt(), LocalDate.parse(scan.next()));
        	listereservation.add(r1);
        	session.saveOrUpdate(r1);
        	v1.setListeReservation(listereservation);
        	System.out.println("Taper 0 pour continuer ou 1 pour enregistrer");
        	choix = scan.nextInt();
    	} while (choix != 1 || listereservation.size() <3);
    	session.getTransaction().commit();
    }


}


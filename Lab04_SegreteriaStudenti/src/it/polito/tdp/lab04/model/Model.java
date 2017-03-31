package it.polito.tdp.lab04.model;

import java.util.List;

import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.DAO.IscrizioneDAO;
import it.polito.tdp.lab04.DAO.StudenteDAO;

public class Model {
	
	private CorsoDAO c;
	private StudenteDAO s;
	private IscrizioneDAO i;
	
	public Model(){
		c=new CorsoDAO();
		s=new StudenteDAO();
		i=new IscrizioneDAO();
	}
	
	public List<Corso> getCorsi(){
		return c.getTuttiICorsi();
	}
	
	public List<Studente> getIscritti(Corso c){
		return this.c.getStudentiIscrittiAlCorso(c);
	}
	
	public List<String> getStud(String matricola){
		return this.s.getStud(matricola);
	}
	
	public List<Corso> getCorsiStud(String matricola){
		return this.c.getCorsiStud(matricola);
	}
	
	public boolean iscrivi(String matricola,Corso corso){
		return this.i.iscrivi(matricola,corso.getCod());
	}
}

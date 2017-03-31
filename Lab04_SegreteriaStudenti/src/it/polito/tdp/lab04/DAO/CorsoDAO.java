package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Studente;

public class CorsoDAO {

	/*
	 * Ottengo tutti i corsi salvati nel Db
	 */
	public List<Corso> getTuttiICorsi() {

		final String sql = "SELECT * FROM corso";

		List<Corso> corsi = new LinkedList<Corso>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				// Crea un nuovo JAVA Bean Cors
				Corso c = new Corso(rs.getString("codins"),rs.getInt("crediti"),rs.getString("nome"),rs.getInt("pd"));
				// Aggiungi il nuovo Corso alla lista
				//if (!corsi.contains(c))
					corsi.add(c);
				
			}

			return corsi;

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
	}

	/*
	 * Dato un codice insegnamento, ottengo il corso
	 */
	public void getCorso(Corso corso) {
		// TODO
	}

	/*
	 * Ottengo tutti gli studenti iscritti al Corso
	 */
	public List<Studente> getStudentiIscrittiAlCorso(Corso corso) {
		// TODO
		final String sql = "SELECT matricola,nome,cognome,CDS FROM studente WHERE matricola IN (SELECT matricola FROM iscrizione where codins='"+corso.getCod()+"')";
		
		List<Studente> iscritti = new LinkedList<Studente>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			//st.setString(1,corso.getCod());
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				
				iscritti.add(new Studente(rs.getInt("matricola"),rs.getString("cognome"),rs.getString("nome"),rs.getString("CDS")));
				
			}

			return iscritti;

		} catch (SQLException e) {
			//e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
	}

	/*
	 * Data una matricola ed il codice insegnamento,
	 * iscrivi lo studente al corso.
	 */
	public boolean inscriviStudenteACorso(Studente studente, Corso corso) {
		// TODO
		return false;
	}
	
	public List<Corso> getCorsiStud(String matricola){
			
			List<Corso> dati = new LinkedList<Corso>();
			
			
			if (controlloStudente(matricola)==true) {
				
				final String sql1 = "SELECT codins,crediti,nome,pd FROM corso WHERE codins IN (SELECT codins FROM iscrizione WHERE matricola='"+matricola+"')";

				try {
					Connection conn1 = ConnectDB.getConnection();
					PreparedStatement st1 = conn1.prepareStatement(sql1);
					//st.setString(1,matricola);
					ResultSet rs1 = st1.executeQuery();

					while (rs1.next()) {
						
						dati.add(new Corso(rs1.getString("codins"),rs1.getInt("crediti"),rs1.getString("nome"),rs1.getInt("pd")));
						
					}


				} catch (SQLException e) {
					// e.printStackTrace();
					throw new RuntimeException("Errore Db");
				}
				
				return dati;
				
			}
			else{
				return null;
			}

	}
	
	public boolean controlloStudente(String matricola){
		
		final String sql1 = "SELECT matricola,nome,cognome FROM studente WHERE matricola='"+matricola+"'";
		int x=0;

		try {
			Connection conn1 = ConnectDB.getConnection();
			PreparedStatement st1 = conn1.prepareStatement(sql1);
			//st.setString(1,matricola);
			ResultSet rs1 = st1.executeQuery();

			while(rs1.next()) {
				x++;
			}


		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
		if (x==0)
			return false;
		else
			return true;
	}
	
}

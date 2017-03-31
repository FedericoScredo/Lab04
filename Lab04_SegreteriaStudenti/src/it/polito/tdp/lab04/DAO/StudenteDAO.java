package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class StudenteDAO {

	public List<String> getStud(String matricola){
		if (controlloStudente(matricola)==true){
			final String sql = "SELECT cognome,nome FROM studente WHERE matricola='"+matricola+"'";
			List<String> dati = new LinkedList<String>();
	
			try {
				Connection conn = ConnectDB.getConnection();
				PreparedStatement st = conn.prepareStatement(sql);
				//st.setString(1,matricola);
				ResultSet rs = st.executeQuery();
	
				while (rs.next()) {
					
					dati.add(rs.getString("cognome"));
					dati.add(rs.getString("nome"));
					
				}
	
	
			} catch (SQLException e) {
				// e.printStackTrace();
				throw new RuntimeException("Errore Db");
			}
			return dati;
		}
		return null;
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

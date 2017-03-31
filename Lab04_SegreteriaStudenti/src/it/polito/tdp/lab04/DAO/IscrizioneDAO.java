package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class IscrizioneDAO {
	
	private CorsoDAO c=new CorsoDAO();
	
	public boolean iscrivi(String matricola,String codins){
		//System.out.println(c.controlloStudente(matricola));
		if(c.controlloStudente(matricola)==true && controllo(matricola,codins)==false){
			
			final String sql = "INSERT INTO iscrizione (`matricola`, `codins`) VALUES ('"+matricola+"','"+codins+"')";
			//System.out.println(sql);
			try {
				Connection conn = ConnectDB.getConnection();
				PreparedStatement st = conn.prepareStatement(sql);
				
				//st.setString(1,matricola);
				int rs= st.executeUpdate();

			} catch (SQLException e) {
				// e.printStackTrace();
				throw new RuntimeException("Errore Db");
			}
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean controllo(String matricola, String codins){
		final String sql="SELECT matricola, codins FROM iscrizione WHERE matricola='"+matricola+"' AND codins='"+codins+"'";
		try	{
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			
			//st.setString(1,matricola);
			ResultSet rs=st.executeQuery();
			
			if (rs.next())
				return true;
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
		return false;
	}
	
}

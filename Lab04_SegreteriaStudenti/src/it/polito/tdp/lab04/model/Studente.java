package it.polito.tdp.lab04.model;

public class Studente {
	
	private int matricola;
	private String cognome;
	private String nome;
	private String percorsodistudi;
	
	public Studente(int matricola, String cognome, String nome, String percorsodistudi) {
		super();
		this.matricola = matricola;
		this.cognome = cognome;
		this.nome = nome;
		this.percorsodistudi = percorsodistudi;
	}

	public int getMatricola() {
		return matricola;
	}

	public String getCognome() {
		return cognome;
	}

	public String getNome() {
		return nome;
	}

	public String getPercorsodistudi() {
		return percorsodistudi;
	}

	@Override
	public String toString() {
		return matricola + " " + cognome + " " + nome + " "
				+ percorsodistudi;
	}
	
	
	
}

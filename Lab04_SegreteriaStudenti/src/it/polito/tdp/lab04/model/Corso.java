package it.polito.tdp.lab04.model;

public class Corso {
	
	private String cod;
	private int crediti;
	private String nome;
	private int periodo;
	
	public Corso(String cod, int crediti, String nome, int periodo) {
		super();
		this.cod = cod;
		this.crediti = crediti;
		this.nome = nome;
		this.periodo = periodo;
	}

	public String getCod() {
		return cod;
	}

	public int getCrediti() {
		return crediti;
	}

	public String getNome() {
		return nome;
	}

	public int getPeriodo() {
		return periodo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cod == null) ? 0 : cod.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Corso other = (Corso) obj;
		if (cod == null) {
			if (other.cod != null)
				return false;
		} else if (!cod.equals(other.cod))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return cod+ " "+ nome;
	}
	
	

}

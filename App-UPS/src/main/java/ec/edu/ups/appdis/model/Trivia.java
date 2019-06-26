package ec.edu.ups.appdis.model;

import java.util.ArrayList;

public class Trivia {
	
	private int codigo;
	
	private ArrayList<String> Preguntas;
	
	private ArrayList<String> Respuestas;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public ArrayList<String> getPreguntas() {
		return Preguntas;
	}

	public void setPreguntas(ArrayList<String> preguntas) {
		Preguntas = preguntas;
	}

	public ArrayList<String> getRespuestas() {
		return Respuestas;
	}

	public void setRespuestas(ArrayList<String> respuestas) {
		Respuestas = respuestas;
	}
	

}

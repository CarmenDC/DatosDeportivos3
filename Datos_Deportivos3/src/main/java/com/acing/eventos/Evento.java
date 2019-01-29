package com.acing.eventos;

import java.util.Date;

//Transient

public class Evento {
	private Participante local; // transient para que no serialice este campo.
	private Participante visitante;
	private Date fecha;
	private String resultado;
	//Evento no es solo partido
//	private int golesLocal;
//	private int golesVisitante;
	
//	Json json= new Json();
	
	
	
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	
	public Evento () {
	}
	
	public Evento(Participante local, Participante visitante, Date fecha) {
		super();
		this.local = local;
		this.visitante = visitante;
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "("+ fecha +")" + local.toString() + " vs " + visitante.toString() +", resultado=" + resultado;
				
	}

	

}

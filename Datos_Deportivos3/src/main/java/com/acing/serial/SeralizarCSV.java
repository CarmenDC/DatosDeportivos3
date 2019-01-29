package com.acing.serial;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import com.acing.eventos.Evento;
import com.acing.eventos.Participante;

public class SeralizarCSV {
	
	public static Collection<Evento> getEventos (String rutaArchivo){
		
		Collection<Evento> eventosLeidos = new ArrayList<>();
				
				try(BufferedReader reader =  new BufferedReader(
						new InputStreamReader(
								new FileInputStream(rutaArchivo), "UTF-8"))){
					String linea = reader.readLine();
					
					while ((linea = reader.readLine())!= null){
						eventosLeidos.add(deserializarEvento(linea));
					}
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		return eventosLeidos;
	}
	
	public static Evento deserializarEvento(String linea) throws ParseException {
		String [] miarray =linea.split(",");
		String fechaString = miarray [1];
		String localString = miarray [2];
		String visitanteString = miarray [3];
		String golesLocalString = miarray [4];
		String golesVisitanteString = miarray [5];
		
		SimpleDateFormat sdformat = new SimpleDateFormat("dd/MM/yy");
		
		Date fecha = (Date) sdformat.parse(fechaString);
		Participante local = new Participante(localString);
		Participante visitante = new Participante(visitanteString);
		int golesLocal= Integer.parseInt(golesLocalString);
		int golasVisitante = Integer.parseInt(golesVisitanteString);
		String resultado = golesLocal+ "-" + golasVisitante;
		
		Evento miEvento = new Evento(local, visitante, fecha);
		miEvento.setResultado(resultado);
				
		return miEvento;
	}

}

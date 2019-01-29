package com.acing.app;


import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.Collection;

import com.acing.eventos.Evento;
import com.acing.serial.SeralizarCSV;
import com.esotericsoftware.jsonbeans.Json;

public class App {

	public static void main(String[] args) {
	System.out.println("hola");
	
	String rutaJson ="datos/eventos.json";
	Json json = new Json();		
	
	Collection<Evento> eventos = SeralizarCSV.getEventos("SP1.CSV");
//	System.out.println(eventos);
	for (Evento evento : eventos) {
		System.out.println(evento);	
	}
	

	String eventosJson =json.prettyPrint(eventos);
	System.out.println(eventosJson);
	
	guardarStringFichero(eventosJson,rutaJson);
	
	guardarColeccionAJsonPorLineas(eventos, rutaJson);
	
}

	private static void guardarStringFichero (String texto, String ruta) {
		try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(ruta),"UTF-8"))){
			writer.write(texto);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void guardarColeccionAJsonPorLineas(Collection<Evento> eventos,String ruta) {
		Json json = new Json();
			try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(ruta),"UTF-8"))){
				for (Evento evento : eventos) {
					writer.write(json.toJson(evento));
					writer.newLine();
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
		}
	}
	
//	private static Collection<Evento> getEventosFromJson(String rutaarchivo){
//		Collection<Evento> eventosLeidos = new ArrayList<>();
//		Json json =  new Json();
//		
//		try(BufferedReader reader =  new BufferedReader(
//				new InputStreamReader(
//						new FileInputStream(rutaarchivo), "UTF-8"))){
//			String linea = reader.readLine();
//			
//			while ((linea = reader.readLine())!= null){
//				eventosLeidos.add(guardarStringFichero(texto, ruta);(linea));
//			}
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return null;
//	}
}

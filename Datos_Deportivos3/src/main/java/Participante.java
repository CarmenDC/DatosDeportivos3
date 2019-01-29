import java.util.HashMap;
import java.util.Map;

public class Participante {
	public static Map <String, Participante> mapaParticipantes = new HashMap<>();
	
	private String nombre;
	
	public Participante(String nombre) {
		this.nombre=nombre;
	}
	
	

	public Participante() {
		super();
	}



	@Override
	public String toString() {
		return " "+ nombre;
	}
	



}

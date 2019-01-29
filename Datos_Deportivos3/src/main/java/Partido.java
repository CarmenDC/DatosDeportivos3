
public class Partido implements Serializable{
	
	private String division;
	private String fecha;
	private String local;
	private String visitante;
	private String ganador;
	
	public Partido(String division, String fecha, String local, String visitante, String ganador) {
		super();
		this.division = division;
		this.fecha = fecha;
		this.local = local;
		this.visitante = visitante;
		this.ganador = ganador;
	}

	@Override
	public String toString() {
		return "Partido [division=" + division + ", fecha=" + fecha + ", local=" + local + ", visitante=" + visitante
				+ ", ganador=" + ganador + "]";
	}
	
	

}

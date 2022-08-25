package Caso1;

public class ProcesoIntermedio extends Thread
{
	private String mensaje;
	private Buzon buzonInicio;
	private Buzon buzonFin;
	private int nivel;
	private int id;
	
	public ProcesoIntermedio(Buzon inicio, Buzon fin)
	{
		this.buzonFin = fin;
		this.buzonInicio = inicio;
	}
	
	public void run()
	{
		this.mensaje = buzonInicio.enviarMensaje();
		
		modificarMensaje(mensaje);
		
		buzonFin.recibirMensaje(this.mensaje);
	}
	
	public void modificarMensaje(String mensaje)
	{
		this.mensaje = mensaje + "T" + nivel + id;
	}
}

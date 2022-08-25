
import java.util.concurrent.ThreadLocalRandom;

public class ProcesoIntermedio extends Thread
{
	private String mensaje;
	private Buzon buzonInicio;
	private Buzon buzonFin;
	private int nivel;
	private int id;
	
	public ProcesoIntermedio(Buzon inicio, Buzon fin, int nivel, int id)
	{
		this.buzonInicio = inicio;
		this.buzonFin = fin;
		this.nivel = nivel;
		this.id = id;
	}

	
	public void run()
	{
		this.mensaje = buzonInicio.enviarMensaje();
		
		if (!mensaje.equals("FIN"))
		{
			modificarMensaje(mensaje);
		}
		buzonFin.recibirMensaje(this.mensaje);
	}
	
	public void modificarMensaje(String mensaje)
	{
		try
		{
		Thread.sleep(ThreadLocalRandom.current().nextInt(50, 500));
		}catch(InterruptedException e)
		{
			e.printStackTrace();
		}

		this.mensaje = mensaje + "T" + nivel + id;
	}
}

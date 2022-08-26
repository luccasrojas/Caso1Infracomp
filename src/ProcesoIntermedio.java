
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
		System.out.println("Proceso intermedio " +this.nivel+ this.id + " iniciado"+" mi buzon de entrada es: " + String.valueOf(this.buzonInicio.id) + " mi buzon de salida es: " + String.valueOf(this.buzonFin.id));
		boolean condicion =true;
		while (condicion)
		{
			this.mensaje = buzonInicio.enviarMensaje();
			
			if (!mensaje.equals("FIN"))
			{
				modificarMensaje(mensaje);
				buzonFin.recibirMensaje(this.mensaje);
			}
			else
			{
				condicion = false;
				buzonFin.recibirMensaje(mensaje);
			}
			
		}
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

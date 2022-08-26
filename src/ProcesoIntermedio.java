
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ThreadLocalRandom;

public class ProcesoIntermedio extends Thread
{
	private String mensaje;
	private Buzon buzonInicio;
	private Buzon buzonFin;
	private int nivel;
	private int id;
	private CyclicBarrier barrera;
	
	public ProcesoIntermedio(Buzon inicio, Buzon fin, int nivel, int id, CyclicBarrier barrera)
	{
		this.buzonInicio = inicio;
		this.buzonFin = fin;
		this.nivel = nivel;
		this.id = id;
		this.barrera = barrera;
	}
	
	public void run()
	{
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
				if (this.nivel == 3)
				{
					try {
						this.barrera.await();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (BrokenBarrierException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
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

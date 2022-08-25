import java.util.LinkedList;

public class ProcesoFinal extends Thread
{
	private Buzon buzonFinal;
	private int numMensajes;
	private String resultado;
		
	public ProcesoFinal( Buzon inicial)
	{
		this.buzonFinal = inicial;	
			
	}
		
	public void run()
	{
		String mensaje = buzonFinal.enviarMensaje();
		while(mensaje != null)
		{
			resultado += mensaje + "\n";
		}
		
	}
		

}

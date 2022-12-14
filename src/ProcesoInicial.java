import java.util.ArrayList;

public class ProcesoInicial extends Thread
{
	private ArrayList<String> mensajes = new ArrayList<String>();
	private Buzon buzonInicial;
	private int numMensajes;
	
	public ProcesoInicial(int numMensajes, Buzon inicial)
	{
		this.numMensajes = numMensajes;
		this.buzonInicial = inicial;
		
		for (int i=1; i<= this.numMensajes; i++)
		{
			String mensaje = "M" + i;
			this.mensajes.add(mensaje);
		}
		
	}
	
	public void run()
	{
		for (String mensaje: mensajes)
		{
			if (buzonInicial.estaLleno())
			{
				Thread.yield();
			}
			buzonInicial.recibirMensaje(mensaje);
		}

		buzonInicial.recibirMensaje("FIN");
		buzonInicial.recibirMensaje("FIN");
		buzonInicial.recibirMensaje("FIN");
		
	}
	
}

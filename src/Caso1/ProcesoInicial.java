package Caso1;

import java.util.ArrayList;
import java.util.LinkedList;

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
			buzonInicial.recibirMensaje(mensaje);
		}
	}
	
}

package Caso1;

import java.util.LinkedList;

public class ProcesoFinal extends Thread
{
	private LinkedList<String> mensajes = new LinkedList<String>();
	private Buzon buzonFinal;
	private int numMensajes;
		
	public ProcesoFinal(LinkedList mensajes, Buzon inicial)
	{
		this.mensajes = mensajes;
		this.buzonFinal = inicial;	
			
	}
		
	public void run()
	{
		for (String mensaje: mensajes)
		{
			System.out.println(mensaje + "\n" );
		}
		
	}
		

}

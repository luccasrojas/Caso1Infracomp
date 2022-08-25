package Caso1;

import java.util.ArrayList;

public class Buzon 
{
	private ArrayList<String> mensajes = new ArrayList<String>();
	private int tamano;
	private int id;
	
	public synchronized void recibirMensaje (String mensaje)
	{
		while(mensajes.size()==tamano)
		{
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		mensajes.add(mensaje);
		notify();
	}
	
	public synchronized String enviarMensaje()
	{
		while(mensajes.size()== 0)
		{
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		String mensaje = mensajes.get(0);
		mensajes.remove(0);
		notify();
		
		return mensaje;
		
	}
	
}


import java.util.ArrayList;

public class Buzon 
{
	private ArrayList<String> mensajes = new ArrayList<String>();
	private int tamano;
	public int id;

	public Buzon(int tamano, int id)
	{
		this.tamano = tamano;
		this.id = id;
	}
	
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
	public synchronized boolean estaVacio()
	{
		return mensajes.size()==0;
	}
	public synchronized boolean estaLleno()
	{
		return mensajes.size()==tamano;
	}
	
}

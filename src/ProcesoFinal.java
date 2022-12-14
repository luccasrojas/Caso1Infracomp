public class ProcesoFinal extends Thread
{
	private Buzon buzonFinal;
	private String resultado="";
		
	public ProcesoFinal( Buzon inicial)
	{
		this.buzonFinal = inicial;	
			
	}
		
	public void run()
	{
		int contadorFin = 3;
		while(contadorFin!=0)
		{
			if (buzonFinal.estaVacio())
			{
				Thread.yield();
			}
			String mensaje = buzonFinal.enviarMensaje();
			if (mensaje.equals("FIN"))
			{
				contadorFin--;
			}
			if (contadorFin==0)
			{
			resultado += mensaje;
			}
			else
			{
			resultado += mensaje + ",";
			}
		}
		System.out.println(resultado);
		
	}
		

}

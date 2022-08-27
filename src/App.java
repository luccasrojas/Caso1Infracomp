import java.util.HashMap;
import java.util.concurrent.CyclicBarrier;


public class App {
    public static void main(String[] args) throws Exception 
    {
        int tamanioBuzonIntermedio;
        int tamanioBuzonExtremos;
        int numeroSubconjuntos;


        System.out.println("Escriba el tamaño del buzon inicial y final: ");
        tamanioBuzonExtremos = Integer.parseInt(System.console().readLine());

        System.out.println("Escriba el tamaño de los buzones intermedios: ");
        tamanioBuzonIntermedio = Integer.parseInt(System.console().readLine());

        System.out.println("Escriba el numero de subconjuntos: ");
        numeroSubconjuntos = Integer.parseInt(System.console().readLine());


        Buzon buzonInicial = new Buzon(tamanioBuzonExtremos,-1);

        Buzon buzonFinal = new Buzon(tamanioBuzonExtremos,-2);

        ProcesoInicial procesoinicial = new ProcesoInicial(numeroSubconjuntos, buzonInicial);
        procesoinicial.start();

        ProcesoFinal procesofinal = new ProcesoFinal(buzonFinal);
        procesofinal.start();

        HashMap<Integer,ProcesoIntermedio> procesosIntermedios = new HashMap<Integer,ProcesoIntermedio>();

        HashMap<Integer,Buzon> buzonesIntermedios = new HashMap<>();

        CyclicBarrier barrera = new CyclicBarrier(3);

        // i es columnas
        for (int i=1; i<=2;i++)
        {
            // j es filas
            for (int j=1; j<=3;j++)
            {
                buzonesIntermedios.put(i*10+j,new Buzon(tamanioBuzonIntermedio,i*10+j));
            }
        }

        for (int i=1; i<=3;i++)
        {
            for (int j=1; j<=3;j++)
            {
                if (i==1)
                {
                    procesosIntermedios.put(i*10 +j, new ProcesoIntermedio(buzonInicial, buzonesIntermedios.get(i*10+j), i, j,barrera));
                }

                else if(i==3)
                {
                    procesosIntermedios.put(i*10 +j, new ProcesoIntermedio(buzonesIntermedios.get((i-1)*10+j), buzonFinal, i, j,barrera));
                }

                else 
                {
                    procesosIntermedios.put(i*10 +j, new ProcesoIntermedio(buzonesIntermedios.get((i-1)*10+j), buzonesIntermedios.get(i*10+j), i, j,barrera));
                }

                procesosIntermedios.get(i*10+j).start();
                
            }
        }

    }
}

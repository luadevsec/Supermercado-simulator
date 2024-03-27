public class Entrada extends Thread{

    /* essa classe serve para controlar a entrada de clientes de forma paralela */

    public void run (){
        while(Supermercado.getClientes() > 0){
            Cliente cliente = Supermercado.entrar(); // decrementa o numero de clientes no supermercado e entra um novo cliente

            // adiciona o cliente na caixa com a menor fila
            Caixa menor = Supermercado.getFrota().get(0);
            for (Caixa caixa : Supermercado.getFrota()){
                if (caixa.getFila() < menor.getFila())
                    menor = caixa;
                
            }
            menor.addCliente(cliente);
            menor.addFilinha();

            try{
                int tempo = (int) (Math.random() * 6) + 1; // gera um numero aleatorio entre 1 a 6 para simbolizar o tempo de entrada de clientes
                Thread.sleep(200 * tempo); // tempo de entrada de clientes
            }catch(InterruptedException e){}
        }
    }

    
}

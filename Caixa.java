import java.util.ArrayList;

public class Caixa extends Thread{
    private ArrayList<Cliente> fila_dClientes = new ArrayList<Cliente>();
    private int id;
    public String filinha = "";

    public int getNum(){
        return this.id;
    }

    public void addFilinha(){
        this.filinha += Cliente.cliente;
    }

    public String getFilinha(){
        return this.filinha;
    }

    public void addCliente(Cliente cliente){
        fila_dClientes.add(cliente);
    }

    public int getFila(){
        return fila_dClientes.size();
    }

    public Caixa(int id){
        this.id = id;
    }

    public void atenderCliente(){
        Cliente cliente = fila_dClientes.get(0);
            try{
                
                Thread.sleep(cliente.time()); // desempacotar carrinho

                
            }catch(InterruptedException e){
                System.out.println("Erro ao atender cliente");
            } finally {
                fila_dClientes.remove(cliente);
                this.filinha = this.filinha.substring(Cliente.cliente.length());
                

            }
        
    }

    
    public void run(){
        while(Supermercado.getClientes() > 0 | getFila() > 0) {
            if (fila_dClientes.size() > 0){
                atenderCliente();
                continue; //evitar else               
            }
            try{
                Thread.sleep(2000);
            }catch(InterruptedException e){}

        }
        Supermercado.caixas--;
        this.filinha = "Fim do expediente !";
    }
}

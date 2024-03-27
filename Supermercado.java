import java.util.ArrayList;

public class Supermercado {
    private static final int NUM_CAIXAS = 6;
    private static int clientes = 10; //para fechar o programa
    private static ArrayList<Caixa> frota = new ArrayList<Caixa>();
    public static int caixas = 0;


    public static void abrir(){
        for(int i = 0; i < NUM_CAIXAS; i++){
            Caixa caixa = new Caixa(i + 1);
            frota.add(caixa);
            caixa.start();
            caixas++;
        }
    }

    public static ArrayList<Caixa> getFrota(){
        return frota;
    }

    public static Cliente entrar(){
        clientes -= 1;
        
        return new Cliente();
    }
    public static int getClientes(){
        return clientes;
    }


    private static void leitor (){
                    
        System.out.println("====================================");
        for(Caixa caixa : frota)
            System.out.println("Caixa " + caixa.getNum() + ": " + caixa.getFilinha());
            


        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){}
    }



    public static void main(String[] args) {
        abrir();
        Entrada entrada = new Entrada();
        entrada.start();

        while (caixas > 0){
            
            leitor(); // mostra os caixas com clientes

            
        }
        leitor(); // mostra os caixas vazios
    }

    
}

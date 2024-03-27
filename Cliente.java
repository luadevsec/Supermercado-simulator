public class Cliente {
    private int carrinho = 0; // quantidade de produtos no carrinho
    public static String cliente = ".=/i ";

    public Cliente() {
        this.carrinho = medir_carrinho() * 1000; // transforma de ms para s
    }

    private int medir_carrinho() {
        // gera um numero aleatorio entre 1 a 10 para simbolizar o tempo de atendimento de resolver aquele cliente
        return (int) (Math.random() * 10) + 1;
    }

    public int time() {
        return this.carrinho;
    }
}



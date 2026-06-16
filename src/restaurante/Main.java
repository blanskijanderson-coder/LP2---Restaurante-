package restaurante;

public class Main {

    public static void main(String[] args) {
        Comida prato1 = new Comida("Lasanha à Bolonhesa", 45.0, "Massa artesanal", "Trigo, carne, queijo e molho");
        Comida prato2 = new Comida("Filé com Fritas", 38.0, "Carne suculenta", "Carne bovina, batata, sal");
        Bebida suco1 = new Bebida("Suco de Uva", 12.0, "Fazenda Videira");
        Bebida refri1 = new Bebida("Coca-Cola 350ml", 7.0, "Distribuidora Regional");
        Cliente c1 = new Cliente("Janderson", "janderson@uneb.br", 5, 123456789);

        System.out.println("======= BEM-VINDO AO RESTAURANTE =======");
        c1.verCardapio();

        System.out.println("\n--- Realizando o Pedido ---");
        c1.solicitarPedido(prato1); 
        c1.solicitarPedido(suco1);  
        
        c1.enviarPedido(); 
        
        System.out.println("\n--- Painel da Cozinha ---");
        Cozinha.listarPedido(); 
        System.out.println("\n--- Finalizando Prato ---");
        Cozinha.entregarPedido(0); 

        System.out.println("\n--- Área de Pagamento ---");
        c1.pagarPedido(); 

        System.out.println("\n======= FIM DA SIMULAÇÃO =======");
    }
}
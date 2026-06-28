package restaurante;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // Criando alguns produtos iniciais
        new Comida("Lasanha à Bolonhesa", 45.0, "Massa artesanal", "Trigo, carne, queijo e molho");
        new Comida("Filé com Fritas", 38.0, "Carne suculenta", "Carne bovina, batata, sal");
        new Bebida("Suco de Uva", 12.0, "Fazenda Videira");
        new Bebida("Coca-Cola 350ml", 7.0, "Distribuidora Regional");

        Cliente c1 = new Cliente("Janderson", "janderson@uneb.br", "123456789", "teste".toCharArray(), false);

        System.out.println("======= BEM-VINDO AO RESTAURANTE =======");

        // 1. Escolher Mesa
        System.out.println("\n--- Escolhendo Mesa ---");
        c1.escolherMesa();

        // 2. Ver Cardápio
        System.out.println("\n--- Cardápio ---");
        c1.verCardapio();

        // 3. Realizando o Pedido
        System.out.println("\n--- Realizando o Pedido ---");

        // Simulando a escolha de itens do cardápio

        // 4. Painel da Cozinha
        System.out.println("\n--- Painel da Cozinha ---");
        Cozinha.listarPedido();

        System.out.println("\n--- Preparando e Entregando Prato ---");
        Cozinha.entregarPedido(0);

        // 5. Área de Pagamento
        System.out.println("\n--- Área de Pagamento ---");
        c1.pagarConta();

        System.out.println("\n======= FIM DA SIMULAÇÃO =======");
    }
}
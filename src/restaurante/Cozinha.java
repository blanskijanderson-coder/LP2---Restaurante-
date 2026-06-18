

package restaurante;

import java.util.ArrayList;

public class Cozinha {
    private static ArrayList<Cardapio> lista_produto = new ArrayList<>();
    private static ArrayList<Pedido> lista_pedidosGerais = new ArrayList<>();
    private static ArrayList<Conta> historico_contasGerais = new ArrayList<>();
    
    public static void addProduto(Cardapio outro){
        lista_produto.add(outro);
    }
    
    public static void addPedidoGeral(Pedido outro){
        lista_pedidosGerais.add(outro);
    }
    
    public static void listarPedido(){
        System.out.println("Segue lista com todos os pedidos dos clientes:");
        
        for (Pedido p : lista_pedidosGerais) {
        System.out.println(p); 
        System.out.println("--------------------------");
        }   
    }
    
    public static void entregarPedido(int indice) {
        if (indice >= 0 && indice < lista_pedidosGerais.size()) {
            
            Pedido pedidoPronto = lista_pedidosGerais.get(indice);

            pedidoPronto.setStatus("A pagar");
            
            System.out.println("Pedido entregue para: " + pedidoPronto.getCliente().getNome());
        } else {
            System.out.println("Índice de pedido inválido!");
        }
    }
    
    public static ArrayList<Cardapio> getListaProduto(){return lista_produto;}
    
    public static ArrayList<Pedido> getListaPedido(){return lista_pedidosGerais;}

}
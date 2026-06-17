
package restaurante;

import java.util.ArrayList;

public class Conta {
    private Cliente cliente;
    private double valor = 0;
    private double bonus = 0;
    private ArrayList<Pedido> lista_PedidosCliente = new ArrayList<>();
    
    
        public void addPedidoCliente(Pedido outro){
        lista_PedidosCliente.add(outro);
    }
}

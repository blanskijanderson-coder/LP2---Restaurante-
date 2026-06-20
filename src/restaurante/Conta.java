
package restaurante;

import java.util.ArrayList;

public class Conta {
    private Cliente cliente;
    private double valor = 0;
    private String status_conta;
    private ArrayList<Pedido> lista_PedidosCliente = new ArrayList<>();
    
    public Conta(Cliente cliente){
        this.cliente = cliente;
        this.status_conta = "Aberta";
    }

    
    public void addPedidoCliente(Pedido outro){
    lista_PedidosCliente.add(outro);
    }

    public void PagarConta(){
        for(Pedido feito : lista_PedidosCliente){
            this.valor += feito.calcularTotal();
        }
        this.cliente.setBonus(this.valor/10);
        this.status_conta = "Encerrada";
        this.cliente.setContaAtual(null);
    }
    
    public String getStatusConta(){return this.status_conta;}
}

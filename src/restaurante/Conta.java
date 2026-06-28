
package restaurante;

import java.util.ArrayList;

public class Conta {
    private Cliente cliente;
    private double valor = 0;
    private String status_conta;
    private ArrayList<Pedido> lista_PedidosCliente = new ArrayList<>();

    public Conta(Cliente cliente) {
        this.cliente = cliente;
        this.status_conta = "Aberta";
    }

    public void addPedidoCliente(Pedido outro) {
        lista_PedidosCliente.add(outro);
    }

    public double pagarConta() {
        this.valor = 0;
        for (Pedido feito : lista_PedidosCliente) {
            this.valor += feito.getTotal();
        }

        return this.valor;
    }

    public void finalizarConta() {
        this.setStatusConta("Encerrada");
        Cozinha.addContaHistorico(this);
    }

    public String getStatusConta() {return this.status_conta;}
    
    public ArrayList<Pedido> getListaPedidosCliente(){return this.lista_PedidosCliente;}

    public void setStatusConta(String status) {this.status_conta = status;}

}

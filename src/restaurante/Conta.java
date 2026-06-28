
package restaurante;

import java.util.ArrayList;

public class Conta {
    private Cliente cliente;
    private String mesa_conta;
    private double total_conta = 0;
    private String status_conta;
    private ArrayList<Pedido> lista_PedidosCliente = new ArrayList<>();

    public Conta(Cliente cliente, String mesa_numero) {
        this.cliente = cliente;
        this.status_conta = "Aberta";
        this.mesa_conta = mesa_numero;
    }

    public void addPedidoCliente(Pedido outro) {
        this.total_conta = 0;
        lista_PedidosCliente.add(outro);
        for (Pedido feito : lista_PedidosCliente) {
            this.total_conta += feito.getTotal();
        }
    }

    public double pagarConta() {
        this.total_conta = 0;
        for (Pedido feito : lista_PedidosCliente) {
            this.total_conta += feito.getTotal();
        }

        return this.total_conta;
    }

    public void finalizarConta() {
        this.setStatusConta("Paga");
        Cozinha.addContaHistorico(this);
    }
    
    public int getQtdPedidos(){
        int qtdPedidos = 0;
        for(Pedido numero : this.lista_PedidosCliente){
            qtdPedidos ++;
        }
        return qtdPedidos;
    }
    
    public double getTotalConta(){return total_conta;}
    
    public String getMesaConta(){return mesa_conta;}
    
    public String getStatusConta(){return status_conta;}
    
    public ArrayList<Pedido> getListaPedidosCliente(){return lista_PedidosCliente;}

    public void setStatusConta(String status){this.status_conta = status;}
    
    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return String.valueOf(this.mesa_conta);
    }
}

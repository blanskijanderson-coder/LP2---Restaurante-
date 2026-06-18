package restaurante;

import java.util.ArrayList;

public class Pedido {
    private String status;
    private Cliente cliente;
    private Mesa mesa_cliente;
    private ArrayList<Cardapio> itensSolicitados;

    public Pedido(Cliente cliente, Mesa mesa_cliente) {
        this.cliente = cliente;
        this.mesa_cliente = mesa_cliente;
        this.itensSolicitados = new ArrayList<>();
        this.status = "A fazer";
    }
    
    public void produtoSolicitado(Cardapio item) {
        this.itensSolicitados.add(item);
    }
    
    public void encerrarPedido(){
        Cozinha.addPedidoGeral(this);
        Conta.addPedidoCliente(this);
    }

    public double calcularTotal() {
    double total = 0;
        for (Cardapio item : itensSolicitados) {
            total += item.getCusto(); 
        }
    return total;
    }   
    
    
    public String getStatus() {return this.status;}

    public Cliente getCliente() {return this.cliente;}
    
    
    public void setStatus(String status) {this.status = status;}
    
    
    
    @Override
    public String toString() {
        String resumo = "Pedido do Cliente: " + this.cliente.getNome() + "\n";
        resumo += "Status: " + this.status + "\n";
        resumo += "Itens:\n";

        for (Cardapio item : itensSolicitados) {
            resumo += " - " + item.getNome() + " (R$ " + item.getCusto() + ")\n";
        }

        resumo += "Total: R$ " + this.calcularTotal() + "\n";
        return resumo;
    }

}
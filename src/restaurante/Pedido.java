package restaurante;

import java.util.ArrayList;

public class Pedido {
    private String status_pedido;
    private Cliente cliente;
    private Mesa mesa_cliente;
    private ArrayList<Cardapio> itensSolicitados = new ArrayList<>();
    private ArrayList<String> qtdSolicitada = new ArrayList<>();

    public Pedido(Cliente cliente, Mesa mesa_cliente) {
        this.cliente = cliente;
        this.mesa_cliente = mesa_cliente;
        this.itensSolicitados = new ArrayList<>();
        this.status_pedido = "A fazer";
    }
    
    public void produtoSolicitado(Cardapio item, String qtd) {
        this.itensSolicitados.add(item);
        this.qtdSolicitada.add(qtd);
    }
    
    public void finalizarPedido(){
        this.setStatusPedido("Em preparo");
        Cozinha.addPedidoGeral(this);
        cliente.getContaAtual().addPedidoCliente(this);
    }    
    
    public double calcularTotal() {
        double total = 0;
        int i = 0;
        for (Cardapio item : itensSolicitados) {
            total += item.getCusto() * Integer.parseInt(qtdSolicitada.get(i)); 
            i++;
        }
    return total;
    }       
    
    public String getStatus(){return this.status_pedido;}

    public Cliente getCliente(){return this.cliente;}
    
    public ArrayList<String> getQtdSolicitada(){return this.qtdSolicitada;}
    
    public ArrayList<Cardapio> getListaItensSolicitados(){return this.itensSolicitados;}
    
    public void setStatusPedido(String status){this.status_pedido = status;}
    
    
    
    @Override
    public String toString() {
        String resumo = "Pedido do Cliente: " + this.cliente.getNome() + "\n";
        resumo += "Status: " + this.status_pedido + "\n";
        resumo += "Itens:\n";

        for (int i = 0; i < itensSolicitados.size(); i++) {
            Cardapio item = itensSolicitados.get(i);
            int qtd = Integer.parseInt(qtdSolicitada.get(i));
            resumo += " - " + item.getNome() + " x" + qtd + " (R$ " + (item.getCusto() * qtd) + ")\n";
        }

        resumo += "Total: R$ " + this.calcularTotal() + "\n";
        return resumo;
    }
}
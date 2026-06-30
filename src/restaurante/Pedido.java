package restaurante;

import java.util.ArrayList;

public class Pedido {
    
    private int ordem;
    private double total;
    private String status_pedido;
    private Cliente cliente;
    private Mesa mesa_cliente;
    private ArrayList<Cardapio> itensSolicitados = new ArrayList<>();
    private ArrayList<String> qtdSolicitada = new ArrayList<>();

    public Pedido(Cliente cliente, Mesa mesa_cliente) {
    this.cliente = cliente;
    this.mesa_cliente = mesa_cliente;
    this.status_pedido = "A fazer";
    
    // CORRIGIDO: Força ambas as listas a nascerem limpas e isoladas em cada instância
    this.itensSolicitados = new ArrayList<>();
    this.qtdSolicitada = new ArrayList<>(); 
}
    
    public void produtoSolicitado(Cardapio item, String qtd) {
        this.itensSolicitados.add(item);
        this.qtdSolicitada.add(qtd);
    }
    
    public int calcularQtdProdutos(){
        int qtd = 0;
        for(String quantidade : this.qtdSolicitada){
            qtd += Integer.valueOf(quantidade);
        }        
        return qtd;
    }
    
    public void finalizarPedido(){
        this.setStatusPedido("Em preparo");
        Cozinha.addPedidoGeral(this);
        cliente.getContaAtual().addPedidoCliente(this);
    }    
     
    
    public void addTotal(double valor){this.total += valor;}
    
    public int getOrdem(){return this.ordem;}
    
    public double getTotal(){return this.total;}
    
    public String getStatus(){return this.status_pedido;}

    public Cliente getCliente(){return this.cliente;}
    
    public Mesa getMesa(){return this.mesa_cliente;}
    
    public ArrayList<String> getQtdSolicitada(){return this.qtdSolicitada;}
    
    public ArrayList<Cardapio> getListaItensSolicitados(){return this.itensSolicitados;}
    
    public void setOrdem(int numero){this.ordem = numero;}
    
    public void setStatusPedido(String status){this.status_pedido = status;}
    
    
    
    @Override
    public String toString() {
        return "Pedido nº" + this.ordem;
    }
}
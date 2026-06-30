
package restaurante;

import java.util.ArrayList;
import java.util.Scanner;

public class Cliente extends Cadastrado  { //falta acesso ao historico de contas
    
    private double bonus = 0;
    private Mesa mesa_atual;
    private Pedido pedido_novo;
    private Conta conta_atual;
    private ArrayList<Conta> historico_contasCliente = new ArrayList<>();

    public Cliente(String nome, String email, String cpf, 
                        char[] senha, boolean poderes_adm){
        
        super(nome, email, cpf, senha, poderes_adm);
        addListaCadastrados();
    }

    public void escolherMesa() {
        if (this.mesa_atual == null) {
            this.mesa_atual = new Mesa(this);
        } else {
            Mesa.liberarMesa(mesa_atual.getMesaNumero());
            this.mesa_atual = null;
            this.mesa_atual = new Mesa(this);
        }
    }

    public void verCardapio() {
        System.out.println("Segue cardápio de produtos ofertados:");
        int i = 1;
        for (Cardapio item : Cozinha.getListaProduto()) {
            System.out.println(i + " - " + item);
            i++;
        }
    }

    public void PedirNovosItens(Cardapio item, String quantidade) {
        if (this.pedido_novo != null) {
            this.pedido_novo.produtoSolicitado(item, quantidade);
            
        } else {
            System.out.println("Abra um pedido primeiro");
        }
    }

    public void enviarPedido() {
        if (this.pedido_novo != null) {
            this.pedido_novo.finalizarPedido();
            this.pedido_novo = null;
            System.out.println("Pedido enviado para a cozinha!");
        } else {
            System.out.println("Você ainda não adicionou itens ao seu pedido.");
        }
    }

    public void pagarConta() {
        if (this.conta_atual != null && this.conta_atual.getStatusConta().equals("Aberta")) {

            Scanner scanner = new Scanner(System.in);
            double valor = this.conta_atual.pagarConta();

            double valorComDesconto = valor - this.bonus;
            this.bonus = 0;

            System.out.println("deseja pagar com crédito ou débito? (digite C para crédito ou D para débito");
            String pagamentoModo = scanner.nextLine();

            System.out.println(this.getNome() + " pagou R$ " + valorComDesconto + " utilizando o modo de pagamento "
                    + pagamentoModo + ". Obrigado!");

            this.conta_atual.finalizarConta();

            this.bonus = valor / 10;
            Mesa.liberarMesa(this.mesa_atual.getMesaNumero());
            this.conta_atual = null;
            this.mesa_atual = null;
        }
    }
    
    public void addHistoricoCliente(Conta nova){
        historico_contasCliente.add(nova);
    }
    
    public double getBonus(){return bonus;}
    
    public Pedido getPedidoAtual(){return pedido_novo;}

    public Mesa getMesaAtual(){return mesa_atual;}

    public Conta getContaAtual(){return conta_atual;}
    
    public ArrayList<Conta> getHistoricoCliente(){return historico_contasCliente;}

    public void setBonus(double valorBonus){this.bonus = valorBonus;}
    
    public void setPedidoAtual(Pedido novo){this.pedido_novo = novo;}

    public void setContaAtual(Conta mudada){this.conta_atual = mudada;}
    public void setMesaAtual(Mesa mesa){ this.mesa_atual = mesa; } //somente usado para resetar mesa ao pagar conta.
    
    @Override
    public String toString() {
        return this.getNome();
    }
}
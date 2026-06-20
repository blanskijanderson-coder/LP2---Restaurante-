
package restaurante;

import java.util.ArrayList;
import java.util.Scanner;



public class Cliente{
    private String nome;
    private String email;
    private int cpf;
    private double bonus = 0;
    private Conta conta_atual;
    private Pedido pedido_novo;
    private Mesa mesa_atual;
    private ArrayList<Conta> historico_contasCliente = new ArrayList<>();
    
    public Cliente(String nome, String email, int cpf){
    this.nome = nome;
    this.email = email;
    this.cpf = cpf;
    }    
    
     
    public void escolherMesa(){ // quando encerrar a conta, a mesa nulificar mesa atual
        if(this.mesa_atual == null){
            this.mesa_atual = new Mesa(this);
        }
        else{
            System.out.println("você ja possui uma mesa.");
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
    
    public void solicitarPedido(Cardapio item) {
        if(this.mesa_atual != null){
            if(this.conta_atual != null){
                if (this.pedido_novo == null) {
                    this.pedido_novo = new Pedido(this, this.mesa_atual);
                }
            }
            else{
                this.conta_atual = new Conta(this);
                this.pedido_novo = new Pedido(this, this.mesa_atual);
            }
            this.pedido_novo.produtoSolicitado(item); 
        }
        else{
            System.out.println("Escolha uma mesa primeiro.");
        }
    }

    public void enviarPedido() {
    if (this.pedido_novo != null) {
        this.pedido_novo.setStatus("Em preparo");
        this.pedido_novo.finalizarPedido();
        
        this.pedido_novo = null; //o pedido atual tem que ficar nulo pra ele fazer outro pedido, mas se ele para de apontar para  pedido atual, como a cozinha pode devolver ?
        
        System.out.println("Pedido enviado para a cozinha!");
    } else {
        System.out.println("Você ainda não adicionou itens ao seu pedido.");
    }
}
    
    public void pagarConta() {
    if (this.conta_atual != null && this.conta_atual.getStatus().equals("Aberta")) {
        
        Scanner scanner = new Scanner(System.in);
        
        double valor = this.pedido_novo.calcularTotal();
        
        double valorComDesconto = valor - this.bonus;
        this.bonus = 0;
        
        
        System.out.println("deseja pagar com crédito ou débito? (digite C para crédito ou D para débito");
        String pagamentoModo = scanner.nextLine();
        
        
        System.out.println(this.nome + " pagou R$ " + valorComDesconto + " utilizando o modo de pagamento " + pagamentoModo + ". Obrigado!");
        this.pedido_novo = null; 
        this.mesa_atual = null;
        } else {
        System.out.println("O pedido ainda não está pronto para pagamento ou não existe.");
        }
    }
    
    
    public String getNome(){return nome;}
    
    public String getEmail(){return email;}
    
    public int getCpf(){return cpf;}
    
    public Mesa getMesa(){return mesa_atual;}
    
    public Conta getContaAtual (){return conta_atual;}
    
    public double getBonus(){return bonus;}
    
        
    public void setBonus(double valorBonus){this.bonus = valorBonus;}
    
    public void setContaAtual(Conta mudada){this.conta_atual = mudada;}
}

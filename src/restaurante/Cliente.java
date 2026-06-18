
package restaurante;

import java.util.ArrayList;
import java.util.Scanner;



public class Cliente{
    private String nome;
    private String email;
    private int cpf;
    private double bonus = 0;
    private Conta conta_atual;
    private Pedido pedido_atual;
    private Mesa mesa_atual;
    private ArrayList<Conta> historico_contas = new ArrayList<>();
    
    public Cliente(String nome, String email, int cpf){
    this.nome = nome;
    this.email = email;
    this.cpf = cpf;
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
                if (this.pedido_atual == null) {
                    this.pedido_atual = new Pedido(this);
                }
            }
        }
    this.pedido_atual.produtoSolicitado(item); 
    }
    
    public void escolherMesa(){ // quando encerrar a conta, a mesa virará zero de novo.
        if(this.mesa_atual == null){
            this.mesa_atual = new Mesa(this);
        }
        else{
            System.out.println("você ja possui uma mesa.");
        }
    }

    public void enviarPedido() {
    if (this.pedido_atual != null) {
        this.pedido_atual.setStatus("Em preparo");
        this.pedido_atual.encerrarPedido(); 
        System.out.println("Pedido enviado para a cozinha!");
    } else {
        System.out.println("Você ainda não adicionou itens ao seu pedido.");
    }
}
    
    public void pagarConta() {
    if (this.pedido_atual != null && this.pedido_atual.getStatus().equals("A pagar")) {
        
        Scanner scanner = new Scanner(System.in);
        
        double valor = this.pedido_atual.calcularTotal();
        
        double valorComDesconto = valor - this.bonus;
        this.bonus = 0;
        
        
        System.out.println("deseja pagar com crédito ou débito? (digite C para crédito ou D para débito");
        String pagamentoModo = scanner.nextLine();
        
        
        System.out.println(this.nome + " pagou R$ " + valorComDesconto + " utilizando o modo de pagamento " + pagamentoModo + ". Obrigado!");
        this.pedido_atual = null; 
        this.mesa = 0;
        } else {
        System.out.println("O pedido ainda não está pronto para pagamento ou não existe.");
        }
    }
    
    
    
    public String getNome(){return nome;}
    
    public String getEmail(){return email;}
    
    public int getCpf(){return cpf;}
    
    public int getMesa(){return mesa;}
    
    public double getBonus(){return bonus;}
}

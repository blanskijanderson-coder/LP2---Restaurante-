
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
    
     
    public void escolherMesa(){
        if(this.mesa_atual == null){
            this.mesa_atual = new Mesa(this);
            this.mesa_atual.selectMesa();
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
                    this.pedido_novo.setStatus
                }
                else{
                    System.out.println("Ja possui um pedido aberto.");
                }
            }
            else{
                this.conta_atual = new Conta(this);
                this.pedido_novo = new Pedido(this, this.mesa_atual);
            }
        }
        else{
            System.out.println("Escolha uma mesa primeiro.");
        }
    }
    
    //metodo pedido: tornar possivel solicitar novas coisas com o pedido em aberto.
    public void PedirNovosItens(){
        if(this.pedido_novo != null){
            this.pedido_novo.produtoSolicitado(item); 
        }
        else{
            System.out.println("abra um pedido primeiro");
        }
    }
    

    public void enviarPedido() {
    if (this.pedido_novo != null) {
        this.pedido_novo.setStatusPedido("Em preparo");
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
        
        
        System.out.println(this.nome + " pagou R$ " + valorComDesconto + " utilizando o modo de pagamento " + pagamentoModo + ". Obrigado!");
        this.bonus = valor/10;
        this.conta_atual = null; 
        this.mesa_atual = null;
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


package restaurante;

public abstract class Cardapio {
    protected String nome;
    protected double custo;
    protected int qtd;
    
    public Cardapio(String nome, double custo, int qtd){
        this.nome = nome;
        this.custo = custo;
        this.qtd = qtd;
    }
    
    
    
    public Cardapio getCardapio(){return this;}
    
    public String getNome(){return nome;}
    
    public double getCusto(){return custo;}
    
    public abstract String getDetalhes();
    
    
    @Override
    public String toString() {
        return this.nome + " - R$ " + this.custo + " | " + getDetalhes();
    }
}
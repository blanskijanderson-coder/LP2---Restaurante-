package restaurante;

public class Bebida extends Cardapio{
    private String fornecedor;
    
    public Bebida(String nome, double custo, int qtd, String fornecedor){
        super(nome, custo, qtd);
        this.fornecedor = fornecedor;
        Cozinha.addProduto(this);
    }
    
    @Override
    public String getDetalhes() {
        return "Fornecedor: " + this.fornecedor;
   }
    
}

package restaurante;

public class Bebida extends Cardapio{
    private String fornecedor;
    
    public Bebida(String nome, double custo, String fornecedor){
        super(nome, custo);
        this.fornecedor = fornecedor;
        Cozinha.addProduto(this);
    }
    
    @Override
    public String getDetalhes() {
        return "Fornecedor: " + this.fornecedor;
   }
    
}

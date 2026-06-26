package restaurante;

import java.util.ArrayList;

public class Bebida extends Cardapio{
    private String fornecedor;
    private static ArrayList<Bebida> lista_bebida = new ArrayList<>();
    
    public Bebida(String nome, double custo, String fornecedor){
        super(nome, custo);
        this.fornecedor = fornecedor;
        Cozinha.addProduto(this);
        lista_bebida.add(this);
    }
    
    public static ArrayList<Bebida> getListaBebida(){return lista_bebida;}
    
    @Override
    public String getDetalhes() {
        return "Fornecedor: " + this.fornecedor;
   }
    
}

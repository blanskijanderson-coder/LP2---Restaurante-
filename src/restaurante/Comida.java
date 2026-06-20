package restaurante;

import java.util.ArrayList;


public class Comida extends Cardapio{
    private String desc;
    private String ingred;
    
    public Comida(String nome, double custo, int qtd, String desc, String ingred){
        super(nome, custo, qtd);
        this.desc = desc;
        this.ingred = ingred;
        Cozinha.addProduto(this);
    }
    
    @Override
    public String getDetalhes() {
        return "Ingredientes: " + this.ingred;
    }
}

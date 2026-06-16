package restaurante;

import java.util.ArrayList;


public class Comida extends Cardapio{
    private String desc;
    private String ingred;
    
    public Comida(String nome, double custo, String desc, String ingred){
        super(nome, custo);
        this.desc = desc;
        this.ingred = ingred;
        Cozinha.addProduto(this);
    }
    
    @Override
    public String getDetalhes() {
        return "Ingredientes: " + this.ingred;
    }
}

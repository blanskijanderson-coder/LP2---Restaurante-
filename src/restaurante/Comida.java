package restaurante;

import java.util.ArrayList;


public class Comida extends Cardapio{
    private String desc;
    private String ingred;
    private static ArrayList<Comida> lista_comida = new ArrayList<>();
    
    public Comida(String nome, double custo, String desc, String ingred){
        super(nome, custo);
        this.desc = desc;
        this.ingred = ingred;
        Cozinha.addProduto(this);
        lista_comida.add(this);
    }
    
    public static ArrayList<Comida> getListaComida(){return lista_comida;}
    
    public String getIngredientes(){return this.ingred;}
    
    public String getDescricao(){return this.desc;}
    
    @Override
    public String getDetalhes() {
        return this.nome;
    }
}

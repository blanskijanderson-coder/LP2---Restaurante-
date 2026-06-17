package restaurante;

import java.util.ArrayList;

public class Mesa {
    private static int qtd_mesa = 40;
    private static ArrayList<Integer> lista_MesasOcupds = new ArrayList<>();
    private int mesa_Atual;
    private Pedido pedido;
    private Cliente cliente;
    
    public Mesa(Pedido pedido, Cliente cliente){
        this.pedido = pedido;
        this.cliente = cliente;
    }
    
    
    public void selectMesa(int numero){
        if(numero > qtd_mesa){
            for(int i = 0; i < lista_MesasOcupds.size(); i ++){
                if (lista_MesasOcupds.get(i) != numero){
                    lista_MesasOcupds.add(numero);
                    this.mesa_Atual = numero;
                }
                else{
                    System.out.println("Mesa ocupada");
                }
            }
            System.out.println("Mesa invalida");
        }
    }
     
    
    
    
    
    public void setQtdMesa(int quantidade){
    qtd_mesa = quantidade;
    }
}

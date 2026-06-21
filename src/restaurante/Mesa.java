package restaurante;

import java.util.ArrayList;
import java.util.Scanner;

public class Mesa {
    private static int qtd_mesa = 40;
    private static ArrayList<Integer> lista_MesasOcupds = new ArrayList<>();
    private int mesa_numero;
    private Cliente cliente;
    
    public Mesa(Cliente cliente){
        this.cliente = cliente;
        selectMesa();
    }
    
    
    
    public void selectMesa(){
        int numero;
        Scanner scanner = new Scanner(System.in);
        System.out.println("digite o número da mesa escolhida");
        numero = scanner.nextInt();
        
        if(numero < qtd_mesa){
            for(int i = 0; i < lista_MesasOcupds.size(); i ++){
                if (lista_MesasOcupds.get(i) != numero){
                    lista_MesasOcupds.add(numero);
                    this.mesa_numero = numero;
                }
                else{
                    System.out.println("Mesa ocupada");
                }
            }
            System.out.println("Mesa invalida");
        }
    }
    
    
    public int getMesaNumero(){return mesa_numero;}
    
    public void setQtdMesa(int quantidade){qtd_mesa = quantidade;}
}

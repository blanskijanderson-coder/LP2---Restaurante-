package restaurante;

import java.util.ArrayList;
import java.util.Scanner;

public class Mesa {
    private static int qtd_mesa = 40;
    private static ArrayList<String> lista_MesasOcupds = new ArrayList<>();

    private String mesa_numero;
    private Cliente cliente;

    public Mesa(Cliente cliente) {
        this.cliente = cliente;
    }

    public static void liberarMesa(String numero) {
        if (lista_MesasOcupds.contains(numero)) {
            lista_MesasOcupds.remove(numero);
            System.out.println("Mesa " + numero + " agora está livre.");
        }
    }


    public String getMesaNumero(){return mesa_numero;}
    
    public static ArrayList<String> getListaMesa(){return lista_MesasOcupds;}
    
    public static int getQtdMesa(){return qtd_mesa;}
    
    public void setMesaNumero(String numero){this.mesa_numero = numero;}

    public static void setQtdMesa(int quantidade){qtd_mesa = quantidade;}
}
package restaurante;

import java.util.ArrayList;
import java.util.Scanner;

public class Mesa {
    private static int qtd_mesa = 40;
    private static ArrayList<Integer> lista_MesasOcupds = new ArrayList<>();

    private int mesa_numero;
    private Cliente cliente;

    public Mesa(Cliente cliente) {
        this.cliente = cliente;
    }

    public static void liberarMesa(int numero) {
        if (lista_MesasOcupds.contains(numero)) {
            lista_MesasOcupds.remove(Integer.valueOf(numero));
            System.out.println("Mesa " + numero + " agora está livre.");
        }
    }

    public void selectMesa() {
        Scanner scanner = new Scanner(System.in);
        boolean mesaSelecionada = false;

        while (!mesaSelecionada) {
            System.out.println("Digite o número da mesa escolhida (0 a " + (qtd_mesa - 1) + "):");
            int numero = scanner.nextInt();
            if (numero >= 0 && numero < qtd_mesa) {
                if (lista_MesasOcupds.contains(numero)) {
                    System.out.println("Mesa já está ocupada. Por favor, escolha outra.");
                } else {
                    lista_MesasOcupds.add(numero);
                    this.mesa_numero = numero;
                    System.out.println("Mesa " + numero + " reservada com sucesso para o cliente!");
                    mesaSelecionada = true;
                }

            } else {
                System.out.println("Mesa inválida. Tente novamente.");
            }
        }
    }

    public int getMesaNumero(){return mesa_numero;}

    public static void setQtdMesa(int quantidade){qtd_mesa = quantidade;}
}
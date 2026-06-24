package restaurante;

public class Administrador extends Cadastrado{
    
    public Administrador(String nome, String email, String cpf, 
                              char[] senha, boolean poderes_adm){
        
        super(nome, email, cpf, senha, poderes_adm);
    }
    
    //metodo mudar qtd mesas -> usa setmesa
    
    //metodos da classe cardápio:
    //adicionar itens de cardápio
    //remover itens da classe cardápio
    //modificar itends da classe cardápio
    
    //metodos da classe cozinha:
    //entregar pedidos -> junto com lista dos pedidosgerais
    //acessar listas(pedidosGerais, contasGerais, contas de um cliente, listaCardápio).
}

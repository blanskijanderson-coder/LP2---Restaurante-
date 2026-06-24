package restaurante;

public class Administrador extends Cadastrado{
    
    public Administrador(String nome, String email, String cpf, 
                              char[] senha, boolean poderes_adm){
        
        super(nome, email, cpf, senha, poderes_adm);
        addListaCadastrados();
    }
    
    //metodo mudar qtd mesas -> usa setmesa OK
    
    //metodos da classe cardápio:  
    //adicionar itens de cardápio       
    //remover itens da classe cardápio 
    //modificar itends da classe cardápio
    
    //metodos da classe cozinha:
    //entregar pedidos -> junto com lista dos pedidosgerais
    //Quando o pedido é entregue, ele muda de status
    //A conta só pode ser paga se todos os pedidos forem entregues
    
    //acessar listas(pedidosGerais, contasGerais, contas de um cliente, listaCardápio).
    //não sei se este ultimo é necessário mas está OK
}

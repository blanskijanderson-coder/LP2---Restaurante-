package restaurante;

public class Administrador extends Cadastrado{
    
    public Administrador(String nome, String email, String cpf, 
                              char[] senha, boolean poderes_adm){
        
        super(nome, email, cpf, senha, poderes_adm);
        addListaCadastrados();
    }
    
    @Override
    public String toString() {
        return this.getNome();
    }
}

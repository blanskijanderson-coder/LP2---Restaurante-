package restaurante;

import java.util.ArrayList;

public class Cadastrado {
    
    private String nome;
    private String email;
    private String cpf;
    private char[] senha;
    private boolean poderes_adm;
    private static ArrayList<Cadastrado> lista_Cadastrados = new ArrayList<>();
    
    public Cadastrado(String nome, String email, String cpf, 
                           char[] senha, boolean poderes_adm){
        
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.senha = senha;
        this.poderes_adm = poderes_adm;
    }
    
    public Cadastrado getCadastrado(){return this;}
    
    public String getNome(){return nome;}

    public String getEmail(){return email;}

    public String getCpf(){return cpf;}
    
    public ArrayList<Cadastrado> getClientesCadastrados(){return lista_Cadastrados;}
}

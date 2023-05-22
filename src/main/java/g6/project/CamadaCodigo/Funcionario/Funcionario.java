package g6.project.CamadaCodigo.Funcionario;

import java.util.Set;

public class Funcionario {
    private int idFuncionario;
    private int cpf;
    private String nome;
    private String telefone;
    private String email;
    private float salario;
    public int getCpf() {
        return cpf;
    }
    public String getEmail() {
        return email;
    }
    public int getIdFuncionario() {
        return idFuncionario;
    }
    public String getNome() {
        return nome;
    }
    public float getSalario() {
        return salario;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setCpf(int cpf) {
        this.cpf = cpf;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setSalario(float salario) {
        this.salario = salario;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public void efetuarVenda(){
        return;
    }
}

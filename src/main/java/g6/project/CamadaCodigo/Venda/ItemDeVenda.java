package g6.project.CamadaCodigo.Venda;

public class ItemDeVenda {
    String nome;
    float valor;
    public ItemDeVenda(String nome, float valor){
        setNome(nome);
        setValor(valor);
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setValor(float valor) {
        this.valor = valor;
    }
    public String getNome() {
        return nome;
    }
    public float getValor() {
        return valor;
    }
    public float calculaValor(){
        return 0;
    }
}

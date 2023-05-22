package g6.project.CamadaCodigo.Produto;

public class Produto {
    private int codigoProduto;
    private int lote;
    private String nomeProduto;
    //getters
    public int getCodigoProduto() {
        return codigoProduto;
    }
    public int getLote() {
        return lote;
    }
    public String getNomeProduto() {
        return nomeProduto;
    }
    //setters
    public void setCodigoProduto(int codigoProduto) {
        this.codigoProduto = codigoProduto;
    }
    public void setLote(int lote) {
        this.lote = lote;
    }
    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }
}

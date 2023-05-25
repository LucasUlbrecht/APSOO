package g6.project.CamadaCodigo.Produto;

public class Produto {
    private int codigoProduto;
    private int lote;
    private String nomeProduto;
    public Produto(int codigoProduto, int lote, String nomeProduto){
        setCodigoProduto(codigoProduto);
        setLote(lote);
        setNomeProduto(nomeProduto);
    }
    public int getCodigoProduto() {
        return codigoProduto;
    }
    public int getLote() {
        return lote;
    }
    public String getNomeProduto() {
        return nomeProduto;
    }
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

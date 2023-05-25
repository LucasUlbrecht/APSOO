package g6.project.CamadaCodigo.Produto;

public class ProdutoVendivel extends Produto {
    public ProdutoVendivel(int codigoProduto, int lote, String nomeProduto, float valor) {
        super(codigoProduto, lote, nomeProduto);
        setValor(valor);
    }
    private float valor;
    public void setValor(float valor) {
        this.valor = valor;
    }
    public float getValor() {
        return valor;
    }
}

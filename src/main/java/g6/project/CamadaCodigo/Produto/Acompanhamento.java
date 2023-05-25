package g6.project.CamadaCodigo.Produto;

public class Acompanhamento extends Produto{
    public Acompanhamento(int codigoProduto, int lote, String nomeProduto, int quantidadeEstoque) {
        super(codigoProduto, lote, nomeProduto);
        setQuantidadeEstoque(lote);
    }
    @Override
    public int getCodigoProduto() {
        return super.getCodigoProduto();
    }
    private int quantidadeEstoque;
    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }
    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }
}

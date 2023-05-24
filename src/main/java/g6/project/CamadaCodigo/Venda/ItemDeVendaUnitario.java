package g6.project.CamadaCodigo.Venda;

import g6.project.CamadaCodigo.Produto.ProdutoVendivel;

public class ItemDeVendaUnitario extends ItemDeVenda{
    private int quantidade;
    private int codigoItem;
    private ProdutoVendivel prodVend;
    public ItemDeVendaUnitario(String nome, int codigoItem, int quantidade, ProdutoVendivel prodVend, float valor){
        super(nome, valor);
        setCodigoItem(codigoItem);
        setProdVend(prodVend);
        setQuantidade(quantidade);
        
    }
    public ProdutoVendivel getProdVend() {
        return prodVend;
    }
    public int getCodigoItem() {
        return codigoItem;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public void setProdVend(ProdutoVendivel prodVend) {
        this.prodVend = prodVend;
    }
    public void setCodigoItem(int codigoItem) {
        this.codigoItem = codigoItem;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    public float calculaValor(){
        return prodVend.getValor();
    }
}

package g6.project.CamadaCodigo.Venda;

import g6.project.CamadaCodigo.Produto.ProdutoVendivel;

public class ItemDeVendaPeso extends ItemDeVenda{
    private float peso;
    private ProdutoVendivel prodVend;
    public ItemDeVendaPeso(ProdutoVendivel prodVend, String nome, float peso, float valor){
        super(nome, valor);
        setProdVend(prodVend);
        setPeso(peso);
    }
    public ProdutoVendivel getProdVend() {
        return prodVend;
    }
    public void setValor(float valor) {
        this.valor = valor;
    }
    public void setProdVend(ProdutoVendivel prodVend) {
        this.prodVend = prodVend;
    }
    public float getPeso() {
        return peso;
    }
    public void setPeso(float peso) {
        this.peso = peso;
    }
    public float calculaValor(){
        return getPeso()*prodVend.getValor();
    }
    public void cancelarVenda(ItemDeVendaPeso item) {
        item = null;
    }
}

package g6.project.CamadaCodigo.Venda;

import g6.project.CamadaCodigo.Produto.ProdutoVendivel;

public class ItemDeVendaPeso {
    private float peso;
    private ProdutoVendivel prodVend;
    public ItemDeVendaPeso(ProdutoVendivel prodVend, float peso){
        setProdVend(prodVend);
        setPeso(peso);
    }
    public ProdutoVendivel getProdVend() {
        return prodVend;
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
}

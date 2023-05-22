package g6.project.CamadaCodigo.Produto;

import java.util.ArrayList;

public class Sorvete extends ProdutoVendivel{
    private int quantidadeEstoque;
    private ArrayList<Acompanhamento> acompanhamento;
    public ArrayList<Acompanhamento> getAcompanhamento() {
        return acompanhamento;
    }
    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }
    public void setAcompanhamento(ArrayList<Acompanhamento> acompanhamento) {
        this.acompanhamento = acompanhamento;
    }
    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }
}

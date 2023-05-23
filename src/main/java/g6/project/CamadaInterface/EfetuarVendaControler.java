package g6.project;
//g6.project.CamadaInterfaceEfetuarVendaControler
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import g6.project.CamadaCodigo.Venda.Pagamento;
import g6.project.CamadaCodigo.Venda.Venda;
import g6.project.CamadaCodigo.Funcionario.Funcionario;
import g6.project.CamadaCodigo.Venda.ItemDeVendaPeso;
import g6.project.CamadaCodigo.Venda.ItemDeVendaUnitario;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class EfetuarVendaControler {
    @FXML
    private TextField pesquisarCodBarras;
    @FXML
    private TextField inserirPeso;
    @FXML
    private Button confirmarPagamentoButton;

    private ArrayList<ItemDeVendaPeso> listaItensPeso;
    private ArrayList<ItemDeVendaUnitario> listaItensUnitario;
    private Pagamento pagamento;
    private Funcionario funcionario;
    private Venda venda;
    private float valorTotal;
    private Venda v;
    public Venda getVenda() {
        return venda;
    }
    public Funcionario getFuncionario() {
        return funcionario;
    }
    public Pagamento getPagamento() {
        return pagamento;
    }
    public float getValorTotal() {
        return valorTotal;
    }
    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }
    public void setVenda(Venda venda) {
        this.venda = venda;
    }
    public ArrayList<ItemDeVendaPeso> getListaItemDeVendaPeso() {
        return listaItensPeso;
    }
    public void associarListaItemDeVendaPeso(ItemDeVendaPeso ListaDeVendaPesoNova){
        this.listaItensPeso.add(ListaDeVendaPesoNova);
    }
    public void setListaItensPeso(ArrayList<ItemDeVendaPeso> listaItensPeso) {
        this.listaItensPeso = listaItensPeso;
    }
    public void setListaItensUnitario(ArrayList<ItemDeVendaUnitario> listaItensUnitario) {
        this.listaItensUnitario = listaItensUnitario;
    }
    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    @FXML
    public void cancelarVenda(){
        setPagamento(null);
        setListaItensPeso(null);
        setListaItensUnitario(null);
        setFuncionario(null);
        setValorTotal(0);
        return;
    }
    @FXML
    public void tipoPagamento(){
        //gerar tela tipoPagamento
        //set new scene;
        //meubotao.setOnAction(event->{
        //  Pagamento tmp = new Pagamento("Tipo pagamento");  
        //  })
        //  retorna a antiga scene ou deleta essa nova cena;
        //  setPagamento(tmp)
        return;
    }
    @FXML
    public void adicionarItemVendaPeso(float peso){
        int cod=1;
        ItemDeVendaPeso tmp;
        //Conexao.conectar();
        //tmp=new ItemDeVendaPeso(DAOVendivel.get(cod), peso);
        //this.associarListaItemDeVendaPeso(tmp);
        //this.setValorTotal(this.getValorTotal()+tmp.calculaValor());
        //criar novo root com nome e valor na label e adicionar na scene
        //Conexao.desconectar();
        return;
    }
    @FXML
    public void adicionarItemVendaUnitario(int cod){
        ItemDeVendaUnitario tmp;
        //Conexao.conectar();
        //tmp=new ItemDeVendaUnitario(cod, 1, DAOVendivel.get(cod));
        //this.associarListaItemDeVendaPeso(tmp);
        //this.setValorTotal(this.getValorTotal()+tmp.calculaValor());
        //criar novo root com nome e valor na label e adicionar na scene
        //Conexao.desconectar();
    }
    @FXML
    public void confirmar(){
        //Conexao.conectar();
        //do{cod=gerarRandomCod}while(VendaDAO.get(cod)!=NULL);
        //v = new Venda(getListaDeVendaUnitario(), getListaDeVendaPeso(), getFuncionario(), getPagamento(), getValorVenda(), getCodigoVenda());
        //vendaDAO.insert(v);
        //Conexao.desconectar();
        return;
    }
}

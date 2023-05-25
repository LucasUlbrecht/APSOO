package g6.project;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

import g6.project.CamadaCodigo.Venda.Pagamento;
import g6.project.CamadaCodigo.Venda.Venda;
import g6.project.CamadaPersistencia.Implementacao.ImplementacaoProdutoVendidvel;
import g6.project.CamadaPersistencia.Implementacao.ImplementacaoVendaDAO;
import g6.project.CamadaCodigo.Funcionario.Funcionario;
import g6.project.CamadaCodigo.Produto.ProdutoVendivel;
import g6.project.CamadaCodigo.Venda.ItemDeVenda;
import g6.project.CamadaCodigo.Venda.ItemDeVendaPeso;
import g6.project.CamadaCodigo.Venda.ItemDeVendaUnitario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Node;

public class EfetuarVendaControler implements Initializable{
    @FXML
    private TextField pesquisarCodBarras;
    @FXML
    private TextField inserirPeso;
    @FXML
    private Button confirmarPagamentoButton;
    @FXML
    private TableView<ItemDeVenda> tabela;
    @FXML
    private TableColumn<ItemDeVenda, String> tabelaProdutoNome;
    @FXML
    private TableColumn<ItemDeVenda, Float> tabelaProdutoPreco;
    @FXML
    private Label totalLabel;
    Stage popupPagamento;
    Button pixButton;
    Button dinheiroButton;
    Button cartaoButton;
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
    public ArrayList<ItemDeVendaUnitario> getListaItemDeVendaUnitario() {
        return listaItensUnitario;
    }
    public void associarListaItemDeVendaPeso(ItemDeVendaPeso ListaDeVendaPesoNova){
        this.listaItensPeso.add(ListaDeVendaPesoNova);
    }
    private void associarListaItemDeVendaUnitario(ItemDeVendaUnitario ListaDeVendaUnitarioNova) {
        this.listaItensUnitario.add(ListaDeVendaUnitarioNova);
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        totalLabel.setText("");
    }
    

    @FXML
    public void cancelarVenda(ActionEvent event) throws IOException{
        setPagamento(null);
        setListaItensPeso(null);
        setListaItensUnitario(null);
        setFuncionario(null);
        setValorTotal(0);
        pesquisarCodBarras.setText("");
        inserirPeso.setText("");
        totalLabel.setText("");
        ObservableList<ItemDeVenda> listaItens = FXCollections.observableArrayList();
        listaItens.add(null);
        tabela.setItems(listaItens);
        return;
    }



    @FXML
    public void tipoPagamento(ActionEvent Event) throws IOException{
        String nome;
        Stage popupStage = new Stage();
        VBox popupRoot = new VBox(pixButton);
        Scene popupScene = new Scene(popupRoot, 450, 500);
        popupStage.initOwner(((Node) Event.getSource()).getScene().getWindow());
        popupStage.initModality(Modality.WINDOW_MODAL);
        pixButton = new Button("Pix");
        pixButton.setOnAction(event -> {
            this.setPagamento(new Pagamento("Pix"));
            
            popupStage.close();
        });
        dinheiroButton=new Button("Dinheiro");
        dinheiroButton.setOnAction(event -> {
            this.setPagamento(new Pagamento("Dinheiro"));
            
            popupStage.close();
        });
        cartaoButton=new Button("Cartão");
        cartaoButton.setOnAction(event -> {
            this.setPagamento(new Pagamento("Cartão"));
            
            popupStage.close();
        });
        popupStage.showAndWait();
        return;
    }



    @FXML
    public void adicionarItemVendaPeso(ActionEvent event) throws IOException{
        float peso=Float.parseFloat(inserirPeso.getText());
        int cod=1;
        ItemDeVendaPeso tmp;
        try {
            Connection connection = Conexao.conectar();
            ImplementacaoProdutoVendidvel ProdVendDAO=new ImplementacaoProdutoVendidvel();
            ProdutoVendivel proVend= ProdVendDAO.get(cod);
            tmp=new ItemDeVendaPeso(proVend, proVend.getNomeProduto(), peso, 0);
            tmp.setValor(tmp.calculaValor());
            this.associarListaItemDeVendaPeso(tmp);
            this.setValorTotal(this.getValorTotal()+tmp.getValor());
            ObservableList<ItemDeVenda> listaItens = FXCollections.observableArrayList();
            ItemDeVenda tmpItemVend = new ItemDeVenda(tmp.getNome(), tmp.getValor());
            listaItens.add(tmpItemVend);
            listaItens.add(tmpItemVend);
            tabela.setItems(listaItens);
            totalLabel.setText(Float.toString(valorTotal));
            Conexao.desconectar();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return;
    }




    @FXML
    public void adicionarItemVendaUnitario(ActionEvent event) throws IOException{
        int cod=Integer.parseInt(pesquisarCodBarras.getText());
        ItemDeVendaUnitario tmp;
        try{
            Connection connection = Conexao.conectar();
            ImplementacaoProdutoVendidvel ProdVendDAO=new ImplementacaoProdutoVendidvel();
            tmp=new ItemDeVendaUnitario(null, cod, 1, ProdVendDAO.get(cod), 0);
            tmp.setValor(tmp.calculaValor());
            this.associarListaItemDeVendaUnitario(tmp);
            this.setValorTotal(this.getValorTotal()+tmp.getValor());
            ObservableList<ItemDeVenda> listaItens = FXCollections.observableArrayList();
            ItemDeVenda tmpItemVend = new ItemDeVenda(tmp.getNome(), tmp.getValor());
            listaItens.add(tmpItemVend);
            listaItens.add(tmpItemVend);
            tabela.setItems(listaItens);
            totalLabel.setText(Float.toString(valorTotal));
            Conexao.desconectar();
            popUpConclusão();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }



    @FXML
    public void confirmar(ActionEvent event) throws IOException{
        try{
            tipoPagamento(event);
            Connection connection = Conexao.conectar();
            ImplementacaoVendaDAO vendaDAO = new ImplementacaoVendaDAO();
            Random random = new Random();
            int cod;
            do{cod = random.nextInt(1_000_000_000 + 1);}while(vendaDAO.get(cod)!=null);
            v = new Venda(getListaItemDeVendaUnitario(), getListaItemDeVendaPeso(), getFuncionario(), getPagamento(), getValorTotal(), cod);
            vendaDAO.insert(v);
            cancelarVenda(event);
            Conexao.desconectar();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return;
    }
    private void popUpConclusão(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Venda Concluída!");
        alert.showAndWait();
    }
}

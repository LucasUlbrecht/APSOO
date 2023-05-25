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
import g6.project.CamadaPersistencia.DAO.SorveteDAO;
import g6.project.CamadaPersistencia.Implementacao.ImplementacaoItens;
import g6.project.CamadaPersistencia.Implementacao.ImplementacaoSorvete;
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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;

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
    @FXML
    private ObservableList<ItemDeVenda> listaItens;
    @FXML
    private Button cartaoDeCreditoButton;
    @FXML
    private Button cartaoDeDebitoButton;
    @FXML
    private Button pixButton;
    @FXML
    private Button dinheiroButton;
    private ObservableList<ItemDeVendaPeso> listaItensPeso;
    private ObservableList<ItemDeVendaUnitario> listaItensUnitario;
    private Pagamento pagamento;
    private Funcionario funcionario;
    private Venda v;
    private float valorTotal;
    public ObservableList<ItemDeVenda> getListaItens() {
        return listaItens;
    }
    public Venda getVenda() {
        return v;
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
        this.v = venda;
    }
    public void setListaItens(ObservableList<ItemDeVenda> listaItens) {
        this.listaItens = listaItens;
    }
    public ObservableList<ItemDeVendaPeso> getListaItemDeVendaPeso() {
        return listaItensPeso;
    }
    public ObservableList<ItemDeVendaUnitario> getListaItemDeVendaUnitario() {
        return listaItensUnitario;
    }
    public void associarListaItemDeVendaPeso(ItemDeVendaPeso ListaDeVendaPesoNova){
        if(listaItensPeso.isEmpty()){
            listaItensPeso = FXCollections.observableArrayList();
        }
        this.listaItensPeso.add(ListaDeVendaPesoNova);
    }
    private void associarListaItemDeVendaUnitario(ItemDeVendaUnitario ListaDeVendaUnitarioNova) {
        if(listaItensUnitario.isEmpty()){
            listaItensUnitario = FXCollections.observableArrayList();
        }
        this.listaItensUnitario.add(ListaDeVendaUnitarioNova);
    }
    private void associarListaItens(ItemDeVenda ListaItem) {
        if(listaItens.isEmpty()){
            listaItens = FXCollections.observableArrayList();
        }
        this.listaItens.add(ListaItem);
    }
    public void setListaItensPeso(ObservableList<ItemDeVendaPeso> listaItensPeso) {
        this.listaItensPeso = listaItensPeso;
    }
    public void setListaItensUnitario(ObservableList<ItemDeVendaUnitario> listaItensUnitario) {
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
        try{
        totalLabel.setText("");}
        catch(NullPointerException e){}
        try{
            listaItens = FXCollections.observableArrayList();
            tabela.setItems(listaItens);}
        catch(NullPointerException e){}
        try{
            inserirPeso.setOnKeyPressed(event -> {
                if (event.getCode().equals(KeyCode.ENTER)) {
                    try {
                        this.adicionarItemVendaPeso(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });}
        catch(NullPointerException e){}
        try{
            pesquisarCodBarras.setOnKeyPressed(event -> {
                if (event.getCode().equals(KeyCode.ENTER)) {
                    try {
                        this.adicionarItemVendaUnitario(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });}
        catch(NullPointerException e){}
        listaItensUnitario = FXCollections.observableArrayList();
        listaItensPeso = FXCollections.observableArrayList();
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
        tabela.setItems(listaItens);
        listaItens.clear();
        listaItensPeso = FXCollections.observableArrayList();
        listaItensUnitario = FXCollections.observableArrayList();

        return;
    }


    public void tipoPagamento(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("popup.fxml"));
        Parent root = loader.load();
        
        pixButton = (Button) loader.getNamespace().get("pixButton");
        pixButton.setOnAction(e -> {
            setPagamento(new Pagamento("Pix"));
            ((Stage) pixButton.getScene().getWindow()).close();
        });
        
        dinheiroButton = (Button) loader.getNamespace().get("dinheiroButton");
        dinheiroButton.setOnAction(e -> {
            setPagamento(new Pagamento("Dinheiro"));
            ((Stage) dinheiroButton.getScene().getWindow()).close();
        });
        
        cartaoDeDebitoButton = (Button) loader.getNamespace().get("cartaoDeDebitoButton");
        cartaoDeDebitoButton.setOnAction(e -> {
            setPagamento(new Pagamento("Cartão de Débito"));
            ((Stage) cartaoDeDebitoButton.getScene().getWindow()).close();
        });
        cartaoDeCreditoButton = (Button) loader.getNamespace().get("cartaoDeCreditoButton");
        cartaoDeCreditoButton.setOnAction(e -> {
            setPagamento(new Pagamento("Cartão de Crédito"));
            ((Stage) cartaoDeCreditoButton.getScene().getWindow()).close();
        });
        
        Stage popupStage = new Stage();
        Scene popupScene = new Scene(root, 450, 500);
        
        popupStage.initOwner(((Node) event.getSource()).getScene().getWindow());
        popupStage.initModality(Modality.WINDOW_MODAL);
        popupStage.setScene(popupScene);
        
        popupStage.showAndWait();
    }


    @FXML
    public void adicionarItemVendaPeso(ActionEvent event) throws IOException{
        float peso=Float.parseFloat(inserirPeso.getText());
        int cod=1;
        ItemDeVendaPeso tmp;
        try {
            Connection connection = Conexao.conectar();
            ProdutoVendivel exemplo= new ProdutoVendivel(1, 0, "Sorvete Massa", 20);
            //ImplementacaoSorvete SorveteDAO=new ImplementacaoSorvete();
            //tmp=new ItemDeVendaUnitario(null, cod, 1, SorveteDAO.get(cod), 0);
            tmp=new ItemDeVendaPeso(exemplo, exemplo.getNomeProduto(), peso, exemplo.getValor());
            tmp.setValor(tmp.calculaValor());
            this.associarListaItemDeVendaPeso(tmp);
            this.setValorTotal(this.getValorTotal()+tmp.getValor());
            ItemDeVenda tmpItemVend = new ItemDeVenda(tmp.getNome(), tmp.getValor());
            listaItens = tabela.getItems();
            listaItens.add(tmpItemVend);
            for(ItemDeVenda uwu:listaItens){
                System.out.println("valor: "+uwu.getValor()+" nome: "+uwu.getNome());
            }
            System.out.println("\n");
            tabela.setItems(listaItens);
            tabela.refresh();
            totalLabel.setText(Float.toString(valorTotal));
            Conexao.desconectar();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        inserirPeso.setText("");
        return;
    }


    @FXML
    public void adicionarItemVendaUnitario(ActionEvent event) throws IOException{
        String Tmp =pesquisarCodBarras.getText();
        String textoSemQuebraDeLinha = Tmp.trim().replaceAll("\n$", "");
        int cod=Integer.parseInt(textoSemQuebraDeLinha);
        ItemDeVendaUnitario tmp;
        try{
            Connection connection = Conexao.conectar();
            ProdutoVendivel exemplo= new ProdutoVendivel(cod, 4, "Picole", 23);
            //ImplementacaoSorvete SorveteDAO=new ImplementacaoSorvete();
            //tmp=new ItemDeVendaUnitario(null, cod, 1, SorveteDAO.get(cod), 0);
            tmp=new ItemDeVendaUnitario(exemplo.getNomeProduto(), exemplo.getCodigoProduto(), 1, exemplo, exemplo.getValor());
            tmp.setValor(tmp.calculaValor());
            this.associarListaItemDeVendaUnitario(tmp);
            this.setValorTotal(this.getValorTotal()+tmp.getValor());
            ItemDeVenda tmpItemVend = new ItemDeVenda(tmp.getNome(), tmp.getValor());
            listaItens = tabela.getItems();
            listaItens.add(tmpItemVend);
            for(ItemDeVenda uwu:listaItens){
                System.out.println("valor: "+uwu.getValor()+" nome: "+uwu.getNome());
            }
            System.out.println("\n");
            tabela.setItems(listaItens);
            tabela.refresh();
            totalLabel.setText(Float.toString(valorTotal));
            Conexao.desconectar();
        } catch (SQLException e){
            e.printStackTrace();
        }
        pesquisarCodBarras.setText("");
        return;
    }

    @FXML
    public void confirmar(ActionEvent event) throws IOException{
        //try{
            tipoPagamento(event);
            //Connection connection = Conexao.conectar();
            ImplementacaoVendaDAO vendaDAO = new ImplementacaoVendaDAO();
            Random random = new Random();
            int cod = random.nextInt(1_000_000_000 + 1);
            //do{cod = random.nextInt(1_000_000_000 + 1);}while(vendaDAO.get(cod)!=null);
            v = new Venda(getListaItemDeVendaUnitario(), getListaItemDeVendaPeso(), getFuncionario(), getPagamento(), getValorTotal(), cod);
            //vendaDAO.insert(v);
            cancelarVenda(event);
            //Conexao.desconectar();
            popUpConclusao();
        /* } catch (SQLException e){
            e.printStackTrace();
        }*/
        return;
    }

    private void popUpConclusao(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Venda Concluída!");
        alert.showAndWait();
    }
}
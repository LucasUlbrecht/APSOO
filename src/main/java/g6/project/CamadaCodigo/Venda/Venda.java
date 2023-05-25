package g6.project.CamadaCodigo.Venda;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

import g6.project.CamadaCodigo.Funcionario.Funcionario;
import javafx.collections.ObservableList;

public class Venda {
    private Date data;
    private int codigoVenda;
    private float valorVenda;
    private LocalTime horario;
    private Pagamento Pagamento;
    private ObservableList<ItemDeVendaUnitario> listaDeVendaUnitario;
    private ObservableList<ItemDeVendaPeso> listaDeVendaPeso;
    private Funcionario funcionario;
    public Venda(ObservableList<ItemDeVendaUnitario> listaDeVendaUnitario, ObservableList<ItemDeVendaPeso> listaDeVendaPeso,
     Funcionario funcionario, Pagamento Pagamento, float valorVenda, int codigoVenda){
        Date    data = new Date();
        LocalTime horaAtual = LocalTime.now();
        setCodigoVenda(codigoVenda);
        setFuncionario(funcionario);
        setHorario(horaAtual);
        setListaDeVendaPeso(listaDeVendaPeso);
        setListaDeVendaUnitario(listaDeVendaUnitario);
        setPagamento(Pagamento);
        setValorVenda(valorVenda);
    }
    public Venda(ObservableList<ItemDeVendaUnitario> listaDeVendaUnitario, ObservableList<ItemDeVendaPeso> listaDeVendaPeso,
    Funcionario funcionario, Pagamento Pagamento, float valorVenda, int codigoVenda, Date data, LocalTime horaAtual){
       if(data==null){
           data = new Date();
       }
       if(horaAtual==null){
       horaAtual = LocalTime.now();
       }
       setCodigoVenda(codigoVenda);
       setFuncionario(funcionario);
       setHorario(horaAtual);
       setListaDeVendaPeso(listaDeVendaPeso);
       setListaDeVendaUnitario(listaDeVendaUnitario);
       setPagamento(Pagamento);
       setValorVenda(valorVenda);
   }
    public Funcionario getFuncionario() {
        return funcionario;
    }
    public ObservableList<ItemDeVendaPeso> getListaDeVendaPeso() {
        return listaDeVendaPeso;
    }
    public ObservableList<ItemDeVendaUnitario> getListaDeVendaUnitario() {
        return listaDeVendaUnitario;
    }
    public Pagamento getPagamento() {
        return Pagamento;
    }
    public int getCodigoVenda() {
        return codigoVenda;
    }
    public Date getData() {
        return data;
    }
    public LocalTime getHorario() {
        return horario;
    }
    public float getValorVenda() {
        return valorVenda;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    public void setListaDeVendaPeso(ObservableList<ItemDeVendaPeso> listaDeVendaPeso) {
        this.listaDeVendaPeso = listaDeVendaPeso;
    }
    public void setListaDeVendaUnitario(ObservableList<ItemDeVendaUnitario> listaDeVendaUnitario) {
        this.listaDeVendaUnitario = listaDeVendaUnitario;
    }
    public void setPagamento(Pagamento pagamento) {
        Pagamento = pagamento;
    }
    public void setCodigoVenda(int codigoVenda) {
        this.codigoVenda = codigoVenda;
    }
    public void setData(Date data) {
        this.data = data;
    }
    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }
    public void setValorVenda(float valorVenda) {
        this.valorVenda = valorVenda;
    }
    public void emitirComprovante(){

    }
    public void finalizarVenda(){

    }
}

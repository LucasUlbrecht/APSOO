package g6.project.CamadaCodigo.Venda;

import java.time.LocalTime;
import java.util.Date;

public class Venda {
    private Date data;
    private int codigoVenda;
    private float valorVenda;
    private LocalTime horario;
    //private Pagamento Pagamento;
    //private ArrayList<ItemDeVendaUnitario> listaDeVendaUnitario;
    //private ArrayList<ItemDeVendaPeso> listaDeVendaPeso;
    //private Funcionario funcionario;


    /*
     * getpagamento();
     * getlistaDeVendaUnitario();
     * getlistaDeVendaPeso();
     * getfuncionario();
     */
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


    /*
     * setpagamento();
     * associarlistaDeVendaUnitario();
     * associarlistaDeVendaPeso();
     * associarfuncionario();
     */
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

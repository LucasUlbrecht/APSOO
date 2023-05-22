package g6.project.CamadaPersistencia.Implementacao;

import java.util.ArrayList;

import g6.project.CamadaCodigo.Venda.Venda;
import g6.project.CamadaPersistencia.DAO.VendaDAO;

public class ImplementacaoVendaDAO implements VendaDAO{
    @Override
    public Venda get(int cod){
        return null;
    }
    @Override
    public int insert(Venda t){
        return 0;
    }
    @Override
    public ArrayList<Venda> getAll() {
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }
}

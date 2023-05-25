package g6.project.CamadaPersistencia.Implementacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import g6.project.Conexao;
import g6.project.CamadaCodigo.Produto.ProdutoVendivel;
import g6.project.CamadaCodigo.Venda.ItemDeVenda;
import g6.project.CamadaCodigo.Venda.ItemDeVendaPeso;
import g6.project.CamadaCodigo.Venda.ItemDeVendaUnitario;
import g6.project.CamadaPersistencia.DAO.ItensDAO;

public class ImplementacaoItens implements ItensDAO{

    @Override
    public void insert(ItemDeVenda t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }
    public void insertListPeso(ArrayList<ItemDeVendaPeso> t, int cod) throws SQLException{
        Connection connection = Conexao.conectar();
        String sql = "INSERT INTO itemVenda  (valor, peso, codVenda) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            for (ItemDeVendaPeso item : t) {
                statement.setString(1, item.getNome());
                statement.setFloat(2, item.getValor());
                statement.setFloat(3, item.getPeso());
                statement.setInt(4,cod);
                statement.addBatch(); // Adiciona o insert ao batch
            }

            statement.executeBatch(); // Executa todos os inserts do batch
        }
    }
    public void insertListUnitario(ArrayList<ItemDeVendaUnitario> t, int cod) throws SQLException{
        Connection connection = Conexao.conectar();
        String sql = "INSERT INTO itemVenda  (valor, peso, quantidade, codVenda) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            for (ItemDeVendaUnitario item : t) {
                statement.setString(1, item.getNome());
                statement.setFloat(2, item.getValor());
                statement.setFloat(3, item.getCodigoItem());
                statement.setFloat(4, Collections.frequency(t, item.getCodigoItem()));
                statement.setInt(5,cod);
                statement.addBatch(); // Adiciona o insert ao batch
            }

            statement.executeBatch(); // Executa todos os inserts do batch
        }
    }
    @Override
    public ItemDeVenda get(int cod) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }
}

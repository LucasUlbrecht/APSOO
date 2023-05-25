package g6.project.CamadaPersistencia.Implementacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import g6.project.Conexao;
import g6.project.CamadaCodigo.Produto.Acompanhamento;
import g6.project.CamadaPersistencia.DAO.AcompanhamentoDAO;

public class ImplementacaoAcompanhamento implements AcompanhamentoDAO{

    @Override
    public Acompanhamento get(int cod) {
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    } 

    @Override
    public void insert(Acompanhamento t){
        try{
            Connection connection = Conexao.conectar();
            String sql = "INSERT INTO venda(codVenda, lote, nome, data) VALUES(?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,t.getCodigoProduto());
            ps.setFloat(2,t.getLote());
            ps.setString(3,t.getNomeProduto());
            int result = ps.executeUpdate();
            return;
        }catch(SQLException e){
            e.printStackTrace();
            return;
        }
    }
}

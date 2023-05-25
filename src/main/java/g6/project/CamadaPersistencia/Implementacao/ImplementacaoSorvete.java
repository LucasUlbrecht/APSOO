package g6.project.CamadaPersistencia.Implementacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;



import g6.project.Conexao;
import g6.project.CamadaCodigo.Produto.Acompanhamento;
import g6.project.CamadaCodigo.Produto.Produto;
import g6.project.CamadaCodigo.Produto.Sorvete;
import g6.project.CamadaPersistencia.DAO.SorveteDAO;

public class ImplementacaoSorvete implements SorveteDAO {

    @Override
    public Sorvete get(int cod){
        try{
        Connection connection = Conexao.conectar();
        Sorvete sorv = null;

        String sql = "SELECT * FROM venda WHERE cpf = ?";
        
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, cod);
        ResultSet rs = ps.executeQuery();
        if (rs.next()){
            int codNovo = rs.getInt("cod");
            int lote = rs.getInt("lote");
            String nomeProduto  = rs.getString("nomeProduto");
            float valor = rs.getFloat("valor");
            int quant = rs.getInt("quantidadeEstoque");
            sorv = new Sorvete(codNovo, lote, nomeProduto, valor, null, quant);
        }
        return sorv;
    }catch(SQLException e){
        e.printStackTrace();
        return null;
    }
    }
    @Override
    public void insert(Sorvete t){
        try{
            Connection connection = Conexao.conectar();
            ImplementacaoAcompanhamento impAcomp= new ImplementacaoAcompanhamento();
            String sql = "INSERT INTO venda(codVenda, valor, acompanhamento, data) VALUES(?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,t.getCodigoProduto());
            ps.setFloat(2,t.getValor());
            for (Acompanhamento item : t.getAcompanhamento()) {
                impAcomp.insert(item);
            }

            int result = ps.executeUpdate();
            return;
        }catch(SQLException e){
            e.printStackTrace();
            return;
        }
    }
}

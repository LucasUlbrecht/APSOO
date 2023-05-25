package g6.project.CamadaPersistencia.Implementacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import g6.project.Conexao;
import g6.project.CamadaCodigo.Venda.Venda;
import g6.project.CamadaPersistencia.DAO.VendaDAO;

public class ImplementacaoVendaDAO implements VendaDAO{
    @Override
    public Venda get(int cod){
        try{
        Connection connection = Conexao.conectar();
        Venda venda = null;

        String sql = "SELECT * FROM venda WHERE cpf = ?";
        
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, cod);
        ResultSet rs = ps.executeQuery();
        if (rs.next()){
            int codNovo = rs.getInt("cod");
            float valor = rs.getFloat("valor");
            Timestamp data  = rs.getTimestamp("data");
            LocalDate date = data.toLocalDateTime().toLocalDate();

            // Obtendo um objeto LocalTime a partir do Timestamp
            LocalTime time = data.toLocalDateTime().toLocalTime();
            venda = new Venda(null, null, null, null, valor, codNovo, data, time);
        }
        return venda;
    }catch(SQLException e){
        e.printStackTrace();
        return null;
    }
    }
    @Override
    public int insert(Venda t){
        try{
            Connection connection = Conexao.conectar();
            String sql = "INSERT INTO venda(codVenda, valor, tipoPagamento, data) VALUES(?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,t.getCodigoVenda());
            ps.setFloat(2,t.getValorVenda());
            ps.setString(3,t.getPagamento().getTipoPagamento());
            LocalDateTime dateTime = LocalDateTime.ofInstant(t.getData().toInstant(), ZoneId.systemDefault());
            LocalDateTime combinedDateTime = dateTime.with(t.getHorario());
            Timestamp timestamp = Timestamp.valueOf(combinedDateTime);
            ps.setTimestamp(4,timestamp);
            int result = ps.executeUpdate();
            return result;
        }catch(SQLException e){
            e.printStackTrace();
            return -1;
        }
    }
}

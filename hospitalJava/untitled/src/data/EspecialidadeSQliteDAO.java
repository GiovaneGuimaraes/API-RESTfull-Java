package data;

import model.Especialidade;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EspecialidadeSQliteDAO implements EspecialidadeDAO{

    @Override
    public void salvar(Especialidade especialidade) {
        String sql = "INSERT INTO especialidade(idEspecialidade,descricao) VALUES (?,?)";
        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setInt(1,especialidade.getIdEspecialidade());
            stmt.setString(2,especialidade.getDescricao());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Especialidade buscar(int id) {
        String sql = "SELECT * FROM especialidade WHERE idEspecialidade=?";
        Especialidade especialidade = null;
        try (PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                especialidade = new Especialidade(rs.getInt("idEspecialidade"),rs.getString("descricao"));
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return especialidade;
    }

    @Override
    public List<Especialidade> buscarTodos() {
        String sql = "SELECT * FROM especialidade";
        List<Especialidade> ListaEspec = new ArrayList<>();
        try (PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                Especialidade especialidade = new Especialidade(rs.getInt("idEspecialidade"),rs.getString("descricao"));
                ListaEspec.add(especialidade);
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return ListaEspec;
    }
}

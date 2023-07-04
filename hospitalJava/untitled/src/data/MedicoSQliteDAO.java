package data;

import model.Especialidade;
import model.Medico;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MedicoSQliteDAO implements MedicoDAO{
    @Override
    public void salvar(Medico medico) {
        String sql = "INSERT INTO medico(id,cpf,nome,numCRM,especialidade) VALUES (?,?,?,?,?)";
        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setInt(1,medico.getId());
            stmt.setString(2,medico.getCpf());
            stmt.setString(3,medico.getNome());
            stmt.setString(4,medico.getNumCRM());
            stmt.setInt(5,medico.getEspecialidade().getIdEspecialidade());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void atualizar(Medico medico) {
        String sql = "UPDATE medico SET cpf=?,nome=?,numCRM=?,especialidade=? WHERE id = ?";
        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setString(1,medico.getCpf());
            stmt.setString(2,medico.getNome());
            stmt.setString(3,medico.getNumCRM());
            stmt.setInt(4,medico.getEspecialidade().getIdEspecialidade());
            stmt.setInt(5,medico.getId());
            stmt.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void apagar(Medico medico) {
        String sql = "DELETE FROM medico WHERE id=?";
        try (PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setInt(1,medico.getId());
            stmt.executeUpdate();
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public Medico buscar(int id) {
        String sql = "SELECT * FROM medico WHERE id=?";
        Medico medico = null;
        try (PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                Especialidade especialidade = new EspecialidadeSQliteDAO().buscar(rs.getInt("especialidade"));
                medico = new Medico(rs.getInt("id"),rs.getString("cpf"),rs.getString("nome"),rs.getString("numCRM"),especialidade);
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return medico;
    }

    @Override
    public List<Medico> buscarTodos() {
        String sql = "SELECT * FROM medico";
        List<Medico> ListaMedicos = new ArrayList<>();
        try (PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                Especialidade especialidade = new EspecialidadeSQliteDAO().buscar(rs.getInt("especialidade"));
                Medico medico = new Medico(rs.getInt("id"),rs.getString("cpf"),rs.getString("nome"),rs.getString("numCRM"),especialidade);
                ListaMedicos.add(medico);
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return ListaMedicos;
    }

    @Override
    public List<Medico> buscarMedicoPorEspecialidade(Especialidade especialidade) {
        String sql = "SELECT * FROM medico WHERE idEspecialidade=?";
        List<Medico> ListaMedicos = new ArrayList<>();
        try (PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setInt(1,especialidade.getIdEspecialidade());
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                Medico medico = new Medico(rs.getInt("id"),rs.getString("cpf"),rs.getString("nome"),rs.getString("numCRM"),especialidade);
                ListaMedicos.add(medico);
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return ListaMedicos;
    }
}

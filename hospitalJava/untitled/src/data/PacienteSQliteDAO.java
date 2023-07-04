package data;

import model.Paciente;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PacienteSQliteDAO implements PacienteDAO{
    @Override
    public void salvar(Paciente paciente) {
        String sql = "INSERT INTO paciente(id,cpf,nome,endereco,dataNascimento) VALUES (?,?,?,?,?)";
        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setInt(1,paciente.getId());
            stmt.setString(2,paciente.getCpf());
            stmt.setString(3,paciente.getNome());
            stmt.setString(4,paciente.getEndereco());
            stmt.setString(5,paciente.getDataNascimento());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Paciente buscar(int id) {
        String sql = "SELECT * FROM paciente WHERE id=?";
        Paciente paciente = null;
        try (PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                paciente = new Paciente(rs.getInt("id"),rs.getString("cpf"),rs.getString("nome"),rs.getString("endereco"),rs.getString("dataNascimento"));
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return paciente;
    }

    @Override
    public List<Paciente> buscarTodos() {
        String sql = "SELECT * FROM paciente";
        List<Paciente> ListaPacientes = new ArrayList<>();
        try (PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                Paciente paciente = new Paciente(rs.getInt("id"),rs.getString("cpf"),rs.getString("nome"),rs.getString("endereco"),rs.getString("dataNascimento"));
                ListaPacientes.add(paciente);
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return ListaPacientes;
    }
}

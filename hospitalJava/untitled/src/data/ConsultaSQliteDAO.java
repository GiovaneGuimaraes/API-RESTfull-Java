package data;

import model.Consulta;
import model.Medico;
import model.Paciente;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConsultaSQliteDAO implements ConsultaDAO{
    @Override
    public void salvar(Consulta consulta) {
        String sql = "INSERT INTO consulta(idConsulta,data,hora,paciente,medico) VALUES (?,?,?,?,?)";
        try (PreparedStatement stmt = ConnectionFactory.criaStatement(sql)) {
            stmt.setInt(1, consulta.getIdConsulta());
            stmt.setString(2, consulta.getData());
            stmt.setString(3, consulta.getHora());
            stmt.setInt(4,consulta.getPaciente().getId());
            stmt.setInt(5,consulta.getMedico().getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void atualizar(Consulta consulta) {
        String sql = "UPDATE consulta SET data=?,hora=?,paciente=?,medico=? WHERE idConsulta = ?";
        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setString(1,consulta.getData());
            stmt.setString(2,consulta.getHora());
            stmt.setInt(3,consulta.getPaciente().getId());
            stmt.setInt(4,consulta.getMedico().getId());
            stmt.setInt(5,consulta.getIdConsulta());
            stmt.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void apagar(Consulta consulta) {
        String sql = "DELETE FROM consulta WHERE numero=?";
        try (PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setInt(1,consulta.getIdConsulta());
            stmt.executeUpdate();
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public Consulta buscar(int id) {
        String sql = "SELECT * FROM consulta WHERE idConsulta=?";
        Consulta consulta = null;
        try (PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                Paciente paciente = new PacienteSQliteDAO().buscar(rs.getInt("paciente"));
                Medico medico = new MedicoSQliteDAO().buscar(rs.getInt("medico"));
                consulta = new Consulta(rs.getInt("idConsulta"),rs.getString("data"),rs.getString("hora"),medico,paciente);
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return consulta;
    }

    @Override
    public List<Consulta> buscarTodos() {
        String sql = "SELECT * FROM consulta";
        List<Consulta> ListaConsultas = new ArrayList<>();
        try (PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                Paciente paciente = new PacienteSQliteDAO().buscar(rs.getInt("paciente"));
                Medico medico = new MedicoSQliteDAO().buscar(rs.getInt("medico"));
                Consulta consulta = new Consulta(rs.getInt("idConsulta"),rs.getString("data"),rs.getString("hora"),medico,paciente);
                ListaConsultas.add(consulta);
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return ListaConsultas;
    }

    @Override
    public List<Consulta> buscarConsultaPorPaciente(Paciente paciente) {
        String sql = "SELECT * FROM consulta WHERE paciente=?";
        List<Consulta> ListaConsultas = new ArrayList<>();
        try (PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setInt(1,paciente.getId());
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                Medico medico = new MedicoSQliteDAO().buscar(rs.getInt("medico"));
                Consulta consulta = new Consulta(rs.getInt("idConsulta"),rs.getString("data"),rs.getString("hora"),medico,paciente);
                ListaConsultas.add(consulta);
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return ListaConsultas;
    }
}

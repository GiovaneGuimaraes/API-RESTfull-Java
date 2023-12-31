package data;

import model.Consulta;
import model.Paciente;

import java.util.List;

public interface ConsultaDAO extends DAO<Consulta>{
    @Override
    void salvar(Consulta consulta);

    void atualizar(Consulta consulta);

    void apagar(Consulta consulta);

    @Override
    Consulta buscar(int id);

    @Override
    List<Consulta> buscarTodos();

    List<Consulta> buscarConsultaPorPaciente(Paciente paciente);
}

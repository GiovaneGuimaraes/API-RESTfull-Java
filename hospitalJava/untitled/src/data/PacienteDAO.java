package data;

import model.Paciente;

import java.util.List;

public interface PacienteDAO extends DAO<Paciente>{
    @Override
    void salvar(Paciente paciente);

    @Override
    Paciente buscar(int id);

    @Override
    List<Paciente> buscarTodos();
}

package data;

import model.Paciente;

import java.util.List;

public interface PacienteDAO {
    void salvar(Paciente paciente);


    Paciente buscar(int id);


    List<Paciente> buscarTodos();
}

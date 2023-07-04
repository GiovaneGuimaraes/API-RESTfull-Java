package data;

import model.Especialidade;

import java.util.List;

public interface EspecialidadeDAO {

    void salvar(Especialidade especialidade);


    Especialidade buscar(int id);


    List<Especialidade> buscarTodos();
}

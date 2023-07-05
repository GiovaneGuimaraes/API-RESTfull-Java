package data;

import model.Especialidade;

import java.util.List;

public interface EspecialidadeDAO extends DAO<Especialidade>{

    @Override
    void salvar(Especialidade especialidade);

    @Override
    Especialidade buscar(int id);

    @Override
    List<Especialidade> buscarTodos();
}

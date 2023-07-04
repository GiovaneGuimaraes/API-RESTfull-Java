package data;

import model.Especialidade;
import model.Medico;

import java.util.List;

public interface MedicoDAO extends DAO<Medico>{
    @Override
    void salvar(Medico medico);

    @Override
    void atualizar(Medico medico);

    @Override
    void apagar(Medico medico);

    @Override
    Medico buscar(int id);

    @Override
    List<Medico> buscarTodos();

    List<Medico> buscarMedicoPorEspecialidade(Especialidade especialidade);
}

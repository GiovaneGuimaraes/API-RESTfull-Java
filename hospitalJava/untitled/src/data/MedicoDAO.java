package data;

import model.Especialidade;
import model.Medico;

import java.util.List;

public interface MedicoDAO extends DAO<Medico>{
    @Override
    void salvar(Medico medico);

    void atualizar(Medico medico);

    void apagar(Medico medico);

    @Override
    Medico buscar(int id);

    @Override
    List<Medico> buscarTodos();

    List<Medico> buscarMedicoPorEspecialidade(Especialidade especialidade);
}

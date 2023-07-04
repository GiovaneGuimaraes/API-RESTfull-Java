package data;

import model.Venda;

import java.util.List;

public interface VendaDAO extends DAO<Venda>{
    @Override
    void salvar(Venda venda);

    @Override
    void atualizar(Venda venda);

    @Override
    void apagar(Venda venda);

    @Override
    Venda buscar(int id);

    @Override
    List<Venda> buscarTodos();
}

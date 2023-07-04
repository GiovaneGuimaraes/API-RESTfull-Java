package data;

import model.ItemVenda;
import model.Venda;

import java.util.List;

public interface ItemVendaDAO extends DAO<ItemVenda>{
    @Override
    void salvar(ItemVenda itemVenda);

    @Override
    void atualizar(ItemVenda itemVenda);

    @Override
    void apagar(ItemVenda itemVenda);

    @Override
    ItemVenda buscar(int id);

    @Override
    List<ItemVenda> buscarTodos();

    List<ItemVenda> buscarItensVenda(Venda venda);
}

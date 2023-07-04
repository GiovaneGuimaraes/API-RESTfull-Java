package data;

import model.Produto;

import java.util.List;

public interface ProdutoDAO extends DAO<Produto>{
    @Override
    void salvar(Produto produto);
    @Override
    void atualizar(Produto produto);
    @Override
    void apagar(Produto produto);
    @Override
    Produto buscar(int id);
    @Override
    List<Produto> buscarTodos();
}

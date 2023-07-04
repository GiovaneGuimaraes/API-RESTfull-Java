package data;

import model.ItemVenda;
import model.Produto;
import model.Venda;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemVendaSQliteDAO implements ItemVendaDAO{
    @Override
    public void salvar(ItemVenda itemVenda) {
        String sql = "INSERT INTO itemvenda(idItemVenda,idProduto, idVenda, quantidadeVendida, valorTotal) VALUES (?,?,?,?,?)";
        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setInt(1,itemVenda.getIdItemVenda());
            stmt.setInt(2,itemVenda.getProduto().getIdProduto());
            stmt.setInt(3,itemVenda.getVenda().getIdVenda());
            stmt.setInt(4,itemVenda.getQuantidadeVendida());
            stmt.setDouble(5,itemVenda.getValorTotal());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void atualizar(ItemVenda itemVenda) {
        String sql = "UPDATE itemvenda SET idProduto=?,idVenda=?,quantidadeVendida=?,valorTotal=? WHERE idItemVenda = ?";
        try(PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setInt(1,itemVenda.getProduto().getIdProduto());
            stmt.setInt(2,itemVenda.getVenda().getIdVenda());
            stmt.setInt(3,itemVenda.getQuantidadeVendida());
            stmt.setDouble(4,itemVenda.getValorTotal());
            stmt.setInt(5,itemVenda.getIdItemVenda());
            stmt.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void apagar(ItemVenda itemVenda) {
        String sql = "DELETE FROM itemvenda WHERE idItemVenda=?";
        try (PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setInt(1,itemVenda.getIdItemVenda());
            stmt.executeUpdate();
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public ItemVenda buscar(int id) {
        String sql = "SELECT * FROM itemvenda WHERE idItemVenda=?";
        ItemVenda itemVenda = null;
        try (PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                Produto produto = new ProdutoSQliteDAO().buscar(rs.getInt("produto"));
                Venda venda = new VendaSQliteDAO().buscar(rs.getInt("venda"));
                itemVenda = new ItemVenda(rs.getInt("idItemVenda"),rs.getInt("quantidadeVendida"),produto,venda);
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return itemVenda;
    }

    @Override
    public List<ItemVenda> buscarTodos() {
        String sql = "SELECT * FROM itemvenda";
        List<ItemVenda> ListaItensVenda = new ArrayList<>();
        try (PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                Produto produto = new ProdutoSQliteDAO().buscar(rs.getInt("idProduto"));
                Venda venda = new VendaSQliteDAO().buscar(rs.getInt("idVenda"));
                ItemVenda itemVenda = new ItemVenda(rs.getInt("idItemVenda"),rs.getInt("quantidadeVendida"),produto,venda);
                ListaItensVenda.add(itemVenda);
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return ListaItensVenda;
    }

    @Override
    public List<ItemVenda> buscarItensVenda(Venda venda) {

        String sql = "SELECT * FROM itemvenda WHERE idVenda = ?";
        List<ItemVenda> ListaItensVendaEspec = new ArrayList<>();
        try (PreparedStatement stmt = ConnectionFactory.criaStatement(sql)){
            stmt.setInt(1,venda.getIdVenda());
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                Produto produto = new ProdutoSQliteDAO().buscar(rs.getInt("produto"));
                ItemVenda itemVenda = new ItemVenda(rs.getInt("idItemVenda"),rs.getInt("quantidadeVendida"),produto,venda);
                ListaItensVendaEspec.add(itemVenda);
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return ListaItensVendaEspec;
    }
}


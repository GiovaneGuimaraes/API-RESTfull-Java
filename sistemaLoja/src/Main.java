import data.*;
import model.ItemVenda;
import model.Produto;
import model.Venda;

public class Main {
    public static void main(String[] args) {
        Produto produto1 = new Produto(1,"vinho",200.0,100);
        Produto produto2 = new Produto(2,"geladeira",2500.0,5);

        Venda venda1 = new Venda(1,"24/02/2003",0);

        ItemVenda itemvenda1 = new ItemVenda(1,5,produto1,venda1);
        ItemVenda itemVenda2 = new ItemVenda(2,1,produto2,venda1);

        venda1.incluirItemVenda(itemvenda1);
        venda1.incluirItemVenda(itemVenda2);

        //produto1.mostrarDados();
        //itemvenda1.mostrarDados();
        //venda1.mostrarDados();

        ProdutoDAO produtoDAO = new ProdutoSQliteDAO();
        produtoDAO.salvar(produto1);
        produtoDAO.salvar(produto2);
        //produtoDAO.apagar(produto1);
        //produtoDAO.apagar(produto2);

        VendaDAO vendaDAO = new VendaSQliteDAO();
        vendaDAO.salvar(venda1);
        //vendaDAO.apagar(venda1);


        ItemVendaDAO itemVendaDAO = new ItemVendaSQliteDAO();
        itemVendaDAO.salvar(itemvenda1);
        itemVendaDAO.salvar(itemVenda2);
        //itemVendaDAO.apagar(itemvenda1);
        //itemVendaDAO.apagar(itemVenda2);


        System.out.println("\nProdutos:");
        for (Produto p : produtoDAO.buscarTodos())
            p.mostrarDados();


        System.out.println("\nItens Venda:");
        for (ItemVenda i : itemVendaDAO.buscarTodos())
            i.mostrarDados();

        System.out.println("\nVendas:");
        for (Venda v : vendaDAO.buscarTodos())
            v.mostrarDados();
    }
}
package model;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Venda implements IMostrarDados{
    private int idVenda;
    private String dataVenda;
    private double valorTotalVenda;
    private List<ItemVenda> itemVendaList = new ArrayList<>();

    public Venda(int idVenda, String dataVenda, double valorTotalVenda) {
        this.idVenda = idVenda;
        this.dataVenda = dataVenda;
        this.valorTotalVenda = valorTotalVenda;
    }

    void calcularValorTotalCompra() {
        double total = 0;
        for (ItemVenda i : itemVendaList)
            total = total + i.getValorTotal();

        valorTotalVenda = total;
    }

    public void incluirItemVenda(ItemVenda...itemVenda){
        Collections.addAll(itemVendaList, itemVenda);
        this.calcularValorTotalCompra();
    }

    public void removerItemVenda(ItemVenda itemVenda){
        itemVendaList.remove(itemVenda);
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public String getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }

    public double getValorTotalVenda() {
        return valorTotalVenda;
    }

    public void setValorTotalVenda(double valorTotalVenda) {
        this.valorTotalVenda = valorTotalVenda;
    }

    public List<ItemVenda> getItemVendaList() {
        return itemVendaList;
    }

    public void setItemVendaList(List<ItemVenda> itemVendaList) {
        this.itemVendaList = itemVendaList;
    }

    @Override
    public void mostrarDados() {
        System.out.println("\nVENDA: " +
                            "\nid venda: " + this.getIdVenda() +
                            "\ndata da venda: "+ this.getDataVenda() +
                            "\nvalor total da venda: "+ this.getValorTotalVenda());
        System.out.println("\nitens da venda: ");
        for (ItemVenda i: itemVendaList)
            System.out.println("\nProduto: " + i.getProduto().getDescricao()
                    + "\n Quantidade: " + i.getQuantidadeVendida());
    }
}

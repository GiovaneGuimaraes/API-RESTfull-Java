package model;
import model.Produto;

public class ItemVenda implements IMostrarDados{
    private int idItemVenda;
    private int quantidadeVendida;
    private double valorTotal;
    private Produto produto;
    private Venda venda;

    public ItemVenda(int idItemVenda, int quantidadeVendida, Produto produto, Venda venda) {
        this.idItemVenda = idItemVenda;
        this.quantidadeVendida = quantidadeVendida;
        this.produto = produto;
        this.venda = venda;
        calcularValorTotal();
        produto.atualizarEstoque(quantidadeVendida);
        venda.incluirItemVenda(this);
    }

    void calcularValorTotal(){
        valorTotal= this.quantidadeVendida * this.getProduto().getPrecoUnitario();
    }

    public int getIdItemVenda() {
        return idItemVenda;
    }

    public void setIdItemVenda(int idItemVenda) {
        this.idItemVenda = idItemVenda;
    }

    public int getQuantidadeVendida() {
        return quantidadeVendida;
    }

    public void setQuantidadeVendida(int quantidadeVendida) {
        this.quantidadeVendida = quantidadeVendida;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    @Override
    public void mostrarDados() {
        System.out.println("\nITEM VENDA: " +
                            "\nid itemVenda: " + this.getIdItemVenda() +
                            "\nquantidade vendida: " + this.getQuantidadeVendida() +
                            "\nvalor total: " + this.getValorTotal() +
                            "\nProduto : " + this.getProduto().getDescricao() +
                            "\nid Venda : " + this.getVenda().getIdVenda());
    }
}

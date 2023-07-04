package model;

public class Produto implements IMostrarDados{
    private int idProduto;
    private String descricao;
    private double precoUnitario;
    private int quantidadeEstoque;

    public Produto(int idProduto, String descricao, double precoUnitario, int quantidadeEstoque) {
        this.idProduto = idProduto;
        this.descricao = descricao;
        this.precoUnitario = precoUnitario;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    void atualizarEstoque(int quantidade){
        this.quantidadeEstoque = quantidadeEstoque - quantidade;
        System.out.println("\nestoque atualizado!");
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    @Override
    public void mostrarDados() {
        System.out.println("\nPRODUTO: " +
                            "\nid do produto: " + this.getIdProduto() +
                            "\ndescricao: " + this.getDescricao() +
                            "\npreco unitario: " + this.getPrecoUnitario() +
                            "\nquantidade em estoque: " + this.getQuantidadeEstoque());
    }
}

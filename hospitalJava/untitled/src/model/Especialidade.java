package model;

public class Especialidade implements IMostrarDados{
    private int idEspecialidade;
    private String descricao;

    public Especialidade(int idEspecialidade, String descricao) {
        this.idEspecialidade = idEspecialidade;
        this.descricao = descricao;
    }

    @Override
    public void mostrarDados() {
        System.out.println("\nEspecialidade: " +
                            "\nid: " + this.getIdEspecialidade() +
                            "\ndescricao: " + this.getDescricao());
    }

    public int getIdEspecialidade() {
        return idEspecialidade;
    }

    public void setIdEspecialidade(int idEspecialidade) {
        this.idEspecialidade = idEspecialidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}

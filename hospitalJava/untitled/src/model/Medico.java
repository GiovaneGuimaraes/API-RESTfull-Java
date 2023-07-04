package model;

public class Medico extends Pessoa implements IMostrarDados{
    private String numCRM;
    private Especialidade especialidade;

    public Medico(int id, String cpf, String nome, String numCRM, Especialidade especialidade) {
        super(id, cpf, nome);
        this.numCRM = numCRM;
        this.especialidade = especialidade;
    }

    public String getNumCRM() {
        return numCRM;
    }

    public void setNumCRM(String numCRM) {
        this.numCRM = numCRM;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    @Override
    public void mostrarDados() {
        System.out.println("\nMedico: " +
                "\nid pessoa: " + this.getId() +
                "\nnome: " + this.getNome() +
                "\ncpf: " + this.getCpf() +
                "\nCRM: " + this.getNumCRM() +
                "\nespecialidade: " + this.getEspecialidade().getDescricao());
    }
}

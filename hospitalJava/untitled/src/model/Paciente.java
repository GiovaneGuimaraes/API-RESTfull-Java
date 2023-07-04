package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Paciente extends Pessoa implements IMostrarDados{
    private String endereco;
    private String dataNascimento;
    private List<Consulta> ConsultaList = new ArrayList<>();

    public Paciente(int id, String cpf, String nome, String endereco, String dataNascimento) {
        super(id, cpf, nome);
        this.endereco = endereco;
        this.dataNascimento = dataNascimento;
    }

    public void incluirConsulta(Consulta...consulta){
        Collections.addAll(ConsultaList, consulta);
        // OU assim: itemCompraList.addAll(List.of(itemCompra));

    }

    public void removerConsulta(Consulta consulta){
        ConsultaList.remove(consulta);
    }

    public void exibirHistoricoConsultas(){
        System.out.println("\nHistorico de consultas do paciente:");
        for (Consulta c: ConsultaList)
            System.out.println("\nConsulta: " + c.getIdConsulta()
                    + "\n data: " + c.getData() + " hora: " + c.getHora() +
                    "\nnome do medico: " + c.getMedico().getNome() +
                    "\nespecialidade do medico: " + c.getMedico().getEspecialidade().getDescricao());
    }

    @Override
    public void mostrarDados() {
        System.out.println("\nPaciente: " +
                "\nid pessoa: " + this.getId() +
                "\nnome: " + this.getNome() +
                "\ncpf: " + this.getCpf() +
                "\nendereco: " + this.getEndereco() +
                "\ndata nascimento: " +this.getDataNascimento());
    }


    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public List<Consulta> getConsultaList() {
        return ConsultaList;
    }

    public void setConsultaList(List<Consulta> consultaList) {
        ConsultaList = consultaList;
    }
}

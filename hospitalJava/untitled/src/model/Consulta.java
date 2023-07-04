package model;

public class Consulta implements IMostrarDados{
    private int idConsulta;
    private String data;
    private String hora;
    private Medico medico;
    private Paciente paciente;

    public Consulta(int idConsulta, String data, String hora, Medico medico, Paciente paciente) {
        this.idConsulta = idConsulta;
        this.data = data;
        this.hora = hora;
        this.medico = medico;
        this.paciente = paciente;
        paciente.incluirConsulta(this);
    }

    @Override
    public void mostrarDados() {
        System.out.println("\nConsulta: " +
                            "\nid: " + this.getIdConsulta() +
                            "\ndata: " + this.getData() + " hora: " + this.getHora() +
                            "\nMedico: " + this.getMedico().getNome() +
                            "\nPaciente: " + this.getPaciente().getNome());

    }

    public int getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(int idConsulta) {
        this.idConsulta = idConsulta;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
}

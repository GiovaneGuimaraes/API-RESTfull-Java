import data.*;
import model.Consulta;
import model.Especialidade;
import model.Medico;
import model.Paciente;

public class Main {
    public static void main(String[] args) {
        Especialidade pediatra = new Especialidade(1,"pediatra");
        Especialidade cirurgiao = new Especialidade(2,"Cirurgiao");

        Medico medico1 = new Medico(1,"44631741","Giovane","10",pediatra);
        Medico medico2 = new Medico(2,"5212425","Cleito","20",cirurgiao);


        Paciente paciente1 = new Paciente(1,"1641641","Robertin","rua BR","24-02-2003");

        //Consulta consulta1 = new Consulta(1,"13/06/2023","08:23",medico1,paciente1);
        //Consulta consulta2 = new Consulta(2,"14/06/2023","9:12",medico2,paciente1);

        //pediatra.mostrarDados();
        //medico1.mostrarDados();
        //paciente1.mostrarDados();
        //paciente1.exibirHistoricoConsultas();
        //consulta1.mostrarDados();

        PacienteDAO pacienteDAO = new PacienteSQliteDAO();
        //pacienteDAO.salvar(paciente1);

        EspecialidadeDAO especialidadeDAO = new EspecialidadeSQliteDAO();
        //especialidadeDAO.salvar(pediatra);
        //especialidadeDAO.salvar(cirurgiao);

        MedicoDAO medicoDAO = new MedicoSQliteDAO();
        //medicoDAO.salvar(medico1);
        //medicoDAO.apagar(medico1);
        //medicoDAO.salvar(medico2);

        ConsultaDAO consultaDAO = new ConsultaSQliteDAO();
        //consultaDAO.salvar(consulta1);
        //consultaDAO.salvar(consulta2);

        System.out.println("\n------------------- Pacientes: -----------------");
        for (Paciente p : pacienteDAO.buscarTodos())
            p.mostrarDados();

        System.out.println("\n------------------- Especialidades: ------------");
        for (Especialidade e : especialidadeDAO.buscarTodos())
            e.mostrarDados();

        System.out.println("\n------------------- Medicos: -------------------");
        for (Medico m : medicoDAO.buscarTodos())
            m.mostrarDados();

        System.out.println("\n------------------ Consultas: ------------------");
        for (Consulta c : consultaDAO.buscarTodos())
            c.mostrarDados();

        System.out.println("\n-------- Consultas por paciente: paciente1 -----");
        for( Consulta c : consultaDAO.buscarConsultaPorPaciente(paciente1))
            c.mostrarDados();

        System.out.println("--------- Exibir historico do paciente 1 ---------");
        paciente1.exibirHistoricoConsultas();
    }
}
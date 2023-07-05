# API de um hospital no método RESTfull em Java

Projeto feito para estudo

redes: www.linkedin.com/in/giovane-guimar%C3%A3es-a06683211/

Diagramas: 

![1](https://github.com/GiovaneGuimaraes/API-RESTfull-Java/assets/133304083/3cab8942-30a6-43e6-929d-7da6525e43ed)

![2](https://github.com/GiovaneGuimaraes/API-RESTfull-Java/assets/133304083/ef3c4471-f12e-4f05-bc4f-78f9c9fd0c98)

Objetivo: Trata-se de um sistema em Java que implementa uma API RESTfull para uma aplicação de hospital, esses códigos fornecem uma estrutura básica que permite a manipulação de pacientes, médicos, especialidades e consultas.
  'o foco principal não é o embelezamento até porque não tem uma interface JavaFX presente, mas sim, sua aplicação no backend'

- Resultados e testes: 
Implementação de Especialidade, médicos e paciente na main:
        
        Especialidade pediatra = new Especialidade(1,"pediatra");
        Especialidade cirurgiao = new Especialidade(2,"Cirurgiao");
        Medico medico1 = new Medico(1,"44631741","Giovane","10",pediatra);
        Medico medico2 = new Medico(2,"5212425","Cleito","20",cirurgiao);
        Paciente paciente1 = new Paciente(1,"1641641","Robertin","rua BR","24-02-2003");
  
        PacienteDAO pacienteDAO = new PacienteSQliteDAO();
        pacienteDAO.salvar(paciente1); // salva no banco de dados

        EspecialidadeDAO especialidadeDAO = new EspecialidadeSQliteDAO();
        especialidadeDAO.salvar(pediatra); // salva no banco de dados
        especialidadeDAO.salvar(cirurgiao); // salva no banco de dados

        MedicoDAO medicoDAO = new MedicoSQliteDAO();
        medicoDAO.salvar(medico1); // salva no banco de dados
        medicoDAO.salvar(medico2); // salva no banco de dados

Imprime utilizando o buscarTodos e o mostrarDados : 

![3](https://github.com/GiovaneGuimaraes/API-RESTfull-Java/assets/133304083/872b6a1b-c14c-4046-a94b-bbe4e133cd2c)

Criação de uma consulta: 

        Consulta consulta1 = new Consulta(1,"13/06/2023","08:23",medico1,paciente1);
        Consulta consulta2 = new Consulta(2,"14/06/2023","9:12",medico2,paciente1);

        ConsultaDAO consultaDAO = new ConsultaSQliteDAO();
        consultaDAO.salvar(consulta1); // salva no banco de dados
        consultaDAO.salvar(consulta2); // salva no banco de dados

Imprime utilizando o buscarTodos e o mostrarDados:

![2](https://github.com/GiovaneGuimaraes/API-RESTfull-Java/assets/133304083/20de259a-c04d-4a0b-b5d8-f09cd588cbc3)

Busca de consultas de um paciente especifico: 

      for( Consulta c : consultaDAO.buscarConsultaPorPaciente(paciente1))
            c.mostrarDados();

![4](https://github.com/GiovaneGuimaraes/API-RESTfull-Java/assets/133304083/b4f908aa-aae8-48fe-876a-02f74061587d)

Exibir historico de um paciente especifico: 

      paciente1.exibirHistoricoConsultas();

![5](https://github.com/GiovaneGuimaraes/API-RESTfull-Java/assets/133304083/e7ffd644-e893-4444-b4ee-9c04145d9229)



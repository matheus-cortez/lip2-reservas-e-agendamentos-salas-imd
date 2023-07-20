import java.util.ArrayList;

public class GerenciadorSalasIMD implements Gestao
{
    private ArrayList<Sala> salas;
    private ArrayList<Professor> professores;
    
    public GerenciadorSalasIMD()
    {
        salas = new ArrayList<Sala>();
        professores = new ArrayList<Professor>();
    }

    public String registrarProfessor(Professor prof_de_interesse){
        String mat_professor;

        mat_professor = prof_de_interesse.getMatricula();
        for(Professor professor : professores){
            if(mat_professor == professor.getMatricula()){
                return "Professor de matrícula " + mat_professor + " já está registrado no sistema.";
            }
        }

        professores.add(prof_de_interesse);

        return "Professor registrado com sucesso!";
    }    

    public String removerProfessor(Professor professor){
        professores.remove(professor);

        return "Professor removido com sucesso!";
    }

    public String removerProfessor(String mat_professor){
        String mat_professor;
        for(Professor professor : professores){
            if(mat_professor == professor.getMatricula()){
                professores.remove(professor);
                return "Professor de matrícula " + mat_professor + " removido do sistema com sucesso.";
            }
        }
        return "Não há professores registrados sob a matrícula " + mat_professor;
    }
    
    public String registrarSala(Sala sala_de_interesse){       
        String id_sala;

        id_sala = sala_de_interesse.getId();
        for(Sala sala : salas){
            if(id_sala == sala.getId()){
                return "Sala de id " + id_sala + " já está registrado no sistema.";
            }
        }
        salas.add(sala_de_interesse);

        return "Sala registrada com sucesso!";
    }

    public String removerSala(Sala sala){
        salas.remove(sala);
        
        return "Sala removida com sucesso!";
    }

    public String removerSala(String id_sala){
        String sala_de_interesse;

        for(Sala sala : salas){
            if(id_sala == sala.getId()){
                salas.remove(sala);
                return "Sala de id " + id_sala + " removida do sistema com sucesso.";
            }
        }
        return "Não há salas registradas sob o id " + id_sala;
    }

    public void exibeSalasRegistradas(){
        for(Sala sala : salas){
            System.out.println(sala.getId());
        }
    }

    public void exibeProfessoresRegistrados(){
        for(Professor professor : professores){
            System.out.println(professor.getNome() + " " + professor.getMatricula());
        }
    }

    public void exibeSalasLivresNoDiaEHorario(String data, int horario){
        System.out.println("Salas livres no dia " + data + " e horário " + horario + ":\n");
        for(Sala sala : salas){
            if(sala.isHorarioDisponivel(data,horario)){
                System.out.println(sala.getId());
            }
        }
    }
}
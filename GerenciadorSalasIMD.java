import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class GerenciadorSalasIMD implements Gestao
{
    private ArrayList<Sala> salas;
    private ArrayList<Professor> professores;
    
    public GerenciadorSalasIMD()
    {
        salas = new ArrayList<Sala>();
        professores = new ArrayList<Professor>();
    }

    public boolean existeSala(String id_sala){
        for(Sala sala : salas){
            if(id_sala == sala.getId()){
                return true;
            }
        }
        return false;
    }

    public void printaSala(Sala sala){
        String id;
        id = sala.getId();

        System.out.println(id);
    }

    public boolean existeProfessor(String mat_professor){
        for(Professor professor : professores){
            if(mat_professor.equals(professor.getMatricula())){
                return true;
            }
        }
        return false;
    }

    public Professor retornaProfessor(String mat_professor){
        for(Professor professor : professores){
            if(mat_professor.equals(professor.getMatricula())){
                return professor;
            }
        }
        Professor blank_professor = new Professor("blank","blank","blank","blank");
        return blank_professor;
    }

    public Sala retornaSala(String id_sala){
        for(Sala sala : salas){
            if(id_sala.equals(sala.getId())){
                return sala;
            }
        }
        Sala blank_sala = new Sala("blank",1,false);
        return blank_sala;
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
        if(existeProfessor(mat_professor)){
            professores.remove(retornaProfessor(mat_professor));
            return "Professor de matrícula " + mat_professor + " removido do sistema com sucesso.";
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

/*     public void exibeReservasDeProfessor(String mat_professor){
        if(!existeProfessor(mat_professor)){
            System.out.println("Não existe um professor associado a essa matrícula.");
            return;
        }

        Professor professor = retornaProfessor(mat_professor);

        for(Sala sala : salas){

        }

    } */

    public void exibeProfessoresRegistrados(){
        for(Professor professor : professores){
            System.out.println(professor.getNome() + " " + professor.getMatricula());
        }
    }

    public void exibeSalasLivresNoDiaEHorario(String data, int horario){
        System.out.println("Salas livres no dia " + data + " e horário " + horario + ":\n");
        for(Sala sala : salas){
            if(isHorarioDisponivel(sala,data,horario)){
                System.out.println(sala.getId());
            }
        }
    }




    public boolean isHorarioDisponivel(Sala sala, String data, int horario) {
        if (sala.horarios.containsKey(data)) {
            Map<Integer, String> horariosData = sala.horarios.get(data);
            
            if (horariosData.containsKey(horario)) {
                return horariosData.get(horario).isEmpty();
            } else {
                System.out.println("Horário inválido!");
            }
        } else {
            return true; // atenção, não está verificando o formato da data
            //System.out.println("Data inválida!");
        }
    
    return false;
    }

    
    public String reservarHorario(Sala sala, String data, int horario, String mat_professor) {
        if(!existeProfessor(mat_professor)){
            System.out.println("Não existe um professor associado a essa matrícula.");
            return "Não existe um professor associado a essa matrícula.";
        }

        if (!sala.horarios.containsKey(data)) {
            sala.horarios.put(data, new HashMap<>());
        }

        Map<Integer, String> horariosData = sala.horarios.get(data);

        if (horariosData.size() != 8) {
            for (int i = horariosData.size() + 1; i <= 8; i++) {
                horariosData.put(i, "");
            }
        }

        if (horariosData.containsKey(horario)) {
            if (horariosData.get(horario).isEmpty()) {
                horariosData.put(horario, mat_professor);
                System.out.println("Horário reservado com sucesso.");
                return "Horário reservado com sucesso.";
            } else {
                System.out.println("Horário indisponível.");
                return "Horário indisponível.";
            }
        } else {
            System.out.println("Horário inválido!");
            return "Horário inválido!";
        }
    }

    public String liberarHorario(Sala sala, String data, int horario) {
        if (sala.horarios.containsKey(data)) {
            Map<Integer, String> horariosData = sala.horarios.get(data);

            if (horariosData.containsKey(horario)) {
                if (!horariosData.get(horario).isEmpty()) {
                    horariosData.put(horario, "");
                    System.out.println("Horário liberado com sucesso.");
                    return "Horário liberado com sucesso.";
                } else {
                    System.out.println("Horário já está livre.");
                    return "Horário já está livre.";
                }
            } else {
                System.out.println("Horário inválido!");
                return "Horário inválido!";
            }
        } else {
            System.out.println("A sala não está reservada nesta data!");
            return "A sala não está reservada nesta data!";
        }
    }

    public void exibeHorariosLivresNaSalaUmaSemanaPraFrente(Sala sala, String dataInicial) {
        LocalDate data = LocalDate.parse(dataInicial, DateTimeFormatter.ISO_DATE);
        
        for (int i = 0; i < 9; i++) {
            String dataAtual = data.plusDays(i).format(DateTimeFormatter.ISO_DATE);

            System.out.println("Data: " + dataAtual);
            
            if (sala.horarios.containsKey(dataAtual)) {
                Map<Integer, String> horariosData = sala.horarios.get(dataAtual);
                
                for (int horario = 1; horario <= 8; horario++) {
                    if (horariosData.containsKey(horario) && horariosData.get(horario).isEmpty()) {
                        System.out.println("Horário " + horario + ": Livre");
                    }
                }
                
                System.out.println();
            }else{
                Map<Integer, String> horariosData = sala.horarios.get(dataAtual);

                for (int horario = 1; horario <= 8; horario++) {
                        System.out.println("Horário " + horario + ": Livre");
                }

            }
        }
    }
}
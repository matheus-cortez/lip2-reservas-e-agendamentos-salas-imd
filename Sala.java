import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Sala
{
    private String id;
    private float capacidade_pessoas;
    private boolean possui_computadores_para_alunos;
    public Map<String, Map<Integer, String>> horarios;

    public Sala(String id, float capacidade_pessoas, boolean possui_computadores_para_alunos)
    {
        this.id = id;
        this.capacidade_pessoas = capacidade_pessoas;
        this.possui_computadores_para_alunos = possui_computadores_para_alunos;
        this.horarios = new HashMap<>();
    }
    
    public void setId(String id)
    {
        this.id = id;
    }
    
    public void setCapacidadePessoas(float capacidade_pessoas)
    {
        this.capacidade_pessoas = capacidade_pessoas;
    }
    
    public void setPossuiComputadoresParaAlunos(boolean possui_computadores_para_alunos)
    {
        this.possui_computadores_para_alunos = possui_computadores_para_alunos;
    }
    
    public String getId(){
        return this.id;
    }
    
    public float getCapacidadePessoas(){
        return this.capacidade_pessoas;
    }
    
    public boolean getPossuiComputadoresParaAlunos(){
        return this.possui_computadores_para_alunos;
    }

/*     public void reservarHorario(String data, int horario, String matricula) {
        if (!horarios.containsKey(data)) {
            horarios.put(data, new HashMap<>());
        }

        Map<Integer, String> horariosData = horarios.get(data);

        if (horariosData.size() != 8) {
            for (int i = horariosData.size() + 1; i <= 8; i++) {
                horariosData.put(i, "");
            }
        }

        if (horariosData.containsKey(horario)) {
            if (horariosData.get(horario).isEmpty()) {
                horariosData.put(horario, matricula);
                System.out.println("Horário reservado com sucesso.");
            } else {
                System.out.println("Horário indisponível.");
            }
        } else {
            System.out.println("Horário inválido!");
        }
    }

    public void liberarHorario(String data, int horario) {
        if (horarios.containsKey(data)) {
            Map<Integer, String> horariosData = horarios.get(data);

            if (horariosData.containsKey(horario)) {
                if (!horariosData.get(horario).isEmpty()) {
                    horariosData.put(horario, "");
                    System.out.println("Horário liberado com sucesso.");
                } else {
                    System.out.println("Horário já está livre.");
                }
            } else {
                System.out.println("Horário inválido!");
            }
        } else {
            System.out.println("Data inválida!");
        }
    }

    public void exibeHorariosLivresNaSalaUmaSemanaPraFrente(String dataInicial) {
        LocalDate data = LocalDate.parse(dataInicial, DateTimeFormatter.ISO_DATE);
        
        for (int i = 0; i < 9; i++) {
            String dataAtual = data.plusDays(i).format(DateTimeFormatter.ISO_DATE);
            
            if (horarios.containsKey(dataAtual)) {
                Map<Integer, String> horariosData = horarios.get(dataAtual);
                
                System.out.println("Data: " + dataAtual);
                
                for (int horario = 1; horario <= 8; horario++) {
                    if (horariosData.containsKey(horario) && horariosData.get(horario).isEmpty()) {
                        System.out.println("Horário " + horario + ": Livre");
                    }
                }
                
                System.out.println();
            }
        }
    }

    public boolean isHorarioDisponivel(String data, int horario) {
        // se a sala contiver 
    if (horarios.containsKey(data)) {
        Map<Integer, String> horariosData = horarios.get(data);
        
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
    } */

}

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

    public String registrarProfessor(Professor professor){
        //professor.get(0).registrarProfessor(this.professores, professor);
        professores.add(professor);

        return "Professor registrado com sucesso!";
    }    

    public String removerProfessor(Professor professor){
        professores.remove(professor);

        return "Professor removido com sucesso!";
    }

    public String registrarSala(Sala sala){        
        salas.add(sala);

        return "Sala registrada com sucesso!";
    }

    public String removerSala(Sala sala){
        salas.remove(sala);
        
        return "Sala removida com sucesso!";
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


    /*
    public void reservarSala(String identificadorContaOrigem, String pixDestino, double valor){        
        for(Cliente cliente : clientes){
            if(cliente.getConta().getIdentificador().equals(identificadorContaOrigem)){
                cliente.getConta().debitar(valor);
            }
            if(cliente.getChavePix().equals(pixDestino)){
                cliente.getConta().creditar(valor);
            }
        }        
    }
    
    public void transferenciaViaIdentificador(String identificadorContaOrigem, String identificadorDestino, double valor){   
        for(Cliente cliente : clientes){
            if(cliente.getConta().getIdentificador().equals(identificadorContaOrigem)){
                cliente.getConta().debitar(valor);
            }
            if(cliente.getConta().getIdentificador().equals(identificadorDestino)){
                cliente.getConta().creditar(valor);
            }
        }        
    }
    
    public int qntClientes(){
        return this.clientes.size();
    }
    
    public void exibirClientes(){
        for(Cliente cliente : clientes){
            System.out.println("Cliente: " + cliente.getNome());            
        }
    }
    
    */
}
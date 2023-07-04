public class Professor extends Pessoa
{
    private String matricula;
    
    public Professor(String nome, String cpf, String rg, String matricula, String funcao)
    {
        super(nome, cpf, rg);
        this.matricula = matricula;
    }
    
    public void setMatricula(String matricula){
        this.matricula = matricula;
    }
    
    public String getMatricula(){
        return this.matricula;
    }
}

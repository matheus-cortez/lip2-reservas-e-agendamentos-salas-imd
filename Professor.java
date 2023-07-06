public class Professor extends Pessoa
{
    private String matricula;
    
    public Professor(String nome, String cpf, String rg, String matricula)
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

    public String getDescricao(){
        return "Nome: " + this.getNome() + "\nCPF: " + this.getCpf() + "\nRG: " + this.getRg() + "\nMatricula: " + this.matricula + "\n";
    }
}

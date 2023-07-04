public class Sala
{
    private String id;
    private float capacidade_pessoas;
    private boolean possui_computadores_para_alunos;

    public Sala(String id, float capacidade_pessoas, boolean possui_computadores_para_alunos)
    {
        this.id = id;
        this.capacidade_pessoas = capacidade_pessoas;
        this.possui_computadores_para_alunos = possui_computadores_para_alunos;      
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
}

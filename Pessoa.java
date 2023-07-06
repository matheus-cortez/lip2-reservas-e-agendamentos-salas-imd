abstract class Pessoa
{
    private String nome;
    private String cpf;
    private String rg;

    public Pessoa(String nome, String cpf, String rg)
    {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;      
    }
    
    public void setNome(String nome)
    {
        this.nome = nome;
    }
    
    public void setCpf(String cpf)
    {
        this.nome = cpf;
    }
    
    public void setRg(String rg)
    {
        this.rg = rg;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public String getCpf(){
        return this.cpf;
    }
    
    public String getRg(){
        return this.rg;
    }

    public String getDescricao(){
        return "Nome: " + this.nome + "\nCPF: " + this.cpf + "\nRG: " + this.rg + "\n";
    }
}

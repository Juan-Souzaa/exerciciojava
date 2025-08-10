package exercicio36_cadastro_classeabstrata;

public abstract class Pessoa {
    protected String nome;
    protected Data nascimento;
    
    public Pessoa(String nome, Data nascimento) {
        this.nome = nome;
        this.nascimento = nascimento;
    }
    
    public abstract void imprimeDados();
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public Data getNascimento() {
        return nascimento;
    }
    
    public void setNascimento(Data nascimento) {
        this.nascimento = nascimento;
    }
    
    @Override
    public String toString() {
        return String.format("Nome: %s | Nascimento: %s", nome, nascimento);
    }
}

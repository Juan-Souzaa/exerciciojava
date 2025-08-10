package exercicio34_vcRiquinho;

public abstract class ProdutoInvestimento implements ProdutoCalculavel {
    protected String nome;
    protected String descricao;
    protected double rendimentoMensal;
    
    public ProdutoInvestimento(String nome, String descricao, double rendimentoMensal) {
        this.nome = nome;
        this.descricao = descricao;
        this.rendimentoMensal = rendimentoMensal;
    }
    


    

    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public double getRendimentoMensal() {
        return rendimentoMensal;
    }
    
    public void setRendimentoMensal(double rendimentoMensal) {
        this.rendimentoMensal = rendimentoMensal;
    }
    
    @Override
    public String toString() {
        return "ProdutoInvestimento{" +
                "nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", rendimentoMensal=" + String.format("%.2f%%", rendimentoMensal * 100) +
                '}';
    }
}

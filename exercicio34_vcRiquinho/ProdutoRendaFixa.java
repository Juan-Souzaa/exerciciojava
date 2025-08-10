package exercicio34_vcRiquinho;

public class ProdutoRendaFixa extends ProdutoInvestimento {
    private int periodoCarencia; // em dias
    
    public ProdutoRendaFixa(String nome, String descricao, double rendimentoMensal, int periodoCarencia) {
        super(nome, descricao, rendimentoMensal);
        this.periodoCarencia = periodoCarencia;
    }
    
    @Override
    public double calcularRendimento(int dias) {
        // Rendimento mensal convertido para o período especificado
        return rendimentoMensal * (dias / 30.0);
    }
    
    public int getPeriodoCarencia() {
        return periodoCarencia;
    }
    
    public void setPeriodoCarencia(int periodoCarencia) {
        this.periodoCarencia = periodoCarencia;
    }
    
    @Override
    public String toString() {
        return "ProdutoRendaFixa{" +
                "nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", rendimentoMensal=" + String.format("%.2f%%", rendimentoMensal * 100) +
                ", periodoCarencia=" + periodoCarencia + " dias" +
                '}';
    }
}

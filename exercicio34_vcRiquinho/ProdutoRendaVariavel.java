package exercicio34_vcRiquinho;

public class ProdutoRendaVariavel extends ProdutoInvestimento {
    
    public ProdutoRendaVariavel(String nome, String descricao, double rendimentoMensal) {
        super(nome, descricao, rendimentoMensal);
    }
    
    @Override
    public double calcularRendimento(int dias) {
        // Rendimento mensal esperado convertido para o período especificado
        return rendimentoMensal * (dias / 30.0);
    }
    
    @Override
    public String toString() {
        return "ProdutoRendaVariavel{" +
                "nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", rendimentoMensalEsperado=" + String.format("%.2f%%", rendimentoMensal * 100) +
                '}';
    }
}

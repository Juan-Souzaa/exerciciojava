package exercicio34_vcRiquinho;

import java.util.ArrayList;
import java.util.List;

public class ContaInvestimentoAutomatico extends Conta {
    private static final double TAXA_SERVICO_PF = 0.001; // 0.1% para PF
    private static final double TAXA_SERVICO_PJ = 0.0015; // 0.15% para PJ
    private List<ProdutoInvestimento> produtosInvestidos;
    
    public ContaInvestimentoAutomatico(String numero, Cliente titular) {
        super(numero, titular);
        this.produtosInvestidos = new ArrayList<>();
    }
    
    @Override
    public double calcularRendimento(int dias) {
        double rendimentoTotal = 0.0;
        
        for (ProdutoInvestimento produto : produtosInvestidos) {
            // Verifica se o produto está fora do período de carência
            if (produto instanceof ProdutoRendaFixa) {
                ProdutoRendaFixa rendaFixa = (ProdutoRendaFixa) produto;
                if (dias >= rendaFixa.getPeriodoCarencia()) {
                    rendimentoTotal += produto.calcularRendimento(dias);
                }
            } else {
                // Produto de renda variável sempre gera rendimento
                rendimentoTotal += produto.calcularRendimento(dias);
            }
        }
        
        return rendimentoTotal;
    }
    
    @Override
    public double calcularTaxaServico(double rendimento) {
        double taxaServico;
        
        if (titular instanceof PessoaFisica) {
            taxaServico = TAXA_SERVICO_PF;
        } else {
            taxaServico = TAXA_SERVICO_PJ;
        }
        
        return rendimento * taxaServico;
    }
    
    @Override
    public String getTipoConta() {
        return "Investimento Automático";
    }
    
    public void adicionarProduto(ProdutoInvestimento produto) {
        produtosInvestidos.add(produto);
    }
    
    public void removerProduto(ProdutoInvestimento produto) {
        produtosInvestidos.remove(produto);
    }
    
    public List<ProdutoInvestimento> getProdutosInvestidos() {
        return new ArrayList<>(produtosInvestidos);
    }
}

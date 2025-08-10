package exercicio34_vcRiquinho;

public class ContaCDI extends Conta {
    private static final double TAXA_CDI_DIARIA = 1.0 / 30.0; // 1/30 do CDI diariamente
    private static final double TAXA_SERVICO = 0.0007; // 0.07%
    
    public ContaCDI(String numero, Cliente titular) {
        super(numero, titular);
    }
    
    @Override
    public double calcularRendimento(int dias) {
        // Rendimento = saldo * (1/30 do CDI) * dias
        return saldo * TAXA_CDI_DIARIA * dias;
    }
    
    @Override
    public double calcularTaxaServico(double rendimento) {
        // Taxa de serviço fixa de 0.07% sobre os rendimentos
        return rendimento * TAXA_SERVICO;
    }
    
    @Override
    public String getTipoConta() {
        return "CDI";
    }
}

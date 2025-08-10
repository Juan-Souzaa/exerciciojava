package exercicio35_lanchonete;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private String nomeCliente;
    private double taxaServico;
    private List<Prato> itensConsumidos;
    
    public Pedido(String nomeCliente, double taxaServico) {
        this.nomeCliente = nomeCliente;
        this.taxaServico = taxaServico;
        this.itensConsumidos = new ArrayList<>();
    }
    
    public void adicionarItem(Prato prato) {
        itensConsumidos.add(prato);
    }
    
    public void removerItem(Prato prato) {
        itensConsumidos.remove(prato);
    }
    
    public double calcularTotal() {
        double total = 0.0;
        for (Prato prato : itensConsumidos) {
            total += prato.calcularPreco();
        }
        return total + taxaServico;
    }
    
    public void mostrarTroco(double valorRecebido) {
        double total = calcularTotal();
        if (valorRecebido >= total) {
            double troco = valorRecebido - total;
            System.out.printf("Valor recebido: R$ %.2f%n", valorRecebido);
            System.out.printf("Total do pedido: R$ %.2f%n", total);
            System.out.printf("Troco: R$ %.2f%n", troco);
        } else {
            System.out.printf("Valor insuficiente! Faltam R$ %.2f%n", total - valorRecebido);
        }
    }
    
    public String gerarNotaFiscal() {
        StringBuilder nota = new StringBuilder();
        nota.append("=== NOTA FISCAL - QUASE TRÊS LANCHES ===\n");
        nota.append("Cliente: ").append(nomeCliente).append("\n");
        nota.append("========================================\n");
        
        double subtotal = 0.0;
        for (int i = 0; i < itensConsumidos.size(); i++) {
            Prato prato = itensConsumidos.get(i);
            nota.append(String.format("%d. %s\n", i + 1, prato.toString()));
            subtotal += prato.calcularPreco();
        }
        
        nota.append("========================================\n");
        nota.append(String.format("Subtotal: R$ %.2f\n", subtotal));
        nota.append(String.format("Taxa de Serviço: R$ %.2f\n", taxaServico));
        nota.append(String.format("TOTAL: R$ %.2f\n", calcularTotal()));
        nota.append("========================================\n");
        nota.append("Obrigado pela preferência!\n");
        
        return nota.toString();
    }
    
    public String getNomeCliente() {
        return nomeCliente;
    }
    
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }
    
    public double getTaxaServico() {
        return taxaServico;
    }
    
    public void setTaxaServico(double taxaServico) {
        this.taxaServico = taxaServico;
    }
    
    public List<Prato> getItensConsumidos() {
        return new ArrayList<>(itensConsumidos);
    }
    
    @Override
    public String toString() {
        return String.format("Pedido de %s - %d itens - Total: R$ %.2f", 
                           nomeCliente, itensConsumidos.size(), calcularTotal());
    }
}

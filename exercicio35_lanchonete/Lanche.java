package exercicio35_lanchonete;

import java.time.LocalDate;

public class Lanche extends Prato {
    private String tipoPao;
    private String recheio;
    private String molho;
    
    public Lanche(double preco, LocalDate dataValidade, double peso,
                  String tipoPao, String recheio, String molho) {
        super(preco, dataValidade, peso);
        this.tipoPao = tipoPao;
        this.recheio = recheio;
        this.molho = molho;
    }
    
    @Override
    public double calcularPreco() {
        double precoFinal = preco;
        
        if (tipoPao.equalsIgnoreCase("integral") || tipoPao.equalsIgnoreCase("brioche")) {
            precoFinal += 2.00;
        }
        
        if (recheio.toLowerCase().contains("duplo")) {
            precoFinal += 6.00;
        }
        
        return precoFinal;
    }
    
    public String getTipoPao() {
        return tipoPao;
    }
    
    public void setTipoPao(String tipoPao) {
        this.tipoPao = tipoPao;
    }
    
    public String getRecheio() {
        return recheio;
    }
    
    public void setRecheio(String recheio) {
        this.recheio = recheio;
    }
    
    public String getMolho() {
        return molho;
    }
    
    public void setMolho(String molho) {
        this.molho = molho;
    }
    
    @Override
    public String toString() {
        return "Lanche [" + super.toString() + 
               String.format(" | Pão: %s | Recheio: %s | Molho: %s | Preço Final: R$ %.2f]", 
                           tipoPao, recheio, molho, calcularPreco());
    }
}

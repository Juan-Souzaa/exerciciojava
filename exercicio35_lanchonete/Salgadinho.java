package exercicio35_lanchonete;

import java.time.LocalDate;

public class Salgadinho extends Prato {
    private String tipo;
    private String massa;
    private String recheio;
    
    public Salgadinho(double preco, LocalDate dataValidade, double peso,
                      String tipo, String massa, String recheio) {
        super(preco, dataValidade, peso);
        this.tipo = tipo;
        this.massa = massa;
        this.recheio = recheio;
    }
    
    @Override
    public double calcularPreco() {
        double precoFinal = preco;
        
        if (tipo.equalsIgnoreCase("assado")) {
            precoFinal += 1.50;
        }
        
        if (recheio.toLowerCase().contains("queijo") || 
            recheio.toLowerCase().contains("camarão")) {
            precoFinal += 2.00;
        }
        
        return precoFinal;
    }
    
    public String getTipo() {
        return tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public String getMassa() {
        return massa;
    }
    
    public void setMassa(String massa) {
        this.massa = massa;
    }
    
    public String getRecheio() {
        return recheio;
    }
    
    public void setRecheio(String recheio) {
        this.recheio = recheio;
    }
    
    @Override
    public String toString() {
        return "Salgadinho [" + super.toString() + 
               String.format(" | Tipo: %s | Massa: %s | Recheio: %s | Preço Final: R$ %.2f]", 
                           tipo, massa, recheio, calcularPreco());
    }
}

package exercicio35_lanchonete;

import java.time.LocalDate;

public class Pizza extends Prato {
    private String recheio;
    private String borda;
    private String molho;
    
    public Pizza(double preco, LocalDate dataValidade, double peso, 
                 String recheio, String borda, String molho) {
        super(preco, dataValidade, peso);
        this.recheio = recheio;
        this.borda = borda;
        this.molho = molho;
    }
    
    @Override
    public double calcularPreco() {
        double precoFinal = preco;
        
        if (borda.equalsIgnoreCase("recheada")) {
            precoFinal += 5.00;
        }
        
        if (recheio.equalsIgnoreCase("premium")) {
            precoFinal += 8.00;
        }
        
        return precoFinal;
    }
    
    public String getRecheio() {
        return recheio;
    }
    
    public void setRecheio(String recheio) {
        this.recheio = recheio;
    }
    
    public String getBorda() {
        return borda;
    }
    
    public void setBorda(String borda) {
        this.borda = borda;
    }
    
    public String getMolho() {
        return molho;
    }
    
    public void setMolho(String molho) {
        this.molho = molho;
    }
    
    @Override
    public String toString() {
        return "Pizza [" + super.toString() + 
               String.format(" | Recheio: %s | Borda: %s | Molho: %s | Preço Final: R$ %.2f]", 
                           recheio, borda, molho, calcularPreco());
    }
}

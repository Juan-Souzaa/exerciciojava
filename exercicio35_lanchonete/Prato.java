package exercicio35_lanchonete;

import java.time.LocalDate;

public abstract class Prato {
    protected double preco;
    protected LocalDate dataValidade;
    protected double peso;
    
    public Prato(double preco, LocalDate dataValidade, double peso) {
        this.preco = preco;
        this.dataValidade = dataValidade;
        this.peso = peso;
    }
    
    public abstract double calcularPreco();
    
    public double getPreco() {
        return preco;
    }
    
    public void setPreco(double preco) {
        this.preco = preco;
    }
    
    public LocalDate getDataValidade() {
        return dataValidade;
    }
    
    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }
    
    public double getPeso() {
        return peso;
    }
    
    public void setPeso(double peso) {
        this.peso = peso;
    }
    
    @Override
    public String toString() {
        return String.format("Preço: R$ %.2f | Validade: %s | Peso: %.2fg", 
                           preco, dataValidade, peso);
    }
}

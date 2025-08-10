public class exercicio05 {
    public static void main(String[] args) {
        Carro carro1 = new Carro("Toyota", "Corolla", 2022);
        Carro carro2 = new Carro("Honda", "Civic", 2023);
        
        carro1.exibirInfo();
        carro2.exibirInfo();
    }
}

class Carro {
    private String marca;
    private String modelo;
    private int ano;
    
    public Carro(String marca, String modelo, int ano) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
    }
    
    public String getMarca() {
        return marca;
    }
    
    public String getModelo() {
        return modelo;
    }
    
    public int getAno() {
        return ano;
    }
    
    public void exibirInfo() {
        System.out.println("Carro: " + marca + " " + modelo + " (" + ano + ")");
    }
}

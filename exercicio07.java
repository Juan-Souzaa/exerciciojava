public class exercicio07 {
    public static void main(String[] args) {
        Veiculo veiculo = new Veiculo("Genérico", "Modelo Base");
        Carro carro = new Carro("Toyota", "Corolla", 4);
        Moto moto = new Moto("Honda", "CG 150", 150);
        
        System.out.println(veiculo);
        System.out.println(carro);
        System.out.println(moto);
    }
}

class Veiculo {
    protected String marca;
    protected String modelo;
    
    public Veiculo(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }
    
    @Override
    public String toString() {
        return "Veículo: " + marca + " " + modelo;
    }
}

class Carro extends Veiculo {
    private int numeroDePortas;
    
    public Carro(String marca, String modelo, int numeroDePortas) {
        super(marca, modelo);
        this.numeroDePortas = numeroDePortas;
    }
    
    @Override
    public String toString() {
        return "Carro: " + marca + " " + modelo + " - " + numeroDePortas + " portas";
    }
}

class Moto extends Veiculo {
    private int cilindradas;
    
    public Moto(String marca, String modelo, int cilindradas) {
        super(marca, modelo);
        this.cilindradas = cilindradas;
    }
    
    @Override
    public String toString() {
        return "Moto: " + marca + " " + modelo + " - " + cilindradas + "cc";
    }
}

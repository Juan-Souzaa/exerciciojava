public class exercicio06 {
    public static void main(String[] args) {
        try {
            Circulo circulo1 = new Circulo(5.0);
            System.out.println("Raio: " + circulo1.getRaio());
            System.out.println("Área: " + circulo1.calcularArea());
            
            circulo1.setRaio(7.5);
            System.out.println("Novo raio: " + circulo1.getRaio());
            System.out.println("Nova área: " + circulo1.calcularArea());
            
            circulo1.setRaio(-2.0);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}

class Circulo {
    private double raio;
    
    public Circulo(double raio) {
        setRaio(raio);
    }
    
    public double getRaio() {
        return raio;
    }
    
    public void setRaio(double raio) {
        if (raio <= 0) {
            throw new IllegalArgumentException("Raio deve ser maior que zero");
        }
        this.raio = raio;
    }
    
    public double calcularArea() {
        return Math.PI * raio * raio;
    }
}

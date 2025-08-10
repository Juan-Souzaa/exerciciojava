package exercicio36_cadastro_classeabstrata;

public class Gerente extends Funcionario {
    private String area;
    
    public Gerente(String nome, Data nascimento, float salario, String area) {
        super(nome, nascimento, salario);
        this.area = area;
    }
    
    @Override
    public float calculaImposto() {
        return salario * 0.03f;
    }
    
    @Override
    public void imprimeDados() {
        System.out.println("=== DADOS DO GERENTE ===");
        System.out.println("Nome: " + nome);
        System.out.println("Data de Nascimento: " + nascimento);
        System.out.printf("Salário: R$ %.2f%n", salario);
        System.out.println("Área: " + area);
        System.out.printf("Imposto (3%%): R$ %.2f%n", calculaImposto());
        System.out.println("========================");
    }
    
    public String getArea() {
        return area;
    }
    
    public void setArea(String area) {
        this.area = area;
    }
    
    @Override
    public String toString() {
        return String.format("Gerente [%s | Área: %s]", super.toString(), area);
    }
}

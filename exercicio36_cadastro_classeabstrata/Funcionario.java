package exercicio36_cadastro_classeabstrata;

public class Funcionario extends Pessoa {
    protected float salario;
    
    public Funcionario(String nome, Data nascimento, float salario) {
        super(nome, nascimento);
        this.salario = salario;
    }
    
    public float calculaImposto() {
        return salario * 0.05f;
    }
    
    @Override
    public void imprimeDados() {
        System.out.println("=== DADOS DO FUNCIONÁRIO ===");
        System.out.println("Nome: " + nome);
        System.out.println("Data de Nascimento: " + nascimento);
        System.out.printf("Salário: R$ %.2f%n", salario);
        System.out.printf("Imposto (5%%): R$ %.2f%n", calculaImposto());
        System.out.println("============================");
    }
    
    public float getSalario() {
        return salario;
    }
    
    public void setSalario(float salario) {
        this.salario = salario;
    }
    
    @Override
    public String toString() {
        return String.format("Funcionário [%s | Salário: R$ %.2f]", super.toString(), salario);
    }
}

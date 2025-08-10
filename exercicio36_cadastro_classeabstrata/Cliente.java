package exercicio36_cadastro_classeabstrata;

public class Cliente extends Pessoa {
    private int codigo;
    
    public Cliente(String nome, Data nascimento, int codigo) {
        super(nome, nascimento);
        this.codigo = codigo;
    }
    
    @Override
    public void imprimeDados() {
        System.out.println("=== DADOS DO CLIENTE ===");
        System.out.println("Nome: " + nome);
        System.out.println("Data de Nascimento: " + nascimento);
        System.out.println("Código do Cliente: " + codigo);
        System.out.println("========================");
    }
    
    public int getCodigo() {
        return codigo;
    }
    
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    @Override
    public String toString() {
        return String.format("Cliente [%s | Código: %d]", super.toString(), codigo);
    }
}

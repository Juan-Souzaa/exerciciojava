import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class exercicio31 {
    public static void main(String[] args) {
        Produto p = new Produto(101, "Notebook Gamer", 8500.0);
        AnalisadorDeClasse.inspecionar(p);
    }
}

class AnalisadorDeClasse {
    public static void inspecionar(Object obj) {
        Class<?> classe = obj.getClass();
        
        System.out.println("=== INSPEÇÃO DE CLASSE ===");
        System.out.println("Nome completo da classe: " + classe.getName());
        
        System.out.println("\n--- ATRIBUTOS ---");
        Field[] campos = classe.getDeclaredFields();
        for (Field campo : campos) {
            System.out.println("Atributo: " + campo.getName() + " (Tipo: " + campo.getType().getSimpleName() + ")");
        }
        
        System.out.println("\n--- MÉTODOS ---");
        Method[] metodos = classe.getDeclaredMethods();
        for (Method metodo : metodos) {
            System.out.println("Método: " + metodo.getName() + " (Retorno: " + metodo.getReturnType().getSimpleName() + ")");
        }
    }
}

class Produto {
    private int codigo;
    public String nome;
    protected double preco;
    
    public Produto(int codigo, String nome, double preco) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
    }
    
    private double calcularImposto() {
        return preco * 0.1;
    }
}

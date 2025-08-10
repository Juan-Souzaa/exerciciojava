import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Method;

public class exercicio33 {
    public static void main(String[] args) {
        MinhaClasseDeTeste obj = new MinhaClasseDeTeste();
        ExecutorDeTestes.executarTestes(obj);
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Teste {
}

class MinhaClasseDeTeste {
    @Teste
    public void testeSoma() {
        System.out.println("Executando testeSoma: SUCESSO");
    }
    
    public void metodoComum() {
        System.out.println("Este não é um teste.");
    }
    
    @Teste
    public void testeLogin() {
        System.out.println("Executando testeLogin: SUCESSO");
    }
}

class ExecutorDeTestes {
    public static void executarTestes(Object obj) {
        Class<?> classe = obj.getClass();
        Method[] metodos = classe.getMethods();
        
        System.out.println("=== EXECUTOR DE TESTES ===");
        System.out.println("Classe: " + classe.getSimpleName());
        System.out.println("Procurando métodos com anotação @Teste...\n");
        
        int testesExecutados = 0;
        
        for (Method metodo : metodos) {
            if (metodo.isAnnotationPresent(Teste.class)) {
                try {
                    System.out.println("Executando: " + metodo.getName());
                    metodo.invoke(obj);
                    testesExecutados++;
                } catch (Exception e) {
                    System.out.println("Erro ao executar " + metodo.getName() + ": " + e.getMessage());
                }
                System.out.println();
            }
        }
        
        System.out.println("Total de testes executados: " + testesExecutados);
    }
}

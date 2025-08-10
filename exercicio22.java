import java.util.TreeMap;
import java.util.Map;

public class exercicio22 {
    public static void main(String[] args) {
        Map<String, Double> notasAlunos = new TreeMap<>();
        
        System.out.println("Adicionando alunos fora da ordem alfabética:");
        notasAlunos.put("Zeca", 8.5);
        notasAlunos.put("Ana", 9.0);
        notasAlunos.put("Carlos", 7.5);
        notasAlunos.put("Beatriz", 8.0);
        notasAlunos.put("Daniel", 9.5);
        
        System.out.println("Alunos adicionados: Zeca, Ana, Carlos, Beatriz, Daniel");
        
        System.out.println("\nAlunos e notas em ordem alfabética (TreeMap):");
        int contador = 1;
        for (Map.Entry<String, Double> aluno : notasAlunos.entrySet()) {
            System.out.println(contador + "º: " + aluno.getKey() + " - Nota: " + aluno.getValue());
            contador++;
        }
        
        System.out.println("\nO TreeMap automaticamente ordena as chaves em ordem alfabética!");
    }
}

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class exercicio30 {
    public static void main(String[] args) {
        List<Aluno> alunos = new ArrayList<>();
        
        alunos.add(new Aluno("João", 8.5));
        alunos.add(new Aluno("Maria", 6.0));
        alunos.add(new Aluno("Pedro", 4.5));
        alunos.add(new Aluno("Ana", 9.0));
        alunos.add(new Aluno("Carlos", 5.5));
        alunos.add(new Aluno("Beatriz", 7.5));
        alunos.add(new Aluno("Daniel", 3.0));
        alunos.add(new Aluno("Juliana", 8.0));
        
        System.out.println("Lista de alunos:");
        for (Aluno aluno : alunos) {
            System.out.println(aluno.getNome() + " - Nota: " + aluno.getNota());
        }
        
        Map<String, List<Aluno>> alunosPorFaixa = agruparAlunosPorNota(alunos);
        
        System.out.println("\n=== Alunos Agrupados por Faixa de Nota ===");
        
        for (Map.Entry<String, List<Aluno>> entrada : alunosPorFaixa.entrySet()) {
            String faixa = entrada.getKey();
            List<Aluno> listaAlunos = entrada.getValue();
            
            System.out.println("\n" + faixa + " (" + listaAlunos.size() + " aluno(s)):");
            for (Aluno aluno : listaAlunos) {
                System.out.println("  - " + aluno.getNome() + " (Nota: " + aluno.getNota() + ")");
            }
        }
    }
    
    public static Map<String, List<Aluno>> agruparAlunosPorNota(List<Aluno> alunos) {
        Map<String, List<Aluno>> resultado = new HashMap<>();
        
        resultado.put("Aprovados", new ArrayList<>());
        resultado.put("Recuperação", new ArrayList<>());
        resultado.put("Reprovados", new ArrayList<>());
        
        for (Aluno aluno : alunos) {
            double nota = aluno.getNota();
            
            if (nota >= 7.0) {
                resultado.get("Aprovados").add(aluno);
            } else if (nota >= 5.0) {
                resultado.get("Recuperação").add(aluno);
            } else {
                resultado.get("Reprovados").add(aluno);
            }
        }
        
        return resultado;
    }
}

class Aluno {
    private String nome;
    private double nota;
    
    public Aluno(String nome, double nota) {
        this.nome = nome;
        this.nota = nota;
    }
    
    public String getNome() {
        return nome;
    }
    
    public double getNota() {
        return nota;
    }
}

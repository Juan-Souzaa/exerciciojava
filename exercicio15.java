import java.util.LinkedHashSet;
import java.util.Set;

public class exercicio15 {
    public static void main(String[] args) {
        Set<String> diasSemana = new LinkedHashSet<>();
        
        System.out.println("Adicionando dias da semana fora de ordem:");
        diasSemana.add("Quarta");
        diasSemana.add("Segunda");
        diasSemana.add("Sexta");
        diasSemana.add("Terça");
        diasSemana.add("Quinta");
        diasSemana.add("Domingo");
        diasSemana.add("Sábado");
        
        System.out.println("Ordem de inserção:");
        int contador = 1;
        for (String dia : diasSemana) {
            System.out.println(contador + "º: " + dia);
            contador++;
        }
        
        System.out.println("\nVerificando que a ordem de exibição é a mesma da inserção:");
        System.out.println("LinkedHashSet mantém a ordem de inserção dos elementos!");
    }
}

import java.util.TreeSet;
import java.util.Set;

public class exercicio16 {
    public static void main(String[] args) {
        Set<String> nomes = new TreeSet<>();
        
        System.out.println("Adicionando nomes fora da ordem alfabética:");
        nomes.add("Zeca");
        nomes.add("Ana");
        nomes.add("Carlos");
        nomes.add("Beatriz");
        nomes.add("Daniel");
        
        System.out.println("Nomes adicionados: Zeca, Ana, Carlos, Beatriz, Daniel");
        
        System.out.println("\nNomes em ordem alfabética natural (TreeSet):");
        int contador = 1;
        for (String nome : nomes) {
            System.out.println(contador + "º: " + nome);
            contador++;
        }
        
        System.out.println("\nO TreeSet automaticamente ordena os elementos!");
    }
}

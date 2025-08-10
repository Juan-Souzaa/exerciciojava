import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class exercicio13 {
    public static void main(String[] args) {
        ArrayList<Integer> numerosComDuplicatas = new ArrayList<>();
        
        numerosComDuplicatas.add(1);
        numerosComDuplicatas.add(2);
        numerosComDuplicatas.add(2);
        numerosComDuplicatas.add(3);
        numerosComDuplicatas.add(4);
        numerosComDuplicatas.add(4);
        numerosComDuplicatas.add(5);
        numerosComDuplicatas.add(5);
        numerosComDuplicatas.add(6);
        
        System.out.println("Lista original com duplicatas:");
        System.out.println(numerosComDuplicatas);
        System.out.println("Tamanho: " + numerosComDuplicatas.size());
        
        Set<Integer> numerosUnicos = new HashSet<>(numerosComDuplicatas);
        
        System.out.println("\nLista sem duplicatas (HashSet):");
        System.out.println(numerosUnicos);
        System.out.println("Tamanho: " + numerosUnicos.size());
        
        ArrayList<Integer> listaSemDuplicatas = new ArrayList<>(numerosUnicos);
        
        System.out.println("\nLista sem duplicatas (ArrayList):");
        System.out.println(listaSemDuplicatas);
        System.out.println("Tamanho: " + listaSemDuplicatas.size());
    }
}

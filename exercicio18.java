import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class exercicio18 {
    public static void main(String[] args) {
        Map<String, String> dicionario = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        
        dicionario.put("casa", "house");
        dicionario.put("carro", "car");
        dicionario.put("livro", "book");
        dicionario.put("água", "water");
        dicionario.put("sol", "sun");
        
        System.out.println("Dicionário Português -> Inglês");
        System.out.println("Palavras disponíveis: casa, carro, livro, água, sol");
        
        System.out.print("\nDigite uma palavra em português: ");
        String palavra = scanner.nextLine().toLowerCase();
        
        if (dicionario.containsKey(palavra)) {
            String traducao = dicionario.get(palavra);
            System.out.println("Tradução: " + palavra + " -> " + traducao);
        } else {
            System.out.println("Palavra não encontrada no dicionário.");
        }
        
        scanner.close();
    }
}

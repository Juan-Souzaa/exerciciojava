import java.util.HashMap;
import java.util.Map;

public class exercicio19 {
    public static void main(String[] args) {
        String texto = "Java é uma linguagem de programação orientada a objetos. Java é muito popular e Java é usado em muitas aplicações.";
        
        System.out.println("Texto original:");
        System.out.println(texto);
        
        Map<String, Integer> frequencia = new HashMap<>();
        
        String[] palavras = texto.toLowerCase().replaceAll("[^a-zA-Z\\s]", "").split("\\s+");
        
        for (String palavra : palavras) {
            if (!palavra.isEmpty()) {
                frequencia.put(palavra, frequencia.getOrDefault(palavra, 0) + 1);
            }
        }
        
        System.out.println("\nFrequência de cada palavra:");
        for (Map.Entry<String, Integer> entrada : frequencia.entrySet()) {
            System.out.println("'" + entrada.getKey() + "': " + entrada.getValue() + " vez(es)");
        }
    }
}

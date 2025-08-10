import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class exercicio28 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Inversor de Frase ===");
        System.out.print("Digite uma frase: ");
        String frase = scanner.nextLine();
        
        String[] palavras = frase.split("\\s+");
        
        Deque<String> pilhaPalavras = new ArrayDeque<>();
        
        System.out.println("\nEmpilhando palavras na ordem original:");
        for (String palavra : palavras) {
            if (!palavra.isEmpty()) {
                pilhaPalavras.push(palavra);
                System.out.println("Empilhado: " + palavra);
            }
        }
        
        System.out.println("\nDesempilhando para formar a frase invertida:");
        StringBuilder fraseInvertida = new StringBuilder();
        
        while (!pilhaPalavras.isEmpty()) {
            String palavra = pilhaPalavras.pop();
            fraseInvertida.append(palavra);
            
            if (!pilhaPalavras.isEmpty()) {
                fraseInvertida.append(" ");
            }
            
            System.out.println("Desempilhado: " + palavra);
        }
        
        System.out.println("\nFrase original: " + frase);
        System.out.println("Frase invertida: " + fraseInvertida.toString());
        
        scanner.close();
    }
}

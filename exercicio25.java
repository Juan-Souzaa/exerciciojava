import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class exercicio25 {
    public static void main(String[] args) {
        Deque<String> pilhaLivros = new ArrayDeque<>();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Pilha de Livros ===");
        System.out.println("Empilhando 3 livros...");
        
        System.out.print("Digite o nome do 1º livro: ");
        String livro1 = scanner.nextLine();
        pilhaLivros.push(livro1);
        
        System.out.print("Digite o nome do 2º livro: ");
        String livro2 = scanner.nextLine();
        pilhaLivros.push(livro2);
        
        System.out.print("Digite o nome do 3º livro: ");
        String livro3 = scanner.nextLine();
        pilhaLivros.push(livro3);
        
        System.out.println("\nLivros na pilha (do topo para a base):");
        for (String livro : pilhaLivros) {
            System.out.println("- " + livro);
        }
        
        System.out.println("\nDesempilhando um livro...");
        String livroRemovido = pilhaLivros.pop();
        System.out.println("Livro removido: " + livroRemovido);
        
        System.out.println("\nEspiando o livro no topo da pilha...");
        String livroTopo = pilhaLivros.peek();
        System.out.println("Livro no topo: " + livroTopo);
        
        System.out.println("\nLivros restantes na pilha:");
        for (String livro : pilhaLivros) {
            System.out.println("- " + livro);
        }
        
        scanner.close();
    }
}

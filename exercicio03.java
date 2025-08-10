import java.util.Scanner;
import java.util.Random;

public class exercicio03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int numeroAleatorio = random.nextInt(100) + 1;
        int tentativas = 0;
        int palpite;
        
        System.out.println("Adivinhe o número entre 1 e 100!");
        
        while (true) {
            System.out.println("Digite seu palpite:");
            palpite = scanner.nextInt();
            tentativas++;
            
            if (palpite == numeroAleatorio) {
                System.out.println("Parabéns! Você acertou!");
                System.out.println("Número de tentativas: " + tentativas);
                break;
            } else if (palpite > numeroAleatorio) {
                System.out.println("Muito alto! Tente um número menor.");
            } else {
                System.out.println("Muito baixo! Tente um número maior.");
            }
        }
        
        scanner.close();
    }
}

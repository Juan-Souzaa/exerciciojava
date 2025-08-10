import java.util.HashSet;
import java.util.Set;

public class exercicio14 {
    public static void main(String[] args) {
        Set<String> emails = new HashSet<>();
        
        System.out.println("Adicionando e-mails...");
        
        boolean adicionado1 = emails.add("joao@email.com");
        System.out.println("joao@email.com adicionado: " + adicionado1);
        
        boolean adicionado2 = emails.add("maria@email.com");
        System.out.println("maria@email.com adicionado: " + adicionado2);
        
        boolean adicionado3 = emails.add("pedro@email.com");
        System.out.println("pedro@email.com adicionado: " + adicionado3);
        
        boolean adicionado4 = emails.add("joao@email.com");
        System.out.println("joao@email.com adicionado novamente: " + adicionado4);
        
        boolean adicionado5 = emails.add("ana@email.com");
        System.out.println("ana@email.com adicionado: " + adicionado5);
        
        System.out.println("\nE-mails únicos no Set:");
        for (String email : emails) {
            System.out.println("- " + email);
        }
        
        System.out.println("\nTamanho do Set: " + emails.size());
        System.out.println("O e-mail duplicado não foi adicionado!");
    }
}

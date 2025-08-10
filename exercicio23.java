import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class exercicio23 {
    public static void main(String[] args) {
        Map<String, String> agenda = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        
        agenda.put("João", "(11) 99999-1111");
        agenda.put("Maria", "(11) 99999-2222");
        agenda.put("Pedro", "(11) 99999-3333");
        agenda.put("Ana", "(11) 99999-4444");
        
        System.out.println("Agenda atual:");
        for (Map.Entry<String, String> contato : agenda.entrySet()) {
            System.out.println(contato.getKey() + ": " + contato.getValue());
        }
        
        System.out.print("\nDigite um nome para verificar se existe: ");
        String nomeBusca = scanner.nextLine();
        
        if (agenda.containsKey(nomeBusca)) {
            System.out.println("✓ Nome encontrado na agenda!");
        } else {
            System.out.println("✗ Nome não encontrado na agenda.");
        }
        
        System.out.print("Digite um telefone para verificar se existe: ");
        String telefoneBusca = scanner.nextLine();
        
        if (agenda.containsValue(telefoneBusca)) {
            System.out.println("✓ Telefone encontrado na agenda!");
        } else {
            System.out.println("✗ Telefone não encontrado na agenda.");
        }
        
        scanner.close();
    }
}

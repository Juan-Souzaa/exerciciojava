import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class exercicio20 {
    public static void main(String[] args) {
        Map<String, String> agenda = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n=== Agenda de Contatos ===");
            System.out.println("1. Adicionar contato");
            System.out.println("2. Buscar telefone por nome");
            System.out.println("3. Listar todos os contatos");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            
            int opcao = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do contato: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite o telefone: ");
                    String telefone = scanner.nextLine();
                    agenda.put(nome, telefone);
                    System.out.println("Contato adicionado!");
                    break;
                    
                case 2:
                    System.out.print("Digite o nome para buscar: ");
                    String nomeBusca = scanner.nextLine();
                    if (agenda.containsKey(nomeBusca)) {
                        String telefoneEncontrado = agenda.get(nomeBusca);
                        System.out.println("Telefone de " + nomeBusca + ": " + telefoneEncontrado);
                    } else {
                        System.out.println("Contato não encontrado!");
                    }
                    break;
                    
                case 3:
                    if (agenda.isEmpty()) {
                        System.out.println("Agenda vazia!");
                    } else {
                        System.out.println("Contatos na agenda:");
                        for (Map.Entry<String, String> contato : agenda.entrySet()) {
                            System.out.println(contato.getKey() + ": " + contato.getValue());
                        }
                    }
                    break;
                    
                case 4:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                    
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}

import java.util.LinkedList;
import java.util.Scanner;

public class exercicio29 {
    public static void main(String[] args) {
        Navegador navegador = new Navegador();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n=== Navegador ===");
            System.out.println("1. Visitar URL");
            System.out.println("2. Voltar");
            System.out.println("3. Avançar");
            System.out.println("4. Mostrar histórico");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            
            int opcao = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcao) {
                case 1:
                    System.out.print("Digite a URL: ");
                    String url = scanner.nextLine();
                    navegador.visitar(url);
                    break;
                    
                case 2:
                    navegador.voltar();
                    break;
                    
                case 3:
                    navegador.avancar();
                    break;
                    
                case 4:
                    navegador.mostrarHistorico();
                    break;
                    
                case 5:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                    
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}

class Navegador {
    private LinkedList<String> historico = new LinkedList<>();
    private int posicaoAtual = -1;
    
    public void visitar(String url) {
        while (posicaoAtual < historico.size() - 1) {
            historico.removeLast();
        }
        
        historico.add(url);
        posicaoAtual = historico.size() - 1;
        System.out.println("Visitando: " + url);
    }
    
    public void voltar() {
        if (posicaoAtual > 0) {
            posicaoAtual--;
            System.out.println("Voltando para: " + historico.get(posicaoAtual));
        } else {
            System.out.println("Não é possível voltar mais!");
        }
    }
    
    public void avancar() {
        if (posicaoAtual < historico.size() - 1) {
            posicaoAtual++;
            System.out.println("Avançando para: " + historico.get(posicaoAtual));
        } else {
            System.out.println("Não é possível avançar mais!");
        }
    }
    
    public void mostrarHistorico() {
        if (historico.isEmpty()) {
            System.out.println("Histórico vazio!");
            return;
        }
        
        System.out.println("Histórico de navegação:");
        for (int i = 0; i < historico.size(); i++) {
            String marcador = (i == posicaoAtual) ? " → " : "   ";
            System.out.println(marcador + historico.get(i));
        }
    }
}

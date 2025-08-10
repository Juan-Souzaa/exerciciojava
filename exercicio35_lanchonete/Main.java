package exercicio35_lanchonete;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Prato> cardapio = new ArrayList<>();
    private static List<Pedido> pedidos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        inicializarCardapio();
        
        System.out.println("=== SISTEMA QUASE TRÊS LANCHES ===");
        
        while (true) {
            exibirMenu();
            int opcao = lerInteiro();
            
            switch (opcao) {
                case 1:
                    exibirCardapio();
                    break;
                case 2:
                    criarPedido();
                    break;
                case 3:
                    consultarPedidos();
                    break;
                case 4:
                    testarPolimorfismo();
                    break;
                case 0:
                    System.out.println("Sistema encerrado!");
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
    
    private static void exibirMenu() {
        System.out.println("\n=== MENU PRINCIPAL ===");
        System.out.println("1. Ver Cardápio");
        System.out.println("2. Criar Pedido");
        System.out.println("3. Consultar Pedidos");
        System.out.println("4. Testar Polimorfismo");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }
    
    private static void inicializarCardapio() {
        LocalDate validade = LocalDate.now().plusDays(3);
        
        cardapio.add(new Pizza(25.00, validade, 500, "Calabresa", "tradicional", "tomate"));
        cardapio.add(new Pizza(30.00, validade, 550, "Margherita", "recheada", "branco"));
        cardapio.add(new Pizza(35.00, validade, 600, "premium", "recheada", "pesto"));
        
        cardapio.add(new Lanche(15.00, validade, 300, "francês", "hambúrguer", "maionese"));
        cardapio.add(new Lanche(18.00, validade, 350, "integral", "frango duplo", "barbecue"));
        cardapio.add(new Lanche(20.00, validade, 400, "brioche", "picanha duplo", "chimichurri"));
        
        cardapio.add(new Salgadinho(5.00, validade, 80, "frito", "tradicional", "carne"));
        cardapio.add(new Salgadinho(6.00, validade, 90, "assado", "integral", "queijo"));
        cardapio.add(new Salgadinho(7.00, validade, 100, "assado", "folhada", "camarão"));
    }
    
    private static void exibirCardapio() {
        System.out.println("\n=== CARDÁPIO ===");
        for (int i = 0; i < cardapio.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, cardapio.get(i));
        }
    }
    
    private static void criarPedido() {
        System.out.print("\nNome do cliente: ");
        scanner.nextLine();
        String nomeCliente = scanner.nextLine();
        
        System.out.print("Taxa de serviço: R$ ");
        double taxaServico = lerDouble();
        
        Pedido pedido = new Pedido(nomeCliente, taxaServico);
        
        System.out.println("\n=== ADICIONANDO ITENS AO PEDIDO ===");
        while (true) {
            exibirCardapio();
            System.out.print("Escolha um item (0 para finalizar): ");
            int opcao = lerInteiro();
            
            if (opcao == 0) break;
            
            if (opcao >= 1 && opcao <= cardapio.size()) {
                pedido.adicionarItem(cardapio.get(opcao - 1));
                System.out.println("Item adicionado!");
            } else {
                System.out.println("Opção inválida!");
            }
        }
        
        if (!pedido.getItensConsumidos().isEmpty()) {
            pedidos.add(pedido);
            
            System.out.println("\n" + pedido.gerarNotaFiscal());
            
            System.out.print("Valor recebido em dinheiro: R$ ");
            double valorRecebido = lerDouble();
            pedido.mostrarTroco(valorRecebido);
            
            System.out.println("Pedido criado com sucesso!");
        } else {
            System.out.println("Pedido cancelado - nenhum item foi adicionado.");
        }
    }
    
    private static void consultarPedidos() {
        System.out.println("\n=== PEDIDOS REALIZADOS ===");
        if (pedidos.isEmpty()) {
            System.out.println("Nenhum pedido realizado ainda.");
            return;
        }
        
        for (int i = 0; i < pedidos.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, pedidos.get(i));
        }
        
        System.out.print("\nVer detalhes do pedido (número): ");
        int opcao = lerInteiro();
        
        if (opcao >= 1 && opcao <= pedidos.size()) {
            Pedido pedido = pedidos.get(opcao - 1);
            System.out.println("\n" + pedido.gerarNotaFiscal());
        } else {
            System.out.println("Pedido não encontrado!");
        }
    }
    
    private static void testarPolimorfismo() {
        System.out.println("\n=== TESTE DE POLIMORFISMO ===");
        System.out.println("Demonstrando como diferentes produtos calculam preços:");
        
        LocalDate validade = LocalDate.now().plusDays(1);
        
        Prato[] pratos = {
            new Pizza(20.00, validade, 400, "Calabresa", "recheada", "tomate"),
            new Lanche(12.00, validade, 250, "integral", "frango duplo", "maionese"), 
            new Salgadinho(4.00, validade, 70, "assado", "tradicional", "queijo")
        };
        
        System.out.println("\nPreços base vs. Preços finais (com polimorfismo):");
        for (Prato prato : pratos) {
            System.out.printf("%-15s | Base: R$ %.2f | Final: R$ %.2f\n", 
                            prato.getClass().getSimpleName(),
                            prato.getPreco(), 
                            prato.calcularPreco());
        }
        
        System.out.println("\nTodos os produtos implementam calcularPreco() de forma diferente!");
    }
    
    private static int lerInteiro() {
        while (!scanner.hasNextInt()) {
            System.out.print("Por favor, digite um número válido: ");
            scanner.next();
        }
        return scanner.nextInt();
    }
    
    private static double lerDouble() {
        while (!scanner.hasNextDouble()) {
            System.out.print("Por favor, digite um valor válido: ");
            scanner.next();
        }
        return scanner.nextDouble();
    }
}

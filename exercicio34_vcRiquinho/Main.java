package exercicio34_vcRiquinho;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Cliente> clientes = new ArrayList<>();
    private static List<ProdutoInvestimento> produtos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("=== SISTEMA VcRiquinho - Escritório de Investimentos ===\n");
        
        // Adicionar alguns produtos de exemplo
        adicionarProdutosExemplo();
        
        int opcao;
        do {
            exibirMenu();
            opcao = lerInteiro("Escolha uma opção: ");
            
            switch (opcao) {
                case 1:
                    gerenciarClientes();
                    break;
                case 2:
                    gerenciarProdutos();
                    break;
                case 3:
                    simularRendimento();
                    break;
                case 4:
                    listarClientes();
                    break;
                case 5:
                    listarProdutos();
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
        
        scanner.close();
    }
    
    private static void exibirMenu() {
        System.out.println("\n=== MENU PRINCIPAL ===");
        System.out.println("1. Gerenciar Clientes");
        System.out.println("2. Gerenciar Produtos de Investimento");
        System.out.println("3. Simular Rendimento");
        System.out.println("4. Listar Clientes");
        System.out.println("5. Listar Produtos");
        System.out.println("0. Sair");
        System.out.println("=====================");
    }
    
    private static void gerenciarClientes() {
        int opcao;
        do {
            System.out.println("\n=== GERENCIAMENTO DE CLIENTES ===");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Consultar Cliente");
            System.out.println("3. Atualizar Cliente");
            System.out.println("4. Excluir Cliente");
            System.out.println("5. Adicionar Conta");
            System.out.println("0. Voltar");
            
            opcao = lerInteiro("Escolha uma opção: ");
            
            switch (opcao) {
                case 1:
                    cadastrarCliente();
                    break;
                case 2:
                    consultarCliente();
                    break;
                case 3:
                    atualizarCliente();
                    break;
                case 4:
                    excluirCliente();
                    break;
                case 5:
                    adicionarConta();
                    break;
            }
        } while (opcao != 0);
    }
    
    private static void cadastrarCliente() {
        System.out.println("\n=== CADASTRO DE CLIENTE ===");
        
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        
        System.out.print("Email: ");
        String email = scanner.nextLine();
        
        System.out.println("Tipo de cliente:");
        System.out.println("1. Pessoa Física");
        System.out.println("2. Pessoa Jurídica");
        
        int tipo = lerInteiro("Escolha o tipo: ");
        
        Cliente cliente = null;
        
        if (tipo == 1) {
            System.out.print("CPF: ");
            String cpf = scanner.nextLine();
            cliente = new PessoaFisica(nome, email, cpf);
        } else if (tipo == 2) {
            System.out.print("CNPJ: ");
            String cnpj = scanner.nextLine();
            cliente = new PessoaJuridica(nome, email, cnpj);
        } else {
            System.out.println("Tipo inválido!");
            return;
        }
        
        // Criar conta padrão (corrente)
        String numeroConta = "CC" + (clientes.size() + 1);
        Conta conta = new ContaCorrente(numeroConta, cliente);
        cliente.adicionarConta(conta);
        
        clientes.add(cliente);
        System.out.println("Cliente cadastrado com sucesso!");
        System.out.println("Conta padrão criada: " + numeroConta);
    }
    
    private static void consultarCliente() {
        System.out.println("\n=== CONSULTA DE CLIENTE ===");
        
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado!");
            return;
        }
        
        System.out.print("Digite o nome ou documento do cliente: ");
        String busca = scanner.nextLine();
        
        for (Cliente cliente : clientes) {
            if (cliente.getNome().toLowerCase().contains(busca.toLowerCase()) ||
                cliente.getDocumento().contains(busca)) {
                System.out.println("\nCliente encontrado:");
                System.out.println(cliente);
                System.out.println("\nContas:");
                for (Conta conta : cliente.getContas()) {
                    System.out.println("  " + conta);
                }
                return;
            }
        }
        
        System.out.println("Cliente não encontrado!");
    }
    
    private static void atualizarCliente() {
        System.out.println("\n=== ATUALIZAÇÃO DE CLIENTE ===");
        
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado!");
            return;
        }
        
        System.out.print("Digite o documento do cliente: ");
        String documento = scanner.nextLine();
        
        for (Cliente cliente : clientes) {
            if (cliente.getDocumento().equals(documento)) {
                System.out.println("Cliente encontrado: " + cliente.getNome());
                
                System.out.print("Novo nome (ou Enter para manter): ");
                String novoNome = scanner.nextLine();
                if (!novoNome.isEmpty()) {
                    cliente.setNome(novoNome);
                }
                
                System.out.print("Novo email (ou Enter para manter): ");
                String novoEmail = scanner.nextLine();
                if (!novoEmail.isEmpty()) {
                    cliente.setEmail(novoEmail);
                }
                
                System.out.println("Cliente atualizado com sucesso!");
                return;
            }
        }
        
        System.out.println("Cliente não encontrado!");
    }
    
    private static void excluirCliente() {
        System.out.println("\n=== EXCLUSÃO DE CLIENTE ===");
        
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado!");
            return;
        }
        
        System.out.print("Digite o documento do cliente: ");
        String documento = scanner.nextLine();
        
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getDocumento().equals(documento)) {
                Cliente cliente = clientes.get(i);
                System.out.println("Cliente encontrado: " + cliente.getNome());
                
                System.out.print("Tem certeza que deseja excluir? (s/n): ");
                String confirmacao = scanner.nextLine().toLowerCase();
                
                if (confirmacao.equals("s") || confirmacao.equals("sim")) {
                    clientes.remove(i);
                    System.out.println("Cliente excluído com sucesso!");
                } else {
                    System.out.println("Operação cancelada!");
                }
                return;
            }
        }
        
        System.out.println("Cliente não encontrado!");
    }
    
    private static void adicionarConta() {
        System.out.println("\n=== ADICIONAR CONTA ===");
        
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado!");
            return;
        }
        
        System.out.print("Digite o documento do cliente: ");
        String documento = scanner.nextLine();
        
        Cliente cliente = null;
        for (Cliente c : clientes) {
            if (c.getDocumento().equals(documento)) {
                cliente = c;
                break;
            }
        }
        
        if (cliente == null) {
            System.out.println("Cliente não encontrado!");
            return;
        }
        
        System.out.println("Tipo de conta:");
        System.out.println("1. Conta Corrente");
        System.out.println("2. Conta CDI");
        System.out.println("3. Conta de Investimento Automático");
        
        int tipoConta = lerInteiro("Escolha o tipo: ");
        
        String numeroConta = "";
        Conta novaConta = null;
        
        switch (tipoConta) {
            case 1:
                numeroConta = "CC" + (clientes.size() + 1);
                novaConta = new ContaCorrente(numeroConta, cliente);
                break;
            case 2:
                numeroConta = "CDI" + (clientes.size() + 1);
                novaConta = new ContaCDI(numeroConta, cliente);
                break;
            case 3:
                numeroConta = "IA" + (clientes.size() + 1);
                novaConta = new ContaInvestimentoAutomatico(numeroConta, cliente);
                break;
            default:
                System.out.println("Tipo inválido!");
                return;
        }
        
        cliente.adicionarConta(novaConta);
        System.out.println("Conta " + numeroConta + " adicionada com sucesso!");
    }
    
    private static void gerenciarProdutos() {
        int opcao;
        do {
            System.out.println("\n=== GERENCIAMENTO DE PRODUTOS ===");
            System.out.println("1. Cadastrar Produto");
            System.out.println("2. Consultar Produto");
            System.out.println("3. Atualizar Produto");
            System.out.println("4. Excluir Produto");
            System.out.println("0. Voltar");
            
            opcao = lerInteiro("Escolha uma opção: ");
            
            switch (opcao) {
                case 1:
                    cadastrarProduto();
                    break;
                case 2:
                    consultarProduto();
                    break;
                case 3:
                    atualizarProduto();
                    break;
                case 4:
                    excluirProduto();
                    break;
            }
        } while (opcao != 0);
    }
    
    private static void cadastrarProduto() {
        System.out.println("\n=== CADASTRO DE PRODUTO ===");
        
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();
        
        System.out.print("Rendimento mensal (%): ");
        double rendimentoMensal = lerDouble() / 100.0; // Converte para decimal
        
        System.out.println("Tipo de produto:");
        System.out.println("1. Renda Fixa");
        System.out.println("2. Renda Variável");
        
        int tipo = lerInteiro("Escolha o tipo: ");
        
        ProdutoInvestimento produto = null;
        
        if (tipo == 1) {
            System.out.print("Período de carência (dias): ");
            int periodoCarencia = lerInteiro();
            produto = new ProdutoRendaFixa(nome, descricao, rendimentoMensal, periodoCarencia);
        } else if (tipo == 2) {
            produto = new ProdutoRendaVariavel(nome, descricao, rendimentoMensal);
        } else {
            System.out.println("Tipo inválido!");
            return;
        }
        
        produtos.add(produto);
        System.out.println("Produto cadastrado com sucesso!");
    }
    
    private static void consultarProduto() {
        System.out.println("\n=== CONSULTA DE PRODUTO ===");
        
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado!");
            return;
        }
        
        System.out.print("Digite o nome do produto: ");
        String busca = scanner.nextLine();
        
        for (ProdutoInvestimento produto : produtos) {
            if (produto.getNome().toLowerCase().contains(busca.toLowerCase())) {
                System.out.println("\nProduto encontrado:");
                System.out.println(produto);
                return;
            }
        }
        
        System.out.println("Produto não encontrado!");
    }
    
    private static void atualizarProduto() {
        System.out.println("\n=== ATUALIZAÇÃO DE PRODUTO ===");
        
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado!");
            return;
        }
        
        System.out.print("Digite o nome do produto: ");
        String nome = scanner.nextLine();
        
        for (ProdutoInvestimento produto : produtos) {
            if (produto.getNome().equals(nome)) {
                System.out.println("Produto encontrado: " + produto.getNome());
                
                System.out.print("Nova descrição (ou Enter para manter): ");
                String novaDescricao = scanner.nextLine();
                if (!novaDescricao.isEmpty()) {
                    produto.setDescricao(novaDescricao);
                }
                
                System.out.print("Novo rendimento mensal % (ou 0 para manter): ");
                double novoRendimento = lerDouble();
                if (novoRendimento > 0) {
                    produto.setRendimentoMensal(novoRendimento / 100.0);
                }
                
                System.out.println("Produto atualizado com sucesso!");
                return;
            }
        }
        
        System.out.println("Produto não encontrado!");
    }
    
    private static void excluirProduto() {
        System.out.println("\n=== EXCLUSÃO DE PRODUTO ===");
        
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado!");
            return;
        }
        
        System.out.print("Digite o nome do produto: ");
        String nome = scanner.nextLine();
        
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getNome().equals(nome)) {
                ProdutoInvestimento produto = produtos.get(i);
                System.out.println("Produto encontrado: " + produto.getNome());
                
                System.out.print("Tem certeza que deseja excluir? (s/n): ");
                String confirmacao = scanner.nextLine().toLowerCase();
                
                if (confirmacao.equals("s") || confirmacao.equals("sim")) {
                    produtos.remove(i);
                    System.out.println("Produto excluído com sucesso!");
                } else {
                    System.out.println("Operação cancelada!");
                }
                return;
            }
        }
        
        System.out.println("Produto não encontrado!");
    }
    
    private static void simularRendimento() {
        System.out.println("\n=== SIMULAÇÃO DE RENDIMENTO ===");
        
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado!");
            return;
        }
        
        System.out.print("Digite o documento do cliente: ");
        String documento = scanner.nextLine();
        
        Cliente cliente = null;
        for (Cliente c : clientes) {
            if (c.getDocumento().equals(documento)) {
                cliente = c;
                break;
            }
        }
        
        if (cliente == null) {
            System.out.println("Cliente não encontrado!");
            return;
        }
        
        System.out.println("Períodos disponíveis:");
        System.out.println("1. 30 dias");
        System.out.println("2. 60 dias");
        System.out.println("3. 90 dias");
        System.out.println("4. 180 dias");
        
        int opcao = lerInteiro("Escolha o período: ");
        int dias;
        
        switch (opcao) {
            case 1: dias = 30; break;
            case 2: dias = 60; break;
            case 3: dias = 90; break;
            case 4: dias = 180; break;
            default:
                System.out.println("Período inválido!");
                return;
        }
        
        System.out.println("\n=== SIMULAÇÃO PARA " + dias + " DIAS ===");
        System.out.println("Cliente: " + cliente.getNome() + " (" + cliente.getTipoCliente() + ")");
        
        double rendimentoTotal = 0.0;
        double taxaServicoTotal = 0.0;
        
        for (Conta conta : cliente.getContas()) {
            double rendimento = conta.calcularRendimento(dias);
            double taxaServico = conta.calcularTaxaServico(rendimento);
            
            System.out.println("\nConta: " + conta.getNumero() + " (" + conta.getTipoConta() + ")");
            System.out.println("Saldo: R$ " + String.format("%.2f", conta.getSaldo()));
            System.out.println("Rendimento: R$ " + String.format("%.2f", rendimento));
            System.out.println("Taxa de Serviço: R$ " + String.format("%.2f", taxaServico));
            
            rendimentoTotal += rendimento;
            taxaServicoTotal += taxaServico;
        }
        
        System.out.println("\n=== RESUMO ===");
        System.out.println("Rendimento Total: R$ " + String.format("%.2f", rendimentoTotal));
        System.out.println("Taxa de Serviço Total: R$ " + String.format("%.2f", taxaServicoTotal));
        System.out.println("Rendimento Líquido: R$ " + String.format("%.2f", rendimentoTotal - taxaServicoTotal));
    }
    
    private static void listarClientes() {
        System.out.println("\n=== LISTA DE CLIENTES ===");
        
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado!");
            return;
        }
        
        for (int i = 0; i < clientes.size(); i++) {
            Cliente cliente = clientes.get(i);
            System.out.println((i + 1) + ". " + cliente);
        }
    }
    
    private static void listarProdutos() {
        System.out.println("\n=== LISTA DE PRODUTOS ===");
        
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado!");
            return;
        }
        
        for (int i = 0; i < produtos.size(); i++) {
            ProdutoInvestimento produto = produtos.get(i);
            System.out.println((i + 1) + ". " + produto);
        }
    }
    
    private static void adicionarProdutosExemplo() {
        produtos.add(new ProdutoRendaFixa("CDB Banco A", "CDB com rendimento fixo", 0.008, 30));
        produtos.add(new ProdutoRendaFixa("LCI Banco B", "LCI com rendimento fixo", 0.009, 60));
        produtos.add(new ProdutoRendaVariavel("Ações Petrobras", "Ações da Petrobras", 0.012));
        produtos.add(new ProdutoRendaVariavel("FII Shopping", "Fundo Imobiliário", 0.010));
        
        System.out.println("Produtos de exemplo adicionados!");
    }
    
    private static int lerInteiro() {
        return lerInteiro("");
    }
    
    private static int lerInteiro(String mensagem) {
        while (true) {
            try {
                if (!mensagem.isEmpty()) {
                    System.out.print(mensagem);
                }
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, digite um número inteiro válido!");
            }
        }
    }
    
    private static double lerDouble() {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, digite um número válido!");
            }
        }
    }
}

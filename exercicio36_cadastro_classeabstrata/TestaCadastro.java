package exercicio36_cadastro_classeabstrata;

import java.util.Scanner;

public class TestaCadastro {
    private static CadastroPessoas cadastro = new CadastroPessoas();
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE CADASTRO DE PESSOAS ===");
        
        cadastrarExemplos();
        
        while (true) {
            exibirMenu();
            int opcao = lerInteiro();
            
            switch (opcao) {
                case 1:
                    cadastrarCliente();
                    break;
                case 2:
                    cadastrarFuncionario();
                    break;
                case 3:
                    cadastrarGerente();
                    break;
                case 4:
                    cadastro.imprimeCadastro();
                    break;
                case 5:
                    buscarPessoa();
                    break;
                case 6:
                    removerPessoa();
                    break;
                case 7:
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
    
    private static void cadastrarExemplos() {
        System.out.println("Cadastrando exemplos...");
        
        Data dataCliente = new Data(15, 3, 1985);
        Cliente cliente = new Cliente("João Silva", dataCliente, 1001);
        cadastro.cadastraPessoa(cliente);
        
        Data dataFunc = new Data(22, 7, 1990);
        Funcionario funcionario = new Funcionario("Maria Santos", dataFunc, 3500.00f);
        cadastro.cadastraPessoa(funcionario);
        
        Data dataGer = new Data(10, 11, 1982);
        Gerente gerente = new Gerente("Carlos Oliveira", dataGer, 8500.00f, "Vendas");
        cadastro.cadastraPessoa(gerente);
        
        System.out.println("Exemplos cadastrados!\n");
    }
    
    private static void exibirMenu() {
        System.out.println("\n=== MENU PRINCIPAL ===");
        System.out.println("1. Cadastrar Cliente");
        System.out.println("2. Cadastrar Funcionário");
        System.out.println("3. Cadastrar Gerente");
        System.out.println("4. Imprimir Todo o Cadastro");
        System.out.println("5. Buscar Pessoa");
        System.out.println("6. Remover Pessoa");
        System.out.println("7. Testar Polimorfismo");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }
    
    private static void cadastrarCliente() {
        System.out.print("Nome do cliente: ");
        scanner.nextLine();
        String nome = scanner.nextLine();
        
        System.out.print("Dia nascimento: ");
        int dia = lerInteiro();
        System.out.print("Mês nascimento: ");
        int mes = lerInteiro();
        System.out.print("Ano nascimento: ");
        int ano = lerInteiro();
        
        System.out.print("Código do cliente: ");
        int codigo = lerInteiro();
        
        Data nascimento = new Data(dia, mes, ano);
        Cliente cliente = new Cliente(nome, nascimento, codigo);
        cadastro.cadastraPessoa(cliente);
    }
    
    private static void cadastrarFuncionario() {
        System.out.print("Nome do funcionário: ");
        scanner.nextLine();
        String nome = scanner.nextLine();
        
        System.out.print("Dia nascimento: ");
        int dia = lerInteiro();
        System.out.print("Mês nascimento: ");
        int mes = lerInteiro();
        System.out.print("Ano nascimento: ");
        int ano = lerInteiro();
        
        System.out.print("Salário: R$ ");
        float salario = lerFloat();
        
        Data nascimento = new Data(dia, mes, ano);
        Funcionario funcionario = new Funcionario(nome, nascimento, salario);
        cadastro.cadastraPessoa(funcionario);
    }
    
    private static void cadastrarGerente() {
        System.out.print("Nome do gerente: ");
        scanner.nextLine();
        String nome = scanner.nextLine();
        
        System.out.print("Dia nascimento: ");
        int dia = lerInteiro();
        System.out.print("Mês nascimento: ");
        int mes = lerInteiro();
        System.out.print("Ano nascimento: ");
        int ano = lerInteiro();
        
        System.out.print("Salário: R$ ");
        float salario = lerFloat();
        
        System.out.print("Área de atuação: ");
        scanner.nextLine();
        String area = scanner.nextLine();
        
        Data nascimento = new Data(dia, mes, ano);
        Gerente gerente = new Gerente(nome, nascimento, salario, area);
        cadastro.cadastraPessoa(gerente);
    }
    
    private static void buscarPessoa() {
        System.out.print("Nome para buscar: ");
        scanner.nextLine();
        String nome = scanner.nextLine();
        
        Pessoa pessoa = cadastro.buscarPorNome(nome);
        if (pessoa != null) {
            System.out.println("\nPessoa encontrada:");
            pessoa.imprimeDados();
        } else {
            System.out.println("Pessoa não encontrada.");
        }
    }
    
    private static void removerPessoa() {
        System.out.print("Nome para remover: ");
        scanner.nextLine();
        String nome = scanner.nextLine();
        cadastro.removerPessoa(nome);
    }
    
    private static void testarPolimorfismo() {
        System.out.println("\n=== TESTE DE POLIMORFISMO ===");
        System.out.println("Demonstrando polimorfismo com imprimeDados():");
        
        Data data1 = new Data(1, 1, 2000);
        Data data2 = new Data(2, 2, 1995);
        Data data3 = new Data(3, 3, 1988);
        
        Pessoa[] pessoas = {
            new Cliente("Teste Cliente", data1, 999),
            new Funcionario("Teste Funcionário", data2, 2500.00f),
            new Gerente("Teste Gerente", data3, 6000.00f, "TI")
        };
        
        for (Pessoa pessoa : pessoas) {
            pessoa.imprimeDados();
            System.out.println();
        }
        
        System.out.println("Note como cada classe implementa imprimeDados() de forma diferente!");
    }
    
    private static int lerInteiro() {
        while (!scanner.hasNextInt()) {
            System.out.print("Por favor, digite um número válido: ");
            scanner.next();
        }
        return scanner.nextInt();
    }
    
    private static float lerFloat() {
        while (!scanner.hasNextFloat()) {
            System.out.print("Por favor, digite um valor válido: ");
            scanner.next();
        }
        return scanner.nextFloat();
    }
}

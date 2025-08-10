package exercicio36_cadastro_classeabstrata;

import java.util.ArrayList;

public class CadastroPessoas {
    private int qtdAtual;
    private ArrayList<Pessoa> pessoas;
    
    public CadastroPessoas() {
        this.qtdAtual = 0;
        this.pessoas = new ArrayList<>();
    }
    
    public void cadastraPessoa(Pessoa pessoa) {
        pessoas.add(pessoa);
        qtdAtual++;
        System.out.println("Pessoa cadastrada com sucesso!");
    }
    
    public void imprimeCadastro() {
        System.out.println("\n=== CADASTRO DE PESSOAS ===");
        System.out.println("Quantidade total: " + qtdAtual);
        System.out.println("===========================");
        
        if (qtdAtual == 0) {
            System.out.println("Nenhuma pessoa cadastrada.");
            return;
        }
        
        for (int i = 0; i < pessoas.size(); i++) {
            System.out.println("\n--- Pessoa " + (i + 1) + " ---");
            pessoas.get(i).imprimeDados();
        }
    }
    
    public Pessoa buscarPorNome(String nome) {
        for (Pessoa pessoa : pessoas) {
            if (pessoa.getNome().equalsIgnoreCase(nome)) {
                return pessoa;
            }
        }
        return null;
    }
    
    public void removerPessoa(String nome) {
        Pessoa pessoa = buscarPorNome(nome);
        if (pessoa != null) {
            pessoas.remove(pessoa);
            qtdAtual--;
            System.out.println("Pessoa removida com sucesso!");
        } else {
            System.out.println("Pessoa não encontrada.");
        }
    }
    
    public int getQtdAtual() {
        return qtdAtual;
    }
    
    public ArrayList<Pessoa> getPessoas() {
        return new ArrayList<>(pessoas);
    }
}

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class exercicio26 {
    public static void main(String[] args) {
        Map<String, List<Produto>> catalogo = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        
        List<Produto> eletronicos = new ArrayList<>();
        eletronicos.add(new Produto("Notebook", 3500.0));
        eletronicos.add(new Produto("Smartphone", 1200.0));
        eletronicos.add(new Produto("Tablet", 800.0));
        
        List<Produto> livros = new ArrayList<>();
        livros.add(new Produto("Java Programming", 150.0));
        livros.add(new Produto("Design Patterns", 200.0));
        livros.add(new Produto("Clean Code", 180.0));
        
        List<Produto> roupas = new ArrayList<>();
        roupas.add(new Produto("Camiseta", 50.0));
        roupas.add(new Produto("Calça", 120.0));
        roupas.add(new Produto("Tênis", 200.0));
        
        catalogo.put("Eletrônicos", eletronicos);
        catalogo.put("Livros", livros);
        catalogo.put("Roupas", roupas);
        
        System.out.println("Categorias disponíveis:");
        for (String categoria : catalogo.keySet()) {
            System.out.println("- " + categoria);
        }
        
        System.out.print("\nDigite uma categoria para listar os produtos: ");
        String categoriaBusca = scanner.nextLine();
        
        if (catalogo.containsKey(categoriaBusca)) {
            List<Produto> produtos = catalogo.get(categoriaBusca);
            System.out.println("\nProdutos da categoria '" + categoriaBusca + "':");
            for (int i = 0; i < produtos.size(); i++) {
                Produto produto = produtos.get(i);
                System.out.println((i+1) + ". " + produto.getNome() + " - R$ " + produto.getPreco());
            }
        } else {
            System.out.println("Categoria não encontrada!");
        }
        
        scanner.close();
    }
}

class Produto {
    private String nome;
    private double preco;
    
    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }
    
    public String getNome() {
        return nome;
    }
    
    public double getPreco() {
        return preco;
    }
}

import java.util.TreeSet;
import java.util.Set;

public class exercicio17 {
    public static void main(String[] args) {
        Set<Produto> produtos = new TreeSet<>();
        
        produtos.add(new Produto("Notebook", 3500.0));
        produtos.add(new Produto("Mouse", 50.0));
        produtos.add(new Produto("Teclado", 150.0));
        produtos.add(new Produto("Monitor", 800.0));
        produtos.add(new Produto("Headset", 200.0));
        
        System.out.println("Produtos ordenados por preço (menor para maior):");
        int contador = 1;
        for (Produto produto : produtos) {
            System.out.println(contador + "º: " + produto.getNome() + " - R$ " + produto.getPreco());
            contador++;
        }
        
        System.out.println("\nO TreeSet ordena automaticamente usando o método compareTo!");
    }
}

class Produto implements Comparable<Produto> {
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
    
    @Override
    public int compareTo(Produto outro) {
        return Double.compare(this.preco, outro.preco);
    }
}

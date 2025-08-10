import java.util.LinkedHashMap;
import java.util.Map;

public class exercicio21 {
    public static void main(String[] args) {
        Map<Integer, String> produtos = new LinkedHashMap<>();
        
        System.out.println("Adicionando produtos na ordem:");
        produtos.put(1001, "Notebook");
        produtos.put(1002, "Mouse");
        produtos.put(1003, "Teclado");
        produtos.put(1004, "Monitor");
        produtos.put(1005, "Headset");
        
        System.out.println("Produtos adicionados na ordem: 1001, 1002, 1003, 1004, 1005");
        
        System.out.println("\nListando produtos na ordem de inserção:");
        int contador = 1;
        for (Map.Entry<Integer, String> produto : produtos.entrySet()) {
            System.out.println(contador + "º: Código " + produto.getKey() + " - " + produto.getValue());
            contador++;
        }
        
        System.out.println("\nO LinkedHashMap mantém a ordem de inserção dos elementos!");
    }
}

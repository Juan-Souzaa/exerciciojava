import java.util.ArrayList;
import java.util.Scanner;

public class exercicio12 {
    public static void main(String[] args) {
        ArrayList<String> cidades = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        
        cidades.add("São Paulo");
        cidades.add("Rio de Janeiro");
        cidades.add("Belo Horizonte");
        cidades.add("Salvador");
        cidades.add("Brasília");
        cidades.add("Fortaleza");
        cidades.add("Curitiba");
        cidades.add("Recife");
        
        System.out.println("Cidades cadastradas:");
        for (int i = 0; i < cidades.size(); i++) {
            System.out.println(i + ": " + cidades.get(i));
        }
        
        System.out.print("\nDigite o nome de uma cidade para buscar: ");
        String cidadeBusca = scanner.nextLine();
        
        if (cidades.contains(cidadeBusca)) {
            int indice = cidades.indexOf(cidadeBusca);
            System.out.println("Cidade encontrada!");
            System.out.println("Nome: " + cidadeBusca);
            System.out.println("Índice: " + indice);
        } else {
            System.out.println("Cidade não encontrada na lista.");
        }
        
        scanner.close();
    }
}

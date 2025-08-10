import java.util.LinkedList;

public class exercicio11 {
    public static void main(String[] args) {
        LinkedList<String> filaAtendimento = new LinkedList<>();
        
        System.out.println("Adicionando 5 clientes na fila:");
        filaAtendimento.add("João");
        filaAtendimento.add("Maria");
        filaAtendimento.add("Pedro");
        filaAtendimento.add("Ana");
        filaAtendimento.add("Carlos");
        
        System.out.println("Fila inicial: " + filaAtendimento);
        
        System.out.println("\nAtendendo os 2 primeiros clientes:");
        String cliente1 = filaAtendimento.removeFirst();
        String cliente2 = filaAtendimento.removeFirst();
        System.out.println("Atendido: " + cliente1);
        System.out.println("Atendido: " + cliente2);
        System.out.println("Fila após atendimentos: " + filaAtendimento);
        
        System.out.println("\nAdicionando 2 clientes prioritários no início:");
        filaAtendimento.addFirst("VIP - Roberto");
        filaAtendimento.addFirst("URGENTE - Sofia");
        
        System.out.println("Fila final: " + filaAtendimento);
        System.out.println("Ordem de atendimento (do início ao fim):");
        for (int i = 0; i < filaAtendimento.size(); i++) {
            System.out.println((i+1) + "º: " + filaAtendimento.get(i));
        }
    }
}

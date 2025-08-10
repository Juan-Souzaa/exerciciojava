import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class exercicio27 {
    public static void main(String[] args) {
        List<String> participantes = new ArrayList<>();
        
        participantes.add("João");
        participantes.add("Maria");
        participantes.add("Pedro");
        participantes.add("Ana");
        participantes.add("Carlos");
        participantes.add("João");
        participantes.add("Beatriz");
        participantes.add("Pedro");
        participantes.add("Daniel");
        participantes.add("Maria");
        
        System.out.println("Lista de participantes (com repetições):");
        for (int i = 0; i < participantes.size(); i++) {
            System.out.println((i+1) + ". " + participantes.get(i));
        }
        
        System.out.println("\nTamanho da lista: " + participantes.size());
        
        List<String> ganhadores = sortearGanhadores(participantes, 3);
        
        System.out.println("\nGanhadores únicos sorteados:");
        for (int i = 0; i < ganhadores.size(); i++) {
            System.out.println((i+1) + "º lugar: " + ganhadores.get(i));
        }
    }
    
    public static List<String> sortearGanhadores(List<String> participantes, int quantidade) {
        Set<String> participantesUnicos = new HashSet<>(participantes);
        List<String> listaUnicos = new ArrayList<>(participantesUnicos);
        List<String> ganhadores = new ArrayList<>();
        Random random = new Random();
        
        System.out.println("\nParticipantes únicos: " + participantesUnicos.size());
        
        int sorteios = Math.min(quantidade, listaUnicos.size());
        
        for (int i = 0; i < sorteios; i++) {
            int indice = random.nextInt(listaUnicos.size());
            String ganhador = listaUnicos.remove(indice);
            ganhadores.add(ganhador);
        }
        
        return ganhadores;
    }
}

import java.util.LinkedList;
import java.util.Queue;

public class exercicio24 {
    public static void main(String[] args) {
        Queue<String> filaImpressao = new LinkedList<>();
        
        System.out.println("Adicionando documentos na fila de impressão:");
        filaImpressao.add("Documento1.pdf");
        filaImpressao.add("Foto.png");
        filaImpressao.add("Relatorio.docx");
        filaImpressao.add("Apresentacao.pptx");
        filaImpressao.add("Planilha.xlsx");
        
        System.out.println("Documentos na fila: " + filaImpressao);
        System.out.println("Tamanho da fila: " + filaImpressao.size());
        
        System.out.println("\nProcessando a fila de impressão:");
        int contador = 1;
        while (!filaImpressao.isEmpty()) {
            String documento = filaImpressao.poll();
            System.out.println(contador + "º documento impresso: " + documento);
            contador++;
        }
        
        System.out.println("\nFila processada completamente!");
        System.out.println("Tamanho da fila: " + filaImpressao.size());
    }
}

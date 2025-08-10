public class exercicio04 {
    public static void main(String[] args) {
        int[] numeros = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int somaImpares = 0;
        
        System.out.println("Array de números:");
        for (int numero : numeros) {
            System.out.print(numero + " ");
        }
        
        System.out.println("\n\nCalculando soma dos números ímpares...");
        
        for (int numero : numeros) {
            if (numero % 2 != 0) {
                somaImpares += numero;
                System.out.println(numero + " é ímpar, soma atual: " + somaImpares);
            }
        }
        
        System.out.println("\nResultado final da soma dos ímpares: " + somaImpares);
    }
}

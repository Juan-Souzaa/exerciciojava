public class exercicio08 {
    public static void main(String[] args) {
        ContaBancaria conta = new ContaBancaria("João", 1000.0);
        
        System.out.println("Saldo inicial: R$ " + conta.getSaldo());
        
        try {
            conta.sacar(500.0);
            System.out.println("Saque realizado. Saldo: R$ " + conta.getSaldo());
            
            conta.sacar(800.0);
        } catch (SaldoInsuficienteException e) {
            System.out.println("Erro ao sacar: " + e.getMessage());
        }
        
        try {
            conta.sacar(100.0);
            System.out.println("Saque realizado. Saldo: R$ " + conta.getSaldo());
        } catch (SaldoInsuficienteException e) {
            System.out.println("Erro ao sacar: " + e.getMessage());
        }
    }
}

class SaldoInsuficienteException extends Exception {
    public SaldoInsuficienteException(String message) {
        super(message);
    }
}

class ContaBancaria {
    private String titular;
    private double saldo;
    
    public ContaBancaria(String titular, double saldoInicial) {
        this.titular = titular;
        this.saldo = saldoInicial;
    }
    
    public void sacar(double valor) throws SaldoInsuficienteException {
        if (valor > saldo) {
            throw new SaldoInsuficienteException("Saldo insuficiente. Saldo: R$ " + saldo + ", Valor solicitado: R$ " + valor);
        }
        saldo -= valor;
    }
    
    public double getSaldo() {
        return saldo;
    }
    
    public String getTitular() {
        return titular;
    }
}

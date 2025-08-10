package exercicio34_vcRiquinho;

import java.util.List;

public interface OperacoesCliente {
    
    void adicionarConta(Conta conta);
    
    void removerConta(Conta conta);
    
    List<Conta> getContas();
    
    String getTipoCliente();
    
    String getDocumento();
}

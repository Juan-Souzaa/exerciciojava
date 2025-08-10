package exercicio34_vcRiquinho;

public class PessoaFisica extends Cliente {
    private String cpf;
    
    public PessoaFisica(String nome, String email, String cpf) {
        super(nome, email);
        this.cpf = cpf;
    }
    
    @Override
    public String getTipoCliente() {
        return "PF";
    }
    
    @Override
    public String getDocumento() {
        return cpf;
    }
    
    public String getCpf() {
        return cpf;
    }
    
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    @Override
    public String toString() {
        return "PessoaFisica{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", cpf='" + cpf + '\'' +
                ", contas=" + contas.size() +
                '}';
    }
}

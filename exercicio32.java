import java.lang.reflect.Field;

public class exercicio32 {
    public static void main(String[] args) {
        try {
            Configuracao config = new Configuracao();
            
            System.out.println("Valor inicial da urlConexao: " + config.getUrlConexao());
            
            Field campo = Configuracao.class.getDeclaredField("urlConexao");
            campo.setAccessible(true);
            
            campo.set(config, "db.producao.com:5432");
            
            String novoValor = (String) campo.get(config);
            System.out.println("Novo valor da urlConexao: " + novoValor);
            
            System.out.println("Valor confirmado via getter: " + config.getUrlConexao());
            
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

class Configuracao {
    private String urlConexao = "localhost:5432";
    
    public String getUrlConexao() {
        return urlConexao;
    }
}

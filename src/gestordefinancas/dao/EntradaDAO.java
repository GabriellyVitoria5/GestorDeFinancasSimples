package gestordefinancas.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class EntradaDAO {
    // testar conexão com banco
    private static final String URL = "jdbc:mysql://localhost:3306/financas";
    private static final String USUARIO = "root";
    private static final String SENHA = "Gvc@_1234";

    public static void main(String[] args) {
        try (Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            if (conexao != null) {
                System.out.println("Conexão estabelecida com sucesso!");
            } else {
                System.out.println("Falha ao estabelecer a conexão.");
            }
        } catch (SQLException e) {
            System.out.println("Erro de conexão: " + e.getMessage());
        }
    }
    
    //apagar código de conexao e criar um método para insrir dados do cadastro no banco
}

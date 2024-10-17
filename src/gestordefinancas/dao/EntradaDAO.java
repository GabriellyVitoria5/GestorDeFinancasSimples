package gestordefinancas.dao;

import gestordefinancas.model.Entrada;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// Classe que gerencia as operações de banco de dados relacionadas à entrada financeira
public class EntradaDAO {

    // Método que estabelece a conexão com o banco de dados
    private Connection conexao() throws SQLException {
        String URL = "jdbc:mysql://localhost:3306/financas";
        String USUARIO = "root";
        String SENHA = "12345678";

        // Exibe mensagem no console quando a conexão for estabelecida
        System.out.println("Conexão com o banco de dados estabelecida com sucesso!");

        // Retorna uma conexão com o banco de dados
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }

    // Método para inserir dados do cadastro no banco de dados
    public void inserirCadastro(String nome, String classificacao, double valor, LocalDate dataEntrada, LocalDate dataCadastro, String tipo) {
        // Comando SQL para inserir uma nova entrada na tabela 'entrada'
        String sql = "INSERT INTO entrada (nome, classificacao, valor, data_entrada, data_cadastro, tipo) VALUES (?, ?, ?, ?, ?, ?)";

        // Tenta estabelecer conexão e preparar o comando SQL
        try (Connection conexao = conexao(); // Cria uma conexão com o banco
             PreparedStatement stmt = conexao.prepareStatement(sql)) { // Prepara o comando SQL

            // Define os valores dos parâmetros no comando SQL
            stmt.setString(1, nome);
            stmt.setString(2, classificacao);
            stmt.setDouble(3, valor);
            stmt.setDate(4, Date.valueOf(dataEntrada));
            stmt.setDate(5, Date.valueOf(dataCadastro));
            stmt.setString(6, tipo);

            // Executa a atualização e retorna o número de linhas afetadas
            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                // Mensagem de sucesso se a inserção for bem-sucedida
                System.out.println("Cadastro inserido com sucesso!");
            }
        } catch (SQLException e) {
            // Mensagem de erro caso ocorra uma exceção durante a inserção
            System.out.println("Erro ao inserir cadastro: " + e.getMessage());
        }
    }

    // Método para excluir dados do cadastro no banco de dados
    public void excluirCadastro(String nome) {
        // Comando SQL para excluir uma entrada da tabela 'entrada' com base no nome
        String sql = "DELETE FROM entrada WHERE nome = ?";

        // Tenta estabelecer conexão e preparar o comando SQL
        try (Connection conexao = conexao(); // Cria uma conexão com o banco
             PreparedStatement stmt = conexao.prepareStatement(sql)) { // Prepara o comando SQL

            stmt.setString(1, nome); // Define o nome como parâmetro no comando SQL

            // Executa a atualização e retorna o número de linhas afetadas
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                // Mensagem de sucesso se a exclusão for bem-sucedida
                System.out.println("Cadastro excluído com sucesso!");
            }
        } catch (SQLException e) {
            // Mensagem de erro caso ocorra uma exceção durante a exclusão
            System.out.println("Erro ao excluir cadastro: " + e.getMessage());
        }
    }

    // Método para buscar todas as entradas cadastradas no banco de dados
    public List<Entrada> buscarEntradas() throws SQLException {
        // Cria uma lista para armazenar as entradas
        List<Entrada> entradas = new ArrayList<>();
        // Comando SQL para selecionar todos os dados da tabela 'entrada'
        String sql = "SELECT * FROM entrada";

        // Tenta estabelecer conexão e preparar o comando SQL
        try (Connection conexao = conexao(); // Cria uma conexão com o banco
             PreparedStatement ps = conexao.prepareStatement(sql); // Prepara o comando SQL
             ResultSet rs = ps.executeQuery()) { // Executa a consulta e armazena os resultados

            // Loop para percorrer os resultados
            while (rs.next()) {
                // Cria um novo objeto Entrada para cada linha de resultado
                Entrada entrada = new Entrada();
                entrada.setNome(rs.getString("nome"));
                entrada.setClassificacao(rs.getString("classificacao"));
                entrada.setValor(rs.getDouble("valor"));
                entrada.setDataEntrada(rs.getDate("data_entrada").toLocalDate());
                entrada.setDataCadastro(rs.getDate("data_cadastro").toLocalDate());
                entrada.setTipo(rs.getString("tipo"));
                
                // Adiciona a entrada à lista de entradas
                entradas.add(entrada);
            }
        }

        // Retorna a lista de entradas encontradas
        return entradas;
    }
}

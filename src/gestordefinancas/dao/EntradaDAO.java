package gestordefinancas.dao;

import gestordefinancas.model.Entrada;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EntradaDAO {

    // Função que estabelece a conexão com o banco de dados
    private Connection conexao() throws SQLException {
        String URL = "jdbc:mysql://localhost:3306/financas";
        String USUARIO = "root";
        String SENHA = "Gvc@_1234";

        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }

    // Função para inserir dados do cadastro no banco de dados
    public Boolean inserirCadastro(String nome, String classificacao, double valor, LocalDate dataEntrada, LocalDate dataCadastro, String tipo) {
        String sql = "INSERT INTO entrada (nome, classificacao, valor, data_entrada, data_cadastro, tipo) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conexao = conexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, nome);
            stmt.setString(2, classificacao);
            stmt.setDouble(3, valor);
            stmt.setDate(4, Date.valueOf(dataEntrada));
            stmt.setDate(5, Date.valueOf(dataCadastro));
            stmt.setString(6, tipo);

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao inserir cadastro: " + e.getMessage());
        }
        return false;
    }

    // Função para excluir dados do cadastro no banco de dados
    public Boolean excluirCadastro(String nome) {
        String sql = "DELETE FROM entrada WHERE nome = ?";

        try (Connection conexao = conexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, nome);

            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao excluir cadastro: " + e.getMessage());
        }
        return false;
    }

    // Função para buscar todas as entradas cadastradas no banco de dados
    public List<Entrada> buscarEntradas() throws SQLException {
        List<Entrada> entradas = new ArrayList<>();
        String sql = "SELECT * FROM entrada";

        try (Connection conexao = conexao();
             PreparedStatement ps = conexao.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Entrada entrada = new Entrada();
                entrada.setNome(rs.getString("nome"));
                entrada.setClassificacao(rs.getString("classificacao"));
                entrada.setValor(rs.getDouble("valor"));
                entrada.setDataEntrada(rs.getDate("data_entrada").toLocalDate());
                entrada.setDataCadastro(rs.getDate("data_cadastro").toLocalDate());
                entrada.setTipo(rs.getString("tipo"));
                
                entradas.add(entrada);
            }
        }
        return entradas;
    }
}

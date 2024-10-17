package gestordefinancas.view;

import gestordefinancas.dao.EntradaDAO;
import gestordefinancas.model.Entrada;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GestorDeFinancasGUI extends JFrame {

    // Declaração das variáveis dos componentes da interface gráfica
    private JButton btnCadastrar;
    private JToggleButton btnDebito;
    private JToggleButton btnSaldo;
    private JComboBox<String> jComboBox1;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private JTable tabela;
    private JFormattedTextField txtData;
    private JTextField txtNome;
    private JTextField txtValor;

    // Construtor da classe
    public GestorDeFinancasGUI() {
        initComponents(); // Inicializa os componentes da interface
        carregarTabela(); // Carrega os dados existentes na tabela
    }

    // Método principal para execução do programa
    public static void main(String[] args) {
        try {
            // Configura o estilo visual "Nimbus" se disponível no sistema
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                 UnsupportedLookAndFeelException ex) {
            Logger.getLogger(GestorDeFinancasGUI.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Cria e exibe a janela da aplicação
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestorDeFinancasGUI().setVisible(true);
            }
        });
    }

    // Método gerado automaticamente para inicializar os componentes da interface gráfica
    private void initComponents() {

        jPanel1 = new JPanel(); // Cria o painel principal
        jLabel1 = new JLabel(); // Cria o título da interface
        jLabel2 = new JLabel(); // Cria a label "Nome"
        jLabel3 = new JLabel(); // Cria a label "Classificação"
        jLabel4 = new JLabel(); // Cria a label "Valor"
        jLabel5 = new JLabel(); // Cria a label "Data de Entrada"
        txtNome = new JTextField(); // Campo de texto para o nome da entrada
        txtValor = new JTextField(); // Campo de texto para o valor da entrada
        txtData = new JFormattedTextField(); // Campo formatado para inserção da data
        jScrollPane1 = new JScrollPane(); // Área rolável da tabela
        tabela = new JTable(); // Tabela para exibir dados
        btnSaldo = new JToggleButton(); // Botão de alternância para saldo
        btnDebito = new JToggleButton(); // Botão de alternância para débito
        btnCadastrar = new JButton(); // Botão de ação para cadastrar nova entrada
        jComboBox1 = new JComboBox<>(); // ComboBox para selecionar a classificação

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // Define ação ao fechar a janela

        // Define as propriedades da label de título
        jLabel1.setFont(new Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Finanças Anual - Seu José");

        // Define as propriedades das labels de campos
        jLabel2.setFont(new Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Nome:");

        jLabel3.setFont(new Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Classificação:");

        jLabel4.setFont(new Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Valor:");

        jLabel5.setFont(new Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Data Entrada:");

        // Configura o campo de data com uma máscara no formato "dd/MM/yyyy"
        try {
            txtData.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##/##/####")));
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        // Configura a tabela com o modelo de colunas e valores
        tabela.setModel(new DefaultTableModel(
                new Object[][]{
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null}
                },
                new String[]{
                        "Nome", "Classificação", "Valor", "Data de Entrada", "Data de Cadastrado"
                }
        ));
        jScrollPane1.setViewportView(tabela); // Adiciona a tabela à área rolável

        // Configura o botão de saldo
        btnSaldo.setBackground(new Color(51, 255, 51));
        btnSaldo.setFont(new Font("Segoe UI", 0, 14)); // NOI18N
        btnSaldo.setText("Saldo (+)");
        btnSaldo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnSaldoActionPerformed(evt); // Chama o método ao clicar no botão
            }
        });

        // Configura o botão de débito
        btnDebito.setBackground(new Color(255, 51, 51));
        btnDebito.setFont(new Font("Segoe UI", 0, 14)); // NOI18N
        btnDebito.setText("Débito (-)");
        btnDebito.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnDebitoActionPerformed(evt); // Chama o método ao clicar no botão
            }
        });

        // Configura o botão de cadastrar nova entrada
        btnCadastrar.setBackground(new Color(102, 255, 204));
        btnCadastrar.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnCadastrarActionPerformed(evt); // Chama o método ao clicar no botão
            }
        });

        // Define as opções do ComboBox de classificação
        jComboBox1.setModel(new DefaultComboBoxModel<>(new String[]{"CASA ", "COMPRAS", "SAÚDE", "AUTOMÓVEL", "ALIMENTAÇÃO", "BEM ESTAR", "INVESTIMENTO", "SALÁRIO", "OUTROS"}));

        // Layout do painel principal usando GroupLayout
        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        // Configura o layout horizontal dos componentes
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(260, 260, 260))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(btnCadastrar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(jLabel5)
                                                                        .addComponent(jLabel4)
                                                                        .addComponent(jLabel3)
                                                                        .addComponent(jLabel2))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(txtNome)
                                                                        .addComponent(txtValor, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                                                                        .addComponent(txtData)
                                                                        .addComponent(jComboBox1, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(btnSaldo, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, 0)
                                                                .addComponent(btnDebito, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 564, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        // Configura o layout vertical dos componentes
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel1)
                                .addGap(34, 34, 34)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel2)
                                                        .addComponent(txtNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel3)
                                                        .addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel4)
                                                        .addComponent(txtValor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel5)
                                                        .addComponent(txtData, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addGap(27, 27, 27)
                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(btnSaldo)
                                                        .addComponent(btnDebito))
                                                .addGap(27, 27, 27)
                                                .addComponent(btnCadastrar))
                                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 378, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        // Layout geral da janela
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        // Configura o layout horizontal da janela
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(26, 26, 26))
        );
        // Configura o layout vertical da janela
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        pack(); // Ajusta o tamanho da janela
    }

    // Método chamado ao clicar no botão "Saldo"
    private void btnSaldoActionPerformed(ActionEvent evt) {
        btnDebito.setEnabled(!btnSaldo.isSelected()); // Desabilita o botão "Débito" se "Saldo" estiver selecionado
    }

    // Método chamado ao clicar no botão "Débito"
    private void btnDebitoActionPerformed(ActionEvent evt) {
        btnSaldo.setEnabled(!btnDebito.isSelected()); // Desabilita o botão "Saldo" se "Débito" estiver selecionado
    }

    // Método chamado ao clicar no botão "Cadastrar"
    private void btnCadastrarActionPerformed(ActionEvent evt) {
        // Coleta os dados da interface
        String nome = txtNome.getText();
        String classificacao = (String) jComboBox1.getSelectedItem();
        String valorString = txtValor.getText();
        String campoData = txtData.getText();
        DateTimeFormatter formatoEntrada = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Valida os campos obrigatórios
        if (nome.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, insira um nome.");
            return;
        }
        if (valorString.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, insira um valor.");
            return;
        }
        if (campoData.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, insira uma data.");
            return;
        }

        try {
            // Formata o valor e a data
            double valor = Double.parseDouble(valorString);
            LocalDate dataEntrada = LocalDate.parse(campoData, formatoEntrada);

            // Verifica o tipo de entrada
            String tipo = btnSaldo.isSelected() ? "GANHO" : "DESPESA";

            //Cria uma nova entrada e salva no banco de dados
            EntradaDAO dao = new EntradaDAO();
            dao.inserirCadastro(nome, classificacao, valor, dataEntrada, LocalDate.now(), tipo);
            System.out.println("Cadastro inserido com sucesso!");

            // Limpa os campos da interface após o cadastro
            txtNome.setText("");
            txtValor.setText("");
            txtData.setText("");

            // Atualiza a tabela após o cadastro
            carregarTabela();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, insira um valor válido.");
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(this, "Por favor, insira uma data válida no formato dd/MM/yyyy.");
        }
    }

    // Método para carregar os dados da tabela a partir do banco de dados
    private void carregarTabela() {
        // Cria uma instância do DAO para buscar as entradas
        EntradaDAO entradaDAO = new EntradaDAO();

        try {
            // Chama o método buscarEntradas() e obtém a lista de entradas
            List<Entrada> entradas = entradaDAO.buscarEntradas();

            // Limpa a tabela antes de recarregar os dados
            DefaultTableModel model = (DefaultTableModel) tabela.getModel();
            model.setRowCount(0);

            // Verifica se há entradas registradas
            if (entradas.isEmpty()) {
                // Se não houver entradas, exibe uma mensagem e omite os campos de soma e diferença
                JOptionPane.showMessageDialog(null, "Não há entradas cadastradas até o momento.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                // Esconder os campos de soma e diferença AQUI
            } else {
                // Adiciona cada entrada como uma linha na tabela
                for (Entrada entrada : entradas) {
                    Object[] row = new Object[]{
                            entrada.getNome(),
                            entrada.getClassificacao(),
                            entrada.getValor(),
                            entrada.getDataEntrada().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                            entrada.getDataCadastro().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                    };
                    model.addRow(row); // Adiciona a linha à tabela

                    // Mostrar os campos de soma e diferença AQUI
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao carregar dados da tabela: " + e.getMessage());
        }
    }
}

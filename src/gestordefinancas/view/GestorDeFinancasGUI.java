package gestordefinancas.view;

import gestordefinancas.dao.EntradaDAO;
import gestordefinancas.model.Entrada;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

public class GestorDeFinancasGUI extends javax.swing.JFrame {

    public GestorDeFinancasGUI() {
        initComponents(); 
        carregarTabela(); // Carrega os dados existentes na tabela ao iniciar o programa
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtValor = new javax.swing.JTextField();
        txtData = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        btnGanho = new javax.swing.JToggleButton();
        btnDespesa = new javax.swing.JToggleButton();
        btnCadastrar = new javax.swing.JButton();
        cbClassificacao = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        labelRecebido = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        labelGastos = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        labelDiferenca = new javax.swing.JLabel();
        btnApagar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Finanças Anual - Seu José");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Nome:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Classificação:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Valor:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Data Entrada:");

        txtNome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtValor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        try {
            txtData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nome", "Classificação", "Valor", "Data de Entrada", "Data de Cadastrado", "Tipo"
            }
        ));
        jScrollPane1.setViewportView(tabela);

        btnGanho.setBackground(new java.awt.Color(51, 255, 51));
        btnGanho.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnGanho.setText("Ganho(+)");
        btnGanho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGanhoActionPerformed(evt);
            }
        });

        btnDespesa.setBackground(new java.awt.Color(255, 51, 51));
        btnDespesa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnDespesa.setText("Despesa(-)");
        btnDespesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDespesaActionPerformed(evt);
            }
        });

        btnCadastrar.setBackground(new java.awt.Color(102, 255, 204));
        btnCadastrar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        cbClassificacao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbClassificacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CASA ", "COMPRAS", "SAÚDE", "AUTOMÓVEL", "ALIMENTAÇÃO", "BEM ESTAR", "INVESTIMENTO", "SALÁRIO", "OUTROS" }));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Recebido:");

        labelRecebido.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelRecebido.setText("R$ 0");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Gastos:");

        labelGastos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelGastos.setText("R$ 0");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Diferença:");

        labelDiferenca.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelDiferenca.setText("R$ 0");

        btnApagar.setBackground(new java.awt.Color(51, 255, 204));
        btnApagar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnApagar.setText("Apagar");
        btnApagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApagarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnGanho, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(btnDespesa, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnCadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel1)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel5)
                                .addComponent(jLabel4)
                                .addComponent(jLabel3)
                                .addComponent(jLabel2))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtNome)
                                .addComponent(txtValor)
                                .addComponent(txtData)
                                .addComponent(cbClassificacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(btnApagar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelRecebido, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelGastos, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelDiferenca, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 738, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cbClassificacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGanho)
                            .addComponent(btnDespesa))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCadastrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnApagar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(labelRecebido)
                            .addComponent(jLabel7)
                            .addComponent(labelGastos)
                            .addComponent(jLabel8)
                            .addComponent(labelDiferenca))))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGanhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGanhoActionPerformed
        if (btnGanho.isSelected()) {
            btnDespesa.setEnabled(false);
        } else {
            btnDespesa.setEnabled(true);
        }
    }//GEN-LAST:event_btnGanhoActionPerformed

    private void btnDespesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDespesaActionPerformed
        if (btnDespesa.isSelected()) {
            btnGanho.setEnabled(false);
        } else {
            btnGanho.setEnabled(true);
        }
    }//GEN-LAST:event_btnDespesaActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        String nome = txtNome.getText().trim();
        String classificacao = (String) cbClassificacao.getSelectedItem();
        String valorString = txtValor.getText().trim();
        String campoData = txtData.getText().trim();
        String tipo = "";

        // Valida os campos obrigatórios
        if (nome.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, insira um nome.", "Erro", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (valorString.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, insira um valor.", "Erro", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(campoData.equals("/  /")){
            JOptionPane.showMessageDialog(null, "O campo Data deve ser preenchido.", "Erro", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(!btnGanho.isSelected() && !btnDespesa.isSelected()){
            JOptionPane.showMessageDialog(null, "Selecione o tipo de entrada: Ganho ou Despesa.", "Erro", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(btnGanho.isSelected()){
            tipo = "GANHO";
        }
        if(btnDespesa.isSelected()){
            tipo = "DESPESA";
        }

        try {
            // Formata o valor e a data
            double valor = Double.parseDouble(valorString);
            
            DateTimeFormatter formatoEntrada = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate dataEntrada = LocalDate.parse(campoData, formatoEntrada);
            
            //Cria uma nova entrada e salva no banco de dados
            EntradaDAO dao = new EntradaDAO();
            Boolean resultado = dao.inserirCadastro(nome, classificacao, valor, dataEntrada, LocalDate.now(), tipo);
            
            if(resultado){
                JOptionPane.showMessageDialog(rootPane, "Cadastro inserido com sucesso!");
            }
            else{
                JOptionPane.showMessageDialog(null, "Erro no cadastro!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
            
            // Limpa os campos e carregar a tebela com o novo registro
            limparCampos();
            carregarTabela();
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, insira um valor válido.", "Erro", JOptionPane.WARNING_MESSAGE);
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(this, "Por favor, insira uma data válida no formato dd/MM/yyyy.",  "Erro", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    // Método para limpar os campos após o cadastro
    private void limparCampos(){
        txtNome.setText("");
        txtValor.setText("");
        txtData.setText("");
        cbClassificacao.setSelectedIndex(0);
        btnGanho.setEnabled(true);
        btnDespesa.setEnabled(true);
    }

    // Método para carregar os dados da tabela a partir do banco de dados
    private void carregarTabela() {
        EntradaDAO entradaDAO = new EntradaDAO();

        try {
            // Somas os ganhos e despesas para calcular a diferença 
            float somaGanhos = 0;
            float somaDespesas = 0; 
            
            // Obtém a lista de todas as entradas cadastradas 
            List<Entrada> entradas = entradaDAO.buscarEntradas();

            // Limpa a tabela antes de recarregar os dados
            DefaultTableModel modelTabela = (DefaultTableModel) tabela.getModel();
            modelTabela.setRowCount(0);

            // Bloquear botões de ganho e despesa se não houver entradas
            if (entradas.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Não há entradas cadastradas até o momento.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                btnGanho.setEnabled(false);
                btnDespesa.setEnabled(false);
            } 
            else {
                // Adiciona cada entrada como uma linha na tabela 
                for (Entrada entrada : entradas) {
                    Object[] row = new Object[]{
                            entrada.getNome(),
                            entrada.getClassificacao(),
                            entrada.getValor(),
                            entrada.getDataEntrada().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                            entrada.getDataCadastro().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                            entrada.getTipo()
                    };
                    modelTabela.addRow(row); 

                    // Verificar o tipo da entrada 
                    if(entrada.getTipo().equalsIgnoreCase("GANHO")){
                        somaGanhos += entrada.getValor();
                    }
                    
                    if(entrada.getTipo().equalsIgnoreCase("DESPESA")){
                        somaDespesas += entrada.getValor();
                    }
                }
            }
            
            // Exibir na tela as somas e diferença calculadas
            labelRecebido.setText("R$ " + somaGanhos + "");
            labelGastos.setText("R$ " + somaDespesas + "");
            labelDiferenca.setText("R$ " + (somaGanhos - somaDespesas) + "");
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao carregar dados da tabela: " + e.getMessage());
        }
        
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApagarActionPerformed
        // Pegar índice da linha escolhida na tabela pelo usuário
        DefaultTableModel modelTabela =  (DefaultTableModel) tabela.getModel();
        int linhaSelecionada = tabela.getSelectedRow();

        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(null, "Selecione uma entrada na tabela para apagar.", "Erro", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // Exlcuir entrada com base no nome
        String nome = (String) modelTabela.getValueAt(linhaSelecionada, 0);
        EntradaDAO dao = new EntradaDAO();
        dao.excluirCadastro(nome);

        carregarTabela();
        JOptionPane.showMessageDialog(rootPane, "Entrada apagada com sucesso!");
    }//GEN-LAST:event_btnApagarActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GestorDeFinancasGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestorDeFinancasGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestorDeFinancasGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestorDeFinancasGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestorDeFinancasGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApagar;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JToggleButton btnDespesa;
    private javax.swing.JToggleButton btnGanho;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbClassificacao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelDiferenca;
    private javax.swing.JLabel labelGastos;
    private javax.swing.JLabel labelRecebido;
    private javax.swing.JTable tabela;
    private javax.swing.JFormattedTextField txtData;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
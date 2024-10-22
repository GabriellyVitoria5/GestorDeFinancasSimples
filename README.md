# Controle Financeiro do Seu José

## Integrantes

- Gabrielle Fonseca;
- Gabrielly Vitória.

## Objetivos

Este projeto consiste em um teste diagnóstico sobre conceitos de Programação Orientada a Objetos (POO), Banco de Dados e
Engenharia de Software.

## Tecnologias Utilizadas

- **Linguagem de Programação:** Java
- **Framework:** Swing para a interface gráfica
- **Banco de Dados:** MySQL

## Configurando o projeto

1. Clone o repositório:
   ```bash
   git clone https://github.com/GabriellyVitoria5/GestorDeFinancasSimples.git
   ```
   
2. Importe o projeto na sua IDE:
   ````
    - No Eclipse: `File > Import > General > Existing Projects into Workspace`;
    - No NetBeans: `File > Open Project`;
    - No IntelliJ IDEA: `File > Open`;
    ````

3. Execute o script `financas.sql` no MySQL Workbench:
   ````
    - Crie um banco de dados chamado `financas`;
    - Execute o script;
    ````

4. Configure o arquivo `Conexao.java` com as informações do seu banco de dados:
   ````
    - No arquivo `GestorDeFinancasSimples/src/gestordefinancas/dao/database.example.properties` renomeie para
      `database.properties` e configure com as informações do seu banco de dados;
    ````

5. Adicionae a biblioteca `MySQL Connector` ao projeto

   Baixe o MySQL Connector: 
   ````
   - Faça o download do conector JDBC do MySQL pelo link: [MySQL Connector/J](https://dev.mysql.com/downloads/connector/j/).
   - Escolha a opção `Platform Independent`.
     ````

   Adicione o JAR à sua IDE:
   ````
    - No Eclipse: Botão direito no projeto > `Build Path` > `Add External Archives...` e selecione o arquivo `mysql-connector-java-x.x.xx.jar` baixado.
    - No NetBeans: Botão direito no projeto > `Properties` > `Libraries` > `Add JAR/Folder` e selecione o arquivo `mysql-connector-java-x.x.xx.jar`.
    - No IntelliJ IDEA: Botão direito no projeto > `Open Module Settings` > `Modules` > `Dependencies` > `+` > `JARs or Directories` e selecione o arquivo `mysql-connector-java-x.x.xx.jar`.
    ````

7. Execute o projeto:
   ````
    - No Eclipse: `Run > Run`;
    - No NetBeans: `Run > Run Project`;
    - No IntelliJ IDEA: `Run > Run`.
    ````


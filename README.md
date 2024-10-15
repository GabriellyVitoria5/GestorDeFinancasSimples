# Controle Financeiro do Seu José

## Objetivos
Este projeto consiste em um teste diagnóstico sobre conceitos de Programação Orientada a Objetos (POO), Banco de Dados e Engenharia de Software.

## Descrição
Seu José é um senhor muito conhecido na cidade de Ouro Branco, famoso por seu controle nas finanças. No entanto, com o passar da pandemia e a forte inflação, ele tem enfrentado dificuldades para manter suas contas em dia. Para se planejar anualmente, Seu José mantém um histórico de seus ganhos e despesas em um caderno. Recentemente, ele percebeu que essa estratégia não é mais eficiente, pois algumas folhas foram perdidas, dificultando seu controle financeiro.

Portanto, Seu José pediu que desenvolvêssemos uma aplicação onde ele possa cadastrar seus ganhos e despesas.

## Requisitos Funcionais

1. **Cadastro de Entradas**: O sistema deve permitir que Seu José cadastre uma nova entrada, que pode ser um valor recebido (saldo +) ou uma despesa (débito -). Cada entrada deve conter:
   - Nome
   - Classificação (CASA, COMPRAS, SAÚDE, AUTOMÓVEL, ALIMENTAÇÃO, BEM ESTAR, INVESTIMENTO, SALÁRIO, OUTROS)
   - Data da entrada
   - Data de cadastro

2. **Visualização de Entradas**: O sistema deve permitir que Seu José visualize todas as entradas cadastradas em uma tabela, com colunas para cada atributo (Nome, Classificação, Valor, Data da Entrada, Data de Cadastro).

3. **Exclusão de Entradas**: O sistema deve permitir que Seu José exclua qualquer entrada da tabela. Ele deve selecionar a entrada e confirmar a exclusão ("Deseja excluir a entrada mesmo?"). Caso seja confirmado, o dado no banco de dados deve ser excluído.

4. **Soma e Diferença**: O sistema deve calcular e exibir a soma de todas as despesas, a soma de todos os valores recebidos e a diferença entre eles na parte inferior da tabela.

5. **Mensagens de Inicialização**: Ao iniciar o sistema, todas as entradas registradas anteriormente devem ser apresentadas. Caso não haja entradas, deve ser exibida a mensagem "não há entradas cadastradas até o momento", e os campos de soma e diferença devem ser ocultados.

## Tecnologias Utilizadas
- Java
- MySQL


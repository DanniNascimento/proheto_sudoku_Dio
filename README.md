# Projeto Jogo Sudoku em Java (Terminal)

## Visão Geral

Este projeto implementa um jogo de Sudoku interativo que roda no terminal. O objetivo principal foi aplicar os conceitos de programação em Java, como classes, métodos e lógica de controle, para criar uma experiência de jogo funcional. O projeto permite que o jogador insira números no tabuleiro, valida suas jogadas de acordo com as regras do Sudoku e verifica se o quebra-cabeça foi resolvido com sucesso.

## Funcionalidades

* **Inicialização do Tabuleiro:** O tabuleiro do Sudoku é inicializado com valores predefinidos, passados como argumentos na linha de comando. As células iniciais são marcadas como fixas e não podem ser alteradas pelo jogador.
* **Exibição do Tabuleiro no Terminal:** O tabuleiro é exibido no terminal de forma clara, com bordas para delimitar as linhas, colunas e blocos 3x3. As células fixas podem ser opcionalmente destacadas.
* **Entrada do Jogador:** O jogador pode inserir a linha, a coluna e o valor desejado para preencher uma célula vazia.
* **Validação de Jogadas:** O sistema valida cada jogada do jogador, verificando se o número inserido já existe na mesma linha, coluna ou bloco 3x3 da célula escolhida.
* **Verificação de Vitória:** O jogo verifica continuamente se o tabuleiro está completo e correto, determinando se o jogador venceu o Sudoku.
* **Encerramento do Jogo:** O jogador pode encerrar o jogo a qualquer momento digitando "sair".
* **Feedback ao Jogador:** O jogo fornece feedback ao jogador sobre a validade de suas jogadas e informa quando o jogo é encerrado ou vencido.

## Etapas de Desenvolvimento

Este projeto foi desenvolvido seguindo as seguintes etapas principais:

1.  **Estrutura Inicial do Projeto:**
    * Criação de um novo projeto Java.
    * Definição das classes principais: `Celula`, `Tabuleiro`, `JogoSudoku`, e `Main` (integrada em `JogoSudoku`).

2.  **Implementação da Classe `Celula`:**
    * Criação da classe `Celula` para representar cada célula do tabuleiro, armazenando seu valor e se ela é fixa.

3.  **Implementação da Classe `Tabuleiro`:**
    * Criação da classe `Tabuleiro` para conter uma matriz de `Celula`s representando o tabuleiro 9x9.
    * Implementação de métodos para inicializar o tabuleiro e acessar células específicas.
    * Implementação do método `imprimirTabuleiro()` para exibir o tabuleiro no terminal.

4.  **Implementação da Classe `JogoSudoku`:**
    * Criação da classe `JogoSudoku` para controlar o fluxo do jogo.
    * Implementação do método `inicializarTabuleiroComArgs()` para configurar o tabuleiro com os argumentos da linha de comando.
    * Implementação do método `jogar()` para gerenciar a interação com o jogador.

5.  **Implementação da Interação com o Jogador:**
    * Utilização da classe `Scanner` para receber a entrada do jogador (linha, coluna, valor).
    * Implementação de um loop para permitir que o jogador insira jogadas até a vitória ou encerramento.
    * Validação básica da entrada do jogador (formato e limites dos valores).

6.  **Implementação da Lógica de Validação:**
    * Criação de métodos para validar se um número já existe na mesma linha (`validarValorLinha`), coluna (`validarValorColuna`) e bloco 3x3 (`validarValorBloco`) da célula onde o jogador quer inserir o valor.
    * Integração desses métodos na função `jogar()` para verificar a validade de cada jogada antes de atualizar o tabuleiro.

7.  **Implementação da Lógica de Verificação de Vitória:**
    * Criação de métodos para verificar se o tabuleiro está completamente preenchido (`tabuleiroCompleto()`) e se está correto (`tabuleiroCorreto()`).
    * O método `tabuleiroCorreto()` utiliza métodos auxiliares para verificar linhas, colunas e blocos.
    * Criação do método `verificarVitoria()` para combinar as verificações de tabuleiro completo e correto.
    * Integração da verificação de vitória na função `jogar()` para determinar quando o jogo termina com sucesso.

8.  **Refinamento da Interface do Terminal (Opcional):**
    * Melhoria da formatação do tabuleiro no terminal utilizando caracteres como `|`, `-`, e `+` para criar bordas mais visíveis.
    * Implementação opcional para indicar as células fixas no tabuleiro.
    * Adição de mensagens informativas para o jogador, como confirmação de jogadas válidas e mensagens de erro mais específicas.

## Como Executar

1.  **Pré-requisitos:**
    * Java Development Kit (JDK) instalado.

2.  **Compilação:**
    ```bash
    cd projeto-bancario/src/main/java
    javac br/com/seuprojeto/sudoku/*.java
    ```
    (Substitua `projeto-bancario` pelo nome da sua pasta principal do projeto e ajuste o caminho do pacote se necessário).

3.  **Execução:**
    ```bash
    java br.com.seuprojeto.sudoku.JogoSudoku
    ```

**Observações sobre a Execução:**

* Ao executar o comando `java br.com.seuprojeto.sudoku.JogoSudoku`, o jogo será iniciado.
* O tabuleiro inicial será definido dentro do código da classe `JogoSudoku`. Você pode modificar a forma como o tabuleiro inicial é criado diretamente no método `inicializarTabuleiroComArgs()` ou criando um método separado para isso.
* O jogo exibirá o tabuleiro no terminal e solicitará que você insira a linha, coluna e valor para jogar.
* Siga as instruções exibidas no terminal para interagir com o jogo.
## Contribuição

Contribuições para este projeto são bem-vindas! Se você tiver ideias para melhorar o jogo, adicionar novas funcionalidades ou corrigir bugs, por favor, sinta-se à vontade para abrir uma issue ou enviar um pull request.

---

Este README.md fornece uma visão geral detalhada do projeto de Sudoku, desde suas funcionalidades até as etapas de desenvolvimento e instruções de execução. Ele também destaca os conceitos de programação Java aplicados durante a criação. Adapte as seções conforme necessário para o seu repositório no GitHub.

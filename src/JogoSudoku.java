import java.util.Scanner;

public class JogoSudoku {
    private Tabuleiro tabuleiro;
    private Scanner scanner;

    public JogoSudoku(String[] args) {
        this.tabuleiro = new Tabuleiro();
        inicializarTabuleiroComArgs(args);
        this.scanner = new Scanner(System.in);
    }

    private void inicializarTabuleiroComArgs(String[] args) {

    }

    private boolean validarValorBloco(int linha, int coluna, int valor) {

        int blocoInicioLinha = linha - linha % 3;
        int blocoInicioColuna = coluna - coluna % 3;

        for (int i = blocoInicioLinha; i < blocoInicioLinha + 3; i++) {
            for (int j = blocoInicioColuna; j < blocoInicioColuna + 3; j++) {
                if (tabuleiro.getCelula(i, j).getValor() == valor) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean validarValorLinha(int linha, int valor) {

        for (int j = 0; j < 9; j++) {
            if (tabuleiro.getCelula(linha, j).getValor() == valor) {
                return false;
            }
        }
        return true;
    }

    private boolean validarValorColuna(int coluna, int valor) {

        for (int i = 0; i < 9; i++) {
            if (tabuleiro.getCelula(i, coluna).getValor() == valor) {
                return false;
            }
        }
        return true;
    }

    private boolean tabuleiroCompleto() {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (tabuleiro.getCelula(i, j).getValor() == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean tabuleiroCorreto() {

        for (int i = 0; i < 9; i++) {
            if (!validarConjunto(obterValoresLinha(i))) {
                return false;
            }
        }
        for (int j = 0; j < 9; j++) {
            if (!validarConjunto(obterValoresColuna(j))) {
                return false;
            }
        }
        for (int blocoLinha = 0; blocoLinha < 3; blocoLinha++) {
            for (int blocoColuna = 0; blocoColuna < 3; blocoColuna++) {
                if (!validarConjunto(obterValoresBloco(blocoLinha, blocoColuna))) {
                    return false;
                }
            }
        }
        return true;
    }

    private int[] obterValoresLinha(int linha) {

        int[] valores = new int[9];
        for (int j = 0; j < 9; j++) {
            valores[j] = tabuleiro.getCelula(linha, j).getValor();
        }
        return valores;
    }

    private int[] obterValoresColuna(int coluna) {

        int[] valores = new int[9];
        for (int i = 0; i < 9; i++) {
            valores[i] = tabuleiro.getCelula(i, coluna).getValor();
        }
        return valores;
    }

    private int[] obterValoresBloco(int blocoLinha, int blocoColuna) {

        int[] valores = new int[9];
        int indice = 0;
        int inicioLinha = blocoLinha * 3;
        int inicioColuna = blocoColuna * 3;
        for (int i = inicioLinha; i < inicioLinha + 3; i++) {
            for (int j = inicioColuna; j < inicioColuna + 3; j++) {
                valores[indice++] = tabuleiro.getCelula(i, j).getValor();
            }
        }
        return valores;
    }

    private boolean validarConjunto(int[] valores) {

        boolean[] numerosPresentes = new boolean[10];
        for (int valor : valores) {
            if (valor != 0) {
                if (numerosPresentes[valor]) {
                    return false;
                }
                numerosPresentes[valor] = true;
            }
        }
        return true;
    }

    private boolean verificarVitoria() {

        return tabuleiroCompleto() && tabuleiroCorreto();
    }

    public void imprimirTabuleiro() {
        System.out.println("+-------+-------+-------+");
        for (int i = 0; i < 9; i++) {
            System.out.print("| ");
            for (int j = 0; j < 9; j++) {
                String valor = tabuleiro.getCelula(i, j).toString();
                if (tabuleiro.getCelula(i, j).isFixa() && valor.equals(" ")) {
                    valor = "*";
                } else if (tabuleiro.getCelula(i, j).isFixa()) {
                    valor = valor + "*";
                }
                System.out.print(valor + " ");
                if ((j + 1) % 3 == 0) {
                    System.out.print("| ");
                }
            }
            System.out.println();
            if ((i + 1) % 3 == 0) {
                System.out.println("+-------+-------+-------+");
            }
        }
    }

    public void jogar() {
        boolean jogoTerminado = false;

        while (!jogoTerminado) {
            tabuleiro.imprimirTabuleiro();
            System.out.println("Informe a linha (0-8), coluna (0-8) e valor (1-9) separados por espaço (ou 'sair' para encerrar):");
            String entrada = scanner.nextLine();

            if (entrada.equalsIgnoreCase("sair")) {
                jogoTerminado = true;
                System.out.println("Jogo encerrado.");
            } else {
                String[] partesEntrada = entrada.split(" ");
                if (partesEntrada.length == 3) {
                    try {
                        int linha = Integer.parseInt(partesEntrada[0]);
                        int coluna = Integer.parseInt(partesEntrada[1]);
                        int valor = Integer.parseInt(partesEntrada[2]);

                        if (linha >= 0 && linha < 9 && coluna >= 0 && coluna < 9 && valor >= 1 && valor <= 9) {
                            if (!tabuleiro.getCelula(linha, coluna).isFixa()) {
                                if (validarValorLinha(linha, valor) && validarValorColuna(coluna, valor) && validarValorBloco(linha, coluna, valor)) {
                                    tabuleiro.getCelula(linha, coluna).setValor(valor);
                                    System.out.println("Valor inserido com sucesso!");
                                    jogoTerminado = verificarVitoria();
                                    if (jogoTerminado) {
                                        tabuleiro.imprimirTabuleiro();
                                        System.out.println("Parabéns! Você venceu o Sudoku!");
                                    }
                                } else {
                                    System.out.println("Valor inválido para esta linha, coluna ou bloco.");
                                }
                            } else {
                                System.out.println("Essa célula não pode ser alterada.");
                            }
                        } else {
                            System.out.println("Entrada inválida. Linha, coluna devem estar entre 0-8 e valor entre 1-9.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Entrada inválida. Certifique-se de digitar números.");
                    }
                } else {
                    System.out.println("Entrada inválida. Formato: linha coluna valor.");
                }
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {
        JogoSudoku jogo = new JogoSudoku(args);
        jogo.jogar();
    }
}
public class Tabuleiro {
    private Celula[][] celulas;

    public Tabuleiro() {
        this.celulas = new Celula[9][9];
        inicializarTabuleiroVazio();
    }

    private void inicializarTabuleiroVazio() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                this.celulas[i][j] = new Celula();
            }
        }
    }

    public Celula getCelula(int linha, int coluna) {
        return celulas[linha][coluna];
    }

    public void setCelula(int linha, int coluna, Celula celula) {
        this.celulas[linha][coluna] = celula;
    }

    // Método para imprimir o tabuleiro no terminal
    public void imprimirTabuleiro() {
        System.out.println("-------------------------");
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(celulas[i][j] + " ");
                if ((j + 1) % 3 == 0) {
                    System.out.print("| ");
                }
            }
            System.out.println();
            if ((i + 1) % 3 == 0) {
                System.out.println("-------------------------");
            }
        }
    }
}
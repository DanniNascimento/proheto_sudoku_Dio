public class Celula {
    private int valor;
    private boolean fixa;

    public Celula() {
        this.valor = 0;
        this.fixa = false;
    }

    public Celula(int valor, boolean fixa) {
        this.valor = valor;
        this.fixa = fixa;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public boolean isFixa() {
        return fixa;
    }

    @Override
    public String toString() {
        return (valor == 0) ? " " : String.valueOf(valor);
    }
}
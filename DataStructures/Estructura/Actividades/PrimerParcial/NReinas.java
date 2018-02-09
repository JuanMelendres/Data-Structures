public class NReinas {

    public boolean valido(int[] reinas, int f, int c){ // cheacamos que no esten dos reinas en la misma columna
        for (int i = 0; i < f; i++) {
            if (reinas[i] == c) {
                return false;
            }
            else if (Math.abs(i - f) == Math.abs(reinas[i] - c)) {
                return false;
            }
        }
        return true;
    }

    private void imprimeTablero(int[] reinas){
        for(int i = 0; i < reinas.length; i++) {
            System.out.print(reinas[i]+",");
        }
        System.out.println();
    }

    public void nReinas(int n, int[] reinas){
        for (int i = 0; i < reinas.length; i++) {
            if(this.valido(reinas, n, i)) {
                reinas[n] = i;
                if(n == reinas.length - 1) {
                    this.imprimeTablero(reinas);
                }
                else {
                    this.nReinas(n + 1, reinas);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] reinas = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        NReinas nr = new NReinas();
        nr.nReinas(0, reinas);
    }
}

package generadores;

import java.util.Random;

/**
 * Genera numeros aleatorios con distribucion uniforme. Utiliza el metodo
 * congruencial lineal (multiplicativo mixto). Pero si C == 0, entonces esta
 * utilizando el metodo congruencial simple.
 *
 * @author eric
 */
public class GeneradorUniforme implements IGenerador {

    private int semilla;
    private int A; // Se recomienda sea 1 + 4 * k
    private int M; // Se recomienda ser 2**g
    private int C; // Se recomienda ser primo relativo a M (creo que M - 1 es siempre primo relativo)    

    public GeneradorUniforme() {
        this(new Random().nextInt(1024));
    }

    public GeneradorUniforme(int semilla) {
        this(semilla, 100, 10);
    }

    /**
     * Genera constantes mediante formulas. A = 1 + 4 * K M = 2^G C = M - 1
     *
     * @param semilla
     * @param K
     * @param G
     */
    public GeneradorUniforme(int semilla, int K, int G) {
        this(semilla, 1 + 4 * K, (int) Math.pow(2, G) - 1, (int) Math.pow(2, G));
    }

    public GeneradorUniforme(int semilla, int A, int C, int M) {
        if (semilla < 0 || A < 0 || C < 0 || M < 0) {
            throw new IllegalArgumentException("Las constances A, C y M, y la semilla, deben ser enteros positivos.");
        }
        // Semilla par y C == 0 generan una secuencia erronea.
        this.semilla = semilla; 
        this.A = A;
        this.C = C;
        this.M = M;
        System.out.println("Nuevo generador uniforme con semilla " + String.valueOf(this.semilla));
    }
    
    @Override
    public double nextDouble() {
        this.semilla = (this.A * this.semilla + this.C) % this.M;
        return (double) this.semilla / this.M;
    }
}

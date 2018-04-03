package pruebas;

import generadores.IGenerador;

public class PruebaChiCuadradoUniforme extends PruebaChiCuadrado {

    public PruebaChiCuadradoUniforme(IGenerador generador, int cantidadIntervalos) {
        super(generador, cantidadIntervalos);
    }

    @Override
    double getFrecuenciaEsperada(int numeroIntervalo) {
        return (double) this.TAMAÑOMUESTRA / this.cantidadIntervalos;
    }

    @Override
    int getCantidadValoresEmpiricos() {
        return 0;
    }

}

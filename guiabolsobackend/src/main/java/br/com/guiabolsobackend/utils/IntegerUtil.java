package br.com.guiabolsobackend.utils;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class IntegerUtil {

    /**
     * Gera número pseudo-aleatório na faixa fornecida.
     *
     * @param minimo O primeiro valor da faixa.
     * @param maximo O último valor da faixa.
     * @return Um número contido na faixa indicada, incluindo os limites.
     *
     * @throws IllegalArgumentException Se a faixa for inválida, ou seja, o valor {@code maximo} é
     *         menor que o {@code minimo}.
     */
    public static Integer aleatorioNaFaixa(final int minimo, final int maximo) {
        Random rnd = ThreadLocalRandom.current();
        return rnd.nextInt(maximo - minimo + 1) + minimo;
    }

    public static int somarDigitos(int numero) {
        int soma = 0;

        while (numero != 0) {
            // 1) obter o módulo do número digitado int modulo = num % 10;
            // 2) incrementar o módulo a nossa variavel soma
            soma += numero % 10;
            // 3) dividir o número por 10 e atribuir a variavel;
            numero /= 10;// numero = numero / 10;
        }

        return soma;
    }

}

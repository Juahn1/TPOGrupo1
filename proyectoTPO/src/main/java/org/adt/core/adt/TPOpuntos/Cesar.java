package org.adt.core.adt.TPOpuntos;
import java.lang.Math.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


import java.util.HashMap;
import java.util.Map;

public class Cesar {
    public static String descifrarTextoCesar(String textoCifrado, Map<Character, Double> frecuenciaEspañol) {
        Map<Character, Integer> frecuenciaCifrada = calcularFrecuencia(textoCifrado);
        Map<Character, Double> frecuenciaCifradaPorcentaje = calcularFrecuenciaPorcentaje(frecuenciaCifrada, textoCifrado.length());

        int claveCesar = obtenerClaveCesar(frecuenciaCifradaPorcentaje, frecuenciaEspañol);
        String textoDescifrado = descifrarTexto(textoCifrado, claveCesar);

        return textoDescifrado;
    }

    public static Map<Character, Integer> calcularFrecuencia(String texto) {
        Map<Character, Integer> frecuencia = new HashMap<>();

        for (char letra : texto.toCharArray()) {
            if (Character.isLetter(letra)) {
                letra = Character.toLowerCase(letra);
                frecuencia.put(letra, frecuencia.getOrDefault(letra, 0) + 1);
            }
        }

        return frecuencia;
    }

    public static Map<Character, Double> calcularFrecuenciaPorcentaje(Map<Character, Integer> frecuencia, int longitudTexto) {
        Map<Character, Double> frecuenciaPorcentaje = new HashMap<>();

        for (Map.Entry<Character, Integer> entry : frecuencia.entrySet()) {
            char letra = entry.getKey();
            int apariciones = entry.getValue();
            double porcentaje = (apariciones * 100.0) / longitudTexto;
            frecuenciaPorcentaje.put(letra, porcentaje);
        }

        return frecuenciaPorcentaje;
    }

    public static int obtenerClaveCesar(Map<Character, Double> frecuenciaCifrada, Map<Character, Double> frecuenciaEspañol) {
        int claveCesar = 0;
        double menorDiferencia = Double.MAX_VALUE;

        for (int i = 0; i < 26; i++) {
            double diferenciaTotal = 0;

            for (char letra : frecuenciaCifrada.keySet()) {
                double frecuenciaCifradaActual = frecuenciaCifrada.get(letra);
                double frecuenciaEspañolActual = frecuenciaEspañol.getOrDefault(letra, 0.0);
                double diferencia = Math.abs(frecuenciaCifradaActual - frecuenciaEspañolActual);
                diferenciaTotal += diferencia;
            }

            if (diferenciaTotal < menorDiferencia) {
                menorDiferencia = diferenciaTotal;
                claveCesar = i;
            }

            frecuenciaCifrada = desplazarFrecuenciaCifrada(frecuenciaCifrada);
        }

        return claveCesar;
    }

    public static Map<Character, Double> desplazarFrecuenciaCifrada(Map<Character, Double> frecuenciaCifrada) {
        Map<Character, Double> frecuenciaDesplazada = new HashMap<>();

        for (char letra : frecuenciaCifrada.keySet()) {
            char letraDesplazada = desplazarLetra(letra);
            double frecuencia = frecuenciaCifrada.get(letra);
            frecuenciaDesplazada.put(letraDesplazada, frecuencia);
        }

        return frecuenciaDesplazada;
    }

    public static char desplazarLetra(char letra) {
        int ascii = (int) letra;
        ascii -= 1;
        if (ascii < 97) {
            ascii = 122;
        }
        return (char) ascii;
    }

    public static String descifrarTexto(String texto, int claveCesar) {
        StringBuilder textoDescifrado = new StringBuilder();

        for (char letra : texto.toCharArray()) {
            if (Character.isLetter(letra)) {
                letra = Character.toLowerCase(letra);
                letra = desplazarLetra(letra, claveCesar);
            }
            textoDescifrado.append(letra);
        }

        return textoDescifrado.toString();
    }

    public static char desplazarLetra(char letra, int claveCesar) {
        int ascii = (int) letra;
        ascii -= claveCesar;
        if (ascii < 97) {
            ascii += 26;
        }
        return (char) ascii;
    }



    public static Map<Character, Double> obtenerFrecuenciaEspañol() {
        Map<Character, Double> frecuenciaEspañol = new HashMap<>();
        // Aquí deberías proporcionar la frecuencia de aparición de las letras en español.
        // Puedes utilizar los valores proporcionados anteriormente en esta conversación como referencia.

        // Ejemplo utilizando los valores proporcionados anteriormente
       frecuenciaEspañol.put('a', 11.96);
       frecuenciaEspañol.put('b', 2.22);
       frecuenciaEspañol.put('c', 4.3);
       frecuenciaEspañol.put('d', 5.14);
       frecuenciaEspañol.put('e', 12.37);
       frecuenciaEspañol.put('f', 0.69);
       frecuenciaEspañol.put('g', 1.01);
       frecuenciaEspañol.put('h', 0.7);
       frecuenciaEspañol.put('i', 6.25);
       frecuenciaEspañol.put('j', 0.44);
       frecuenciaEspañol.put('k', 0.01);
       frecuenciaEspañol.put('l', 4.97);
       frecuenciaEspañol.put('m', 3.15);
       frecuenciaEspañol.put('n', 7.01);
       frecuenciaEspañol.put('ñ', 0.31);
       frecuenciaEspañol.put('o', 8.69);
       frecuenciaEspañol.put('p', 2.77);
       frecuenciaEspañol.put('q', 1.53);
       frecuenciaEspañol.put('r', 6.41);
       frecuenciaEspañol.put('s', 7.58);
       frecuenciaEspañol.put('t', 4.94);
       frecuenciaEspañol.put('u', 3.93);
       frecuenciaEspañol.put('v', 1.58);
       frecuenciaEspañol.put('w', 0.09);
       frecuenciaEspañol.put('x', 0.22);
       frecuenciaEspañol.put('y', 0.9);
       frecuenciaEspañol.put('z', 0.52);
        // Resto de las letras...

        return frecuenciaEspañol;
    }

    //El método calcularFrecuencia tiene complejidad O(n).
    //El método calcularFrecuenciaPorcentaje tiene complejidad O(m).
    //El método obtenerClaveCesar tiene complejidad O(26 * m).
    //El método descifrarTexto tiene complejidad O(n).

    public static void main(String[] args) {
        String textoCifrado = "Kzmm ms BLI Kwwzlpuibm, ms kcis istikmui swa diswzma f m g lm cu xcubw mu ms xsiuw. Iñzmñcmsm cu tébwlw ycm zmkpji kwtw xizátmbzw wbzw xcubw lms xsiuw m ptxzpti mu xiubissi ac lpabiukpi. † Kzmm cu BLI Kwcxsm ycm zmkpjm lwa libwa lms tpatw bpxw kwtw xizátmbzw g swa istikmui. Iñzmñcm swa tébwlwa omil g bips ycm lmdcmsdmu ms xzptmz g úsbptw msmtmubw zmaxmkbpditmubm. Mqmzkpkpw 1.8.4: Dmkbwz (níapkw) Kzmm ms BLI Dmkbwz, ms kcis istikmui swa diswzma f m g lm cu xcubw mu ms xsiuw. Iñzmñcmsm cu tébwlw ycm zmkpji kwtw xizátmbzw wbzw dmkbwz g kiskcsm ac xzwlckbw xcubw. † Lili cui spabi lm Dmkbwz ycm kwzzmaxwulmu kwu swa silwa lm cu xwsíñwuw, kiskcsiz ac xmzítmbzw. Apu lmaizzwssiz, ¿ycé mabzibmñpi caizíi xizi kiskcsiz ac ázmi? Mqmzkpkpw 1.8.5: Ázmia Kzmm ms BLI Aycizm, ms kcis istikmui swa diswzma (f1, g1) m (f2, g2) ycm awu aca mfbzmtwa lpiñwuisma, lm phycpmzli i lmzmkoi. Iñzmñcmsm cu tébwlw ycm zmkpji kwtw xizátmbzw cu xcubw g lmdcmsdi bzcm awsitmubm ap ms xcubw mabá lmubzw lm ac zmñpóu. † Acxwuñi cu kízkcsw lm zilpw z = s 2 , lwulm s ma ms bitivw lm cuw lm swa silwa lms kcilzilw, cam ms tébwlw Twubm Kizsw xizi kiskcsiz ms ázmi lms kízkcsw";

        // Frecuencia de aparición de las letras en español
        Map<Character, Double> frecuenciaEspañol = obtenerFrecuenciaEspañol();

        String textoDescifrado = descifrarTextoCesar(textoCifrado, frecuenciaEspañol);

        System.out.println("Texto cifrado: " + textoCifrado);
        System.out.println("Texto descifrado: " + textoDescifrado);

    }
}

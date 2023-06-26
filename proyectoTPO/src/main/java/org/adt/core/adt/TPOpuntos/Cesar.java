package org.adt.core.adt.TPOpuntos;

public class Cesar {
//    public static void main(String[] args) {
//        String textoCifrado = "Jxyhuhv d whvwd sdud gh ixh ehvwh jhqwudv";
//        int rotacion = 3;
//
//        String textoDesencriptado = cesarDesencriptar(textoCifrado, rotacion);
//        System.out.println("Texto desencriptado: " + textoDesencriptado);
//    }

//    public static String cesarDesencriptar(String textoCifrado, int rotacion) {
//        Map<Character, Character> diccionario = crearDiccionario(rotacion);
//
//        StringBuilder textoDesencriptado = new StringBuilder();
//
//        for (char caracter : textoCifrado.toCharArray()) {
//            char caracterDesencriptado = diccionario.getOrDefault(caracter, caracter);
//            textoDesencriptado.append(caracterDesencriptado);
//        }
//
//        return textoDesencriptado.toString();
//    }
//
//    public static Map<Character, Character> crearDiccionario(int rotacion) {
//        Map<Character, Character> diccionario = new HashMap<>();
//
//        String alfabeto = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
//        int longitud = alfabeto.length();
//
//        for (char caracter : alfabeto.toCharArray()) {
//            int indiceOriginal = alfabeto.indexOf(caracter);
//            int indiceDesencriptado = (indiceOriginal - rotacion + longitud) % longitud;
//            char caracterDesencriptado = alfabeto.charAt(indiceDesencriptado);
//
//            diccionario.put(caracter, caracterDesencriptado);
//        }
//
//        return diccionario;
//    }
}

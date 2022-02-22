package com.mycompany.ejerciciolistasenlazadas;

public class Main {
    public static void main(String[] args) {
        Nodo cabeza = new Nodo("Principio");
        ListaEnlazadaDobleCircular lista = new ListaEnlazadaDobleCircular(cabeza);

        lista.agregarAlFinal(new Nodo("Enmedio"));
        lista.agregarAlFinal(new Nodo("Final"));        

        lista.imprimirPrincipioAFinal();
        System.out.println(lista.buscar("Noexiste"));
        lista.eliminar("Principio");
        lista.imprimirPrincipioAFinal();
    }
}

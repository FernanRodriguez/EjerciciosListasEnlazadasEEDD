package com.mycompany.ejerciciolistasenlazadas;

public class Nodo {
    String informacion;
    Nodo anterior;
    Nodo siguiente;
    
    public Nodo(String informacion){
        this.informacion = informacion;
    }

    public Nodo getAnterior() {
        return anterior;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }
    
    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public void agregarAlInicio(Nodo nodoAgregar){
        
    }

    public void imprimirSiguientes(){
        System.out.println(informacion);
        if (siguiente != null) {
            siguiente.imprimirSiguientes();
        }        
    }
    
    public void imprimirAnteriores(){
        System.out.println(informacion);
        if (anterior != null) {
            anterior.imprimirAnteriores();
        }        
    }
}



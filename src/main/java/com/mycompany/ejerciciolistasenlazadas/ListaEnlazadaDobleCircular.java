package com.mycompany.ejerciciolistasenlazadas;

public class ListaEnlazadaDobleCircular {
    Nodo start;
    
    public ListaEnlazadaDobleCircular(Nodo start){
        this.start = start;
        this.start.siguiente = start;
        this.start.anterior = start;        
    }

    public void agregarAlInicio(Nodo nodoAgregar){ //O(1)
        nodoAgregar.setAnterior(start.getAnterior());
        nodoAgregar.setSiguiente(start);
        
        start.getAnterior().setSiguiente(nodoAgregar);        
        start.setAnterior(nodoAgregar);
        
        
        start = start.getAnterior();
    }
    
    public void agregarAlFinal(Nodo nodoAgregar){ //O(1)
        nodoAgregar.setAnterior(start.getAnterior());
        nodoAgregar.setSiguiente(start);
        
        start.getAnterior().setSiguiente(nodoAgregar);        
        start.setAnterior(nodoAgregar);
    }

    public void imprimirPrincipioAFinal(){ //O(n)
        imprimirSiguientes(start);
    }
    
    public void imprimirSiguientes(Nodo nodoActual){ //O(n)
        System.out.println(nodoActual.informacion);
        if (nodoActual.siguiente != start) {
            imprimirSiguientes(nodoActual.siguiente);
        }        
    }

    public void imprimirFinalAPrincipio(){ //O(n)
        imprimirAnteriores(start);
    }
    
    public void imprimirAnteriores(Nodo nodoActual){ //O(n)
        System.out.println(nodoActual.informacion);
        if (nodoActual.anterior != start) {
            imprimirAnteriores(nodoActual.anterior);
        }        
    }
    
    public int buscar(String informacionBuscada){ //O(n)
        if (start.informacion.equals(informacionBuscada)) {
            return 0;
        } else {
            return buscarEnLista(start.siguiente, 1, informacionBuscada);
        }
    }
    
    public int buscarEnLista(Nodo nodoActual, int indiceNodo, String informacionBuscada){ //O(n)
        if (nodoActual.informacion.equals(informacionBuscada)) {
            return indiceNodo;
        } else {
            if (nodoActual.siguiente != start) {
                return buscarEnLista(nodoActual.siguiente, indiceNodo+1, informacionBuscada);
            } else {
                return -1;
            }
        }
    }

    public void eliminar(String informacionEliminar){ //O(n)
        eliminarEnLista(start, informacionEliminar);
    }
    
    public void eliminarEnLista(Nodo nodoActual, String informacionEliminar){ //O(n)
        if (nodoActual.informacion.equals(informacionEliminar) && (nodoActual!=start)) {
            if (nodoActual.siguiente != start) {
                nodoActual.getAnterior().setSiguiente(nodoActual.getSiguiente());
                nodoActual.getSiguiente().setAnterior(nodoActual.getAnterior());
                Nodo siguiente = nodoActual.getSiguiente();
                nodoActual.setAnterior(null);
                nodoActual.setSiguiente(null);
                nodoActual.informacion = null;
                eliminarEnLista(siguiente, informacionEliminar);
            } else {
                nodoActual.getAnterior().setSiguiente(start);
                start.setAnterior(nodoActual.getAnterior());
                nodoActual.setAnterior(null);
                nodoActual.setSiguiente(null);
                nodoActual.informacion = null;
            }
        } else if(nodoActual.informacion.equals(informacionEliminar) && (nodoActual==start)){
                nodoActual.getAnterior().setSiguiente(nodoActual.getSiguiente());
                nodoActual.getSiguiente().setAnterior(nodoActual.getAnterior());
                start = start.getSiguiente();
                nodoActual.setAnterior(null);
                nodoActual.setSiguiente(null);
                nodoActual.informacion = null;
                eliminarEnLista(start, informacionEliminar);
        } else {
            if (nodoActual.siguiente != start) {
                eliminarEnLista(nodoActual.siguiente, informacionEliminar);
            }
        }
    }
}

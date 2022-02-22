package com.mycompany.ejerciciolistasenlazadas;

public class ListaEnlazadaDoble {
    Nodo head;
    Nodo tail;

    public ListaEnlazadaDoble(Nodo cabeza){
        this.head = cabeza;
        this.tail = cabeza;
    }
    
    public void agregarAlInicio(Nodo nodoAgregar){ //O(1)
        head.setAnterior(nodoAgregar);
        head.getAnterior().setSiguiente(head);        
        
        head = head.getAnterior();
    }
    
    public void agregarAlFinal(Nodo nodoAgregar){ //O(1)
        tail.setSiguiente(nodoAgregar);
        tail.getSiguiente().setAnterior(tail);        
        
        tail = tail.getSiguiente();
    }
    
    public void imprimirPrincipioAFinal(){ //O(n)
        head.imprimirSiguientes();
    }
    
    public void imprimirFinalAPrincipio(){ //O(n)
        tail.imprimirAnteriores();
    }
    
    public int buscar(String informacionBuscada){ //O(n)
        if (head.informacion.equals(informacionBuscada)) {
            return 0;
        } else {
            return buscarEnLista(head.siguiente, 1, informacionBuscada);
        }
    }
    
    public int buscarEnLista(Nodo nodoActual, int indiceNodo, String informacionBuscada){ //O(n)
        if (nodoActual.informacion.equals(informacionBuscada)) {
            return indiceNodo;
        } else {
            if (nodoActual.siguiente != null) {
                return buscarEnLista(nodoActual.siguiente, indiceNodo+1, informacionBuscada);
            } else {
                return -1;
            }
        }
    }
    
    public void eliminar(String informacionEliminar){ //O(n)
        eliminarEnLista(head, informacionEliminar);
    }
    
    public void eliminarEnLista(Nodo nodoActual, String informacionEliminar){ //O(n)
        if (nodoActual.informacion.equals(informacionEliminar) && (nodoActual!=head) && (nodoActual!=tail)) {
            if (nodoActual.siguiente != null) {
                nodoActual.getAnterior().setSiguiente(nodoActual.getSiguiente());
                nodoActual.getSiguiente().setAnterior(nodoActual.getAnterior());
                Nodo siguiente = nodoActual.getSiguiente();
                nodoActual.setAnterior(null);
                nodoActual.setSiguiente(null);
                nodoActual.informacion = null;
                eliminarEnLista(siguiente, informacionEliminar);
            } else {
                nodoActual.getAnterior().setSiguiente(null);
                nodoActual.setAnterior(null);
                nodoActual.setSiguiente(null);
                nodoActual.informacion = null;
            }
        } else if (nodoActual.informacion.equals(informacionEliminar) && (nodoActual==head)) {
            if (nodoActual.siguiente != null) {
                head = nodoActual.getSiguiente();
                head.setAnterior(null);
                nodoActual.setSiguiente(null);
                nodoActual.informacion = null;
                eliminarEnLista(head, informacionEliminar);
            } else {
                nodoActual.setAnterior(null);
                nodoActual.setSiguiente(null);
                nodoActual.informacion = null;
            }
        } else if (nodoActual.informacion.equals(informacionEliminar) && (nodoActual==tail)){
            tail = tail.getAnterior();
            tail.setSiguiente(null);
            nodoActual.setAnterior(null);
            nodoActual.setSiguiente(null);
            nodoActual.informacion = null;
        } else {
            if (nodoActual.siguiente != null) {
                eliminarEnLista(nodoActual.siguiente, informacionEliminar);
            }
        }
    }
}

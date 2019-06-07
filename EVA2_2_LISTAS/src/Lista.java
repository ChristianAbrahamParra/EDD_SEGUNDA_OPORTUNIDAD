
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Christian Abraham Parra Pérez # Control: C18550333
 */
public class Lista {
    //Inicio de la lista

    private Nodo inicio; //de tipo nodo para apuntar a nodos. Va a marcar el inicio de la lista
    private Nodo fin; //fin de tipo nodo para marcar el final de la lista
    private int iCantNodos; //Tipo entero para contar el número de nodos

//Al crear la lista, inicia con cero elementos
    //Lista vacía
    //3 Estados: Vacía, con un Nodo, con N Nodos
    public Lista() {
        inicio = null; //Lo inicializamos con null
        fin = null; //debe valer null
        iCantNodos = 0; //Se inicializa el contador a 0
    }

//Primer método: Agregar un Nodo
    //Método que reciba un Nodo
    //Eficiencia o (N)
    public void agregarNodo(Nodo nNuevo) { //Vamos a recibir un Nodo
        //Verificar el estado de la lista
        //Está vacía?
        if (inicio == null) { //Lista vacía
            inicio = nNuevo; //Inicio se inicializa al nuevo nodo
            fin = nNuevo; //Modificado, mayor eficiencia
        } else { //Lista con un nodo
            //Llevar al final de la lista
            /*Nodo nTemp = inicio;
             while(nTemp.getSig() != null ){ //No sabemos cuántos elementos hay, por eso while. Nos debemos de detener antes.
             nTemp = nTemp.getSig(); //Asi recorremos cada elemento
             }
             //Conectamos nTemp.sig --> nuevo
             nTemp.setSig(nNuevo);*/

            fin.setSig(nNuevo); //Fin apunta al nuevo nodo
            fin = nNuevo; //Fin se inicializa al nuevo nodo
            iCantNodos++; //Se cuentan los nodos

        }

    }

    //Eficiencia: O(1)
    public void agregarInicio(Nodo nNuevo) { //Agregar un nuevo nodo al inicio
        if (inicio == null) { //Lista vacía
            inicio = nNuevo; //Inicio apuntará al nuevo nodo
            fin = nNuevo; //Modificado, mayor eficiencia
        } else { //Lista con N nodos
            nNuevo.setSig(inicio); //Lo ponemos al principio
            inicio = nNuevo; //Inicio apuntará al nuevo nodo
        }
    }

    //Eficiencia: O(N)
    public void agregarEn(int iPos, Nodo nNuevo) {
        //Posición válida (dentro del índice de la lista)
        //Insertar al inicio (pos = 0)
        //Insertar en cualquier posición

        if (iPos == 0) { //Si la posición es igual a cero
            agregarInicio(nNuevo); //Ya tenemos un método para agregar al inicio

        } else { //Insertar en cualquier posición
            //Validar si la lista está vacía
            Nodo nTemp = inicio; //El nodo apuntará a inicio
            int iCont = 0; //Contador se iguala a cero
            while (iCont != (iPos - 1)) { //Ciclo while, mientras el contador sea diference de la posición menos uno

                nTemp = nTemp.getSig();// nTemp apuntará a nTemp siguiente
            }
            Nodo nSig = nTemp.getSig(); //El nodo siguiente apuntará a nTemp siguiente

        }
    }

    //Eficiencia: O(N)
    public void borrarNodo(int iPos) { //borrarNodo es eficiencia O(N) porque tenemos que recorrer todos los nodos previos que queremos borrar
        //Borrar al inicio de la lista
        //Borrar cualquier posición
        //Verificar que haya nodos
        //Verificar que la posición sea válida
        if (inicio != null) { //Tenemos Nodos
            if (iPos == 0) { //Nodo inicial
                //Hay un nodo
                //Hay N nodos
                inicio = inicio.getSig(); //Para eliminar el inicio
                //El problema es el nodo fin
                if (inicio.getSig() == null) //Si inicio siguiente es igual a nulo
                {
                    fin = null; //Entonces fin será igual a nulo
                }
            }
        } else {  // Cualquier otro nodo 

            Nodo nTemp = inicio; //El nodo apuntará a inicio
            int iCont = 0; //Contador igual a cero
            while (iCont != (iPos - 1)) { //Mientras el contador sea diferente de la posición menos uno

                nTemp = nTemp.getSig(); //nTemp apuntará a nTemp siguiente
            }
            Nodo nSig = nTemp.getSig();  //El nodo siguiente apuntará a nTemp siguiente
            nTemp.setSig(nTemp.getSig().getSig()); //El get siguiente nos devuelve el nodo a borrar
            //El problema es el nodo fin
            if (nTemp.getSig() == null) { //Si el nodo siguiente apunta a nulo
                fin = nTemp; //Entonces fin apuntará al nodo
            }

            //Implica movernos por la lista
            //En una lista simple (un sólo enlace)
            //Implica movernos hasta la posición - 1 (previa), por el diseño de la lista.
            //--> nTemp --> nodo a borrar --> null
            //                  fin
        } //Generar una excepción -> lista vacía

    }

    //Eficiencia O(N^2)
    public void imprimirOrdenInverso() { //Método para imprimir en orden inverso la lista
        int iVal = 0; //Se inicializa una variable a cero
        int iCont = longitud(iVal); //El contador será igual a la longitud de la lista
        for (int i = iCont - 1; i >= 0; i--) { //Ciclo for para estar invertiendo los valores
            System.out.print("[" + getValor(i) + "]");
            getValor(i); //Se obtiene el valor de la i
        }
        System.out.println(""); //Se imprimen
    }

    //Eficiencia: O(N)
    public void imprimir() { //Método imprimir
        //Llevar al final de la lista
        Nodo nTemp = inicio; //Nodo que apunta a inicio
        while (nTemp != null) { //Nos interesa recorrerlos todos
            System.out.print("[" + nTemp.getDato() + "]"); //Se imprimen los nodos
            nTemp = nTemp.getSig(); //El nodo apunta a siguiente
        } //Lo esencial para recorrer las listas
        System.out.println(""); //Imprimir
    }

    public void imprimirSinRepetir() {
        int iCont = 0;
        int iPos = -1;
        Nodo nTemp = inicio;
        while (nTemp != null) {
            System.out.print("[" + nTemp.getDato() + "]");
            nTemp = nTemp.getSig();
        }
        System.out.println("");
    }

    public void borrarRep() {
        int iPos = -1;
        Nodo nTemp = inicio;
        int iCont = 0;
        
        borrarNodo(iPos);

       
    }

    public void agregarLista(Lista copiaLista) {
        for (int i = 0; i < 10; i++) {
            int iVal = (int) ((Math.random() * 1000) + 1);
            copiaLista.agregarNodo(new Nodo(iVal));
            //agregar lista
        }
    }
    
    

//Eficiencia: O(N)
    public int longitud(int iVal) { //Método para saber la cantidad de nodos en la lista

        /*int iResu = 0;
         Nodo nTemp = inicio;
         while (nTemp != null) {
         iResu++;
         nTemp = nTemp.getSig();
         } */
        return iCantNodos++; //Regresa la cantidad de nodos

    }

    //Eficiencia: O(1)
    public void vaciar() { //Método para vaciar la lista
        inicio = null; //Inicio apunta a null
        fin = null; //Fin apunta a null
    }

//Las listas manejan índices como arreglos
//Primer nodo - posición 0
//Último nodo - N-1
//Eficiencia es: O(N)
//Agregar condiciones:
//Lista vacía
//Parámetro incorrecto (iPos no esté entre 0 y N-1)
//Excepciones
//Si la lista está vacía, iPos no esté entre 0 y N-1
    //Eficiencia: O(N)
    public int getValor(int iPos) { //Posición a la que queremos llegar
        int iVal = 0; //Se inicializa a cero la variable iVal
        int iCont = 0; //Necesitamos un contador
        Nodo nTemp = inicio; //El nodo apunta a inicio
        while (nTemp != null) { //Nos interesa recorrerlos todos
            if (iCont == iPos) { //Si el contador es igual a la posición
                iVal = nTemp.getDato(); //iVal es igual a nTemp
                break; //Detenemos el ciclo, si no va a recorrer todo el ciclo
            }
            nTemp = nTemp.getSig();
            iCont++; //incrementamos el contador
        }
        return iVal; //Regresa el valor
    }

    public boolean estaVacia() { //Método para saber si la lista está vacía
        if (inicio == null) //Si inicio es igual a null
        {
            return true; //Entonces la lista está vacía
        } else //Si no
        {
            return false; //Entonces la lista no está vacía
        }
    }

//Eficiencia: O(N)
    public int buscar(int iVal) { //Método para buscar un valor
        int iPos = -1; //Si no lo encuentra, se regresa al anterior
        //Recorrer elemento por elemento
        //Detener la búsqueda cuando lo encontremos
        //Se puede llegar al final de la lista sin encontrarlo    
        //Cómo buscamos el valor
        Nodo nTemp = inicio; //El nodo apunta a inicio
        int iCont = 0; //Para saber la posición en donde lo encontramos
        while (nTemp != null) { //Mientras el nodo sea diferente de nulo
            //Detener el ciclo cuando lo encontremos
            if (iVal == nTemp.getDato()) {//Lo vamos a buscar con nTemp
                iPos = iCont; //Hay que igualar
                break; //Quebramos el ciclo

            }

            iCont++; //Aumenta el contador
            nTemp = nTemp.getSig(); //El nodo apunta a siguiente

        }
        return iPos; //Regresa la posición

    }

//regresamos un objeto de tipo lista
//Eficiencia: O(N)
    public Lista copiaLista() { //Es un duplicado exacto de la lista, es decir, con los mismos valores
        Lista lsCopia = new Lista();
        //Hay que recorrer toda la lista, leer cadaa nodo
        //Crear un nodo nuevo para ese valor
        //Insertarlo en la nueva lista
        Nodo nTemp = inicio; //El nodo apunta a inicio
        while (nTemp != null) { //Nos interesa recorrerlos todos
            lsCopia.agregarNodo(new Nodo(nTemp.getDato())); //Obtenemos el valor entero para ponerlo en nuevo nodo, tenemos dos copias totalmente separadas
            nTemp = nTemp.getSig(); //El nodo apunta a siguiente
        }
        return lsCopia; //Regresa la copia
    }

}

//Inicio sea al nuevo nodo


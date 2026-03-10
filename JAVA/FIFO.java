package com.mycompany.fifo;

import java.util.Scanner;

class Turno {
    int numero;
    String nombre;

    //constructor de turno para los nuevos que ingresan
    Turno(int numero, String nombre) {
        this.numero = numero;
        this.nombre = nombre;
    }
}

//nodo de la lista enlazada en data y next
class Node {
    Turno data;
    Node next;

    //constructor de nodo para guardar el turno
    Node(Turno data) {
        this.data = data;
        this.next = null;
    }
}

public class FIFO {

    static Node head = null;

    //aquí se crea el primer arreglo para los turnos iniciales
    public static void cargarInicial() {

        Turno[] datos = {
            new Turno(1, "Ana"),
            new Turno(2, "Luis"),
            new Turno(3, "Sara")
        };

        for (int i = 0; i < datos.length; i++) {
            registrarTurno(datos[i].numero, datos[i].nombre);
        }
    }

    public static void registrarTurno(int numero, String nombre) {

        //nuevo nodo para agregar un turno al final de la fila
        Node nuevo = new Node(new Turno(numero, nombre));

        if (head == null) {
            head = nuevo;
        } else {
            Node aux = head; //agrego auxiliar para recorrer la lista enlazada entre los nodos

            while (aux.next != null) {
                aux = aux.next;
            }

            aux.next = nuevo;
        }

        System.out.println("Registrado: " + numero + "-" + nombre);
    }

    //elimina el primer turno
    public static void atenderTurno() {

        if (head == null) {
            System.out.println("No hay turnos.");
        } else {
            System.out.println("Atendido: " + head.data.numero + "-" + head.data.nombre);
            head = head.next;
        }
    }

    //inicia buscador de turno por número
    public static void buscarTurno(int numero) {

        Node aux = head;

        while (aux != null) {

            if (aux.data.numero == numero) {
                System.out.println("ENCONTRADO: " + aux.data.numero + "-" + aux.data.nombre);
                return;
            }

            aux = aux.next;
        }

        System.out.println("NO ENCONTRADO");
    }

    public static void imprimirFila() {

        Node aux = head;

        System.out.print("Fila: [");

        while (aux != null) {

            System.out.print(aux.data.numero + "-" + aux.data.nombre);

            if (aux.next != null) {
                System.out.print(", ");
            }

            aux = aux.next;
        }

        System.out.println("]");
    }

    public static void main(String[] args) {

        //método sc para que lea los datos que escribe el usuario en el teclado
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {

            System.out.println("\n1. Cargar turnos iniciales (desde arreglo)");
            System.out.println("2. Registrar turno (agregar al final)");
            System.out.println("3. Atender turno (eliminar al inicio)");
            System.out.println("4. Buscar turno (por numero)");
            System.out.println("5. Imprimir fila");
            System.out.println("0. Salir");

            opcion = sc.nextInt();

            if (opcion == 1) {
                cargarInicial();
            }

            if (opcion == 2) {
                System.out.print("Numero: ");
                int num = sc.nextInt();
                sc.nextLine();

                System.out.print("Nombre: ");
                String nom = sc.nextLine();

                registrarTurno(num, nom);
            }

            if (opcion == 3) {
                atenderTurno();
            }

            if (opcion == 4) {
                System.out.print("Numero a buscar: ");
                int num = sc.nextInt();
                buscarTurno(num);
            }

            if (opcion == 5) {
                imprimirFila();
            }

        } while (opcion != 0);

    }
}
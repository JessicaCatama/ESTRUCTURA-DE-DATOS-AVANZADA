import java.util.Scanner;

class Turno {
    int numero;
    String nombre;

    Turno(int numero, String nombre) {
        this.numero = numero;
        this.nombre = nombre;
    }
}

class Node {
    Turno data;
    Node next;

    Node(Turno data) {
        this.data = data;
        this.next = null;
    }
}

public class Main {

    static Node head = null;

    // 1. Cargar datos iniciales desde arreglo
    public static void cargarDesdeArreglo() {

        Turno[] iniciales = {
                new Turno(1, "Ana"),
                new Turno(2, "Luis"),
                new Turno(3, "Sara")
        };

        for (Turno t : iniciales) {
            registrarTurno(t.numero, t.nombre);
        }

        System.out.println("Turnos cargados desde arreglo.");
    }

    // 2. Registrar turno (agregar al final)
    public static void registrarTurno(int numero, String nombre) {

        Node nuevo = new Node(new Turno(numero, nombre));

        if (head == null) {
            head = nuevo;
        } else {
            Node temp = head;

            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = nuevo;
        }

        System.out.println("Registrado: " + numero + "-" + nombre);
    }

    // 3. Atender turno (eliminar al inicio)
    public static void atenderTurno() {

        if (head == null) {
            System.out.println("No hay turnos para atender.");
            return;
        }

        System.out.println("Atendido: " + head.data.numero + "-" + head.data.nombre);
        head = head.next;
    }

    // 4. Buscar turno
    public static void buscarTurno(int numero) {

        Node temp = head;

        while (temp != null) {

            if (temp.data.numero == numero) {
                System.out.println("Buscar " + numero + ": ENCONTRADO " + temp.data.numero + "-" + temp.data.nombre);
                return;
            }

            temp = temp.next;
        }

        System.out.println("Buscar " + numero + ": NO ENCONTRADO");
    }

    // 5. Imprimir fila
    public static void imprimirFila() {

        if (head == null) {
            System.out.println("Fila vacía.");
            return;
        }

        Node temp = head;

        System.out.print("Fila: [");

        while (temp != null) {

            System.out.print(temp.data.numero + "-" + temp.data.nombre);

            if (temp.next != null) {
                System.out.print(", ");
            }

            temp = temp.next;
        }

        System.out.println("]");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcion;

        do {

            System.out.println("\n--- MENU ---");
            System.out.println("1. Cargar turnos iniciales");
            System.out.println("2. Registrar turno");
            System.out.println("3. Atender turno");
            System.out.println("4. Buscar turno");
            System.out.println("5. Imprimir fila");
            System.out.println("0. Salir");

            opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    cargarDesdeArreglo();
                    break;

                case 2:
                    System.out.print("Numero de turno: ");
                    int num = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();

                    registrarTurno(num, nombre);
                    break;

                case 3:
                    atenderTurno();
                    break;

                case 4:
                    System.out.print("Numero a buscar: ");
                    int buscar = sc.nextInt();
                    buscarTurno(buscar);
                    break;

                case 5:
                    imprimirFila();
                    break;

            }

        } while (opcion != 0);

        sc.close();
    }
}
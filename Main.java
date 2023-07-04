import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        String msg1;
        String msg2;

        GerenciadorSalasIMD gerenciadorsalas = new GerenciadorSalasIMD();

        Sala sala1 = new Sala("A101", 40, true);
        Sala sala2 = new Sala("A102", 40, true);

        gerenciadorsalas.registrarSala(sala1);
        gerenciadorsalas.registrarSala(sala2);

        gerenciadorsalas.exibeSalasRegistradas();

        msg1 = gerenciadorsalas.removerSala(sala1);
        msg2 = gerenciadorsalas.removerSala(sala1);

        gerenciadorsalas.exibeSalasRegistradas();

        System.out.println("msg1: "+msg1+"\nmsg2: "+msg2);

    }
}
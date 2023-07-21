import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int choice;

        GerenciadorSalasIMD gerenciadorsalas = new GerenciadorSalasIMD();

        Sala sala1 = new Sala("A101", 40, false);
        Sala sala2 = new Sala("A102", 40, false);
        Sala sala3 = new Sala("A103", 20, true);
        Sala sala4 = new Sala("A104", 25, true);
        Sala sala5 = new Sala("A105", 20, true);

        gerenciadorsalas.registrarSala(sala1);
        gerenciadorsalas.registrarSala(sala2);
        gerenciadorsalas.registrarSala(sala3);
        gerenciadorsalas.registrarSala(sala4);
        gerenciadorsalas.registrarSala(sala5);

        gerenciadorsalas.reservarHorario(sala1,"2023-07-06", 1, "12345");
        gerenciadorsalas.reservarHorario(sala1,"2023-07-06", 2, "67890");
        gerenciadorsalas.reservarHorario(sala1,"2023-07-06", 5, "54321");
        gerenciadorsalas.reservarHorario(sala1,"2023-07-06", 6, "09876");
        gerenciadorsalas.reservarHorario(sala1,"2023-07-06", 7, "13579");

        Professor professor1 = new Professor("Matheus", "003003003-03","002020202", "2022032742");
        gerenciadorsalas.registrarProfessor(professor1);

        //gerenciadorsalas.removerSala("A105");

        //sala1.exibeHorariosLivresNaSalaUmaSemanaPraFrente("2023-07-06"); // ok!
        //gerenciadorsalas.exibeSalasRegistradas(); // ok!
        //gerenciadorsalas.exibeSalasLivresNoDiaEHorario("2023-07-06",1); // ok!

        System.out.println("Horário disponivel? " + gerenciadorsalas.isHorarioDisponivel(gerenciadorsalas.retornaSala("A101"),"2023-07-06", 3)); // ok     
        System.out.println("Horário disponivel? " + gerenciadorsalas.isHorarioDisponivel(sala1,"2023-07-06", 3)); // ok


        while(true){
            System.out.println("O que você quer fazer?\n\n" +
            "1. Listar salas registradas\n" +
            "2. Listar professores registrados\n"
            );

            try{
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("A entrada precisa ser um número de 1 a 2.");
                scanner.next();
                continue;
            }

            switch(choice){
                case 1:
                    gerenciadorsalas.exibeSalasRegistradas();
                    break;
                case 2:
                    gerenciadorsalas.exibeProfessoresRegistrados();
                    break;
                default:
                    System.out.println("A entrada precisa ser um número de 1 a 2.");

            }
        }

        
    }
}
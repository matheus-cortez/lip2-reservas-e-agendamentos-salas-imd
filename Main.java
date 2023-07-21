import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int choice;
        String dia_escolhido;
        int horario_escolhido;
        String matricula_professor_escolhido;
        String sala_escolhida;

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

        Professor professor1 = new Professor("Matheus", "003003003-03","002020202", "2022032742");
        gerenciadorsalas.registrarProfessor(professor1);

        gerenciadorsalas.reservarHorario(sala1,"2023-07-06", 1, "2022032742");
        gerenciadorsalas.reservarHorario(sala1,"2023-07-06", 2, "2022032742");
        gerenciadorsalas.reservarHorario(sala1,"2023-07-06", 5, "2022032742");
        gerenciadorsalas.reservarHorario(sala1,"2023-07-06", 6, "2022032742");
        gerenciadorsalas.reservarHorario(sala1,"2023-07-06", 7, "2022032742");

        //gerenciadorsalas.exibeHorariosLivresNaSalaUmaSemanaPraFrente(gerenciadorsalas.retornaSala("A101"), "2023-07-06");



        while(true){
            System.out.println("\nO que você quer fazer?\n\n" +
            "1. Abrir a interface gráfica de reserva/liberação de salas\n" +
            "2. Listar salas registradas\n" +
            "3. Listar professores registrados\n" + 
            "4. Listar horários livres em determinada sala, uma semana pra frente em relação a uma data\n" +
            "5. Listar salas livres em um determinado dia e horário\n\n"
            );

            try{
                choice = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("A entrada precisa ser um número de 1 a 5.");
                scanner.nextLine();
                continue;
            }

            switch(choice){
                case 1:
                    SwingUtilities.invokeLater(new Runnable() {
                        public void run() {
                        new InterfaceGrafica(gerenciadorsalas).setVisible(true);
                        }
                    });
                    break;
                case 2:
                    gerenciadorsalas.exibeSalasRegistradas();
                    break;
                case 3:
                    gerenciadorsalas.exibeProfessoresRegistrados();
                    break;
                case 4:
                    System.out.println("Insira o nome da sala (A101, A102...):\n");
                    sala_escolhida = scanner.nextLine();

                    System.out.println("Insira o dia escolhido no formato YYYY-MM-DD:\n");
                    dia_escolhido = scanner.nextLine();

                    gerenciadorsalas.exibeHorariosLivresNaSalaUmaSemanaPraFrente(gerenciadorsalas.retornaSala(sala_escolhida), dia_escolhido);
                    break;
                case 5:
                    System.out.println("Insira o dia escolhido no formato YYYY-MM-DD:\n");
                    dia_escolhido = scanner.nextLine();

                    System.out.println("Insira o horario escolhido, sendo 1=M12, 8=N34:\n");
                    horario_escolhido = scanner.nextInt();

                    gerenciadorsalas.exibeSalasLivresNoDiaEHorario(dia_escolhido, horario_escolhido);

                default:
                    System.out.println("A entrada precisa ser um número de 1 a 2.");

            }
        }



        
    }
}
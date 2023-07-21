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
        String cpf_professor;
        String rg_professor;
        String nome_professor;
        String nome_sala;
        int qtd_pessoas_sala;
        boolean possui_pc_na_sala;
        String str_possui_pc_na_sala;

        GerenciadorSalasIMD gerenciadorsalas = new GerenciadorSalasIMD();
        InterfaceGrafica interfaceGrafica = new InterfaceGrafica();
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
            "1. Abrir a interface gráfica de reserva/liberação de salas (apenas para demonstrar a GUI)\n" +
            "2. Listar salas registradas\n" +
            "3. Listar professores registrados\n" + 
            "4. Listar horários livres em determinada sala, uma semana pra frente em relação a uma data\n" +
            "5. Listar salas livres em um determinado dia e horário\n" +
            "6. Reservar um horário em uma sala em um determinado dia\n" +
            "7. Liberar um horário em uma sala em um determinado dia\n" +
            "8. Registrar um professor\n" +
            "9. Deletar um professor\n" +
            "10. Registrar uma sala\n" +
            "11. Deletar uma sala\n"
            );

            try{
                choice = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("A entrada precisa ser um número de 1 a 11.");
                scanner.nextLine();
                continue;
            }

            switch(choice){
                case 1:
                    interfaceGrafica.setGerenciadorSalas(gerenciadorsalas); // Set the gerenciadorsalas object
                    SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        interfaceGrafica.setVisible(true);
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
                    scanner.nextLine();

                    gerenciadorsalas.exibeSalasLivresNoDiaEHorario(dia_escolhido, horario_escolhido);

                case 6:
                    System.out.println("Insira o nome da sala (A101, A102...):\n");
                    sala_escolhida = scanner.nextLine();

                    System.out.println("Insira o dia escolhido no formato YYYY-MM-DD:\n");
                    dia_escolhido = scanner.nextLine();

                    System.out.println("Insira o horario escolhido, sendo 1=M12, 8=N34:\n");
                    horario_escolhido = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Insira a matricula do professor solicitante:\n");
                    matricula_professor_escolhido = scanner.nextLine();

                    System.out.println(gerenciadorsalas.reservarHorario(gerenciadorsalas.retornaSala(sala_escolhida), dia_escolhido, horario_escolhido, matricula_professor_escolhido));


                    break;

                case 7:
                    System.out.println("Insira o nome da sala (A101, A102...):\n");
                    sala_escolhida = scanner.nextLine();

                    System.out.println("Insira o dia escolhido no formato YYYY-MM-DD:\n");
                    dia_escolhido = scanner.nextLine();

                    System.out.println("Insira o horario escolhido, sendo 1=M12, 8=N34:\n");
                    horario_escolhido = scanner.nextInt();

                    System.out.println(gerenciadorsalas.liberarHorario(gerenciadorsalas.retornaSala(sala_escolhida), dia_escolhido, horario_escolhido));

                    break;

                case 8://nome cpf rg matricula
                    System.out.println("Insira o nome do professor:\n");
                    nome_professor = scanner.nextLine();

                    System.out.println("Insira o cpf do professor:\n");
                    cpf_professor = scanner.nextLine();

                    System.out.println("Insira o rg do professor:\n");
                    rg_professor = scanner.nextLine();

                    System.out.println("Insira a matricula do professor:\n");
                    matricula_professor_escolhido = scanner.nextLine();

                    gerenciadorsalas.registrarProfessor(new Professor(nome_professor, cpf_professor, rg_professor, matricula_professor_escolhido));
                    break;

                case 9:
                    System.out.println("Insira a matricula do professor solicitante:\n");
                    matricula_professor_escolhido = scanner.nextLine();

                    gerenciadorsalas.removerProfessor(matricula_professor_escolhido);
                    break;

                case 10:
                    System.out.println("Insira o nome da sala (A101, A102...):\n");
                    sala_escolhida = scanner.nextLine();

                    System.out.println("Insira a quantidade de pessoas que a sala suporta:\n");
                    qtd_pessoas_sala = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("A sala possui computadores para os alunos?\n Sim: 's' ou 'S'; Não : 'n' ou 'N'\n");
                    str_possui_pc_na_sala = scanner.nextLine();
                    if(str_possui_pc_na_sala.equals("s")||str_possui_pc_na_sala.equals("S")){
                        possui_pc_na_sala = true;
                    }else if(str_possui_pc_na_sala.equals("n")||str_possui_pc_na_sala.equals("N")){
                        possui_pc_na_sala = false;
                    }else{
                        System.out.println("Entrada inválida.\n");
                        break;
                    }

                    gerenciadorsalas.registrarSala(new Sala(sala_escolhida, qtd_pessoas_sala, possui_pc_na_sala));
                    break;

                case 11:
                    System.out.println("Insira o nome da sala (A101, A102...):\n");
                    sala_escolhida = scanner.nextLine();

                    gerenciadorsalas.removerSala(sala_escolhida);
                    break;

                default:
                    System.out.println("A entrada precisa ser um número de 1 a 11.");

            }
        }



        
    }
}
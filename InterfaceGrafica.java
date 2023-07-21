import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfaceGrafica extends JFrame {
    private JButton reserveButton;
    private JButton releaseButton;
    private GerenciadorSalasIMD gerenciadorsalas;
    private JDialog reservationDialog;
    private JDialog releaseDialog;

    public void setGerenciadorSalas(GerenciadorSalasIMD gerenciadorsalas) {
        this.gerenciadorsalas = gerenciadorsalas;
    }

    public InterfaceGrafica() {
        // Configurações básicas da janela
        setTitle("Sistema de Reserva de Salas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLayout(new FlowLayout());

        // Criação dos botões
        reserveButton = new JButton("Reservar horário em uma sala");
        releaseButton = new JButton("Liberar horário em uma sala");

        // Adiciona os botões à janela
        add(reserveButton);
        add(releaseButton);

        // Adiciona os ouvintes de eventos (Listeners) para os botões
        reserveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showReservationDialog();
            }
        });

        releaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showReleaseDialog();
            }
        });
    }

    private void showReservationDialog() {
        // Criação da caixa de diálogo para reserva de sala
        reservationDialog = new JDialog(this, "Reservar Sala", true);
        reservationDialog.setLayout(new GridLayout(5, 2));
        reservationDialog.setSize(300, 200);

        JLabel nameLabel = new JLabel("Nome da Sala (A101, A102...):");
        JLabel dateLabel = new JLabel("Data (YYYY-MM-DD):");
        JLabel timeLabel = new JLabel("Horário (1 a 8, 1=M12, 8=N34):");
        JLabel enrollmentLabel = new JLabel("Matrícula do professor:");

        JTextField nameField = new JTextField(20);
        JTextField dateField = new JTextField(20);
        JTextField timeField = new JTextField(20);
        JTextField enrollmentField = new JTextField(20);

        JButton submitButton = new JButton("Submeter");

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sala = nameField.getText();
                String data = dateField.getText();
                int horario = Integer.parseInt(timeField.getText());
                String matricula = enrollmentField.getText();

                String result = gerenciadorsalas.reservarHorario(
                    gerenciadorsalas.retornaSala(sala),
                    data,
                    horario,
                    matricula
                );

                JOptionPane.showMessageDialog(reservationDialog, result);
                reservationDialog.dispose();

                /* String result = processReservation(name, date, time, enrollment);
                JOptionPane.showMessageDialog(reservationDialog, result);
                reservationDialog.dispose(); */
            }
        });

        reservationDialog.add(nameLabel);
        reservationDialog.add(nameField);
        reservationDialog.add(dateLabel);
        reservationDialog.add(dateField);
        reservationDialog.add(timeLabel);
        reservationDialog.add(timeField);
        reservationDialog.add(enrollmentLabel);
        reservationDialog.add(enrollmentField);
        reservationDialog.add(new JLabel()); // Espaço em branco para ajustar layout
        reservationDialog.add(submitButton);

        reservationDialog.setVisible(true);
    }

    private void showReleaseDialog() {
        // Criação da caixa de diálogo para liberação de sala
        releaseDialog = new JDialog(this, "Liberar Sala", true);
        releaseDialog.setLayout(new GridLayout(4, 2));
        releaseDialog.setSize(300, 150);

        JLabel nameLabel = new JLabel("Nome da Sala:");
        JLabel dateLabel = new JLabel("Data (YYYY-MM-DD):");
        JLabel timeLabel = new JLabel("Horário (1 a 8):");

        JTextField nameField = new JTextField(20);
        JTextField dateField = new JTextField(20);
        JTextField timeField = new JTextField(20);

        JButton submitButton = new JButton("Submeter");

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sala = nameField.getText();
                String data = dateField.getText();
                int horario = Integer.parseInt(timeField.getText());

                String result = gerenciadorsalas.liberarHorario(
                    gerenciadorsalas.retornaSala(sala),
                    data,
                    horario
                );

                JOptionPane.showMessageDialog(reservationDialog, result);
                reservationDialog.dispose();

                /* String result = processRelease(name, date, time);
                JOptionPane.showMessageDialog(releaseDialog, result);
                releaseDialog.dispose(); */
            }
        });

        releaseDialog.add(nameLabel);
        releaseDialog.add(nameField);
        releaseDialog.add(dateLabel);
        releaseDialog.add(dateField);
        releaseDialog.add(timeLabel);
        releaseDialog.add(timeField);
        releaseDialog.add(new JLabel()); // Espaço em branco para ajustar layout
        releaseDialog.add(submitButton);

        releaseDialog.setVisible(true);
    }

    // Função para processar a reserva de sala
    private String processReservation(String name, String date, String time, String enrollment) {
        // Lógica de processamento de reserva (substitua por sua implementação real)
        // Aqui você pode fazer a chamada à função Java para lidar com a reserva.
        // Retorne uma mensagem apropriada para o usuário.
        return "Sala reservada com sucesso!";
    }

    // Função para processar a liberação de sala
    private String processRelease(String name, String date, String time) {
        // Lógica de processamento de liberação (substitua por sua implementação real)
        // Aqui você pode fazer a chamada à função Java para lidar com a liberação.
        // Retorne uma mensagem apropriada para o usuário.
        return "Sala liberada com sucesso!";
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new InterfaceGrafica().setVisible(true);
            }
        });
    }
}

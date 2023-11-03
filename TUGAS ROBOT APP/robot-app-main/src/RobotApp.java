import java.util.Scanner;

import Model.Layout;
import Model.Position;
import Model.Robot;

public class RobotApp {
    public static void main(String[] args) {
        new RobotApp();
    }

    private Layout layout;
    private Robot robot;
    private Scanner scanner;

    public RobotApp() {
        this.layout = new Layout(10, 10, '*');
        this.robot = new Robot('o', new Position(1, 1));
        this.scanner = new Scanner(System.in);
        startGame();
    }

    private void startGame() {
        System.out.println("-------- Permainan Dimulai --------");
        draw();

        String instruction;
        do {
            instruction = waitInstruction();

            if (!instruction.equals("x")) {
                char direction = instruction.charAt(0);
                int steps = Integer.parseInt(instruction.substring(1));

                moveRobot(direction, steps);

                if (isRobotOutOfBound()) {
                    System.out.println("Robot keluar dari area permainan, permainan selesai");
                    break;
                }
                draw();
            } else {
                System.out.println("Permainan selesai");
            }

        } while (!instruction.equals("x"));
    }

    private void moveRobot(char direction, int steps) {
        switch (direction) {
            case 'd':
                robot.moveRight(steps);
                break;
            case 'a':
                robot.moveLeft(steps);
                break;
            case 'w':
                robot.moveUp(steps);
                break;
            case 's':
                robot.moveDown(steps);
                break;
            default:
                System.out.println("Instruksi tidak dikenali, permainan selesai");
        }
    }

    private boolean isRobotOutOfBound() {
        int x = robot.getPosition().getX();
        int y = robot.getPosition().getY();
        return x < 0 || x >= layout.getMaxX() || y < 0 || y >= layout.getMaxY();
    }

    private String waitInstruction() {
        System.out.println("-------- Instruksi --------");
        System.out.println("Instruksi: {d=kanan/a=kiri/w=atas/s=bawah}{jumlah langkah}");
        System.out.println("Contoh: w3 berarti 'ke atas 3 langkah'");
        System.out.print("Masukkan instruksi atau ketik 'x' untuk keluar: ");
        return scanner.nextLine();
    }

    private void draw() {
        System.out.println("------ Posisi Robot ------");
        for (int y = 0; y < layout.getMaxY(); y++) {
            for (int x = 0; x < layout.getMaxX(); x++) {
                if (x == robot.getPosition().getX() && y == robot.getPosition().getY()) {
                    System.out.print(robot.getIcon());
                } else {
                    System.out.print(layout.getArea()[x][y]);
                }
            }
            System.out.println();
        }
    }
}


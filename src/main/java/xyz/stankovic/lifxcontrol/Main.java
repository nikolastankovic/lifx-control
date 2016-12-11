package xyz.stankovic.lifxcontrol;

import com.diogonunes.jcdp.color.ColoredPrinter;
import com.diogonunes.jcdp.color.api.Ansi.*;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by stankovic on 26.11.2016.
 */
public class Main {

    public static void main(String[] args) throws Exception {

        ColoredPrinter cp = new ColoredPrinter.Builder(1, false)
                .background(BColor.NONE)
                .foreground(FColor.CYAN)
                .build();

        cp.println("-----------------------");
        cp.println("Welcome to Lifx-Control");
        cp.println("-----------------------\n");

        cp.println("Select your action by typing the number to run.\n");

        cp.println("1) Start the Fader for a night to day shift in your time period.");
        cp.println("9) Exit LIFX-Cotnrol.\n");

        Scanner scanner = new Scanner(System.in);

        int choice = 0;

        boolean run = true;
        while (run) {

            try {
                cp.print("Enter your desired action: ");
                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        int duration = 0;

                        cp.print("Enter in minutes the night to day switch: ");
                        duration = scanner.nextInt();

                        if (duration >= 1) {
                            runFader(duration);
                        }
                        run = false;
                        break;

                    case 9:
                        run = false;
                        break;

                    default:
                        cp.errorPrintln("Unknown action number! Please choice an existing one.");
                        break;
                }
            } catch (InputMismatchException ex) {
                cp.errorPrintln("Unknown action number! Please choice an existing one.");
                scanner.nextLine();
                choice = 0;
            }
        }

    }

    private static void runFader(int duration) throws Exception {
        new Fader().start(duration);
    }
}

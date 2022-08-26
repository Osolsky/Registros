import java.io.*;
import java.util.Locale;
import java.util.Scanner;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            MasterOfRegister registerControl = new MasterOfRegister();

            boolean end = false;
            while (!end) {

                registerControl.userComunication();
                String line = scanner.nextLine();

                switch (line.toLowerCase()){

                    case "add":
                        registerControl.addRegister();
                        break;

                    case "view":
                        registerControl.seeRegisters();
                        break;

                    case "end":
                    end = true;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}

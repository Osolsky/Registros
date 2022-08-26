import java.io.*;
import java.util.Scanner;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        try {
            //Instancing the objects we will need
            File workingFile = new File("E:\\Content\\correos.txt");
            Scanner scanner = new Scanner(System.in);
            MasterOfRegister registerControl = new MasterOfRegister();

            //Loop to add whatever data the user wants
            boolean end = false;
            while (!end) {

                registerControl.userComunication();
                String line = scanner.nextLine();



                switch (line){

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

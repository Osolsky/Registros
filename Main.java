import java.io.*;
import java.util.Scanner;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        try {
            //Instancing the objects we will need
            FileWriter create_File = new FileWriter("E:\\Content\\correos.txt", true);
            PrintWriter write_File = new PrintWriter(create_File);
            Scanner scanner = new Scanner(System.in);
            File workingFile = new File("E:\\Content\\correos.txt");



            //Variable to see the times the user have added new data
            int count_Data = 0;
            //Loop to add whatever data the user wants
            boolean end = false;
            while (!end) {

                System.out.println("escribe 'add' para introducir un registro");
                System.out.println("escribe 'view' para ver tus registros");
                System.out.println("escribe 'end' para finalizar el proceso");
                String line = scanner.nextLine();
                int numOfRegisters = 0;


                switch (line){

                    case "add":
                        count_Data++;
                        System.out.println("Introduce tu registro");
                        String register = scanner.nextLine();
                        write_File.println(register);
                        System.out.println("register saved successfully");
                        break;

                    case "view":
                        BufferedReader readerOfWorkingFile = new BufferedReader(new FileReader(workingFile));
                        String lineOfWorkingFile;
                        Vector<String> vectorWhitFileContent = new Vector<String>(40);
                        while ((lineOfWorkingFile = readerOfWorkingFile.readLine()) != null) {
                            vectorWhitFileContent.addElement(lineOfWorkingFile);
                        }

                        String[] arrayOfVectorWhitFileContent = vectorWhitFileContent.toArray(new String[vectorWhitFileContent.size()]);
                        for (int i = 0; i < arrayOfVectorWhitFileContent.length; i++) {
                            ++numOfRegisters;
                            System.out.println(numOfRegisters + ".- " + arrayOfVectorWhitFileContent[i]);
                            System.out.println("------------------------------------------------------------");
                        }
                        break;

                    case "end":
                        end = true;
                        create_File.close();
                        break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}

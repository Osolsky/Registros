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


            //Variable to see the times the user have added new data
            int count_Data = 0;
            //Loop to add whatever data the user wants
            boolean end = false;
            while (!end) {

                //Asking for the user about their information
                System.out.println("Enter all your emails");
                System.out.println("The number of data you have added is  " + count_Data);
                System.out.println("To end the process type ´end´ ");
                System.out.println("To see the last email you add type ´preview´ ");

                //Saves de content of the user input console
                String line = scanner.nextLine();
                int numOfRegisters = 0;
                if (line.equalsIgnoreCase("end")) {
                    end = true;
                    create_File.close();

                } else if (line.equalsIgnoreCase("preview")) {
                    File workingFile = new File("E:\\Content\\correos.txt");
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
                } else {
                    if (line.length() < 15) {
                        System.out.println("Los sentimos, el registro que ingresaste es muy pequeño, vuelve a intentarlo");
                    } else {
                        write_File.println(line);
                        count_Data++;
                        System.out.println("email saved successfully");
                    }

                }


            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

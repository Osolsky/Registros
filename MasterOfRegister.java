import java.io.*;
import java.util.Scanner;
import java.util.Vector;

public class MasterOfRegister {
    String nombre;
    String apellidos;
    int intnumeroTelefonico;
    String numeroTelefonico;
    public void addRegister(){
        try{
            FileWriter createFile = new FileWriter("E:\\Content\\correos.txt", true);
            PrintWriter writeInFile = new PrintWriter(createFile);
            Scanner read = new Scanner(System.in);
            Boolean end = false;
            String lectureFromConsole;

            while (!end){
                System.out.println("Ingresa tu registro");
                System.out.println("Para terminar el proceso escribe 'end'");
                lectureFromConsole = read.nextLine();

                if (lectureFromConsole.equalsIgnoreCase("end")){
                    createFile.close();
                    end=true;
                }else{
                    writeInFile.println(lectureFromConsole);
                    System.out.println("Registro salvado correctamente");
                }

            }


        }catch(IOException e){
            e.printStackTrace();}


    }

    public void seeRegisters() throws IOException {
        int numOfRegisters = 0;
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

    }


    public void userComunication(){
        System.out.println("escribe 'add' para introducir un registro");
        System.out.println("escribe 'view' para ver tus registros");
        System.out.println("escribe 'end' para finalizar el programa");
    }

}




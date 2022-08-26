import java.io.*;
import java.util.Scanner;
import java.util.Vector;

public class MasterOfRegister {
    private String nombre;
    private String apellidos;
    private int intnumeroTelefonico;
    private String numeroTelefonico;

    private String cedula;

    private String direccion;

    public String getCedula() {
        Scanner lector = new Scanner(System.in);
        System.out.println("Ingresa tu cedula");
        this.cedula = lector.nextLine();
        return this.cedula;
    }

    public String getDireccion() {
        Scanner lector = new Scanner(System.in);
        System.out.println("Ingresa tu direccion");
        this.direccion = lector.nextLine();
        return this.direccion;
    }

    public String getNombre() {
        Scanner lector = new Scanner(System.in);
        System.out.println("Ingresa el nombre");
        this.nombre = lector.nextLine();
        return this.nombre;
    }

    public String getApellidos() {
        Scanner lector = new Scanner(System.in);
        System.out.println("Ingresa el apellido");
        this.apellidos = lector.nextLine();
        return this.apellidos;
    }

    public String getIntnumeroTelefonico() {
        Scanner lector = new Scanner(System.in);
        System.out.println("Ingresa el telefono");
        this.numeroTelefonico = lector.nextLine();
        return this.numeroTelefonico;
    }

    public String finalRegister(){
        String line ="";
        line = getCedula()+","+ getNombre() + "," + getApellidos() + "," +getIntnumeroTelefonico() + "," + getDireccion() ;
        return line;
    }

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
                System.out.println("Para ingresar el registro escribe 'continue'");
                lectureFromConsole = read.nextLine();

                if (lectureFromConsole.equalsIgnoreCase("end")){
                    createFile.close();
                    end=true;
                }else if(lectureFromConsole.equalsIgnoreCase("continue")){
                    writeInFile.println(finalRegister());
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




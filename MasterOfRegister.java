import com.sun.jdi.event.BreakpointEvent;

import java.io.*;
import java.util.Scanner;
import java.util.Vector;
import java.io.RandomAccessFile;
public class MasterOfRegister {
    private String nombre;
    private String apellidos;
    private long intnumeroTelefonico;
    private String numeroTelefonico;

    private String cedula;
    private long intCedula;

    private String direccion;

    private String correo;

    public static int id;

    public String getCorreo() {
        Scanner lector = new Scanner(System.in);
        System.out.println("Ingresa tu correo electronico");
        correo = lector.nextLine();
        return correo;
    }

    public String getCedula() {
        boolean end = false;


        while (!end){
            Scanner lector = new Scanner(System.in);
            System.out.println("Ingresa tu cedula");
            intCedula = lector.nextLong();
            cedula = String.valueOf(intCedula);
            if (cedula.length()!=10){
                System.out.println("Ingresa una cedula de 10 caracteres");
            }else {
                end = true;
            }
        }      return cedula;

    }

    public String getDireccion() {
        Scanner lector = new Scanner(System.in);
        System.out.println("Ingresa tu direccion");
        direccion = lector.nextLine();
        return direccion;
    }

    public String getNombre() {
        Scanner lector = new Scanner(System.in);
        System.out.println("Ingresa el nombre");
        nombre = lector.nextLine();
        return nombre;
    }

    public String getApellidos() {
        Scanner lector = new Scanner(System.in);
        System.out.println("Ingresa el apellido");
        apellidos = lector.nextLine();
        return apellidos;
    }

    public int getId() {
        return id;
    }


    public static void setId(int id) {
        MasterOfRegister.id = id;
    }

    public String getIntnumeroTelefonico() {
        boolean end=false;
        while(!end){
                Scanner lector = new Scanner(System.in);
                System.out.println("Ingresa el telefono");
                intnumeroTelefonico = lector.nextLong();
                numeroTelefonico = String.valueOf(intnumeroTelefonico);

            if (numeroTelefonico.length()!=10){
                System.out.println("Ingresa un número telefonico de 10 dígitos");
            }else {
                end = true;
            }

        } return numeroTelefonico;
    }

    public String finalRegister(){
        String line ="";
        line = getCedula()+","+ getNombre() + "," + getApellidos() + "," +getIntnumeroTelefonico() + "," + getDireccion() +
        "," + getCorreo();
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
                System.out.println("-----Ingresa tu registro-----");
                System.out.println("Para regresar al menu escribe 'back'");
                System.out.println("Para ingresar el registro escribe 'continue'");
                lectureFromConsole = read.nextLine();

                if (lectureFromConsole.equalsIgnoreCase("back")){
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
        Scanner readingLine = new Scanner(System.in);


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
                setId(numOfRegisters);
                System.out.println(getId() + ".- " + arrayOfVectorWhitFileContent[i]);
                System.out.println("------------------------------------------------------------");
            }
        }

  public void specificRegister() throws IOException {
        Scanner readingline = new Scanner(System.in);
        boolean end = false;



                File workingFile = new File("E:\\Content\\correos.txt");
                BufferedReader readerOfWorkingFile = new BufferedReader(new FileReader(workingFile));
                String lineOfWorkingFile;
                Vector<String> vectorWhitFileContent = new Vector<String>(40);
                while ((lineOfWorkingFile = readerOfWorkingFile.readLine()) != null) {
                    vectorWhitFileContent.addElement(lineOfWorkingFile);
                }

                String[] arrayOfVectorWhitFileContent = vectorWhitFileContent.toArray(new String[vectorWhitFileContent.size()]);





                    while (!end) {

                        System.out.println("Intgresa el numero del registro que quieres");
                        System.out.println("Para terminar de ver registros escribe 0");
                        System.out.println("Tienes estos  " + (arrayOfVectorWhitFileContent.length-1) + " registros");
                        int aswerInt = readingline.nextInt();

                        if (aswerInt == 0) {
                            end = true;
                        } else {
                            try {

                                System.out.println(arrayOfVectorWhitFileContent[aswerInt]);
                                System.out.println(" ");


                            } catch (Exception e) {
                                System.out.println("Error, registro no encontrado ");
                            }
                        }

                    }

                }




















    public void userComunication(){
        System.out.println("escribe 'add' para introducir un registro");
        System.out.println("escribe 'view' para ver tus registros");
        System.out.println("escribe 'end' para finalizar el programa");
        System.out.println("escribe 'register' para ver un registro especifico");
    }

}




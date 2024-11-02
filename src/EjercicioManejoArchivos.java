import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
public class EjercicioManejoArchivos {
    public static void main(String[] args) {
        String ruta = "C:\\\\Fundamentos_programacion\\\\test.txt\\\\";

        File file = new File("C:\\Fundamentos_programacion\\test.txt");
        System.out.println(file.exists());

        int notas [] = new int[20];
        int cantidad = 0;
        int sum = 0;


        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = br.readLine()) != null) {

                try {
                    int nota = Integer.parseInt(linea);
                    if (cantidad < notas.length) {
                        notas[cantidad] = nota;
                        sum += nota;
                        cantidad++;
                    }
                } catch (NumberFormatException e) {
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        int notaMinima = notas[0];
        int notaMaxima = notas[0];


        for (int i = 1; i < cantidad; i++) {
            if (notas[i] < notaMinima) {
                notaMinima = notas[i];
            }
            if (notas[i] > notaMaxima) {
                notaMaxima = notas[i];
            }
        }


        double promedio = (double) sum / cantidad;


        System.out.println("La nota menor es: " + notaMinima);
        System.out.println("La nota mayor es: " + notaMaxima);
        System.out.println("El promedio de las notas es: " + promedio);
    }
}


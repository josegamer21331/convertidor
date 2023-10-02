package conversordemoneda;
import java.util.Scanner;

public class holamundo {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double tasaDolar = 3800.0; // Cambia esto por la tasa de conversión de COP a USD.
        double tasaEuro = 4500.0; // Cambia esto por la tasa de conversión de COP a EUR.
        double tasaLibra = 5200.0; // Cambia esto por la tasa de conversión de COP a GBP.
        double tasaYen = 34.0; // Cambia esto por la tasa de conversión de COP a JPY.
        double tasaWon = 3.5; // Cambia esto por la tasa de conversión de COP a KRW.

        System.out.println("Convertidor de Moneda - De Peso Colombiano (COP) a:");
        System.out.println("1. Dólar (USD)");
        System.out.println("2. Euro (EUR)");
        System.out.println("3. Libra Esterlina (GBP)");
        System.out.println("4. Yen Japonés (JPY)");
        System.out.println("5. Won Sul-coreano (KRW)");
        System.out.print("Seleccione una opción (1-5): ");
        int opcion = scanner.nextInt();

        System.out.print("Ingrese la cantidad en Peso Colombiano (COP): ");
        double cantidadCOP = scanner.nextDouble();
        double resultado = 0;

        switch (opcion) {
            case 1:
                resultado = cantidadCOP / tasaDolar;
                System.out.println("Resultado: " + resultado + " Dólares (USD)");
                break;
            case 2:
                resultado = cantidadCOP / tasaEuro;
                System.out.println("Resultado: " + resultado + " Euros (EUR)");
                break;
            case 3:
                resultado = cantidadCOP / tasaLibra;
                System.out.println("Resultado: " + resultado + " Libras Esterlinas (GBP)");
                break;
            case 4:
                resultado = cantidadCOP / tasaYen;
                System.out.println("Resultado: " + resultado + " Yen Japonés (JPY)");
                break;
            case 5:
                resultado = cantidadCOP / tasaWon;
                System.out.println("Resultado: " + resultado + " Won Sul-coreano (KRW)");
                break;
            default:
                System.out.println("Opción no válida.");
        }
        
        scanner.close(); // Cierra el scanner cuando hayas terminado.
    }
}

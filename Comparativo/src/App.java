
import java.util.Scanner;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        Merge merge = new Merge();
        Radix radix = new Radix();
        ReadFile file = new ReadFile();
        Scanner scanner = new Scanner(System.in);
        int opt = 0;

do{
        System.out.println("Escolha 1 para MergeSort e 2 para RadixSort e 3 para sair");
        opt = scanner.nextInt();

        int[] array = file.readArrayFromFile("dados100_mil.txt");

        if (array != null) {
            switch (opt) {
                case 1:
                    System.out.println("Array antes da ordenação:");
                    merge.printArray(array);

                    long startTimeMerge = System.currentTimeMillis();
                    merge.sort(array);
                    long endTimeMerge = System.currentTimeMillis();

                    System.out.println("Array após a ordenação:");
                    merge.printArray(array);
                    System.out.println("Tempo de execução: " + (endTimeMerge - startTimeMerge) + " milissegundos");
                    break;
                case 2:
                    int[] arr = file.readArrayFromFile("dados100_mil.txt");
                    System.out.println("Array original: " + Arrays.toString(arr));

                    long startTimeRadix = System.currentTimeMillis();
                    radix.sort(arr);
                    long endTimeRadix = System.currentTimeMillis();

                    System.out.println("Array ordenado: " + Arrays.toString(arr));
                    System.out.println("Tempo de execução: " + (endTimeRadix - startTimeRadix) + " milissegundos");
                    break;
                default:
                    System.out.println("Opção invalida");
            }
        } else {
            System.out.println("Falha ao ler os dados do arquivo.");
        }
    }while(opt != 3);
    System.out.println("Saindo");
    }
}
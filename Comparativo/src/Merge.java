class Merge {
    public void sort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        int[] temp = new int[array.length];
        mergeSort(array, temp, 0, array.length - 1);
    }

    private static void merge(int[] array, int[] temp, int esquerdaInicio, int direitaFim) {
        int esquerdaFim = (esquerdaInicio + direitaFim) / 2;
        int direitaInicio = esquerdaFim + 1;
        int size = direitaFim - esquerdaInicio + 1;

        int esquerda = esquerdaInicio;
        int direita = direitaInicio;
        int index = esquerdaInicio;

        while (esquerda <= esquerdaFim && direita <= direitaFim) {
            if (array[esquerda] <= array[direita]) {
                temp[index] = array[esquerda];
                esquerda++;
            } else {
                temp[index] = array[direita];
                direita++;
            }
            index++;
        }

        System.arraycopy(array, esquerda, temp, index, esquerdaFim - esquerda + 1);
        System.arraycopy(array, direita, temp, index, direitaFim - direita + 1);
        System.arraycopy(temp, esquerdaInicio, array, esquerdaInicio, size);
    }

    private static void mergeSort(int[] array, int[] temp, int esquerda, int direita) {
        if (esquerda >= direita) {
            return;
        }
        int middle = (esquerda + direita) / 2;
        mergeSort(array, temp, esquerda, middle);
        mergeSort(array, temp, middle + 1, direita);
        merge(array, temp, esquerda, direita);
    }

    public void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
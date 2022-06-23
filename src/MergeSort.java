import java.util.Random;

public class MergeSort {

    public static void main(String[] args) {

        Random random = new Random();
        int[] numbers =  new int[10000];

        //lleno el array de prueba
        for(int i = 0; i < numbers.length; i++){
            numbers[i] = random.nextInt(1000);
        }

        System.out.println("Array Inicial:");
        printArray(numbers);
        
        mergeSort(numbers);

        System.out.println("Array Ordenado:");
        printArray(numbers);

    }

    private static void mergeSort(int[] inputArray) {
        int inputArrayLength = inputArray.length;

        //si el array es menor a 2 , retornamos porque ya esta ordenado y dividido
        if(inputArrayLength < 2){
            return;
        }

        //partimos el array por la mitad
        int midIndex = inputArrayLength / 2;

        int[] leftHalf = new int[midIndex];
        int[] rigthHalf = new int[inputArrayLength - midIndex];

        //recorremos hasta la mitad del array y lo ingresamos al array leftHalf desde el original
        for(int indexLeft = 0; indexLeft < midIndex; indexLeft++){
            leftHalf[indexLeft] = inputArray[indexLeft];
        }

        //recorremos desde la mitad del array y lo ingresamos al array rigthHalf desde el original
        for(int indexRigth = midIndex; indexRigth < inputArrayLength; indexRigth++){
            //sustraccion es para indicar siempre posicion desde 0 del array rigthHalf
            rigthHalf[indexRigth - midIndex] = inputArray[indexRigth];
        }

        //realizamos recursividad para las dos mitades
        mergeSort(leftHalf);
        mergeSort(rigthHalf);

        merge(inputArray,leftHalf,rigthHalf);


    }

    private static void merge(int[] inputArray, int[] leftHalf, int[] rightHalf){
        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;

        //3 iteradores, para leftHalf, rightHalf y mergeArray(array final)
        int indexLeft = 0;
        int indexRight = 0;
        int indexMergeArray = 0;

        //recorremos hasta que nos quedemos sin elementos en ambos lados
        while(indexLeft < leftSize && indexRight < rightSize){
            //comparamos si el elemento del lado izquierdo es menos que el elemento del lado derecho,
            // si es asi lo asignamos a inputArray sino le asignamos desde el lado derecho
            if(leftHalf[indexLeft] <= rightHalf[indexRight]){
                inputArray[indexMergeArray] = leftHalf[indexLeft];
                indexLeft++;
            }else{
                inputArray[indexMergeArray] = rightHalf[indexRight];
                indexRight++;
            }
            indexMergeArray++;
        }

        //agregamos los elementos restantes al array combinado
        //si nos quedamos sin elementos en leftHalf, no pasara
        while(indexLeft < leftSize){
            inputArray[indexMergeArray] = leftHalf[indexLeft];
            indexLeft++;
            indexMergeArray++;
        }

        while(indexRight < rightSize){
            inputArray[indexMergeArray] = rightHalf[indexRight];
            indexRight++;
            indexMergeArray++;
        }




    }

    private static void printArray(int[] numbers) {
        for (int number : numbers) {
            System.out.println(number);
        }
    }


}

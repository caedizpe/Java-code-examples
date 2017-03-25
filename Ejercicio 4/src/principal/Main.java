package principal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 * No se realiza manejo de errores
 */
public class Main {
	
	
	private short array[];
    private int length;

	public static void main(String[] args)throws Exception {
		short[] ages = new short[20];
		BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 20; i++) {
			System.out.println("Por favor digite la edad del estudiante "+(i+1));
			ages[i]=Short.valueOf(bufferReader.readLine());
		}
		System.out.println("El arreglo de edades sin organizar es:");
		for (int i = 0; i < ages.length; i++) {
			if(i!=ages.length-1){
				System.out.print(ages[i]+",");
			}else{
				System.out.println(ages[i]);
			}
		}
		//Instancia de la clase actual
		 Main sorter = new Main();
		//Método que ordena el arreglo
	     sorter.sort(ages);
	    //Mostrando el arreglo ordenando por consola
	     System.out.println("El arreglo de edades organizado es:"); 
	     
	     for(int i:ages){
	            System.out.print(i);
	            System.out.print(" ");
	     }
		
	}

 
    public void sort(short[] inputArr) {
         
        if (inputArr == null || inputArr.length == 0) {
            return;
        }
        this.array = inputArr;
        length = inputArr.length;
        quickSort(0, length - 1);
    }
 
    private void quickSort(int lowerIndex, int higherIndex) {
         
        int i = lowerIndex;
        int j = higherIndex;
        // Calcula el pivot, en este caso se emplea la mita geomética como pivote
        int pivot = array[lowerIndex+(higherIndex-lowerIndex)/2];
        // Se divide en dos arrays
        while (i <= j) {
            /**
             * En cada iteración se identifica un número de la izquierda del pivote
             * el cual es más grande que dicho pivote, análogamente se identifica un número 
             * a la derecha del pivote el cual es menor que este. Cuuando las búsquedas 
             * terminan los números se intercambian. Para más información ver el archivo 
             * "Notes Ejercicio 4.odt"
             */
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }
            if (i <= j) {
                exchangeNumbers(i, j);
                //move index to next position on both sides
                i++;
                j--;
            }
        }
        // call quickSort() method recursively
        if (lowerIndex < j)
            quickSort(lowerIndex, j);
        if (i < higherIndex)
            quickSort(i, higherIndex);
    }
 
    private void exchangeNumbers(int i, int j) {
        short temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
 
	

	
}
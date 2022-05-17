package com.example.project;

import java.util.Scanner;

public class Exercise1 {

	public static void main(final String[] args) {

		Exercise1 obj = new Exercise1();
		Scanner sc = new Scanner(System.in);
		while (true) {
			int n = sc.nextInt();
			System.out.println(obj.convertirBaseGabriel(n));			
		}
	}

	public String convertirBaseGabriel(int a) {

		int longNum = Integer.toString(a).length();
		int arreglo[] = new int[longNum];  //Arreglo con los digitos del número
		int contDos= 0, numDif =0,contUno = 0;;   
		
		//Relleno el arreglo con los digitos pero correspondientes a sus posiciones
		//Si es 1020, en el arreglo = [0,2,0,1]
		for(int i = longNum-1, j=0; i >= 0 && j<longNum; i--,j++) {
			String num = String.valueOf(Integer.toString(a).charAt(i));
			arreglo[j] = Integer.parseInt(num);
			//Conteo de 2 y de numeros diferentes a 0,1,2
			if(arreglo[j] == 0 || arreglo[j] == 1 ||arreglo[j] == 2) {
				if(arreglo[j] == 2)  //contar cuantos numeros 2 hay
					contDos++;
			}else 
				numDif++;
		}
		
		//--------------------------------------------
		//El numero proporcionado solo puede tener uno o ningún 2, y también verificar si no lleva números diferentes
		if(contDos < 2 && numDif == 0 ) {
			if(contDos == 1) {
				int pos = BusquedaDeNumeroEnArreglo(arreglo,2);
				if(pos == 0) 
					//SI SALE BIEN--> Convertir la base Gabriel a decimal
					return conversionDefinitiva(arreglo);
				else {
					//Contar cuantos 1
					for(int i = pos-1; i >=0; i--) {
						if(arreglo[i]==1) 
							contUno++;
					}
				}
			}else 
				//SI SALE BIEN--> Convertir la base Gabriel a decimal
				return conversionDefinitiva(arreglo);
			
		}else 
			return "El numero proporcionado no esta en base Gabriel.";
		
		//--------------------------------------------
		//Si no tiene ningun 1, quiere decir que está bien
		if(contUno > 0) 
			return "El numero proporcionado no esta en base Gabriel.";
		else 
			//SI SALE BIEN--> Convertir la base Gabriel a decimal
			return conversionDefinitiva(arreglo);
	}
	
	public static int BusquedaDeNumeroEnArreglo(int[] arreglo, int busqueda) { // busca a penas lo encuentre
		for (int x = 0; x < arreglo.length; x++) {
			if (arreglo[x] == busqueda)
				return x;
		}
		return -1;
	}
	
	public String conversionDefinitiva(int arreglo[]) {
		int suma = 0;
		for (int i = 0; i < arreglo.length; i++) 
			suma = suma + (int) (arreglo[i]*(Math.pow(2,i+1)-1));
		
		return String.valueOf(suma);
	}
	
}

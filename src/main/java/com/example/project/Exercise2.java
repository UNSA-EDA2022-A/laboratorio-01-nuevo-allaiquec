package com.example.project;

import java.util.Scanner;

public class Exercise2 {

	public static void main(final String[] args) {

		Exercise2 obj = new Exercise2();
		Scanner sc = new Scanner(System.in);
		while (true) {

			int n = sc.nextInt(), suma = 0;
			int a[] = new int[n];

			for (int i = 0; i < n; i++) {			
				a[i] = sc.nextInt();
			}

			suma = sc.nextInt();
			suma = suma - nuevSuma(a);
			
			conversionCero(a);
			System.out.println(obj.esSubconjuntoSumaExt(a, suma));
		}
	}
	public boolean esSubconjuntoSumaExt(int conjunto[], int suma) {
		// Casos base
		if (suma == 0)
			return true;
		/*if (n == conjunto.length)
			return false;
		/* verificamos si conseguimos la suma por alguna de las siguientes formas:
		(a) incluyendo el primer elemento
		(b) excluyendo el primer elemento esSubconjuntoSumaExt2(conjunto, 0, suma - conjunto[0]) || */
		return esSubconjuntoSumaExt2(conjunto, 0, suma );
		
		
	}
	
	public boolean esSubconjuntoSumaExt2(int conjunto[], int n, int suma) {
		// Casos base
		if (suma == 0)
			return true;
		if (n == conjunto.length)
			return false;
		/* verificamos si conseguimos la suma por alguna de las siguientes formas:
		(a) incluyendo el primer elemento
		(b) excluyendo el primer elemento */
		return esSubconjuntoSumaExt2(conjunto, n + 1, suma - conjunto[n]) || esSubconjuntoSumaExt2(conjunto, n + 1, suma );
		
		
	}
	//Si encontramos un numero 1, tenemos que fijarnos que el de adelante sea multiplo de 7
	public static int nuevSuma(int[] arr) {
		int sum = 0;
		for (int i = 1; i < arr.length; i++) {
			if(arr[i] != 1 && arr[i-1]%7 == 0) {
				sum =sum + arr[i-1];
			}
			
		}
		return sum;
		
		/*int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 7 == 0) {
				if(i != arr.length-1) {
					if(arr[i+1] != 1) {
						sum = sum +  arr[i];
					}
				}
			}
		
		}
		return sum;*/
	}
	
	//Convierte los numeros 7 a ceros
	public static int[] conversionCero(int[] arr) {	
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 7 == 0) {
				arr[i] = 0;
			}		
		}
		return arr;
	}
	
}

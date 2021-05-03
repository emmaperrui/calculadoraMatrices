import java.util.Scanner;

/**
 * Programa que simula una calculadora de matrices.
 * 
 * @author (Emma Pérez)
 * @version (1)
 */

public class main {

	/**
	 * Método main. Contiene las opciones del menú.
	 * 
	 * @param args.
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		boolean programaFuncionando = true;

		while (programaFuncionando) {
			imprimirMenu();

			int opcion = sc.nextInt();
			sc.nextLine();

			int[][] matriz1 = null;
			int[][] matriz2 = null;
			int[][] resultado = null;

			switch (opcion) {
			case 1:
				matriz1 = obtenerMatriz(sc);
				matriz2 = obtenerMatriz(sc);
				resultado = sumarMatrices(matriz1, matriz2);

				if (null != resultado) {
					imprimirMatriz(resultado);
				} else {
					System.out.println("No se ha podido imprimir resultado");
				}
				break;

			case 2:
				matriz1 = obtenerMatriz(sc);
				int numEscalar = sc.nextInt();
				resultado = escalarMatriz(matriz1, numEscalar);

				if (null != resultado) {
					imprimirMatriz(resultado);
				} else {
					System.out.println("No se ha podido imprimir resultado");
				}
				break;

			case 3:
				matriz1 = obtenerMatriz(sc);
				matriz2 = obtenerMatriz(sc);

				resultado = productoDeMatrices(matriz1, matriz2);

				if (null != resultado) {
					imprimirMatriz(resultado);
				} else {
					System.out.println("No se ha podido imprimir resultado");
				}

				break;

			case 4:
				matriz1 = obtenerMatriz(sc);
				resultado = transponerMatriz(matriz1);

				if (null != resultado) {
					imprimirMatriz(resultado);
				} else {
					System.out.println("No se ha podido imprimir resultado");
				}
				break;

			case 5:
				matriz1 = obtenerMatriz(sc);
				int[] diagonal = obtenerDiagonal(matriz1);

				if (null != diagonal) {
					imprimirDiagonal(diagonal);
				} else {
					System.out.println("No se ha podido imprimir resultado");
				}
				break;

			case 6:
				matriz1 = obtenerMatriz(sc);
				if (esSimetrica(matriz1)) {
					System.out.println("SI es simétrica");
				} else {
					System.out.println("NO es simétrica");
				}
				break;

			case 7:
				matriz1 = obtenerMatriz(sc);
				if(matriz1.length == matriz1[0].length) {
					System.out.println("Introduce el número al que quieres elevar la matríz");
					int potencia = sc.nextInt();
					resultado = calcularPotenciaMatriz(matriz1, potencia);
					
					if (null != resultado) {
						imprimirMatriz(resultado);
					} else {
						System.out.println("No se ha podido imprimir resultado");
					}
				}else {
					System.out.println("No es matriz cuadrada");
				}
				break;

			case 8:
				matriz1 = obtenerMatriz(sc);
				matriz2 = obtenerMatriz(sc);
				resultado = restarMatrices(matriz1, matriz2);
				if (null != resultado) {
					imprimirMatriz(resultado);
				} else {
					System.out.println("No se ha podido imprimir resultado");
				}
				break;

			case 9:
				System.out.println("Saliendo...");
				programaFuncionando = false;
				break;
			default:
				System.out.println("Debes introducir un dato válido");
				break;
			}
		}
	}

	/**
	 * Método para imprimir por pantalla el menú. El usuario selecciona la opción
	 * que guste. No tiene parámetros.
	 */
	public static void imprimirMenu() {
		System.out.println("***** CALCULADORA DE MATRICES *****");
		System.out.println("***** (Escribe la opción que quieras) *****");
		System.out.println("1. Suma de dos matrices");
		System.out.println("2. Producto de un escalar por una matriz");
		System.out.println("3. Producto de dos matrices");
		System.out.println("4. Transponer una matriz");
		System.out.println("5. Diagonal principal de una matriz");
		System.out.println("6. Comprobar si una matriz es simétrica");
		System.out.println("7. Potencia de una matriz cuadrada");
		System.out.println("8. Resta de dos matrices");
		System.out.println("9. Salir del programa");
		System.out.println("INTRODUCE LA OPCIÓN");
	}

	/**
	 * Método para obtener las matrices.
	 * 
	 * @param sc Información introducida por el usuario a la hira de llamar al
	 *           método.
	 * @return matriz.
	 */
	public static int[][] obtenerMatriz(Scanner sc) {
		int[][] matriz = null;
		String matrizString = "";

		System.out.println("Introduce la Matríz (Las columnas se separan por espacios y las filas por '&')");
		matrizString = sc.nextLine();

		String[] filasString = matrizString.split("&");
		int numeroFilas = filasString.length;
		int numeroCulumnas = filasString[0].length();
		// Obtenemos las dimensiones
		matriz = new int[numeroFilas][numeroCulumnas];
		for (int i = 0; i < filasString.length; i++) {
			String[] columnaString = filasString[i].split(" ");
			int[] columna = new int[columnaString.length];
			for (int x = 0; x < columnaString.length; x++) {
				columna[x] = Integer.valueOf(columnaString[x]);
			}
			matriz[i] = columna;
		}
		// imprimirMatriz(matriz);
		return matriz;
	}

	/**
	 * Método para imprimir por pantalla la matriz dada por el usuario.
	 * 
	 * @param matriz Matriz introducida por el usuario.
	 */
	public static void imprimirMatriz(int[][] matriz) {
		for (int i = 0; i < matriz.length; i++) {
			for (int x = 0; x < matriz[i].length; x++) {
				System.out.print(matriz[i][x] + " ");
			}
			System.out.println("");
		}
	}

	/**
	 * Método para sumar dos matrices introducidas por el usuario.
	 * 
	 * @param matriz1 Matriz 1 introducida por el usuario.
	 * @param matriz2 Matriz 1 introducida por el usuario.
	 * @return resultado.
	 */
	public static int[][] sumarMatrices(int[][] matriz1, int[][] matriz2) {
		int[][] resultado = null;

		if (matriz1.length == matriz2.length) {
			resultado = new int[matriz1.length][matriz1[0].length];
			for (int i = 0; i < matriz1.length; i++) {
				for (int x = 0; x < matriz1[i].length; x++) {
					resultado[i][x] = matriz1[i][x] + matriz2[i][x];
				}
			}
		} else {
			System.out.println("Ambas matrices tienen que tener el mismo tamaño");
		}
		return resultado;
	}

	/**
	 * Método para escalar una matriz introducida por el usuario.
	 * 
	 * @param matriz1    Matriz introducida por el usuario.
	 * @param numEscalar Número introducido por el usuario por el que se va a
	 *                   escalar la matriz.
	 * @return resultado
	 */
	public static int[][] escalarMatriz(int[][] matriz1, int numEscalar) {
		int[][] resultado = null;
		resultado = new int[matriz1.length][matriz1[0].length];
		for (int i = 0; i < matriz1.length; i++) {
			for (int x = 0; x < matriz1[i].length; x++) {
				resultado[i][x] = matriz1[i][x] * numEscalar;
			}
		}
		return resultado;
	}

	/**
	 * Método para multiplicar dos matrices introducidas por el usuario.
	 * 
	 * @param matriz1 Matriz 1 introducida por el usuario.
	 * @param matriz2 Matriz 2 introducida por el usuario.
	 * @return resultado.
	 */
	public static int[][] productoDeMatrices(int[][] matriz1, int[][] matriz2) {
		int[][] resultado = null;

		int columnas1 = matriz1[0].length;
		int columnas2 = matriz2[0].length;
		int filas1 = matriz1.length;
		int filas2 = matriz2.length;

		if (columnas1 == filas2) {
			resultado = new int[filas1][columnas2];
			for (int x = 0; x < resultado.length; x++) {
				for (int y = 0; y < resultado[x].length; y++) {
					for (int z = 0; z < columnas1; z++) {
						resultado[x][y] += matriz1[x][z] * matriz2[z][y];
					}
				}
			}
		}
		return resultado;
	}

	/**
	 * Método para transponer una matriz introducida por el usuario
	 * 
	 * @param matriz1 Matriz introducida por el usuario.
	 * @return resultado.
	 */
	public static int[][] transponerMatriz(int[][] matriz1) {
		int[][] resultado = null;
		resultado = new int[matriz1[0].length][matriz1.length];
		for (int i = 0; i < resultado.length; i++) {
			for (int x = 0; x < resultado[i].length; x++) {
				resultado[i][x] = matriz1[x][i];
			}
		}
		return resultado;
	}

	/**
	 * Método para obtener la diagonal de una matriz introducida por un usuario
	 * 
	 * @param matriz1 Matriz intorucida por un usuario
	 * @return resultado
	 */
	public static int[] obtenerDiagonal(int[][] matriz1) {
		int[] diagonal = null;
		if (matriz1.length == matriz1[0].length) {
			diagonal = new int[matriz1.length];
			for (int i = 0; i < matriz1.length; i++) {
				diagonal[i] = matriz1[i][i];
			}
		} else {
			System.out.println("Tiene que tener el mismo número de filas que de columnas");
		}
		return diagonal;
	}

	/**
	 * Método para imprimir por pantalla una diagonal dada por el usuario.
	 * 
	 * @param diagonal Diagonal introducida por el usuario.
	 */
	public static void imprimirDiagonal(int[] diagonal) {
		for (int i = 0; i < diagonal.length; i++) {
			System.out.print(diagonal[i]);
		}
		System.out.println("");
	}

	/**
	 * 
	 * @param matriz
	 * @return
	 */
	public static boolean esSimetrica(int matriz[][]) {
		for (int fila = 1; fila < matriz.length; fila++) {
			for (int columna = 0; columna < fila; columna++) {
				if (matriz[fila][columna] != matriz[columna][fila]) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Método para restar dos matrices introducidas por el usuario.
	 * 
	 * @param matriz1 Matriz 1 introducida por el usuario.
	 * @param matriz2 Matriz 1 introducida por el usuario.
	 * @return resultado.
	 */
	public static int[][] restarMatrices(int[][] matriz1, int[][] matriz2) {
		int[][] resultado = null;

		if (matriz1.length == matriz2.length) {
			resultado = new int[matriz1.length][matriz1[0].length];
			for (int i = 0; i < matriz1.length; i++) {
				for (int x = 0; x < matriz1[i].length; x++) {
					resultado[i][x] = matriz1[i][x] + (-1 * matriz2[i][x]);
				}
			}
		} else {
			System.out.println("Ambas matrices tienen que tener el mismo tamaño");
		}
		return resultado;
	}
	
	
	
	private static int[][] calcularPotenciaMatriz(int[][] matriz1, int potencia) {
		
		int[][] resultado = matriz1;
		
		for(int i = 1; i < potencia; i++) {
			resultado = productoDeMatrices(resultado, matriz1);
		}
		return resultado;
	}
}

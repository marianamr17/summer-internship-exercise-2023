package com.premiumminds.internship.snail;

import java.util.concurrent.Future;
import java.util.concurrent.CompletableFuture;
/**
 * Created by aamado on 05-05-2023.
 */
class SnailShellPattern implements ISnailShellPattern {

  /**
   * Method to get snailshell pattern
   * 
   * @param matrix matrix of numbers to go through
   * @return order array of values thar represent a snail shell pattern
   */
  public Future<int[]> getSnailShell(int[][] matrix) {
   // throw new RuntimeException("Not Implemented Yet");
    		CompletableFuture<int[]> future = new CompletableFuture<>();
		int[] v = new int[(matrix.length * matrix[0].length)]; // vetor com o número de entradas da matriz
		int iv = 0; // iterador do vetor
		int baixo = matrix.length - 1;
		int direita = (matrix[0].length - 1);
		int cima = 0;
		int esquerda = 0;
		
		
		if(matrix == null || matrix.length == 0) {
			int[]v0 = new int[0];
			future.complete(v0);
			return future;
		}

		while (true) {
			// correr matriz da esquerda para a direita
			for (int i = esquerda; i <= direita; i++) {
				v[iv] = matrix[cima][i];
				iv++;
			}
			cima++;

			if (esquerda > direita || cima > baixo)
				break;

			// correr matriz de cima para baixo
			for (int i = cima; i <= baixo; i++) {
				v[iv] = matrix[i][direita];
				iv++;
			}
			direita--;

			if (esquerda > direita || cima > baixo)
				break;

			// correr matriz de baixo para cima
			for (int i = direita; i >= esquerda; i--) {
				v[iv] = matrix[baixo][i];
				iv++;
			}
			baixo--;

			if (esquerda > direita || cima > baixo)
				break;

			// correr matriz da direita para a esquerda
			for (int i = baixo; i >= cima; i--) {
				v[iv] = matrix[i][esquerda];
				iv++;
			}
			esquerda++;

			if (esquerda > direita || cima > baixo)
				break;

		}
		future.complete(v);
		return future;
	}

}

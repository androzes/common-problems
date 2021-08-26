/**
 * Problem: 
 * Given a grid G and word W 
 * Find W in G, such that word can be formed in either right or bottom direction 
 * (leftwarsd or upwards move not allowed )
 * 
 * Output: 	if found, return sequence of coordinates of all found words  
 * 			otherwise return []
 * 
 * G =
 *     [k n i c k l i n i c]
 *     [n i c k l z a i k l]
 *     [i c k l n i c k l c]
 *     [c k l n i c k l n i]
 *     [k l n i c k l e n c]
 * 
 * W = 'nickle'
 * 
 * Output =  [[(2,4),(2,5),(2,6),(3,6),(4,6)],[(3,3),(3,4),(3,5),(3,6),(3,7),(4,7)],
 * 			  [(3,3),(3,4),(3,5),(3,6),(4,6),(4,7)],[(3,3),(3,4),(3,5),(4,5),(4,6),(4,7)]]
 * 
 * 
 */

import java.util.List;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		char[][] grid = new char[][]{
			{'k','n','i','c','k','l','b','n','i','k'},
			{'n','i','c','k','l','z','a','b','y','e'},
			{'i','c','k','l','n','i','c','k','l','c'},
			{'c','k','l','n','i','c','k','l','n','i'},
			{'k','l','n','i','c','k','l','e','n','c'}
		};

		String[] words = new String[]{ "nickle", "baby", "nike"};

		int rows = grid.length;
		int columns = grid[0].length;

		
		List<List<Coords>> out = new ArrayList();
		
		for(String word:  words) {
			List<List<Coords>> result = new ArrayList();
			for (int i=0; i<rows; i++) {
				for (int j=0; j<columns; j++) { 
					getFirstWordInGrid(result, new ArrayList(), grid, word, 0, i, j);
					if(result.size() == 1) {
						break;
					}
				}

				if(result.size() == 1) {
					break;
				}
			}

			if(result.size() > 0) {
				out.add(result.get(0));
			} else {
				out.add(new ArrayList());
			}
		}
		

		System.out.println(out);
	}

	public static class Coords {
		public int x;
		public int y;

		public Coords(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public String toString() {
			return "(" + x + "," + y + ")";
		}
	}

	public static void getWordsInGrid(List<List<Coords>> result, List<Coords> sequence, char[][] grid, String word, int wordIndex, int rowIndex, int columnIndex) {
		
		// if curr character is not same as word character
		if(word.charAt(wordIndex) != grid[rowIndex][columnIndex]) {
			return;
		}


		// curr character is same as word character, add to sequence
		sequence.add(new Coords(rowIndex, columnIndex));

		if(wordIndex + 1 == word.length()) {
			result.add(sequence);
			return;
		}

		// if right char exists
		if(columnIndex + 1 < grid[0].length) {
			getWordsInGrid(result, new ArrayList(sequence), grid, word, wordIndex + 1, rowIndex, columnIndex + 1);
		}

		// if bottom char exists
		if(rowIndex + 1 < grid.length) {
			getWordsInGrid(result, new ArrayList(sequence), grid, word, wordIndex + 1, rowIndex + 1, columnIndex);
		}
	}


	public static void getFirstWordInGrid(List<List<Coords>> result, List<Coords> sequence, char[][] grid, String word, int wordIndex, int rowIndex, int columnIndex) {
		
		// if curr character is not same as word character
		if(word.charAt(wordIndex) != grid[rowIndex][columnIndex]) {
			return;
		}


		// curr character is same as word character, add to sequence
		sequence.add(new Coords(rowIndex, columnIndex));

		if(wordIndex + 1 == word.length()) {
			result.add(sequence);
			return;
		}

		// if right char exists
		if(columnIndex + 1 < grid[0].length) {
			getFirstWordInGrid(result, new ArrayList(sequence), grid, word, wordIndex + 1, rowIndex, columnIndex + 1);
		}

		if(result.size() == 1) {
			return;
		}

		// if bottom char exists
		if(rowIndex + 1 < grid.length) {
			getFirstWordInGrid(result, new ArrayList(sequence), grid, word, wordIndex + 1, rowIndex + 1, columnIndex);
		}

		if(result.size() == 1) {
			return;
		}
	}


}
 

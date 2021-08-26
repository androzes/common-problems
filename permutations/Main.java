/**
 * Given a list of characters
 * Print all permutations of these.
 * 
 * Input: 
 * abc
 * 
 * Output:
 * abc
 * acb
 * bac
 * bca
 * cab
 * cba
 * 
 */

 import java.util.List;
 import java.util.ArrayList;
 import java.util.Set;
 import java.util.HashSet;

 public class Main {

 	public static void main(String[] args) {
 		String str = "abc";
 		Set<String> result = new HashSet();
 		permutations(result, str, "");
 		System.out.println("Number of permutations: " + result.size());
 		for (String res: result) {
 			System.out.println(res);
 		}
 	}

 	public static void permutations(Set<String> result, String str, String permutation) {
 		if(str.length() == 0 && !result.contains(permutation)) {
 			result.add(permutation);
 		}

 		for(int i=0; i<str.length(); i++) {
 			permutations(result, removeCharAt(str, i), permutation + str.charAt(i));
 		}


 	}

 	public static String removeCharAt(String str, int i) {
 		return str.substring(0, i) + (i+1 <str.length() ? str.substring(i+1) : "");
 	}
 }
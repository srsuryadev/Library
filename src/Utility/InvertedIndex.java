/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

/**
 *
 * @author suryadev
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
 
public class InvertedIndex {
 
	List<String> stopwords = Arrays.asList("a", "able", "about",
			"across", "after", "all", "almost", "also", "am", "among", "an",
			"and", "any", "are", "as", "at", "be", "because", "been", "but",
			"by", "can", "cannot", "could", "dear", "did", "do", "does",
			"either", "else", "ever", "every", "for", "from", "get", "got",
			"had", "has", "have", "he", "her", "hers", "him", "his", "how",
			"however", "i", "if", "in", "into", "is", "it", "its", "just",
			"least", "let", "like", "likely", "may", "me", "might", "most",
			"must", "my", "neither", "no", "nor", "not", "of", "off", "often",
			"on", "only", "or", "other", "our", "own", "rather", "said", "say",
			"says", "she", "should", "since", "so", "some", "than", "that",
			"the", "their", "them", "then", "there", "these", "they", "this",
			"tis", "to", "too", "twas", "us", "wants", "was", "we", "were",
			"what", "when", "where", "which", "while", "who", "whom", "why",
			"will", "with", "would", "yet", "you", "your");
 
	Map<String, List<Tuple>> index = new HashMap<String, List<Tuple>>();
	List<String> files = new ArrayList<String>();
        List<String> books = new LinkedList<String>();
	public void indexFile(String line,int num) throws IOException {
		
		
			for (String _word : line.split("\\W+")) {
				String word = _word.toLowerCase();
				
				if (stopwords.contains(word))
					continue;
				List<Tuple> idx = index.get(word);
				if (idx == null) {
					idx = new LinkedList<Tuple>();
					index.put(word, idx);
				}
				idx.add(new Tuple(num));
			}
		
		
	}
 
	public Set<String> search(List<String> words) {
            
                Set<String> answer = new HashSet<String>();
		for (String _word : words) {
			
			String word = _word.toLowerCase();
			List<Tuple> idx = index.get(word);
			if (idx != null) {
				for (Tuple t : idx) {
					answer.add(books.get(t.number));
				}
			}
			
		}
                
                for (String word : answer) {
				System.out.print(" " + word);
		}
		System.out.println("");
                return answer;
	}
 
	public static void main(String[] args) {
		
	}
 
	private class Tuple {
		
		private int number;
 
		public Tuple( int number) {
			
			this.number = number;
		}
	}
}
 
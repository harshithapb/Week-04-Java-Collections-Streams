package FileCopy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
public class WordCounter {
	 public static void main(String[] args) {
		 String file="D:/EclipseDownload/JAVAIO Streams/src/FileCopy/pgm10_ip.txt"; 
		 Map<String ,Integer> wordCounts= new HashMap<>();  
		 
		 try(BufferedReader reader =new BufferedReader(new FileReader(file))){
			 String line;
			 while((line=reader.readLine())!=null) {
				 String[] words=line.toLowerCase().split("[a-zA-Z0-9']"); 
				 for(String  word: words) {
					 if(!word.isEmpty()) {
						 wordCounts.put(word, wordCounts.getOrDefault(word,0)+ 1);
					 }
				 }
			 } 
			 List<Map.Entry<String,Integer>> sortedWordCounts= wordCounts.entrySet().stream().sorted(Map.Entry.<String,Integer>comparingByValue().reversed()).collect(Collectors.toList());
			 System.out.println("Total no. of  words: "+wordCounts.values().stream().mapToInt(Integer ::intValue).sum()); 
			 System.out.println("\nTop 5 most frequent words:");
	         int count = 0; 
	         for(Map.Entry<String ,Integer> entry :sortedWordCounts) {
	        	 System.out.println(entry.getKey()+ ": "+entry.getValue()); 
	        	 count++; 
	        	 if(count==5) {
	        		 break;
	        	 }
	          }
		 }catch(IOException e) {
        	 System.err.println("err reading file "+e.getMessage());
         } 
			 
		 
	 }
} 


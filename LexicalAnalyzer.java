import java.io.*;
import java.util.*;





public class LexicalAnalyzer {
	

	public static void main(String[] args) {
		
		//list of sentences the file includes 
		ArrayList<String> sentences= new ArrayList<String>(); 
		//list of words ,each sentence of the file has .
		ArrayList<ArrayList<String>> wordsPerSentence=new ArrayList<ArrayList<String>>();  
		//words per sentence
		ArrayList<String> words=new ArrayList<String>();
		
		System.out.println("Lexical Analyzer");

		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");		
		

		
		try {
			
			File myFile= new File("C:\\Users\\nek\\Desktop\\NLP Project\\text.txt"); //Creation of File Descriptor for input file
			FileReader readMyFile=new FileReader(myFile); //Creation of File Reader object
			BufferedReader br=new BufferedReader(readMyFile);  //Creation of BufferedReader object
			
			
			  int c = 0;             
			  String sentence="";
			  System.out.println("Original Text from file :");
			  System.out.println("");
			  
		      while((c = br.read()) != -1)         //Read char by Char
		      {
		    	  
		            char character = (char) c; //converting integer to char

		    		
		    		System.out.print(character); // print the whole text from file char by char 
		            
		            if(String.valueOf(character).equals(".")) { // find the end of a sentence
		            	
		            	sentence=sentence+character; // add period to sentence
		            	sentences.add(sentence); //add sentence to sentences list 
		            	sentence="";// initialize sentence variable to null in order to store a new sentence
		            	
		            	
		            }else {
		            	
		            	sentence=sentence+character; //if not the end ,add character to sentence
		            	
		            }
		            
		      }
		      
		      System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");	
		      
		      for( int i=0;i< sentences.size();i++) { //loop as much times as the size of sentences list 
		    	  
		    	  System.out.print("Sentence : ");
		    	  System.out.println(sentences.get(i)); // print each sentence in sentences list 
		    	  System.out.println();
		    	  
		    	  String word="";  //here we store each word our sentence has
		    	  
		    	  for(int j=0;j<sentences.get(i).length();j++) {
		    		  
		    		  if( (String.valueOf(sentences.get(i).charAt(j)).equals(".")) || (String.valueOf(sentences.get(i).charAt(j)).equals(" "))){
		    			  
		    			  words.add(word);
		    			  word="";
		    			  
		    		  }else {
		    			  
		    			  word=word+sentences.get(i).charAt(j);
		    			  
		    			  
		    		  }
		    		 
		    	  }
		    	  
		    	  wordsPerSentence.add(words); // add sentence's i words into wordsPerSentence list 
		    	  
		    	  System.out.print("Words : [ ");
		    	  
		    	  for(int j=0;j<wordsPerSentence.get(i).size();j++){
		    		  
		    		  if(j== (wordsPerSentence.get(i).size() - 1)) { // if it's the last word print more symbols for better representation
							
		    			    System.out.print(wordsPerSentence.get(i).get(j)); // print all the words the sentence i has 
							System.out.print(" ] ");
							System.out.println(" ");
							System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");		
							
							
				     }else {
		    		  
		    		  System.out.print(wordsPerSentence.get(i).get(j));// print all the words the sentence i has 
		    		  System.out.print(",");
				     }
		    		  
		    	  }
		    	  
		    	  
		    	  words.clear(); // remove all words from words list in order to store the words of the new sentence 
		    	  
		      }
			
		}catch (FileNotFoundException e) { // handling file exceptions
			
			System.out.println("An error occurred.");
		    e.printStackTrace();
	    
			
		} catch (IOException e) { // handling IO  exceptions 
			
			System.out.println("An error occurred.");
			e.printStackTrace();
		} 
		
	}

}

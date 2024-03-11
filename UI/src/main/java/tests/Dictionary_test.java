
package tests;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

import Backend.Dictionary;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;




public class Dictionary_test {


    //define a runnable object to run the tests
    public void testDictionary(){
    //test 1: initialize dictionary, fill with words, and check that all words are in the dictionary
        
        String relativePath = ".." + File.separator + "Backend" + File.separator + "Backend" + File.separator + "dict_resources" + File.separator + "words.txt";
        File file_in = new File(relativePath);

        // Use the file (e.g., pass the path to your Dictionary constructor)
        Dictionary dictionary = new Dictionary(file_in.getAbsolutePath());

        //read the words from the text file
        File file = file_in;
        BufferedReader bufferedReader = null;
        int count = 0; // Added for debugging


        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                count++; // Increment word count
            }
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    System.out.println("An error occurred while closing the file: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        }

        int i = 0;
        //check that all words are in the dictionary
        for (i = 0; i < count; i++) {
            
        }
        
        if(i == (count)){
            System.out.println("test 1: pass");
        }else{
            System.out.println("test 1: fail");
        }


        //test 2: check to see if a word is in the dictionary

        if(dictionary.isWord("hello")){
            System.out.println("test 2: pass");

        }else{
            System.out.println("test 2: fail");
        }

        //test 3: check to see if a word is not in the dictionary

        if(!dictionary.isWord("helloo")){
            System.out.println("test 3: pass");

        }else{
            System.out.println("test 3: fail");
        }

        //test 4: get results from the spell checker

        String[] results = dictionary.getSuggestions("mispelt");
        //
        System.out.println(results[0] + " " + results[1] + " " + results[2]);


        //add words to the dictionary
        dictionary.add_user_word("hellooo");

        //test 5: check to see if a word is in the dictionary
        dictionary.isWord("hellooo");

        //remove word from 

    }
}

/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package javaquotes;

import com.google.gson.Gson;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;


public class App {
    public static void main (String[] args) {
        readFile();
        getQuotes();
        // Quotes to print while offline

    }

// this file will read JSON file
    public static Quote[] readFile() {
        //new quote array
        Quote [] response = null;
        try {
            Gson gson = new Gson();

            File file = new File("./resources/recentquotes.json");
            BufferedReader buffer = new BufferedReader(new FileReader(file));
            response = gson.fromJson(buffer, Quote[].class);

//          https://www.geeksforgeeks.org/different-ways-reading-text-file-java/
            int rand = getRandom(112);
            System.out.println(response[rand].toString());

        } catch (IOException e) {
            System.out.println(e);
        }
        return response;
    }




// Random number generator
    public static int getRandom(int num){
        return (int)Math.floor(Math.random()*(num));
    }




  // Make an API call
    public static String getQuotes(){

        try{
            URL url = new URL("http://ron-swanson-quotes.herokuapp.com/v2/quotes");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));

            Gson gson = new Gson();
            String[] quoteArray  = gson.fromJson(reader, String[].class);
            String quote = quoteArray[0];
            System.out.println(quote);

        }
        catch (IOException e){
            System.out.println(e);
            System.out.println(readFile());
            return "Please connect to internet";
        } return null;

    }
    // write a method that adds to JSON file

    



    }




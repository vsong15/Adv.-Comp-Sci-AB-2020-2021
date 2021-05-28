//M. Billington   1/11/2005
//                updated to Java 1.5 on 12/13/2006
//                updated for GradeIt on 12/22/2015
//Galanos         updated to use with Spotify playlists on 12/23/2015
//                updated again for Grade-It on 1.24.2018
//the team.  Limit the methods to queue methods.
//first program on queues.

import java.io.*;
import java.util.*;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;


public class SongQueue_partial
{
   private static Scanner keyboard;  //use this global Scanner
   private static Queue<String> songQueue;
   
   public static void main(String[] args) throws Exception
   {
      keyboard = new Scanner(System.in);
      songQueue = readPlayList();
      printSongList();
      
      String prompt = "Add song (A), Play song (P), Delete song (D), Quit (Q):  ";
      String str = "";
      do
      { 
         System.out.print(prompt);
         str = keyboard.nextLine().toUpperCase();
         processRequest( str );
         System.out.println();
      }while(!str.equals("Q"));
   }
   
   /* reads the file "songs.txt".  Extracts the song's title
      and stores it in a queue.
      @return the queue of songs
      */
   public static Queue<String> readPlayList() throws IOException
   {
      String song_file = getFileByGUI();
      Scanner inFile = new Scanner (new File(song_file));  
      Queue<String> tempSongQueue = new LinkedList<String>();
      while (inFile.hasNextLine())
      {
         String str = inFile.nextLine();
         tempSongQueue.add(str.substring(0,str.indexOf(" -"))); //removed artist's name because of weird control character
      }
      inFile.close();
      return tempSongQueue;   
   }
   
   /* processes the character codes A, P, D, Q, a, p, d, q.
      "A" prompts the user to enter the name of the song, 
      adds it to the queue, and displays the whole queue
      after "Your music queue:  " . Do not add the same song twice.

      "P" plays the song, if one exists, by displaying 
      "Now playing: " and its title and then removing it from the queue.
      If there is nothing play, the program displays "Empty queue!"

      "D" displays the queue, prompts the user by showing 
      "Delete which song (exact match)?" and will either delete the 
      song and display the queue or show "Error:  Song not in list."   

      "Q" displays "No more music for you today.  Goodbye!" 
      and ends the program.

      @param str - the character code
      */
   public static void processRequest(String str)
   {
   /********** YOUR CODE HERE ***********/
      if(str.equals("A") || str.equals("a")){
         System.out.println("Enter the name of the song.");
         String new_song = "";
         String temp = "";
         boolean song_already_in_queue = false;
         new_song = keyboard.nextLine();
         int queue_size = songQueue.size();
         for(int i = 0; i < queue_size; i++){
            temp = songQueue.poll();
            if(new_song.toUpperCase().equals(temp.toUpperCase()))
               song_already_in_queue = true;
            songQueue.add(temp);
         }
         if(!song_already_in_queue){
            songQueue.add(new_song);
         }
         else{
            System.out.println("Song is already in queue!");
         }
         queue_size = songQueue.size();
         String ans = "";
         temp = "";
         for(int i = 0; i < queue_size; i++){
            temp = songQueue.poll();
            if(i != queue_size - 1)
               ans += temp + ", ";
            else
               ans += temp;
            songQueue.add(temp);
         }
         System.out.println("Your music queue: " + ans);
      
      }
      else if(str.equals("P") || str.equals("p")){
         if(songQueue.size() == 0){
            System.out.println("Empty queue!");
         }
         else{
            System.out.println("Now playing: " + songQueue.poll());
         }
         int queue_size = songQueue.size();
         String ans = "";
         String temp = "";
         for(int i = 0; i < queue_size; i++){
            temp = songQueue.poll();
            if(i != queue_size - 1)
               ans += temp + ", ";
            else
               ans += temp;
            songQueue.add(temp);
         }
         System.out.println("Your music queue: " + ans);
      
      }
      else if(str.equals("D") || str.equals("d")){
         int queue_size = songQueue.size();
         String ans = "";
         String temp = "";
         for(int i = 0; i < queue_size; i++){
            temp = songQueue.poll();
            if(i != queue_size - 1)
               ans += temp + ", ";
            else
               ans += temp;
            songQueue.add(temp);
         }
         System.out.println("Your music queue: " + ans);
         System.out.print("Delete which song (exact match)?  ");
         String delete_song = keyboard.nextLine();
         boolean song_in_queue = false; 
         for(int i = 0; i < queue_size; i++){
            temp = songQueue.poll();
            if(delete_song.toUpperCase().equals(temp.toUpperCase()))
               song_in_queue = true;
            songQueue.add(temp);
         }
         if(song_in_queue){
            for(int i = 0; i < queue_size; i++){
               temp = songQueue.poll();
               if(!delete_song.toUpperCase().equals(temp.toUpperCase()))
                  songQueue.add(temp);
            }
            ans = "";
            for(int i = 0; i < queue_size - 1; i++){
               temp = songQueue.poll();
               if(i != queue_size - 2)
                  ans += temp + ", ";
               else
                  ans += temp;
               songQueue.add(temp);
            }
            System.out.println("Your music queue: " + ans);
         
         }
         if(!song_in_queue){
            System.out.println("Error: Song not in list.");
            System.out.println("Your music queue: " + ans);
         }
         
      }
      else if(str.equals("Q") || str.equals("q")){
         System.out.println("");
         System.out.println("No more music for you today. Goodbye!");
      }
      else{
         System.out.println("Invalid. Try Again.");
      }
   }
   
   /* prints the songs in the queue, separated by commas.
   */
   public static void printSongList()
   {
   /********** YOUR CODE HERE ***********/
      String ans = "";
      String temp = "";
      int queue_size = songQueue.size();
      for(int i = 0; i < queue_size; i++){
         temp = songQueue.poll();
         if(i != queue_size - 1)
            ans += temp + ", ";
         else
            ans += temp;
         songQueue.add(temp);
      }
      System.out.println("Your music queue: " + ans);
   }
   
   /*  standard accessor method.
       */
   public static Queue<String> getQueue()
   {
      return songQueue;
   }
   
   // Method to get a file using a GUI
   public static String getFileByGUI(){
      
      String full_path_string = new String();
      JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
   
      int returnValue = jfc.showOpenDialog(null);
        // int returnValue = jfc.showSaveDialog(null);
   
      if (returnValue == JFileChooser.APPROVE_OPTION) {
         File selectedFile = jfc.getSelectedFile();
         full_path_string = selectedFile.getAbsolutePath();
      }
   
      return full_path_string;      
   }
   
   
}

/************* EXAMPLE OUTPUT *******************

 Your music queue: Really Love, Uptown Funk, Thinking Out Loud, Alright, Traveller, Shallow, 
 Add song (A), Play song (P), Delete song (D), Quit (Q):  p
 Now playing: Really Love
 Your music queue: Uptown Funk, Thinking Out Loud, Alright, Traveller, Shallow, 
 
 Add song (A), Play song (P), Delete song (D), Quit (Q):  x
 Invalid.  Try again.
 
 Add song (A), Play song (P), Delete song (D), Quit (Q):  d
 Your music queue: Uptown Funk, Thinking Out Loud, Alright, Traveller, Shallow, 
 Delete which song (exact match)?  xxx
 Error:  Song not in list.
 Your music queue: Uptown Funk, Thinking Out Loud, Alright, Traveller, Shallow, 
 
 Add song (A), Play song (P), Delete song (D), Quit (Q):  d
 Your music queue: Uptown Funk, Thinking Out Loud, Alright, Traveller, Shallow, 
 Delete which song (exact match)?  Alright
 Your music queue: Uptown Funk, Thinking Out Loud, Traveller, Shallow, 
 
 Add song (A), Play song (P), Delete song (D), Quit (Q):  q
 
 No more music for you today.  Goodbye!

**********************************************/
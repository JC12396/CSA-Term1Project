package hangman;

import java.util.Scanner;
import java.nio.file.*;
import java.io.*;
import java.nio.file.attribute.*;
import static java.nio.file.StandardOpenOption.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Random;

public class HangmanUI {
    public static void main(String[] args)
    {
        Random r = new Random();
        String[] wordBank = {"ISIS", "WOMEN", "EGG", "PEDOPHILE", "VANFOSSEN", "THUNDER"};
        Scanner input = new Scanner(System.in);
        Path winners = Paths.get("C:\\Users\\jc155706\\Desktop\\Java\\CSA-Term1Project\\src\\hangman\\HangmanWords.txt");
        FileChannel fcIn = null;
        int wordToGuessNum = r.nextInt(5) + 1;
//        String wordToGuess = wordBank[wordToGuessNum];
        String wordToGuess = wordBank[1];
        int wins = 0;
        int losses = 0;
        String delimiter = "|";
        final String NAME_FORMAT = "          ";
        final int NAME_LENGTH = NAME_FORMAT.length();



        System.out.println("Welcome to Hangman!\nPlease guess a letter in the word! >> ");
        String guess = input.nextLine();
        guess = guess.toUpperCase();
        int length = wordToGuess.length();

        if(guess == wordToGuess.substring(0, 5))
        {
            System.out.println(guess + " was part of the word!");
        }
        else
        {
            System.out.println(guess + " was not part of the word!");
        }


        System.out.println("Word to guess: " + wordToGuess);
        System.out.println("Letter guessed: " + guess);



        try
        {
            fcIn = (FileChannel)Files.newByteChannel(winners, CREATE, WRITE);
            System.out.print("What is your name? >> ");
            String name = input.nextLine();
            StringBuilder sb = new StringBuilder(name);
            sb.setLength(NAME_LENGTH);
            String s = name + delimiter + "W's: " + wins + delimiter + "L's: " + losses;

            byte data[] = s.getBytes();
            ByteBuffer buffer = ByteBuffer.wrap(data);

            fcIn.write(buffer);

            fcIn.close();
        }
        catch (Exception e)
        {
            System.out.println("Error Message: " + e);
        }


    }


}

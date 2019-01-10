import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class PigLatin extends PApplet {

public void setup() 
{
	String[] lines = loadStrings("words.txt");
	System.out.println("there are " + lines.length + " lines");
	for (int i = 0 ; i < lines.length; i++) 
	{
	  System.out.println(pigLatin(lines[i]));
	}
}
public void draw()
{
        //not used
}
public int findFirstVowel(String sWord)
//precondition: sWord is a valid String of length greater than 0.
//postcondition: returns the position of the first vowel in sWord.  If there are no vowels, returns -1
{
	int pos = sWord.length()+1;
	for(int i = 0; i < sWord.length(); i++) {
		if (sWord.indexOf('a') < pos && sWord.indexOf('a') != -1) pos = sWord.indexOf('a');
		if (sWord.indexOf('e') < pos && sWord.indexOf('e') != -1) pos = sWord.indexOf('e');
		if (sWord.indexOf('i') < pos && sWord.indexOf('i') != -1) pos = sWord.indexOf('i');
		if (sWord.indexOf('o') < pos && sWord.indexOf('o') != -1) pos = sWord.indexOf('o');
		if (sWord.indexOf('u') < pos && sWord.indexOf('u') != -1) pos = sWord.indexOf('u');
	}
	if (pos != sWord.length()+1) 
		return pos;
	else
		return -1;
}

public String pigLatin(String sWord)
//precondition: sWord is a valid String of length greater than 0
//postcondition: returns the pig latin equivalent of sWord
{
	if(findFirstVowel(sWord) == -1)
		return sWord + "ay";
	else if(findFirstVowel(sWord) != -1) {
		if (sWord.indexOf("qu") == 0)
			return sWord.substring(2) + "quay";
		else if (findFirstVowel(sWord) == 0) 
			return sWord + "way";
		else if (findFirstVowel(sWord) != 0)
			return sWord.substring(findFirstVowel(sWord)) + sWord.substring(0,findFirstVowel(sWord)) + "ay";
		else 
			return "ERROR!";
	} 
	else 
		return "ERROR!";
	
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "PigLatin" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}

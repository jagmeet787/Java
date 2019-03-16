import java.util.regex.Matcher; 
import java.util.regex.Pattern; 
  
public class PatternRegex { 
    public static void main(String[] args) { 
        final String s = "This is a String with multiple words."; 
        
        // Pattern which will contain a-z characters
        final Pattern p = Pattern.compile("[a-zA-Z]+"); 
   
        Matcher m = p.matcher(s);  
        
        // print all the groups i.e all words
        while (m.find()) System.out.println(m.group()); 
    } 
} 

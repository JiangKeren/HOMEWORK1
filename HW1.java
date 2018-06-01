import java.util.Scanner;
import java.io.BufferedReader;  
import java.io.File;  
import java.io.FileInputStream;  
import java.io.FileReader;  
import java.io.IOException;  

public class HW1 {
     public static boolean contains(String A, String B) {  
        int[] array = new int[60];  
          
        //store the characters in A to array  
        for (int i = 0; i < A.length(); i++) {  
            array[A.charAt(i) - 'A'] ++;  
        }  
          
        //check whether all the characters in B exist in A  
        for (int j = 0; j < B.length(); j++) {  
            array[B.charAt(j) - 'A'] --;  
	    if(B.charAt(j)=='q') array['u'-'A']++;
            if (array[B.charAt(j) - 'A'] < 0) return false;  
        }  
          
        return true;  
    }
    
    public static int value(String a){
	int length=a.length();
	int v=0;
	for(int i=0;i<length;i++){
	    if(a.charAt(i)=='a'|a.charAt(i)=='b'|a.charAt(i)=='d'|a.charAt(i)=='e'|a.charAt(i)=='g'|a.charAt(i)=='i'|a.charAt(i)=='n'|a.charAt(i)=='o'|a.charAt(i)=='r'|a.charAt(i)=='s'|a.charAt(i)=='t'|a.charAt(i)=='u') v=v+1;
	     if(a.charAt(i)=='c'|a.charAt(i)=='f'|a.charAt(i)=='h'|a.charAt(i)=='l'|a.charAt(i)=='m'|a.charAt(i)=='p'|a.charAt(i)=='n'|a.charAt(i)=='v'|a.charAt(i)=='w'|a.charAt(i)=='y') v=v+2;
	      if(a.charAt(i)=='j'|a.charAt(i)=='k'|a.charAt(i)=='q' |a.charAt(i)=='x'|a.charAt(i)=='z') v=v+3;
	}
	return v;
    }
	    

    public static void main(String[] args) {
	System.out.println("Input all characters");
        Scanner console=new Scanner(System.in);
        String ch1=console.nextLine();

        File file = new File("dictionary.txt");  
        BufferedReader reader = null;  
        try {  
            reader = new BufferedReader(new FileReader(file));  
            String ch2 = null;   
	    int f=0;
	    String chmax=null;
            while ((ch2 = reader.readLine()) != null) {
	       	int length=ch2.length();
		boolean m=contains(ch1,ch2);
		if(m==true){
		    if(value(ch2)>f){
			f=value(ch2);
			chmax=ch2;
		    }
		    System.out.print(ch2 +": "+value(ch2)+ " ");   
		}
	    }
	    System.out.println();
	    System.out.println("Highest score words: "+chmax +": "+f);
            reader.close();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            if (reader != null) {  
                try {  
                    reader.close();  
                } catch (IOException e1) {  
                }  
            } 
	}
    }
}

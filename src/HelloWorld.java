package hello_package;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

   
public class HelloWorld {

	//private String str = "0";
	
	/*function prints "Hello World!", a random wait time of
	 * 0-10 seconds between each character */
	public void hello1(String str){
		
		Random rand = new Random();
		for (int i=0; i < str.length(); i++){
			/*sleep for a random time, 0 - 10 seconds*/
			int time = rand.nextInt(100);
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				
				System.err.println("Error: " + e.getMessage());
			}
			System.out.print(str.charAt(i));
			
		}
		System.out.print("\n");
		return;
	}
	
	
	/*function prints str, with one second between each character */
	public void hello2(String str){
		for(int i=0; i<str.length(); i++){
			int time = 10;
			try{
			Thread.sleep(time);
			}catch(InterruptedException e){
				System.err.println("Error: " + e.getMessage());				
			}
			System.out.print(str.charAt(i));
		}
		System.out.print("\n");
		return;
	}
	
	public void hello3(String str){
		System.out.print(str + "\n");
		return;
	}
	
	/*Function prints str, characters are stored in a
	 * LinkedList. LinkedList uses memory storing objects. get and add 
	 * run in O(n) time*/
	public void hello4(String str){
		LinkedList<Character> list = new LinkedList<Character>();
		for (int i = 0; i< str.length(); i++){
			list.add(str.charAt(i));
		}
		for(int i = 0; i < str.length(); i++){
		System.out.print(list.get(i));
		}
		System.out.print("\n");
		return;
	}
	
	/*Function prints "Hello World!", storing characters in an
	 * ArrayList, here get and add run in amortised O(1) time*/
	public void hello5(String str){
		ArrayList<Character> list = new ArrayList<Character>();
		for (int i = 0; i< str.length(); i++){
			list.add(str.charAt(i));
		}
		for(int i = 0; i < str.length(); i++){
		System.out.print(list.get(i));
		}
		System.out.print("\n");
		return;
	}
	
	public static String newString(int length){
		String output;
		
		Random rnd = new Random();
		Character c = (char)(rnd.nextInt(26) + 'a');
		output = c.toString();
		
		for (int i = 0; i < length; i++){
			Character next = (char)(rnd.nextInt(26) + 'a');
			output += next.toString();
		}
		
		return output;
	}
	
	public static void main(String[] args) throws InterruptedException{
		HelloWorld run = new HelloWorld(); 
		
		for (int i = 0; i < 1000; i++){
			String str = newString(10000);
			
			//run.hello1();
			//run.hello2();
			//run.hello3();
			run.hello4(str);
			run.hello5(str);
		}
		return;
	}
	
}

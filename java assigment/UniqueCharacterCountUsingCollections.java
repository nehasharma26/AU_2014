import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;


public class UniqueCharacterCountUsingCollections {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		HashMap<Character,Integer> hashmap = new HashMap<Character,Integer>();		
		System.out.print("Enter a String : ");
		int count =0;
		String str = s.next();
		for(int i=0; i<str.length(); i++){
			if(hashmap.containsKey(str.charAt(i))){
				hashmap.put(str.charAt(i),hashmap.get(str.charAt(i))+1);
			}
			else{
				hashmap.put(str.charAt(i),1);
			}
		}
		Set<Character> keys= hashmap.keySet();
		Iterator<Character> it = keys.iterator();
		while(it.hasNext()){
			if(hashmap.get(it.next())==1){
				count++;
			}
		}
		System.out.print("Count of unique characters = : " + count);
	}
}

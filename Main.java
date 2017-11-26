import java.util.Random;

public class Main {

	
	public static void main (String [] args){
		Random ra = new Random();
		BetterArray table = new BetterArray(10);
		
		for (int i=0; i<10; i++){
			table.put(i);
		}
		
		for (int i=0; i<20; i++){
			System.out.println(i+".  "+table.get(i));
		}
		System.out.println("____");
		for (int i=0; i<20; i++){
			table.put(ra.nextInt(20),i);
		}
		for (int i=0; i<20; i++){
			System.out.println(i+".  "+table.get(i));
		}
		System.out.println("____");
		table.insert(999, 14);
		for (int i=0; i<20; i++){
			System.out.println((i+1) + "  " +table.get(i));
		}
		System.out.println("____");
		table.delete(15);
		for (int i=0; i<19; i++){
			System.out.println((i+1) + "  " +table.get(i));
		}
		System.out.println("____");
		BetterArray table2 = new BetterArray(10000);
		for (int i=0; i<100000; i++){
			table2.put(ra.nextInt(100000));
		}
		table2.sort(table2);
		for (int i=0; i<(100000-1); i++){
			if (table2.get(i)> table2.get(i+1)){
				System.out.println("error");
				return;
			}
		}
		System.out.println((System.currentTimeMillis()* Math.pow(10, -3)));
		System.out.println("completed");
		
	}
	
	
}

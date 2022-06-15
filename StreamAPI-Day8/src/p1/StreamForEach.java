package p1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamForEach {

	List<Account> list = new ArrayList<>();

	PrintWriter pw = null;

	public StreamForEach() {
		String rootPath = "C:\\Users\\dani_\\Downloads";
		String fileName = "MyStreamAPI_FilterOutput.txt";
		File f = new File(rootPath + fileName);

		FileWriter fw = null;

		try {
			fw = new FileWriter(f, true);
			pw = new PrintWriter(fw);

		} catch (IOException e) {

			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {

		StreamForEach obj = new StreamForEach();

		Account a1 = new Account(101, "A", 2000);
		Account a2 = new Account(102, "Aab", 12000);
		Account a3 = new Account(103, "BAC", 5000);
		Account a4 = new Account(104, "BAAc", 6000);
		Account a5 = new Account(105, "xyz", 4000);

		obj.list = Arrays.asList(a1, a2, a3, a4, a5);

		obj.objective1(); // to call the forEach terminal operation
		System.out.println("\n----------------------");
		obj.objective2();
		System.out.println("\n----------------------");
		obj.objective3();
		System.out.println("\n----------------------");
		obj.objective4();
		System.out.println("\n----------------------");
		obj.objective5();

	}
	
	public void objective1() {
		list.stream().forEach(new Consumer<Account>() {

			@Override
			public void accept(Account t) {
				System.out.println(t);

			}

		});
		System.out.println("\n----------------------");
		list.stream().forEach((a) -> System.out.println(a));

	}
	
	public void objective2() {
		/*
		 * Account a = list.stream().min((a1,a2)->{ return a1.getBalance() -
		 * a2.getBalance(); }).get();
		 */
		Account a = list.stream().min((a1, a2) -> a1.getBalance() - a2.getBalance()).get();
		System.out.println(a);
		System.out.println(list.stream().max((a1, a2) -> a1.getBalance() - a2.getBalance()).get());
	}

	public void objective3() {
		/*
		 * Stream.of(14,84,10,60,78,96,47,65,37).filter(new Predicate<Integer>() {
		 * 
		 * @Override public boolean test(Integer t) { if(t>50) { return true; } else
		 * return false; }
		 * 
		 * }).forEach((x)->System.out.println(x));
		 */

		long count = list.stream().filter((a) -> {
			// code to store this a in a file based on some criteria
			if (a.getBalance() >= 4000) {
				pw.print(a + "\n");
				return true;
			} else
				return false;

		}).count();
		// to stroe output in different collection use collect
		System.out.println("Filter output count :- " + count);

		pw.close();
	}
	
	public void objective4() {

		List<Account> outputList = list.stream().filter((a) -> {

			if (a.getBalance() >= 4000) {

				return true;
			} else
				return false;

		}).filter((a) -> {
			if (a.getName().startsWith("B"))
				return true;
			else
				return false;
		}).collect(Collectors.toList());

		outputList.stream().forEach((a) -> System.out.println(a));

	}// end of objective 4



	public void objective5()
	{
		/*
		Stream.of(14,84,10).map(
				new Function<Integer, Integer>()
				{

					@Override
					public Integer apply(Integer t) {
						
						return t+t;
					}
					
				}).forEach((x)->System.out.println(x));
		
		*/
		
		
		
		list.stream().filter((a)->{
			
			if(a.getBalance()>=4000)
			{
				
				return true;
			}
			else return false;
			
		}).filter((a)->{
			if(a.getName().startsWith("B")) return true;
			else return false;
		}).map((a)->{
			int balance = a.getBalance();
			a.setBalance(balance+200);
			return a;
		}).forEach((a)->System.out.println(a));
		
		
		
	}// end of objective 5

	

	
	
}// end class

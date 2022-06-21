package generics;

import java.util.ArrayList;
import java.util.List;

import p4.Account;

class MyClass<T> // <T extends Account> // to call specific behaviour
{
	List<T> myList = new ArrayList<>();
	
	public void addData(T data)
	{
		int x;
		myList.add(data);
	}
	
	public T getData(int index)
	{
		return myList.get(index);
	}
	
	public int getInfo(T x)
	{
		// return x.getBalance(); // specific method cannot be called with type T, has to be T extends Account
		return x.toString().length();
	}
}


public class GenericsDemo {
	
	public static void main(String[] args) {
		
		MyClass<Integer> typeInt = new MyClass();
		typeInt.addData(74);
		typeInt.addData(85);
		typeInt.addData(185);
		typeInt.addData(35);
		typeInt.addData(80);
		
		
		Account a1 = new Account(101, "mike", 52000);// 108
		Account a2 = new Account(102, "abc", 300);// 108
		Account a3 = new Account(103, "jenny", 8000);// 111
		Account a5 = new Account(105, "jenny", 12000);// 111
		Account a6 = new Account(104, "Aaru", 72000);// 111
		
		MyClass<Account> typeAccount = new MyClass();
		typeAccount.addData(a1);
		typeAccount.addData(a2);
		typeAccount.addData(a3);
		typeAccount.addData(a6);
		typeAccount.addData(a5);
		
		
		System.out.println(typeInt.getData(2));
		System.out.println(typeAccount.getData(1));
		
		
		
	}

}




















package atm;


import java.util.ArrayList;
import java.util.Scanner;



public class Customer {
	public int AccountNo, Balance;
	static ArrayList al = new ArrayList();
	public Customer(){

	}
	public Customer(int accno, int balance){
		this.AccountNo = accno;
		this.Balance = balance;
	}
	public int Deposit(int amount) {
		if(amount>=500) {
			System.out.println("invalid");
		}else {
			Balance = Balance + amount;
		}
		return Balance;			
	}
	public int Withdraw(int amount) {
		if(Balance < amount) {
			System.out.print("Insufficent balance");
		}else if(Balance <= 500) {
			System.out.println("Insufficnet balance");
		}else {
			Balance = Balance - amount;
		}
		return Balance;	
	}
	public void Display() {
	    System.out.println("CustomerID:" + this.AccountNo);
	    System.out.println("Balance:" + this.Balance);
	}
	public Customer getDetails(int id) {
		Customer c = (Customer)al.get(id);
		return c;
	}
	public void putDetails(Customer c) {
		al.add(c);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		int Account, Balance, amount, response = 0;
		Customer c = new Customer();
		Customer customer1 = new Customer(1, 10000);
	    Customer customer2 = new Customer(2, 10000);
	    c.putDetails(customer1);
	    c.putDetails(customer2);
	    Boolean flag = true;
	    while(flag) {
	    	System.out.println(".....New Menu .......");
			System.out.println("1.Withdraw amount 2. Deposit Amount 3. Quit");
			response = sc.nextInt();
			switch(response) {
			case 1: 
				System.out.println("Enter the Account number?");
				Account = sc.nextInt();
				System.out.println("Enter the Amount");
				amount = sc.nextInt();
				for(int i = 0; i < 2; i++) {
					Customer c1 = customer1.getDetails(i);
					if(c1.AccountNo == Account) {
						Balance = c1.Withdraw(amount);
						System.out.println("Balance:" + Balance);
					}else {
						System.out.println("in correct account number");
					}
				}	
				break;
			case 2:
				System.out.println("Enter the Account number?");
				Account = sc.nextInt();
				System.out.println("Enter the Amount");
				amount = sc.nextInt();
				for(int i = 0; i < 2; i++) {
					Customer c1 = customer1.getDetails(i);
					if(c1.AccountNo == Account) {
						Balance = c1.Deposit(amount);
						System.out.println("Balance:" + Balance);
					}else {
						System.out.println("in correct account number");
					}
				}	
				break;
			case 3:
				System.out.println("Thanks for using this bank!");
	            flag = false;
				break;
			}
	    }
	    
	}
	
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finaljava;
import java.util.Scanner;
/**
 *
 * @author shabnam
 */
public class Finaljava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner KB=new Scanner(System.in);
		
		//create initial accounts
		System.out.print("How Many Customer U Want to Input : ");
		int n=KB.nextInt();//n is num of customer
		Bank  C[]=new Bank[n];//so many  obj is used for ref
		for(int i=0;i<C.length;i++)
		{   
			C[i]=new Bank();//create an obj 
			C[i].openAccount();//open an acc
		}
		
		//run loop until menu 5 is not pressed
		int ch;
		do
		{
			System.out.println("Main Menu\n1.display All\n2.Search By Account\n3.Deposit\n4.Withdrawal\n5.exit");
			System.out.println("Ur Choice :");
			ch=KB.nextInt();
			switch(ch)
			{ 
				case 1:
                        for (Bank C1 : C) {
                                   // Bank C1=new Bank();
                            C1.showAccount();
                        }
					break;

				case 2:
					System.out.print("Enter Account No U Want to Search...: ");
					String acn=KB.next();
					boolean found=false;
                        for (Bank C1 : C) {
                            found = C1.search(acn);
                            if(found)
                            {
                                break;
                            }
                        }
					if(!found)
					{
						System.out.println("Search Failed..Account Not Exist..");
					}
					break;

				case 3:
					System.out.print("Enter Account No : ");
					acn=KB.next();
					found=false;
                        for (Bank C1 : C) {
                            found = C1.search(acn);
                            if (found) {
                                C1.deposit();//c1 obj is already created i.e declared in for loop 
                                break;
                            }
                        }
					if(!found)
					{
						System.out.println("Search Failed..Account Not Exist..");
					}
					break;

				case 4:
					System.out.print("Enter Account No : ");
					acn=KB.next();
					found=false;
                        for (Bank C1 : C) {
                            found = C1.search(acn);
                            if (found) {
                                C1.withdrawal();
                                break;
                            }
                        }
					if(!found)
					{
						System.out.println("Search Failed..Account Not Exist..");
					}
					break;

				case 5:
					System.out.println("Good Bye..");
					break;
                               /* case 6: System.out.print("Enter Account Your No: ");
					acn=KB.next();
					found=false;
                        for (Bank C1 : C) {
                                found = C1.search(acn);1
                                if (found) {
                                    System.out.println("1.depo,2.Withdraw");
                                    System.out.println("Select the choice");
                                    int choice=KB.nextInt();
                                    switch(choice)
                                    {
                                        case 1:System.out.print("Enter Account where you want to transfer: ");
                                            acn=KB.next();
                                            found=false;
                            for (Bank C1 : C) {
                                found = C1.search(acn);
                                if (found) {
                                            C1.withdrawal();}}
                                    break;
                                        case 2:System.out.print("Enter Account where you want to transfer: ");
                                            acn=KB.next();
                                            found=false;
                            for (Bank C1 : C) {
                                found = C1.search(acn);
                                if (found) {
                                            C1.deposit();}}
                                        break;

                                 } 
                                }
                                break;
                                   
                                        
			*/}
                	
                }
	while(ch!=6);
    }        
    }                           

                 
                

class Bank
{
	private String accno;
	private String name;
	private long balance;

	Scanner KB=new Scanner(System.in);
	
	//method to open an account
	void openAccount()
	{ 
		System.out.print("Enter Account No: ");
		accno=KB.next();
		System.out.print("Enter Name: ");
		name=KB.next();
		System.out.print("Enter Balance: ");
		balance=KB.nextLong();
	}

	//method to display account details
	void showAccount()
	{ 
		System.out.println(accno+","+name+","+balance);
	}

	//method to deposit money
	void deposit()
	{
		long amt;
		System.out.println("Enter Amount U Want to Deposit : ");
		amt=KB.nextLong();
		balance=balance+amt;
	}

	//method to withdraw money
	void withdrawal()
	{
		long amt;
		System.out.println("Enter Amount U Want to withdraw : ");
		amt=KB.nextLong();
		if(balance>=amt)
		{ 
			balance=balance-amt;
		}
		else
		{
			System.out.println("Less Balance..Transaction Failed..");
		}
	}

	//method to search an account number
	boolean search(String acn)
	{ 
		if(accno.equals(acn))//acn is entered account num and check if entered acn for some operation is equal to the exixting accoun 
		{ 
			showAccount();//show the acc details
			return(true);
		}
		return(false);//this is else condition
	}
}
    
    


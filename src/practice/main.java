package practice;



import java.util.Scanner; 
import java.util.Random;
import java.text.DateFormat;  
import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.util.Calendar;  
class customer 
{
	
	String name;
	String address;
	String account_type;
	int phone_no;

	int count;
	 customer()
	 {
		 count=0;

	 }





}

class transaction{
	public transaction head=null;
    public transaction tail=null;
    transaction next=null;
    String transaction_type;
    String date;
	public transaction newnode;
    void add_date(String s)
    {
    	  transaction newNode = new transaction();    
		  if(head==null)
		  {
	          head = newNode;    
	          tail = newNode; 
		  }
		  else {
	          tail.next = newNode;     
	          tail = newNode; 
		  }
		  Date date = Calendar.getInstance().getTime();  
          DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
          newNode.date= dateFormat.format(date); 
          newNode.transaction_type=s;
         
          //System.out.println("Converted String: " + strDate);
          
    }
    
}

class accounts extends customer
{
	int saving_account_no;
	float saving_balance;
	int checking_account_no;
	float checking_balance;
	boolean save_account;
	boolean checking_account;
	int count;
	public accounts head=null;
	public accounts tail=null;
	public accounts next;
	int free_count=0;
	transaction trans=new transaction();
	customer c=new customer();
	accounts()
	{
		count=0;
		save_account=false;
		checking_account=false;
	}
	void add_node()
	{
		  accounts newNode = new accounts();    
		  if(head==null)
		  {
	          head = newNode;    
	          tail = newNode; 
		  }
		  else {
	          tail.next = newNode;     
	          tail = newNode; 
		  }
		  enterdetails(newNode);
	}
	
	void enterdetails(accounts newNode)
	{

	Scanner sc= new Scanner(System.in); 
	if(newNode.save_account==true && newNode.checking_account==true)	
	{
		System.out.print( "You have reached your account limit\n");
	}
	if (newNode.count == 0)
		{
			
		    System.out.print("Enter your name: ");
		    newNode.c.name=sc.next();
		    System.out.print("Enter your phone no: ");
		    newNode.c.phone_no=sc.nextInt();
		    System.out.print("Enter your address: ");
		    newNode.c.address=sc.next();
		    System.out.print("Enter account type: ");
			newNode.account_type=sc.next();
			if(newNode.account_type.equals("saving") || newNode.account_type.equals("Saving"))
			{
				//System.out.print("Your account number is being generated: ");
				Random rnd = new Random();
				int n = 100000 + rnd.nextInt(900000);
				newNode.saving_account_no=n;
				System.out.print("Your account number: "+newNode.saving_account_no+"\n");
				System.out.print("Enter amount: ");
				newNode.saving_balance=sc.nextInt();
				newNode.save_account=true;
			}
			else if(newNode.account_type.equals("checking") || newNode.account_type.equals("Checking"))
			{
				Random rnd = new Random();
				int n = 100000 + rnd.nextInt(900000);
				newNode.checking_account_no=n;
				System.out.print("Your account number: "+newNode.checking_account_no+"\n");
				System.out.print("Enter amount: ");
				newNode.checking_balance=sc.nextInt();
				newNode.checking_account=true;
			}
			newNode.count++;


		}
		else if(newNode.count>0)
		{
			
			String s = "";
			System.out.print( "Enter account type: ");
			s=sc.next();
			if(newNode.save_account==true && s.equals("saving")) 
			{
				System.out.print("Saving account already exist: \n");
				return;
				
			}
			else if(newNode.checking_account==false && s.equals("checking"))
			{
				Random rnd = new Random();
				int n = 100000 + rnd.nextInt(900000);
				newNode.checking_account_no=n;
				System.out.print("Your account number: "+newNode.checking_account_no+"\n");
				System.out.print("Enter amount: ");
				newNode.checking_balance=sc.nextInt();
				newNode.checking_account=true;
			}
			else if(newNode.checking_account==true && s.equals("checking"))
			{
				System.out.print("Checking account already exist: \n");
			}
			else 
			{
				Random rnd = new Random();
				int n = 100000 + rnd.nextInt(900000);
				newNode.saving_account_no=n;
				System.out.print("Your account number: "+newNode.saving_account_no+"\n");
				System.out.print("Enter amount: ");
				newNode.saving_balance=sc.nextInt();
				newNode.save_account=true;
			}



		}
	}
	
	int login(int id)
	{
		 accounts newNode = new accounts(); 
		 newNode=head;
		 int i=0;
		 while(newNode!=null)
		 {
			if(newNode.saving_account_no==id || newNode.checking_account_no==id)
			{
				System.out.print("Welcome "+ newNode.c.name+"\n");
				if(newNode.save_account==true && newNode.checking_account==true)
				{
					System.out.print("your saving acount number is:  "+ newNode.saving_account_no+"\n");
					System.out.print("Your Balance is: "+ newNode.saving_balance);
					System.out.print("your checking acount number is:  "+ newNode.checking_account_no+"\n");
					System.out.print("Your Balance is: "+ newNode.checking_balance+"\n");
					
				}
				else if(newNode.save_account==true && newNode.checking_account==false)
				{
					System.out.print("your saving acount number is:  "+ newNode.saving_account_no+"\n");
					System.out.print("Your Balance is: "+ newNode.saving_balance+"\n");
				}
				else if(newNode.save_account==false && newNode.checking_account==true)
				{
					System.out.print("your checking acount number is:  "+ newNode.checking_account_no+"\n");
					System.out.print("Your Balance is: "+ newNode.checking_balance+"\n");
				}
				i=1;
				break;
			}

				newNode= newNode.next;    
		 }
		return i;
	}
	void add_another_account(int id)
	{
		 accounts newNode = new accounts(); 
		 newNode=head;
		while(newNode!=null)
		{
			if(newNode.saving_account_no==id || newNode.checking_account_no==id)
			{
				enterdetails(newNode);
				break;
			}
				newNode= newNode.next;    
		}
	}
	void makeDeposit(int id)
	{
		 accounts newNode = new accounts(); 
		 newNode=head;
			int amount=0;
			int tax=0;
	        String s="";
	        Scanner sc= new Scanner(System.in); 
	        System.out.print("Enter your account type? ");
	        s=sc.next();
		while(newNode!=null)
		{

	        if(s.equals("saving") && newNode.save_account==true && newNode.saving_account_no==id)
	        {
	            if(newNode.free_count>2)
	            {
	            	tax=10;
	            }
	            System.out.print("How much amount you want to deposit? ");
	    		amount=sc.nextInt();
	    		newNode.saving_balance=newNode.saving_balance-amount-tax;
	    		 System.out.print("Remaining amount " + newNode.saving_balance+ "\n");
	    		 newNode.free_count++;
	    		 newNode.trans.add_date("deposit");
	    		 break;
	        }
	        if(s.equals("checking") && checking_account==true  && newNode.checking_account_no==id)
	        {
	            if(newNode.free_count>2)
	            {
	            	tax=10;
	            }
	            System.out.print("How much amount you want to deposit?: ");
	    		amount=sc.nextInt();
	    		newNode.checking_balance=newNode.checking_balance-amount-tax;
	    		System.out.print("Remaining amount " + newNode.checking_balance+"\n");
	    		newNode.free_count++;
	    		newNode.trans.add_date("deposit");
	    		break;
	        }
				newNode= newNode.next;    
		}
		
		

		
		

	}
	void makeWithdrawal(int id)
	{
		 accounts newNode = new accounts(); 
		 newNode=head;
			int amount=0;
			int tax=0;
	        String s="";
	        Scanner sc= new Scanner(System.in); 
	        System.out.print("Enter your account type? ");
	        s=sc.next();
		while(newNode!=null)
		{

	        if(s.equals("saving") && newNode.save_account==true && newNode.saving_account_no==id)
	        {
	            if(newNode.free_count>2)
	            {
	            	tax=10;
	            }
	        	System.out.print("How much amount you want to withdraw? ");
	    		amount=sc.nextInt();
	    		newNode.saving_balance=newNode.saving_balance-amount-tax;
	    	    System.out.print("Remaining amount " + newNode.saving_balance+ "\n");
	    	    newNode.free_count++;
	    	    newNode.trans.add_date("withdrawl");
	    		 break;
	    		 
	        }
	        if(s.equals("checking") && checking_account==true  && newNode.checking_account_no==id)
	        {
	            if(newNode.free_count>2)
	            {
	            	tax=10;
	            }
	            System.out.print("How much amount you want to deposit?: ");
	    		amount=sc.nextInt();
	    		newNode.checking_balance=newNode.checking_balance-amount-tax;
	    		System.out.print("Remaining amount " + newNode.checking_balance+"\n");
	    		newNode.free_count++;
	    		newNode.trans.add_date("withdrawl");
	    		break;
	        }
				newNode= newNode.next;    
		} 
		
	}
	void checkBalance(int id)
	{
		
		 accounts newNode = new accounts(); 
		 newNode=head;
		 while(newNode!=null)
		 {
			if(newNode.saving_account_no==id || newNode.checking_account_no==id)
			{
				    System.out.print("User's Name" + newNode.c.name+ "\n");
			        if(newNode.save_account==true)
			        {
			        	System.out.print("Remaining Saving account's amount" + newNode.saving_balance+"\n");
			        }
			        if(newNode.checking_account==true)
			        {
			    		System.out.print("Remaining Checking account's amount" + newNode.checking_balance+"\n");
			        }
				
				break;
			}

				newNode= newNode.next;    
		 }
		


	}
	void printStatement(int id)
	{
		 accounts newNode = new accounts(); 
		 newNode=head;
		 while(newNode!=null)
		 {
			if(newNode.saving_account_no==id || newNode.checking_account_no==id)
			{
				System.out.print("User's name: "+ newNode.c.name+"\n");
				newNode.trans.newnode=new transaction();
				while(newNode.trans.newnode!=null)
				{
					System.out.print(newNode.trans.newnode.transaction_type+"\n");
					System.out.print(newNode.trans.newnode.date+"\n");
					newNode.trans.newnode=newNode.trans.newnode.next;
				}
				break;
			}

				newNode= newNode.next;    
		 }
	}
	void transferAmount(int id)
	{
		
		 accounts newNode = new accounts(); 
		 newNode=head;
		 Scanner sc= new Scanner(System.in); 
         int amount=0;
         int id1=0;
		 while(newNode!=null)
		 {
			if(newNode.saving_account_no==id) 
			{
				System.out.print("Enter the account number: ");
				id1=sc.nextInt();
				accounts newNode1 = new accounts(); 
				newNode1=head;
				 while(newNode1!=null)
				 {
					if(newNode1.saving_account_no==id1) 
					{
						System.out.print("Enter Amount to transfer from your saving account: ");
						amount=sc.nextInt();
						newNode1.saving_balance=newNode1.saving_balance+amount;
						break;
					}
					else if(newNode1.checking_account_no==id1)
					{
						System.out.print("Enter Amount to transfer from your saving account: ");
						amount=sc.nextInt();
						newNode1.checking_balance=newNode1.checking_balance+amount;
						break;
					}

						newNode1= newNode1.next;    
				 }
				newNode.saving_balance=newNode.saving_balance-amount;
				
			
			}
			else if(newNode.checking_account_no==id)
			{
				System.out.print("Enter the account number: ");
				id1=sc.nextInt();
				accounts newNode1 = new accounts(); 
				newNode1=head;
				 while(newNode1!=null)
				 {
					if(newNode1.saving_account_no==id1) 
					{
						System.out.print("Enter Amount to transfer from your saving account: ");
						amount=sc.nextInt();
						newNode1.saving_balance=newNode1.saving_balance+amount;
						break;
					}
					else if(newNode1.checking_account_no==id1)
					{
						System.out.print("Enter Amount to transfer from your saving account: ");
						amount=sc.nextInt();
						newNode1.checking_balance=newNode1.checking_balance+amount;
						break;
					}

						newNode1= newNode1.next;    
				 }
				newNode.checking_balance=newNode.checking_balance-amount;
				
			}

				newNode= newNode.next;    
		 }
		
		 newNode.trans.add_date("Tranfer");
	}
	float calculateZakat(int id)
	{
		 accounts newNode = new accounts(); 
		 newNode=head;
		 float zaqat=1;
		while(newNode!=null)
		{
			if(newNode.saving_account_no==id)
			{
				zaqat=(float) (newNode.saving_balance*2.5/100);
				System.out.print("You have Zaqat Amount: " + zaqat+"\n");
				
				break;
			}

		 newNode= newNode.next;    
		}
		if(zaqat==1)
		{
			System.out.print("You account isn't eligible for the Zaqat\n");
		}
		return zaqat;
	}
	void displayAllDeductions(int id)
	{
		 accounts newNode = new accounts(); 
		 newNode=head;
		 while(newNode!=null)
		 {
			if(newNode.saving_account_no==id || newNode.checking_account_no==id)
			{
				break;
			}

				newNode= newNode.next;    
		 }
		 System.out.print("You had total "+ newNode.free_count+" transaction"+"\n");
		 System.out.print("total amount of tax deduction is: "+ newNode.free_count*10+"\n");
		 
     float zaqat=calculateZakat(id);
     System.out.print("You zaqat deduction: "+ zaqat+"\n");
     
	}
	void calculatelnterest()
	{

	}
	public void show_details(customer c)
	{
		 accounts newNode = new accounts(); 
		 newNode=head;
		while(newNode!=null)
		{
				System.out.print( newNode.c.name + "\n");
				System.out.print( newNode.c.address + "\n");
				System.out.print( newNode.c.phone_no + "\n");
				if( newNode.save_account==true)
				{
					System.out.print( newNode.saving_account_no + "\n");
					System.out.print( "Saving" + "\n");
					System.out.print( newNode.saving_balance + "\n");
				}
				if(newNode.checking_account==true)
				{
					System.out.print( newNode.checking_account_no + "\n");
					System.out.print( "Checking" + "\n");
					System.out.print( newNode.checking_balance + "\n");
				}
				newNode= newNode.next;    
		}
	}
}	


public class main {
	public static void main(String args[])
    {
		
		accounts c=new accounts();
        Scanner sc= new Scanner(System.in); 
        String p="";
        int count=-1;
        while(!p.equals("exit"))
        {
        	System.out.print("Write exit to stop the program\n");
        	System.out.print("Press 1 create an account\n");
        	System.out.print("Press 2 to log in to your account\n");
        	p=sc.next();

        	if(p.equals("1"))
        	{
        			c.add_node();
        		    count++;
        		    
        		    
        	}
        	if(p.equals("2"))
        	{
	       	     int id=0;
	       	     System.out.print("please enter you account number\n");
	       		 id=sc.nextInt();
	        	 int i=c.login(id);
	        	 if(i==1)
	        	 {
	        		String p1="";
	        		
	        		while(!p1.equals("q"))
	        		{
	        			    System.out.print("Press q to log out your account\n");
	        			    System.out.print("Press 3 to create another account of the same user\n");
	        			    System.out.print("Press 4 to make deposit\n");
	        			    System.out.print("press 5 to check your balance\n");
	        			    System.out.print("press 6 to calculate your zaqat\n");
	        			    System.out.print("press 7 to display all deduction\n");
	        			    System.out.print("press 8 to transfer amount to another account\n");
	        			    System.out.print("press 9 to print statement\n");
	        			    
		                    p1=sc.next();
			             	if(p1.equals("q"))
			            	{
			    	        		System.out.print("Your account has been logged out\n");
			                    
			            	} 
			             	
			             	else if(p1.equals("3"))
			            	{
			            	   
			            	     //c.enterdetails();
			            		 c.add_another_account(id);
			            		
			            	}
			             	else if(p1.equals("4"))
			            	{
                               c.makeDeposit(id);
			            		
			            	}
			             	else if(p1.equals("5"))
			            	{
			            		
			            		c.checkBalance(id);
			            	}
			             	else if(p1.equals("7"))
			             	{
			             		c.displayAllDeductions(id);
			             	}
			             	else if(p1.equals("6"))
			             	{
			             		c.calculateZakat(id);
			             	}
			             	else if(p1.equals("8"))
			             	{
			             		c.transferAmount(id);
			             	}
			             	else if(p1.equals("9"))
			             	{
			             		c.printStatement(id);
			             	}
	        		}
	        		 
	        		 
	        		 
	        		 
	        		 
	        	 }
        	}
        	
        	
        	
        	

        
        




        	   // System.out.print(p);
        
        }
    }
}


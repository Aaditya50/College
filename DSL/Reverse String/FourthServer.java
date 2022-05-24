import java.sql.*;
import java.sql.Connection;
import java.rmi.*;
import java.rmi.Naming.*;
import java.rmi.server.*;
import java.rmi.registry.*;
import java.util.Vector;
interface DBInterface extends Remote
{
	public String input(String name1) throws RemoteException;
}
public class FourthServer extends UnicastRemoteObject implements DBInterface{
	int i;
	String name3;
	public String reverse_str(String s1)
	{
		char ch[]=s1.toCharArray(); 
		String rev="";
		for(int i=ch.length-1;i>=0;i--)
		{
			rev+=ch[i];
		}
		return rev;
	}
	public FourthServer()throws RemoteException
	{
		try	{
			System.out.println("Initializing Server\n Server Ready");
		}
		catch(Exception e)
		{
			System.out.println("ERROR:"+e.getMessage());
		}
	}
	public static void main(String[]args)
	{
		try
		{
			FourthServer rs=new FourthServer();
			java.rmi.registry.LocateRegistry.createRegistry(1030).rebind("DBServ",rs);
		}
		catch(Exception e)
		{
			System.out.println("ERROR:"+e.getMessage());
		}
	}
	public String input(String name1)
	{ 
		try{
			name3=reverse_str(name1);
		}
		catch(Exception e)
		{
			{
				System.out.println("ERROR:"+e.getMessage());
			}
		}
			return name3;
    }
}
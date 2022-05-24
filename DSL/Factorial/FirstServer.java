import java.sql.*;
import java.rmi.*;
import java.rmi.server.*; 
interface DBInterface extends Remote{
    public int input(int n) throws RemoteException;
} 
public class FirstServer extends UnicastRemoteObject implements DBInterface{
    int fact,i; 
    ResultSet r;
    public FirstServer() throws RemoteException{ 
        try{ 
            System.out.println("Initializing Server\nServer Ready"); 
        } catch (Exception e){ 
            System.out.println("ERROR: " +e.getMessage());
        }
    }
    public static void main(String[] args){ 
        try  {
            FirstServer rs=new FirstServer(); 
            java.rmi.registry.LocateRegistry.createRegistry(1031).rebind("DBServ",rs); 
        }
        catch (Exception e){
            System.out.println("ERROR: " +e.getMessage());
        }
    }
    public int input(int n){
        int fact=1;
        try{ 
            for(i=1;i<=n;i++){    
                fact=fact*i;    
            }
        } 
        catch (Exception e){
            System.out.println("ERROR: " +e.getMessage()); 
        } 
        return fact;
    }
}

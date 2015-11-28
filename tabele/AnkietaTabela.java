import java.sql.*;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class AnkietaTabela {
	
	static String tabela;
	static int id_ankieta;
	static String opis;
	static String data_od;
	static String dtat_do;
	  
	public static void main(String args[]) {
		int input = 0;
		  
		while(input != 4) {
			System.out.println();
    	    System.out.println("Wpisz odpowiadającą cyfrę, aby:");
            Scanner sc = new Scanner(System.in);
            System.out.println("1. Stworzyć tabelę | 2. Usunąć tabelę | 3. Wyświetlić nazwy wszystkich tabel | 4. Zakończyć działanie programu.");
            input = sc.nextInt();
    	   
    	    switch (input) {
    	    	case 1: 
    	    		create();	
    	    		break;
    	    	case 2:
    	    		drop();	
    	    		break;
    	    	case 3:
    	    		names();
    	    	case 4:
    	    		break;
    	    	default: System.out.println("Wpisano nieprawidłową cyfrę");                          
          	  		break;
    	    }//END switch
        }//END while
    }//END main
	   
    public static void create() {
    	Connection c = null;
        Statement stmt = null;
        try {
        	Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");

            stmt = c.createStatement();
            Scanner input = new Scanner(System.in);
            System.out.println("Wpisz nazwę tabeli: ");
            tabela = input.nextLine();
            
            String sql = "CREATE TABLE IF NOT EXISTS " + tabela +
            "(id_ankieta	 INTEGER PRIMARY KEY   AUTOINCREMENT, " +
            " opis           CHAR    NOT NULL, " + 
            " data_od        CHAR    NOT NULL, " +
            " data_do        CHAR    NOT NULL) "; 
                        
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }//END catch
        System.out.println("Utworzono tabelę " + tabela);
 	}//END create

	public static void drop() {
  		Connection c = null;
  	    Statement stmt = null;
  	    try {
  	    	Class.forName("org.sqlite.JDBC");
  	        c = DriverManager.getConnection("jdbc:sqlite:test.db");
  	        c.setAutoCommit(false);
  	      
  	        Scanner input = new Scanner(System.in);
            System.out.println("Którą tabelę chcesz usunąć?");
            tabela = input.nextLine();
        
  	        stmt = c.createStatement();
  	        String sql = "DROP table " + tabela;
  	        stmt.executeUpdate(sql);
  	        c.commit();
  	        stmt.close();
  	        c.close();
  	    } catch ( Exception e ) {
  	        System.err.println( e.getClass().getName() + ": " + e.getMessage() );
  	        System.exit(0);
  	    }//END catch
  	    System.out.println("Tabela usunięta");
  	}//END drop
  	
  	public static void names() {
  		Connection c = null;
  	    Statement stmt = null;
  	    try {
  	    	Class.forName("org.sqlite.JDBC");
  	        c = DriverManager.getConnection("jdbc:sqlite:test.db");
  	        c.setAutoCommit(false);
  	        
  	        stmt = c.createStatement();
  	        DatabaseMetaData md = c.getMetaData();
  	        ResultSet rs = md.getTables(null, null, "%", null);
  	        while (rs.next()) {
  	        	System.out.println(rs.getString(3));
  	        }
  	        c.commit();
  	        stmt.close();
  	        c.close();
  	    } catch ( Exception e ) {
  	        System.err.println( e.getClass().getName() + ": " + e.getMessage() );
  	        System.exit(0);
  	    }//END catch
  	    System.out.println();
  	}//END tables
}//END class

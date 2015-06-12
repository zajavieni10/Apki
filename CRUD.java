import java.sql.*;
public class CRUD {
	public static void main( String args[] )
	  {
		//kategorie:
		//1-smutek
		//2-szczescie
		//3-nie wiem
		//4-nuda
		
		//Ania G.
		insertDB("Shrek", "2001","Andrew Adamson","http://www.filmweb.pl/Shrek", "2");
	    	insertDB("Gwiazd naszych wina", "2014","Josh Boone","http://www.filmweb.pl/film/Gwiazd+naszych+wina-2014-681825", "1");
	    	insertDB("Wladca Pierscieni: Powrot krola", "2003","Peter Jackson","http://www.filmweb.pl/Powrot.Krola", "3");
	    	insertDB("Faceci w czerni", "1997","Barry Sonnenfeld","http://www.filmweb.pl/film/Faceci+w+czerni-1997-5507", "4");
	    	
	    	//Ola K.
	    	insertDB("Pamietnik", "2004", "Nick Cassavetes", "http://www.filmweb.pl/Pamietnik", "1");
	    	insertDB("Wielki Gatsby", "2013", "Baz Luhrmann", "http://www.filmweb.pl/film/Wielki+Gatsby-2013-506934", "2");
	    	insertDB("Gran Torino", "2008", "Clint Eastwood", "http://www.filmweb.pl/film/Gran+Torino-2008-476580", "3");
	    	insertDB("Grand Budapest Hotel", "2014", "Wes Anderson", "http://www.filmweb.pl/film/Grand+Budapest+Hotel-2014-661817", "4");
	    
	    

	  }
		static String dbURL = "jdbc:mysql://mysql.agh.edu.pl:3306/aguzy";
		static String username = "aguzy";
		static String password = "dewikad";
	  
		public static void insertDB( String tytul, String rok, String rezyser, String link, String kategoria)
		{

		  try {
		   
		      Connection conn = DriverManager.getConnection(CRUD.dbURL, CRUD.username, CRUD.password);
		   
		      String sql = "INSERT INTO ap_web (tytul, rok_produkcji, kategoria, rezyser, link) VALUES (?, ?, ?, ?, ?)";
			  
			  PreparedStatement statement = conn.prepareStatement(sql);
			  statement.setString(1, tytul);
			  statement.setString(2, rok);
			  statement.setString(3, kategoria);
			  statement.setString(4, rezyser);
			  statement.setString(5, link);
			   
			  int rowsInserted = statement.executeUpdate();
			  if (rowsInserted > 0) {
			      System.out.println("Dodano nowy tytul");
			  }
		      
		  } catch (SQLException ex) {
		      ex.printStackTrace();
		  }
		  
		  
	  }
	   
	  public static void selectDB()
	  {
		  try {
			   
			  Connection conn = DriverManager.getConnection(CRUD.dbURL, CRUD.username, CRUD.password);
		   
			  String sql = "SELECT * FROM ap_web";
			  
			  Statement statement = conn.createStatement();
			  ResultSet result = statement.executeQuery(sql);
			   
			  int count = 0;
			   
			  while (result.next()){
			      String tytul = result.getString("tytul");
			      String rok = result.getString("rok_produkcji");
			      String kategoria = result.getString("kategoria");
			      String rezyser = result.getString("rezyser");
			      String link = result.getString("link");
			      String kategoria_opis="";
			      switch (kategoria) {
		            case "1":  kategoria_opis = "Jestem smutny";
		                     break;
		            case "2":  kategoria_opis = "Jestem szczesliwy";
                    	break;
		            case "3":  kategoria_opis = "Nie wiem co mi jest";
                    	break;
		            case "4":  kategoria_opis = "Jestem szczesliwy";
                    	break;
                    }
			      String output = "Film #%d: %s (%s), %s, kategoria: %s, link: %s";
			      System.out.println(String.format(output, ++count, tytul, rok, rezyser, kategoria_opis, link));
			  }
		      
		  } catch (SQLException ex) {
		      ex.printStackTrace();
		  }
		  
	  }
	   
	  public static void updateDB(String id, String tytul, String rok, String rezyser, String link, String kategoria)
	  {
		  try {
			   
			  Connection conn = DriverManager.getConnection(CRUD.dbURL, CRUD.username, CRUD.password);
		   
			  String sql = "UPDATE ap_web SET tytul=?, rok_produkcji=?, rezser=?, link=?, kategoria=? WHERE id=?";
			  
			  PreparedStatement statement = conn.prepareStatement(sql);
			  statement.setString(1, tytul);
			  statement.setString(2, rok);
			  statement.setString(3, rezyser);
			  statement.setString(4, link);
			  statement.setString(5, kategoria);
			  statement.setString(6, id);
			   
			  int rowsUpdated = statement.executeUpdate();
			  if (rowsUpdated > 0) {
			      System.out.println("Film zostal zaktualizowany pomyslnie!");
			  }
		      
		  } catch (SQLException ex) {
		      ex.printStackTrace();
		  }
		  
	  }
	   
	  public static void deleteDB(String id)
	  {
		  try {
			   
			  Connection conn = DriverManager.getConnection(CRUD.dbURL, CRUD.username, CRUD.password);
		   
			  String sql = "DELETE FROM ap_web WHERE id=?";
			  
			  PreparedStatement statement = conn.prepareStatement(sql);
			  statement.setString(1, id);
			   
			  int rowsDeleted = statement.executeUpdate();
			  if (rowsDeleted > 0) {
			      System.out.println("Film został pomyślnie usunięty!");
			  }
		      
		  } catch (SQLException ex) {
		      ex.printStackTrace();
		  }
		  
	  }
}

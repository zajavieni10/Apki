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
	    
	    	
		//K.Kawula
		insertDB("Nie opuszczaj mnie", "2010", "Mark Romanek", "http://www.filmweb.pl/film/Nie+opuszczaj+mnie-2010-502884", "1");
	    	insertDB("To nie tak jak myslisz kotku", "2008", "Sławomir Kryński,", "http://www.filmweb.pl/film/To+nie+tak+jak+my%C5%9Blisz%2C+kotku-2008-475684", "2");
	    	insertDB("Życie jest piękne", "1997", "Roberto Benini", "http://www.filmweb.pl/Zycie.Jest.Piekne", "3");
	    	insertDB("Co się wydarzyło w Madison County", "1995", "Clint Eastwood", "http://www.filmweb.pl/film/Co+si%C4%99+wydarzy%C5%82o+w+Madison+County-1995-641", "4");

		//VGolebiewska
		insertDB("Godziny-Wyscig z czasem","2013", "Eric Heisserer", "http://www.filmweb.pl/film/Godziny+-+Wy%C5%9Bcig+z+czasem-2013-638157", "1");
		insertDB("Mamma mia", "2008", "Phyllida Lloyd", "http://www.filmweb.pl/film/Mamma+Mia%21-2008-375547#", "2");
		insertDB("Chappie", "2015", "Neill Blomkamp", "http://www.filmweb.pl/film/Chappie-2015-612189", "3");
		insertDB("Podziemny krag", "1999", "David Fincher", "http://www.filmweb.pl/Podziemny.Krag", "4");

		//Magda P.
		insertDB("Control", "2007","Anton Corbijn", "http://www.filmweb.pl/Control", "1");
	    	insertDB("Zapach kobiety", "1992","Martin Brest", "http://www.filmweb.pl/Zapach.Kobiety", "2");
	    	insertDB("Once", "2006", "John Carney", "http://www.filmweb.pl/Once", "3");
	    	insertDB("Leon zawodowiec", "1994", "Luc Besson", "http://www.filmweb.pl/Leon.Zawodowiec", "4");
	    	
	    	//D.Dobrowolski
	    	insertDB("Poradnik pozytywnego myslenia", "2012","David O. Russel", "http://www.filmweb.pl/film/Poradnik+pozytywnego+my%C5%9Blenia-2012-506803", "1");
	    	insertDB("Nietykalni", "2011","Olivier Nakache, Eric Toledano", "http://www.filmweb.pl/film/Nietykalni-2011-583390", "2");
	    	insertDB("Wszystko o Ewie", "1950", "Joseph L. Mankiewicz", "http://www.filmweb.pl/film/Wszystko+o+Ewie-1950-31277", "3");
	    	insertDB("Casino Royale", "2006", "Martin Campbell", "http://www.filmweb.pl/Casino.Royale#", "4");
	    	
	    	//Maja K.
	    	insertDB("Wybuchowa para", "2010","James Mangold", "http://www.filmweb.pl/Wybuchowa.Para", "1");
		insertDB("Jak zostać królem", "2010","Tom Hooper", "http://www.filmweb.pl/film/Jak+zosta%C4%87+kr%C3%B3lem-2010-539270#", "2");
		insertDB("Jak stracić chłopaka w 10 dni", "2003", "Donald Petrie", "http://www.filmweb.pl/film/Jak+straci%C4%87+ch%C5%82opaka+w+10+dni-2003-38301", "3");
		insertDB("Piraci z Karaibów: Na krańcu świata", "2007", "Gore Verbinski", "http://www.filmweb.pl/Na.Krancu.Swiata.Piraci.Z.Karaibow", "4");
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

package conexion_db;

import java.sql.*;

public class conexion {

	public static void main(String[] args) throws SQLException {


      System.out.println("-------- Connection ------");
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("¿Dónde está su controlador Oracle JDBC?");
            e.printStackTrace();
            return;
        }
        System.out.println("¡Controlador Oracle JDBC registrado!");
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(
            "jdbc:oracle:thin:@99.90.28.31:1521:AGSVISTA","ENROLAMIENTO","ENROLAMIENTO");
        } catch (SQLException e) {
            System.out.println("¡La conexión falló! Verificar consola de salida");
            e.printStackTrace();
            return;
        }

        if (connection != null) {
            System.out.println("lo hiciste, toma el control de tu base de datos ahora!");
                   
            Statement stmt = connection.createStatement();
            ResultSet rset = 
                      stmt.executeQuery("select NIV_EXM from EXAMEN");
            while (rset.next())
                  System.out.println (rset.getString(1));   // Print col 1
            stmt.close();
            
            
        } 
        else {
            System.out.println("Error al hacer la conexión!");

        }
        
       
  
        

		
	}
	}
	
	
	
	
	
	
	
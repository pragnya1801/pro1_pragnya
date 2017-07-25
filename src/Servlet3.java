import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

/**
 * Created by priyadap on 7/23/2017.
 */
@WebServlet(name = "Servlet3")
public class Servlet3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        HttpSession session=request.getSession(false);

        final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        //final String DB_URL = "jdbc:mysql://127.0.0.1/STUD";
        final String DB_URL = "jdbc:mysql://localhost/STUD";

        //  Database credentials
        final String USER = "root";
        final String PASS = "CDKcdk11";
        boolean login =false;
        Connection conn = null;
        Statement stmt = null;
        try{

            //String n1= request.getParameter("uname");
            //String n2 = request.getParameter("pass");

            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection to database server
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            System.out.println("Creating statement...");
            String sql="select * from spareparts";
            stmt = conn.createStatement();


            ResultSet rs= stmt.executeQuery(sql);

            stmt.close();
            conn.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
        }//end try
        System.out.println("Done...");
    }
    }


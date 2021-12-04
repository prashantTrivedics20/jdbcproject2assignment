import java.sql.*;
import java.util.Scanner;

class DAOClass {
    public void insert() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "");
        PreparedStatement ps=con.prepareStatement("insert into assignment.table values(?,?,?,?,?)");
        Scanner readme=new Scanner(System.in);
        ps.setInt(1,readme.nextInt());
        ps.setString(2,readme.next());
        ps.setString(3,readme.next());
        ps.setString(4,readme.next());
        ps.setInt(5,readme.nextInt());
        ps.executeUpdate();
        System.out.println("value is inserted");
    }
    public void delete() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "");
        PreparedStatement ps=con.prepareStatement("delete from assignment.table where fee =4500");
        ps.executeUpdate();

        System.out.println("deleted");
    }
    public void modify() throws ClassNotFoundException, SQLException {
            Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "");
    PreparedStatement ps=con.prepareStatement("update assignment.table set fee=4500  ");
    ps.executeUpdate();

        System.out.println("updated");
    }
    public void display() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "");
        PreparedStatement ps=con.prepareStatement("insert into assignment.table values(?,?,?,?,?)");
        ResultSet rs=ps.executeQuery("select * from assignment.table");
        while(rs.next())
        {
            System.out.println(rs.getInt(1));
            System.out.println(rs.getString(2));
            System.out.println(rs.getString(3));
            System.out.println(rs.getString(4));
            System.out.println(rs.getInt(5));
        }

    }

}
class  JDBCCalls{
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        DAOClass obj=new DAOClass();
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "");
        Scanner readme=new Scanner(System.in);

        while(true)
        {
            System.out.println("Enter the number that which activity you want to perform");

            int n=readme.nextInt();
            if(n==1)
            {

                obj.insert();

            }
            if(n==2)
            {
                obj.delete();

            }
            if(n==3)
            {
                obj.modify();
            }
            if(n==4)
            {
                obj.display();
            }
            if(n>4)
            {
                break;
            }
        }
    }
}

import java.sql.*;

public class OracleTest {
    public static void main(String[] args) throws SQLException {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rajdatabase1", "root", "Sushmamylov@7");
//            String sql = "select * from persons" + "where City = '?'";
//            PreparedStatement stmt = con.prepareStatement(sql);
//            stmt.setString(1, "JHB");
            Statement stmt = con.createStatement();

        //parameterised statements
//        PreparedStatement pstmnt = con.prepareStatement("insert into persons values(?,?,?,?,?)");
//        pstmnt.setInt(1, 20);
//        pstmnt.setString(2, "Gali");
//        pstmnt.setString(3, "Soban");
//        pstmnt.setString(4, "Srunga");
//        pstmnt.setString(5, "Chipe");
            String s = "select * from persons where City = 'JHB'";
//            String s = "insert into persons values(5,'Saripalli','Anitha','SS Traders','NSP')";
        //pstmnt.executeUpdate();

            //String query = "select * from persons";
            ResultSet rs = stmt.executeQuery(s);
            while(rs.next()) {
//                String lastName = rs.getString("LastName");
//                String firstName = rs.getString("FirstName");
//                String address = rs.getString("Address");
//                String city = rs.getString("City");
                System.out.println(rs.getString(1));
                System.out.print(rs.getString(2) + " ");
                System.out.println(rs.getString(3));
                System.out.println(rs.getString(4));
                System.out.println(rs.getString(5));
            }
            con.close();
    }
}

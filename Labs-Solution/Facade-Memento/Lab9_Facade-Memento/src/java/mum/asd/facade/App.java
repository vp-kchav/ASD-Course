/*
 * Created on Jan 22, 2018
 */
package mum.asd.facade;


public class App {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String sql="SELECT * FROM <table> WHERE <column name> = ?";
        String sqlCall = "{call <stored procedure>( ?, ? )}";
        IConnection connection = new JDBCConnection();
        connection.execute(sql, sqlCall);

    }

}

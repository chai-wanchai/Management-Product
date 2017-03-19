
import java.sql.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;

public class ConnectDB {

    public static ArrayList<Integer> product_id = new ArrayList<Integer>();
    public static ArrayList<String> product_barcode = new ArrayList<String>();
    public static ArrayList<String> product_name = new ArrayList<String>();
    public static ArrayList<Integer> product_amount = new ArrayList<Integer>();
    public static ArrayList<Double> product_price = new ArrayList<Double>();
    public static String  test;
    public static String test(){
        return test;
    }
    public static Connection connectDB() {
        
        
        String db_name = "oop";
        String user = "root";
        String pass = "";
        String hostName = "localhost";
        String driverName = "com.mysql.jdbc.Driver";

        try {
            Class.forName(driverName);
            String url = "jdbc:mysql://" + hostName + "/" + db_name + "?useUnicode=true&characterEncoding=UTF-8";
            Connection con = DriverManager.getConnection(url, user, pass);
            
            return con;

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
            test=e.getMessage();
        } catch (NullPointerException a) {
            a.getMessage();
        }
        return null;
    }

    public static void showData(String sql) {
        product_id.clear();
        product_barcode.clear();
        product_name.clear();
        product_amount.clear();
        product_price.clear();
        try {
            Connection con = connectDB();
            ResultSet rs = con.createStatement().executeQuery(sql);

            while (rs.next()) {
                product_id.add(rs.getInt(1));
                product_barcode.add(rs.getString(2));
                product_name.add(rs.getString(3));
                product_amount.add(rs.getInt(4));
                product_price.add(rs.getDouble(5));

            }

            rs.close();
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }

    }

    public static void insertData(String sql) {
        
        try {
            Connection con = connectDB();
            Statement stm = con.createStatement();
            stm.executeUpdate(sql);
            System.out.println("save complete");
            stm.close();
            con.close();
            

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            test=e.getMessage();
            
        }

    }

    public static void updateData(String sql) {

        try {
            Connection con = connectDB();
            Statement stm = con.createStatement();
            stm.executeUpdate(sql);
            System.out.println("update complete");
            stm.close();
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            test=e.getMessage();
        }
    }

    public static void deleteData(int id) {
        String sql = "DELETE FROM products WHERE product_id='" + id + "'";
        try {
            Connection con = connectDB();
            Statement stm = con.createStatement();
            stm.executeUpdate(sql);
            System.out.println("delete complete");
            stm.close();
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            test=e.getMessage();
        }

    }

    public static DefaultTableModel showDataTable(String sql) {

        DefaultTableModel model = new DefaultTableModel();

        try {
            Connection con = ConnectDB.connectDB();
            ResultSet rs = con.createStatement().executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            int rowDB=rs.getRow();
            Object data[] = new Object[rowDB+10];
            String nameCol[] = new String[columnsNumber + 1];
            for (int i = 1; i <= columnsNumber; i++) {
                nameCol[i] = rsmd.getColumnName(i);
                model.addColumn(nameCol[i]);

            }

            while (rs.next()) {

                
                for (int i = 1; i <= columnsNumber; i++) {
                    int type = rsmd.getColumnType(i);
                    switch (type) {
                        case Types.VARCHAR:
                        case Types.CHAR:
                            data[i] = rs.getString(i);
                            data[i - 1] = data[i];
                            break;
                        case Types.INTEGER:
                            data[i] = rs.getInt(i);
                            data[i - 1] = data[i];
                            break;
                        case Types.DOUBLE:
                            data[i] = rs.getDouble(i);
                            data[i - 1] = data[i];
                            break;
                        default:
                            data[i] = rs.getString(i);
                            data[i - 1] = data[i];
                            break;
                    }

                }model.addRow(data);
                

            }

            
            return model;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            test=e.getMessage();
        }
        return model;

    }

}

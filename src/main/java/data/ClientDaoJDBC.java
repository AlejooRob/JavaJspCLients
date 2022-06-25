package data;

import domain.Client;
import java.sql.*;
import java.util.*;

public class ClientDaoJDBC {

    private static final String SQL_SELECT = "SELECT id_client, first_name, last_name, email, phone, saldo"
            + " FROM client ";
    private static final String SQL_SELECT_BY_ID = "SELECT id_client, first_name, last_name, email, phone, saldo"
            + " FROM client WHERE id_client=?";

    private static final String SQL_INSERT = "INSERT INTO client(first_name, last_name, email, phone, saldo)"
            + " VALUES(?, ?, ?, ?, ?)";

    private static final String SQL_UPDATE = "UPDATE client "
            + "SET first_name=?, last_name=?, email=?, phone=?, saldo=? WHERE id_client=?";

    private static final String SQL_DELETE = "DELETE FROM client WHERE id_client=?";

    public List<Client> list() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Client client = null;
        List<Client> clients = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idClient = rs.getInt("id_client");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                double balance = rs.getDouble("saldo");
                client = new Client(idClient, firstName, lastName, email, phone, balance);
                clients.add(client);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return clients;
    }

    public Client find(Client client) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, client.getIdClient());
            rs = stmt.executeQuery();
            rs.next();
            String firstName = rs.getString("first_name");
            String lastName = rs.getString("last_name");
            String email = rs.getString("email");
            String phone = rs.getString("phone");
            double balance = rs.getDouble("saldo");
            
            client.setFirstName(firstName);
            client.setLastName(lastName);
            client.setEmail(email);
            client.setPhone(phone);
            client.setBalance(balance);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return client;
    }
    
    public int insert(Client client) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, client.getFirstName());
            stmt.setString(2, client.getLastName());
            stmt.setString(3, client.getEmail());
            stmt.setString(4, client.getPhone());
            stmt.setDouble(5, client.getBalance());
            
            rows = stmt.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }
    
    public int update(Client client) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, client.getFirstName());
            stmt.setString(2, client.getLastName());
            stmt.setString(3, client.getEmail());
            stmt.setString(4, client.getPhone());
            stmt.setDouble(5, client.getBalance());
            stmt.setInt(6, client.getIdClient());
            
            rows = stmt.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }
    
    public int delete(Client client){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, client.getIdClient());
            
            rows = stmt.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

}

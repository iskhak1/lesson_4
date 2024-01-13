package project;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.sql.*;
import java.util.List;

public class Db {
    private static final String URL = "jdbc:mysql://localhost:3306";
    private static final String USER = "root";
    private static final String PASSWORD = "Admin1886!";
    public static void con(){
      Connector connector = new Connector();
      try(Session session = connector.getSession();){
//          List<Magic> books = session.createQuery("FROM Magic ",Magic.class).getResultList();
//          books.forEach(System.out::println);
//          Transaction t = session.beginTransaction();
//          List<Magic> magics = session.createQuery("from Magic ",Magic.class).getResultList();
//          magics.forEach(magic -> {
//              session.delete(magic);
//          });
//          t.commit();
      }catch(Exception e){
          e.printStackTrace();
      }


    }

}

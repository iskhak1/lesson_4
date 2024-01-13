package home;

import java.sql.*;

public class DB {
    private static final String URL = "jdbc:mysql://localhost:3306/myDB";
    private static final String USER = "root";
    private static final String PASSWORD = "Admin1886!";

    public void con(){
        try(Connection con = DriverManager
                .getConnection(URL,USER,PASSWORD);
            Statement stmt = con.createStatement();
            ){

            String table = "CREATE TABLE IF NOT EXISTS books" +
                    "(id int PRIMARY KEY AUTO_INCREMENT, name varchar(130)," +
                    "author varchar(130))";
            stmt.execute(table);

            String insertData = "INSERT INTO books(name,author)" +
                    "VALUES('Не вычеркивай меня из списка','Дина Рубина')," +
                    "('Путешествие в Элевсин','Виктор Пелевин')," +
                    "('Ловцы книг','Макс Фрай')," +
                    "('Дебютная постановка. Том 1','Александра Маринина')," +
                    "('Что случилось с климатом','Рамиз Алиев')," +
                    "('Кремулятор','Саша Филипенко')," +
                    "('Романовы. История великой династии','Марина Бандиленко')," +
                    "('Интерфейс: новые направления в','Джеф Раскин')," +
                    "('Человеческий фактор. Успешные проекты и...','Том Демарко')," +
                    "('Дневник «горячего башмака». Идеальная...','Джо Макнелли')";
//                    stmt.executeUpdate(insertData);

            ResultSet resultSet = stmt.executeQuery("SELECT * FROM books where author='Джеф Раскин'");
            while(resultSet.next()){
                System.out.println(resultSet.getString(2) + " "+ resultSet.getString(3));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        DB db = new DB();
        db.con();
    }
}

package home;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;


public class HibernateSessionFactoryUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/myDB";
    private static final String USER = "root";
    private static final String PASSWORD = "Admin1886!";

    private static SessionFactory sessionFactory;

    public  SessionFactory getSessionFactory(){
        if(sessionFactory == null){
            try{

                StandardServiceRegistryBuilder standardServiceRegistryBuilder = new StandardServiceRegistryBuilder();
                standardServiceRegistryBuilder.configure();
                final StandardServiceRegistry registry = standardServiceRegistryBuilder
                        .build();
                SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
                Session session = sessionFactory.openSession();
                session.beginTransaction();


                Book book1 = new Book("Не вычеркивай меня из списка","Дина Рубина");
                session.save(book1);
                Book book2 = new Book("Путешествие в Элевсин","Виктор Пелевин");
                session.save(book2);
                Book book3 = new Book("Ловцы книг","Макс Фрай");
                session.save(book3);
                Book book4 = new Book("Дебютная постановка. Том 1","Александра Маринина");
                session.save(book4);
                Book book5 = new Book("Что случилось с климатом","Рамиз Алиев");
                session.save(book5);
                Book book6 = new Book("Кремулятор","Саша Филипенко");
                session.save(book6);

                List<Book> list = session.createQuery("From Book", Book.class).getResultList();
                list.forEach(System.out::println);

                session.getTransaction().commit();
                session.close();

            } catch (HibernateException e) {
                System.out.println("Исключения! "+e);
            }
        }
        return sessionFactory;
    }

    public static void main(String[] args) {
       HibernateSessionFactoryUtil hibernateSessionFactoryUtil =
               new HibernateSessionFactoryUtil();
       hibernateSessionFactoryUtil.getSessionFactory();
    }


}

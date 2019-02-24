package ua.kiev.prog.jpa.sessionhib;

import org.hibernate.HibernateException;

import com.mysql.jdbc.SQLError;

import ua.kiev.prog.jpa.sample1.SimpleClient;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/*
    Создать в БД (в ручную) 5 клиентов
    В приложении:
    1. Получить из базы и вывести на экран всех
    2. Поменять имя клиенту с id 3
    3. Удалить клиента с id 4
    4. Добавить 2х клиентов в группу и вывести всех клиентов из группы на экран
 */
public class App {
    static EntityManagerFactory emf;
    static EntityManager em;

    public static void main(String[] args) {
//        m0();
        m1();
    }

	private static void m0() {
		Scanner sc = new Scanner(System.in);
		
        try {
            // create connection
            emf = Persistence.createEntityManagerFactory("JPAExample1");
            em = emf.createEntityManager();
            if (em == null) {
				throw new SQLException();
			}
            SimpleClient simpleClient = em.find(SimpleClient.class, 1L);
            System.out.println(simpleClient);
        } catch (HibernateException ex) {
            ex.printStackTrace();
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
            em.close();
            emf.close();
        }
	}
    
    public static void m1() {
        try {
            // create connection
            emf = Persistence.createEntityManagerFactory("JPAExample1");
            em = emf.createEntityManager();
//            SimpleClient simpleClient = (SimpleClient)em.createNativeQuery("SELECT * FROM mydb.SimpleClient where id = 1", SimpleClient.class).getSingleResult();
//            List<SimpleClient> simpleClients = em.createNativeQuery("SELECT * FROM mydb.SimpleClient where id > 0", SimpleClient.class).getResultList();
            List<SimpleClient> simpleClients = em.createQuery("SELECT * FROM mydb.SimpleClient where id > 0", SimpleClient.class).getResultList();
//            SimpleClient simpleClient = (SimpleClient)em.createNativeQuery("SELECT * FROM mydb.SimpleClient where id = 1", SimpleClient.class).getSingleResult();
            simpleClients.forEach(System.out::println);
        } catch (HibernateException ex) {
            ex.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
	}
}

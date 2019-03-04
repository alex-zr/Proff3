package ua.kiev.prog.jpa.sessionhib;

import org.hibernate.HibernateException;
import ua.kiev.prog.jpa.sample1.SimpleClient;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Random;
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
        Scanner sc = new Scanner(System.in);
        try {
            // create connection
            emf = Persistence.createEntityManagerFactory("JPAExample1");
            em = emf.createEntityManager();
            for (int i = 1; i < 6; i++) {
                SimpleClient simpleClient = em.find(SimpleClient.class, (long) i);
                System.out.println(simpleClient);
            }
            SimpleClient toRename = em.find(SimpleClient.class, 3L);
            em.getTransaction().begin();
            toRename.setName(String.valueOf(new Random().nextInt()));
            em.getTransaction().commit();
        } catch (HibernateException ex) {
            ex.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}

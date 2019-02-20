package JPA.Task1;

import org.hibernate.HibernateException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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
            for(Long i = 1L; i<=5; i++) {
                SimpleClient simpleClient = em.find(SimpleClient.class, (Long)i);
                System.out.println(simpleClient);
            }
        } catch (HibernateException ex) {
            ex.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}

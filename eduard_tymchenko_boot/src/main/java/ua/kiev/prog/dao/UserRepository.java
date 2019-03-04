package ua.kiev.prog.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.kiev.prog.domain.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /*@Query("SELECT u FROM User u WHERE u.login = :login")
    User findOne(User user)

    public Long addUser(String login, String pass){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        Long userId = null;

        try {
            transaction = session.beginTransaction();

            User user = new User(login, pass);
            userId = (Long) session.save(user);

            transaction.commit();
        }catch (Exception e){

            if(transaction !=null) {
                transaction.rollback();
                e.printStackTrace();
            }
        }finally {
            session.close();
            sessionFactory.close();
        }


        return  userId;

    }*/

}
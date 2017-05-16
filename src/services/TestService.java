package services;

import entities.Question;
import entities.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TestService {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
    EntityManager entityManager = emf.createEntityManager();

    public void addTest(String title, LocalDate startDate, LocalDate endDate, int time, boolean selfCorrecting, boolean showResult){
        Test test =  new Test();

        List questionList = new ArrayList<Question>();

        test.setQuestionList(questionList);
        test.setTitle(title);
        test.setStartDate(startDate);
        test.setEndDate(endDate);
        test.setTime(time);
        test.setSelfCorrecting(selfCorrecting);
        test.setShowResult(showResult);


        entityManager.getTransaction().begin();
        entityManager.persist(test);
        entityManager.getTransaction().commit();

        entityManager.close();
        emf.close();
    }

<<<<<<< HEAD
=======
    public List<Test> getTest() {

        try {
            TypedQuery<Test> query = entityManager.createQuery("SELECT t FROM Test t", Test.class);

            return query.getResultList();

        } catch (NoResultException ex) {
            return null;

        }
    }
>>>>>>> origin/master
}

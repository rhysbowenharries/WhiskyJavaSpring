package com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

public class DistilleryRepositoryImpl implements DistilleryRepositoryCustom {

    @Autowired
    EntityManager entityManager;

    @Override
    @Transactional
    public List<Distillery> getDistilleryByWhiskyAge(int age){
        List<Distillery> result = null;

        Session session = entityManager.unwrap(Session.class);
        Criteria cr = session.createCriteria(Distillery.class);
        cr.createAlias("whiskies", "whiskyAlias");
        cr.add(Restrictions.eq("whiskyAlias.age", age));
        result = cr.list();

        return result;
    }
}

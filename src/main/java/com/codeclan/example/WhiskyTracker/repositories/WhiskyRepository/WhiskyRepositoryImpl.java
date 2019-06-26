package com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;


import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

public class WhiskyRepositoryImpl implements WhiskyRepositoryCustom {

    @Autowired
    EntityManager entityManager;

    @Override
    @Transactional
    public List<Whisky> getWhiskyFromDistilleryOfCertainAge(int age, String name){
        List<Whisky> result = null;

        Session session = entityManager.unwrap(Session.class);
        Criteria cr = session.createCriteria(Whisky.class);
        cr.add(Restrictions.eq("age", age));
        cr.createAlias("distillery", "distilleryAlias");
        cr.add(Restrictions.eq("distilleryAlias.name", name));
        result = cr.list();

        return result;
    }

    @Transactional
    public List<Whisky> getWhiskyByRegion(String region){
        List<Whisky> result = null;

        Session session = entityManager.unwrap(Session.class);
        Criteria cr = session.createCriteria(Whisky.class);
        cr.createAlias("distillery", "distilleryAlias");
        cr.add(Restrictions.eq("distilleryAlias.region", region));
        result = cr.list();

        return result;
    }

//
}

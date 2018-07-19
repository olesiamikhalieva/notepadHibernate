package com.dao;

import com.entity.Notepad;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Repository
@Transactional
public class NotepadDaoImpl implements NotepadDao {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List<Notepad> notepadList() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("from Notepad");
        return query.list();
    }

    @Override
    public void add(Notepad notepad) {
        sessionFactory.getCurrentSession().save(notepad);
    }

    @Override
    public void delete(Notepad notepad) {
        sessionFactory.getCurrentSession().delete(notepad);
    }
}

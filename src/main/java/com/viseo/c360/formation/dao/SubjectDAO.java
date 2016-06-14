package com.viseo.c360.formation.dao;

import com.viseo.c360.formation.domain.skills.Subject;
import com.viseo.c360.formation.exceptions.SkillException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class SubjectDAO {

    @PersistenceContext
    EntityManager em;

    @Transactional
    public List<Subject> getAllSubjects() {
        em.setFlushMode(FlushModeType.COMMIT);
        return em.createQuery("Select s from Subject s left outer join fetch s.closeSubjects", Subject.class).getResultList();
    }

    @Transactional
    public Subject createSubject(Subject subject) {
        return em.merge(subject);
    }

    @Transactional
    public void removeSubject(Subject subject) {
        subject = em.merge(subject);
        if (subject.getCloseSubjects().isEmpty()) {
            em.remove(subject);
        } else {
            throw new SkillException("Only isolated subject may be removed");
        }
    }

    @Transactional
    public void addCloseSubjects(Subject subject1, Subject subject2) {
        subject1 = em.merge(subject1);
        subject2 = em.merge(subject2);
        if (!subject1.getCloseSubjects().contains(subject2)) {
            subject1.addCloseSubject(subject2);
        }
    }

    @Transactional
    public void removeCloseSubjects(Subject subject1, Subject subject2) {
        subject1 = em.merge(subject1);
        subject2 = em.merge(subject2);
        if (subject1.getCloseSubjects().contains(subject2)) {
            subject1.removeCloseSubject(subject2);
        }
    }
}

package by.teachmeskills.lesson39.dao.impl;

import by.teachmeskills.lesson39.dao.PictureDao;
import by.teachmeskills.lesson39.entity.Picture;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JpaPictureDao implements PictureDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Picture> getAll() {
        return entityManager.createQuery("FROM Picture p", Picture.class).getResultList();
    }

    @Override
    public Optional<Picture> getById(Long id) {
        return Optional.ofNullable(entityManager.find(Picture.class, id));
    }

    @Override
    public Picture save(Picture picture) {
        entityManager.persist(picture);
        return picture;
    }

    @Override
    public Picture update(Picture picture) {
        entityManager.merge(picture);
        return picture;
    }

    @Override
    public void delete(Long id) {
        entityManager.createQuery("DELETE Picture WHERE id = :id")
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    public boolean existsById(Long id) {
        return getById(id).isPresent();
    }
}

//package by.teachmeskills.lesson39.dao.impl;
//
//import by.teachmeskills.lesson39.dao.PictureDao;
//import by.teachmeskills.lesson39.entity.Picture;
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaDelete;
//import javax.persistence.criteria.Root;
//import lombok.RequiredArgsConstructor;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//import java.util.Optional;
//
//@Transactional
//@Repository
//@RequiredArgsConstructor
//public class HibernatePictureDao implements PictureDao {
//
//    private final SessionFactory sessionFactory;
//
//    @Override
//    public List<Picture> getAll() {
//        Session currentSession = sessionFactory.getCurrentSession();
//        return currentSession.createQuery("SELECT p FROM Picture p", Picture.class).getResultList();
//    }
//
//    @Override
//    public Optional<Picture> getById(Long id) {
//        Session currentSession = sessionFactory.getCurrentSession();
//        return Optional.ofNullable(currentSession.get(Picture.class, id));
//    }
//
//    @Override
//    public Picture save(Picture picture) {
//        Session currentSession = sessionFactory.getCurrentSession();
//        Long id = (Long) currentSession.save(picture);
//        picture.setId(id);
//        return picture;
//    }
//
//    @Override
//    public Picture update(Picture picture) {
//        Session currentSession = sessionFactory.getCurrentSession();
//        currentSession.update(picture);
//        return picture;
//    }
//
//    @Override
//    public void delete(Long id) {
//        Session currentSession = sessionFactory.getCurrentSession();
//        CriteriaBuilder builder = currentSession.getCriteriaBuilder();
//        CriteriaDelete<Picture> criteriaDelete = builder.createCriteriaDelete(Picture.class);
//        Root<Picture> root = criteriaDelete.from(Picture.class);
//        criteriaDelete.where(builder.equal(root.get("id"), id));
//        currentSession.createQuery(criteriaDelete).executeUpdate();
//    }
//
//    @Override
//    public boolean existsById(Long id) {
//        return getById(id).isPresent();
//    }
//}

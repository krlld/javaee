package com.example.boot.dao.impl;

import com.example.boot.dao.PictureDao;
import com.example.boot.domain.Picture;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class InMemoryPictureDao implements PictureDao {

    private static final AtomicLong counter = new AtomicLong();

    private final Map<Long, Picture> pictures = new ConcurrentHashMap<>();

    @Override
    public List<Picture> getAll() {
        return List.copyOf(pictures.values().stream()
                .map(Picture::new).toList());
    }

    @Override
    public Optional<Picture> getById(Long id) {
        if (!existsById(id)) {
            return Optional.empty();
        }
        return Optional.of(new Picture(pictures.get(id)));
    }

    @Override
    public Picture save(Picture picture) {
        picture.setId(counter.incrementAndGet());
        pictures.put(picture.getId(), new Picture(picture));
        return picture;
    }

    @Override
    public Picture update(Picture picture) {
        pictures.put(picture.getId(), new Picture(picture));
        return picture;
    }

    @Override
    public void delete(Long id) {
        pictures.remove(id);
    }

    @Override
    public boolean existsById(Long id) {
        return pictures.containsKey(id);
    }
}

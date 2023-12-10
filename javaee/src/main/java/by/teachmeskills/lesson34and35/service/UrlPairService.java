package by.teachmeskills.lesson34and35.service;

import by.teachmeskills.lesson34and35.dao.UrlPairDao;
import by.teachmeskills.lesson34and35.domain.UrlPair;

import java.util.Optional;

public class UrlPairService {

    private final UrlPairDao urlPairDao = new UrlPairDao();

    public void save(UrlPair urlPair) {
        if (urlPair.url() == null || urlPair.url().isBlank()) {
            throw new IllegalArgumentException("Incorrect url");
        }
        if (urlPair.alias() == null || urlPair.alias().isBlank()) {
            throw new IllegalArgumentException("Incorrect alias");
        }
        urlPairDao.save(urlPair);
    }

    public UrlPair findByAlias(String alias) {
        if (alias == null || alias.isBlank()) {
            throw new IllegalArgumentException("Incorrect alias");
        }
        Optional<UrlPair> urlPair = urlPairDao.findByAlias(alias);
        if (urlPair.isEmpty()) {
            throw new IllegalArgumentException("Url pair not found");
        }
        return urlPair.get();
    }
}

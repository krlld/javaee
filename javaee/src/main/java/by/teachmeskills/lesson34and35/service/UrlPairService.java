package by.teachmeskills.lesson34and35.service;

import by.teachmeskills.lesson34and35.dao.UrlPairDao;
import by.teachmeskills.lesson34and35.domain.UrlPair;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UrlPairService {

    private final UrlPairDao urlPairDao;

    public void save(UrlPair urlPair) {
        if (urlPair.url() == null || urlPair.url().isBlank()) {
            log.warn("Passing incorrect url: " + urlPair.url());
            throw new IllegalArgumentException("Incorrect url");
        }
        if (urlPair.alias() == null || urlPair.alias().isBlank()) {
            log.warn("Passing incorrect alias: " + urlPair.alias());
            throw new IllegalArgumentException("Incorrect alias");
        }
        urlPairDao.save(urlPair);
    }

    public UrlPair findByAlias(String alias) {
        if (alias == null || alias.isBlank()) {
            log.warn("Passing incorrect alias: " + alias);
            throw new IllegalArgumentException("Incorrect alias");
        }
        Optional<UrlPair> urlPair = urlPairDao.findByAlias(alias);
        if (urlPair.isEmpty()) {
            log.warn("Url with " + alias + " alias not found");
            throw new IllegalArgumentException("Url pair not found");
        }
        return urlPair.get();
    }
}

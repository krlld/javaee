package by.teachmeskills.lesson31.decorator;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class BaseDataSourceDecorator implements DataSource {

    @Getter
    private final DataSource dataSource;
}

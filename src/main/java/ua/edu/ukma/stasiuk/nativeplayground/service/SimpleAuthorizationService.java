package ua.edu.ukma.stasiuk.nativeplayground.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SimpleAuthorizationService {
    protected static final Logger logger = LogManager.getLogger();
    private final Boolean isAuthorizedValue;

    public SimpleAuthorizationService(@Value("#{T(java.lang.Boolean).TRUE}") Boolean isAuthorizedValue) {
        this.isAuthorizedValue = isAuthorizedValue;
    }

    public boolean isAuthorized() {
        logger.info("isAuthorized invoked, returning", isAuthorizedValue);
        return isAuthorizedValue;
    }
}

package config;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class EntityManagerUtil {
    private static EntityManagerFactory EMF;
    public static EntityManagerFactory getEntityManagerFactory() {
        if (EMF == null) {
            EMF = Persistence.createEntityManagerFactory("AppMuseeServerPU");
        }
        return EMF;
    }

    public static void closeEntityManagerFactory() {
        if (EMF != null && EMF.isOpen()) {
            EMF.close();
        }
    }
}





package hu.unideb.inf.moneyhaus.converter;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

/**
 * This converter maps objects by their field names. It can be used for any type
 * of object mapping.
 *
 */
public class GenericConverter {

    /**
     * Logger.
     */
    private static final Logger logger = LoggerFactory.getLogger(GenericConverter.class);
    /**
     * Dozer mapper.
     */
    private static final Mapper mapper = new DozerBeanMapper();

    /**
     * Map an object. <br> Both classes must implement setters/getters for the
     * mapped fields. If a field is not accessable the target instance will
     * contain {@code null} as a value.
     *
     * @param <T> the class to map from
     * @param <U> the class to map to
     * @param entity the instance of T to map from
     * @param clazz the class file to map to
     * @return an instance of U with the values of {@code entity}<br>
     */
    public static <T extends Object, U> U mapTo(T entity, Class<U> clazz) {
        if (entity == null) {
            return null;
        } else {
            logger.info("Converting POJO " + entity.getClass().getName() + " to " + clazz.getName());
            return mapper.map(entity, clazz);
        }
    }

    /**
     * Map objects. <br> Both classes must implement setters/getters for the
     * mapped fields. If a field is not accessable the target instances will
     * contain {@code null} as a value.
     *
     * @param <T> the class to map from
     * @param <U> the class to map to
     * @param entities the instances of T to map from
     * @param clazz the class file to map to
     * @return an instances of U with the values of {@code entity}<br>
     */
    public static <T, U> List<U> mapTo(List<T> entities, Class<U> clazz) {
        List<U> result = new ArrayList<>();
        for (T entity : entities) {
            result.add(mapTo(entity, clazz));
        }
        return result;
    }

}

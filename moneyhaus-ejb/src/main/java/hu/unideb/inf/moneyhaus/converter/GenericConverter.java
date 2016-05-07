package hu.unideb.inf.moneyhaus.converter;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

public class GenericConverter {

    private static Mapper mapper = new DozerBeanMapper();

    public static <T, U> U mapTo(T entity, Class<U> clazz) {
        if (entity == null) {
            return null;
        } else {
            return mapper.map(entity, clazz);
        }
    }

    public static <T, U> List<U> mapTo(List<T> entities, Class<U> clazz) {
        List<U> result = new ArrayList<>();
        for (T entity : entities) {
            result.add(mapTo(entity, clazz));
        }
        return result;
    }

    public static <T, U> U mapTo(T entity, Class<U> clazz, String context) {
        if (entity == null) {
            return null;
        } else {
            return mapper.map(entity, clazz, context);
        }
    }

    public static <T, U> List<U> mapTo(List<T> entities, Class<U> clazz, String context) {
        List<U> result = new ArrayList<>();
        for (T entity : entities) {
            result.add(mapTo(entity, clazz, context));
        }
        return result;
    }
}

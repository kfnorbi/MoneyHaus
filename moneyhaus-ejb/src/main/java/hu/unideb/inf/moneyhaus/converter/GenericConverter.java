package hu.unideb.inf.moneyhaus.converter;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

public class GenericConverter {

    private static final Logger logger = LoggerFactory.getLogger(GenericConverter.class);
    
    private static final Mapper mapper = new DozerBeanMapper();

    public static <T extends Object, U> U mapTo(T entity, Class<U> clazz) {
        if (entity == null) {
            return null;
        } else {
            logger.debug("Converting POJO " + entity.getClass().getName() + " to " + clazz.getName());
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

    public static <T, U> U mapTo(T entity, Class<U> clazz, String mappingId) {
        if (entity == null) {
            return null;
        } else {
            return mapper.map(entity, clazz, mappingId);
        }
    }

    public static <T, U> List<U> mapTo(List<T> entities, Class<U> clazz, String mappingId) {
        List<U> result = new ArrayList<>();
        for (T entity : entities) {
            result.add(mapTo(entity, clazz, mappingId));
        }
        return result;
    }
}

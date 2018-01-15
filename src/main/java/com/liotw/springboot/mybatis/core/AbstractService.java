package com.liotw.springboot.mybatis.core;


import org.apache.ibatis.exceptions.TooManyResultsException;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Condition;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * 基于通用MyBatis Mapper插件的Service接口的实现
 * @author jiangjialiang on 2017/12/25
 * @version 3.0.0
 */
public abstract class AbstractService<T, DTO extends T, PK> implements Service<T, DTO, PK> {

    @Autowired
    protected Mapper<T> mapper;

    private Class<T> domainClass;    // 当前泛型真实类型的Class

    public AbstractService() {
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        domainClass = (Class<T>) pt.getActualTypeArguments()[0];
    }

    public void save(T domain) {
        mapper.insertSelective(domain);
    }

    public void save(List<T> domains) {
        mapper.insertList(domains);
    }

    public void deleteById(PK id) {
        mapper.deleteByPrimaryKey(id);
    }

    public void deleteByIds(String ids) {
        mapper.deleteByIds(ids);
    }

    public void update(T domain) {
        mapper.updateByPrimaryKeySelective(domain);
    }

    public T findById(PK id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public T findBy(String fieldName, Object value) throws TooManyResultsException {
        try {
            T domain = domainClass.newInstance();
            Field field = domainClass.getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(domain, value);
            return mapper.selectOne(domain);
        } catch (ReflectiveOperationException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public List<T> findByIds(String ids) {
        return mapper.selectByIds(ids);
    }

    public List<T> findByCondition(Condition condition) {
        return mapper.selectByCondition(condition);
    }

    public List<T> findAll() {
        return mapper.selectAll();
    }
}

package com.cinema_ticketing_sys.support.base;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.ResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by huitianrui on 2017/5/11.
 */
public abstract class BaseDAOImpl<T> implements BaseDAO<T> {

    private final static Logger logger = Logger.getLogger(BaseDAOImpl.class);

    @Autowired
    protected SessionFactory sessionFactory;

    protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    /**
     * 添加或修改对象
     *
     * @param t
     */
    @Override
    public void save(T t) {
        getCurrentSession().save(t);
    }

    /**
     * 根据主键获取对象
     *
     * @param id
     * @return
     */
    @Override
    public T get(Serializable id) {
        return (T) getCurrentSession().get(getEntityClass(), id);
    }

    /**
     * 删除实体
     * @param entity
     */
    public void delete(T entity) {
        getCurrentSession().delete(entity);
    }

    /**
     * 根据ID删除实体
     * @param entityClazz
     * @param id
     */
    public void delete(Class<T> entityClazz , Serializable id)
    {
        getCurrentSession()
                .createQuery("delete " + entityClazz.getSimpleName()
                        + " en where en.id = ?1")
                .setParameter("1" , id)
                .executeUpdate();
    }

    /**
     * 获取全部对象
     *
     * @return
     */
    @Override
    public List<T> findAll() {
        Criteria c = getCurrentSession().createCriteria(getEntityClass());
        List all = null;
        try {
            all = c.list();
        } catch (Exception e) {
            logger.error("BaseHibernateDAO#findAll() throw a exception", e);
            return null;
        }
        return all;
    }

    /**
     * 获取实体总数
     * @param entityClazz 实体类型
     * @return 实体总数
     */
    public long findCount(Class<T> entityClazz)
    {
        List<?> l = find("select count(*) from "
                + entityClazz.getSimpleName());
        // 返回查询得到的实体总数
        if (l != null && l.size() == 1 )
        {
            return (Long) l.get(0);
        }
        return 0;
    }

    /**
     * 根据分页参数获取对象
     *
     * @param pageNo 查询第几页
     * @param pageSize 每页显示的行数
     * @return
     */
    @Override
    public List<T> findByPage(Integer pageNo, Integer pageSize) {
        Criteria c = getCurrentSession().createCriteria(getEntityClass());
        // 执行分页
        c.setFirstResult((pageNo - 1) * pageSize);
        c.setMaxResults(pageSize);
        return c.list();
    }


    /**
     * 根据属性名和值获取唯一的对象
     *
     * @param propertyName 类属性名（非数据库列名）
     * @param value
     * @return
     */
    @Override
    public T findByUnique(String propertyName, Object value) {
        Criteria c = getCurrentSession().createCriteria(getEntityClass());
        c.add(Restrictions.eq(propertyName, value));
        return (T) c.uniqueResult();
    }

    /**
     * 根据属性名和值获取对象集合
     *
     * @param propertyName 类属性名（非数据库列名）
     * @param value
     * @return
     */
    @Override
    public List<T> findBy(String propertyName, Object value) {
        Criteria c = getCurrentSession().createCriteria(getEntityClass());
        c.add(Restrictions.eq(propertyName, value));
        return c.list();
    }

    /**
     * 根据HQL获取对象集合
     *
     * @param hql
     * @param args
     * @return
     */
    @Override
    public List<T> find(String hql, Object... args) {
        return createQuery(getCurrentSession(), hql, args).list();
    }

    /**
     * 根据HQL获取对象集合 HQL使用的是引用占位符
     *
     * @param hql
     * @param map
     * @return
     */
    @Override
    public List<T> find(String hql, Map<String, Object> map) {
        return createQuery(getCurrentSession(), hql, map).list();
    }

    /**
     * 根据HQL获取唯一对象
     *
     * @param hql
     * @param args
     * @return
     */
    @Override
    public T findUnique(String hql, Object... args) {
        return (T) createQuery(getCurrentSession(), hql, args).uniqueResult();
    }

    /**
     * 根据HQL获取唯一对象 HQL使用的是引用占位符
     *
     * @param hql
     * @param map
     * @return
     */
    @Override
    public T findUnique(String hql, Map<String, Object> map) {
        return (T) createQuery(getCurrentSession(), hql, map).uniqueResult();
    }

    /**
     * 根据Criterion列表获取集合对象
     *
     * @param criterions
     * @return
     */
    @Override
    public List<T> find(Criterion... criterions) {
        return createCriteria(getCurrentSession(), getEntityClass(), criterions).list();
    }

    /**
     * 根据Criterion列表获取唯一对象
     *
     * @param criterions
     * @return
     */
    public T findUnique(Criterion... criterions) {
        return (T) createCriteria(getCurrentSession(), getEntityClass(), criterions).uniqueResult();
    }

    /**
     * 获取当前结果的记录数(工具方法)
     *
     * @param c
     * @return
     */
    private static Long findCountByCriteria(Criteria c) {

        @SuppressWarnings("static-access")
        ResultTransformer t = c.ROOT_ENTITY;

        c.setProjection(Projections.rowCount());
        Long result = (Long) c.uniqueResult();

        c.setProjection(null);
        c.setResultTransformer(t);

        return result != null ? result : 0;
    }

    /**
     * 根据Condition对象构建Criterion对象(工具方法)
     *
     * @param condition
     * @return
     */
    private Criterion builderCriterionByCondition(Condition condition) {
        if (condition != null) {
            ConditionType conditionType = condition.getConditionType();
            String property = condition.getProperty();
            Object value = condition.getValue();
            return builderCriterionByCondition(conditionType, property, value);
        }
        return null;
    }

    /**
     * 根据比较类型、属性名和值构建Criterion对象(工具方法)
     *
     * @param conditionType 比较类型
     * @param property
     * @param value
     * @return
     */
    public static Criterion builderCriterionByCondition(ConditionType conditionType, String property, Object value) {
        if (conditionType.getOp().equalsIgnoreCase("eq")) {
            return Restrictions.eq(property, value);
        } else if (conditionType.getOp().equalsIgnoreCase("ge")) {
            return Restrictions.ge(property, value);
        } else if (conditionType.getOp().equalsIgnoreCase("gt")) {
            return Restrictions.gt(property, value);
        } else if (conditionType.getOp().equalsIgnoreCase("le")) {
            return Restrictions.le(property, value);
        } else if (conditionType.getOp().equalsIgnoreCase("lt")) {
            return Restrictions.lt(property, value);
        } else if (conditionType.getOp().equalsIgnoreCase("like")) {
            return Restrictions.like(property, value.toString(), MatchMode.ANYWHERE);
        }
        return null;
    }


    /**
     * 根据Criterion列表构建Criteria对象(工具方法)
     *
     * @param criterions
     * @return
     */
    public static <T> Criteria createCriteria(Session session, Class<T> entityClass, Criterion... criterions) {
        Criteria c = session.createCriteria(entityClass);
        for (Criterion cri : criterions) {
            c.add(cri);
        }
        return c;
    }

    /**
     * 根据HQL及参数构建Query对象(工具方法)
     *
     * @param hql
     * @param args
     * @return
     */
    public static Query createQuery(Session session, String hql, Object... args) {
        Query query = session.createQuery(hql);
        for (int i = 0; i < args.length; i++) {
            query.setParameter(i, args[i]);
        }
        return query;
    }

    /**
     * 根据HQL及参数构建Query对象(工具方法)
     *
     * @param hql
     * @param map
     * @return
     */
    public static Query createQuery(Session session, String hql, Map<String, Object> map) {
        Query query = session.createQuery(hql);
        query.setProperties(map);
        return query;
    }

    protected abstract Class<T> getEntityClass();

    /**
     * 比较类型
     */
    public static enum ConditionType {

        EQ("eq"),
        LIK("like"),
        GT("gt"),
        GE("ge"),
        LT("lt"),
        LE("le");

        private String op;

        ConditionType(String op) {
            this.op = op;
        }

        public String getOp() {
            return op;
        }
    }


    public static class Condition {
        private ConditionType conditionType;
        private String property;
        private Object value;

        public Condition() {
        }

        public Condition(ConditionType conditionType, String property, Object value) {
            this.conditionType = conditionType;
            this.property = property;
            this.value = value;
        }

        public ConditionType getConditionType() {
            return conditionType;
        }

        public void setConditionType(ConditionType conditionType) {
            this.conditionType = conditionType;
        }

        public String getProperty() {
            return property;
        }

        public void setProperty(String property) {
            this.property = property;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }
    }

}

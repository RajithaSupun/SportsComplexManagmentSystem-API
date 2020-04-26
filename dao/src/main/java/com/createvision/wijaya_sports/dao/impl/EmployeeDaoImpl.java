package com.createvision.wijaya_sports.dao.impl;


import com.createvision.wijaya_sports.dao.EmployeeDao;
import com.createvision.wijaya_sports.model.Employee;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("employeeDao")
public class EmployeeDaoImpl extends AbstractDaoImpl<Employee, Long> implements EmployeeDao {
    @Override
    public List<Employee> getAllEmployee() throws Exception {
        Session session = getSession();
        Criteria criteria = session.createCriteria(Employee.class, "employee");
        criteria.add(Restrictions.eq("employee.isDelete", false));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<Employee> result = criteria.list();
        return result;
    }
}

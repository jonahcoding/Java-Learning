package com.shinrin.dao;

import com.shinrin.pojo.Department;
import com.shinrin.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class EmployeeDao {

    //模拟数据库中的数据
    private static Map<Integer, Employee> employees = null;
    //员工所属的部门
    @Autowired
    private DepartmentDao departmentDao;

    static {
        employees = new HashMap<Integer, Employee>();

        employees.put(1001,new Employee(1001,"A","a123@qq.com",0,new Department(101,"教学部")));
        employees.put(1002,new Employee(1002,"B","b123@qq.com",1,new Department(101,"教研部")));
        employees.put(1003,new Employee(1003,"C","c123@qq.com",0,new Department(101,"市场部")));
        employees.put(1004,new Employee(1004,"D","d123@qq.com",1,new Department(101,"运营部")));
        employees.put(1005,new Employee(1005,"E","e123@qq.com",0,new Department(101,"后勤部")));

    }

    //主键自增
    private static Integer initId = 1006;
    //增加一个员工
    public void save(Employee employee){
        if (employee.getId() == null){
            employee.setId(initId++);
        }

        employee.setDepartment(departmentDao.getDepartmentById(employee.getId()));
        employees.put(employee.getId(), employee);
    }

    //获得所有部门信息
    public Collection<Employee> getAll(){
        return employees.values();
    }

    //通过id得到部门
    public  Employee getEmployeeById(Integer id){
        return employees.get(id);
    }

    //通过ID删除员工
    public void delete(Integer id){
        employees.remove(id);
    }

}

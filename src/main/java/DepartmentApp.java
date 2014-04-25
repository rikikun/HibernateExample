
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import com.hibernate.annotation.entity.Department;
import com.hibernate.annotation.entity.Employee;

public class DepartmentApp {
	static Configuration config;
	SessionFactory factory;

	public DepartmentApp() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		config = new Configuration().configure("hibernate1.cfg.xml");
		config.addAnnotatedClass(Department.class).addAnnotatedClass(
				Employee.class);
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();
		// new schema = create drop
		// new SchemaExport(config).create(true, true);
		DepartmentApp a = new DepartmentApp();
		a.querywithNameQuery();
		// Department dp = (Department) session.get(Department.class, 1);
		// List<Employee> list=dp.getEmployeelist();
		// for(Employee em:list){
		// System.out.println(em.getId()+" : "+em.getFirstName() +" : " );
		// }
		// System.out.println(list.size());
		// a.departQuery(5);
		// a.departCriteria(4);
		// a.addDepartment(new Department("IT"));
		// a.addDepartment(new Department("HR"));

		//
		// SessionFactory factory = config.buildSessionFactory();
		// Session session = factory.openSession();
		// Transaction tx = null;
		// tx = session.beginTransaction();
		// tx.begin();
		// Department department = new Department("IT");
		// session.save(department);
		// tx.commit();
		// tx = session.beginTransaction();
		// tx.begin();
		// Department department1 = new Department("HR");
		// session.save(department1);
		// tx.commit();
		// //department.setDepartmentName("HR");
		// //session.save(department);
		// //tx.commit();
		// session.close();
	}

	private void querywithNameQuery() {
		// TODO Auto-generated method stub
		// session =factory.openSession();
		//
		// List<Employee> em=session.getNamedQuery("aa.findAll").list();
		// display(em);
	}

	public void addDepartment(Department department) {
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		tx = session.beginTransaction();
		tx.begin();
		session.save(department);
		tx.commit();
		session.close();
	}

	public void departQuery(int id) {
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();
		String hql = "FROM Department dp WHERE dp.departmentId = :dpname";
		List<Department> results = session.createQuery(hql)
				.setParameter("dpname", id).list();
		for (Department gg : results) {
			System.out.println(gg.getDepartmentId() + ":"
					+ gg.getDepartmentName());
		}
		for (Iterator it = results.iterator(); it.hasNext();) {
			Department dp = (Department) it.next();
			System.out.println(dp.getDepartmentId() + ":"
					+ dp.getDepartmentName());
		}
		session.close();
	}

	public void departCriteria(int id) {
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();
		Criteria cr = session.createCriteria(Department.class);
		List<Department> results = cr.list();
		for (Department dp : results) {
			System.out.println(dp.getDepartmentId() + ":"
					+ dp.getDepartmentName());
		}
		session.close();
	}
}

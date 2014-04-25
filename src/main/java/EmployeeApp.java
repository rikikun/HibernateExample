import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import com.hibernate.annotation.entity.Department;
import com.hibernate.annotation.entity.Employee;
import com.hibernate.annotation.util.PrePersistIntercepter;

public class EmployeeApp {
	private SessionFactory factory;
	private Session session;

	public EmployeeApp() {
		// TODO Auto-generated constructor stub
		Configuration config = new Configuration()
				.configure("hibernate1.cfg.xml");
		config.addAnnotatedClass(Employee.class)
		.addAnnotatedClass(Department.class)
		.setInterceptor(new PrePersistIntercepter());
//		new SchemaExport(config).create(true, true);
		factory = config.buildSessionFactory();
	}

	public static void main(String args[]) {
		EmployeeApp a = new EmployeeApp();
		Department dp = new Department();
//		a.deleteEm(2);
//		a.querywithNameQuery();
//		dp.setDepartmentName("IT");
//		
//		 a.addEmployee(new Employee( "join", "Thanprasit",100000, 22,
//		 "083-1073040", 1, "HR", new Date(),
//		 "pondpond_arsenal@hotmail.com", "848/49 bang sue",dp));
		a.updateEm(1, "ag");
//		 a.addEmployee(new Employee( "Thanakorn", "Thanprasit",100000, 22,
//		 "083-1073040", 1, "HR", new Date(),
//		 "pondpond_arsenal@hotmail.com", "848/49 bang sue",dp));
		// a.updateEm(1,"bangkok");
		// a.deleteEm(7);
		// a.selectAllCriteria();
		// a.selectAllHQL();
		// a.selectAllSQL();
		// a.QueryCriteria("thanakorn", null, 0, 0, null, 0, null, null, null,
		// null);
//		a.queryWit(a.setbeMap("", "", 0, 0, "", 0, "", new Date(2014,03,2,0,0,0), "", ""));
		//a.nativeQuery();
		// tx = session.beginTransaction();
		// tx.begin();
		// Employee employee = new Employee();
		// employee.setAddress("aaaa");
		// employee.setFirstName("aaaaa");
		// employee.setLastName("aaaaa");
		// employee.setAge(10);
		// employee.setEmail("last");
		// employee.setPosition("SA");
		// employee.setSalary(122222);
		// employee.setPhoneNumber("28282828");
		// employee.setBirthday(new Date());
		// employee.setSex(1);
		// session.save(employee);
		// tx.commit();
		// employee=(Employee) session.get(Employee.class, 1);
		// System.out.println("get  Fristname :"+employee.getFirstName());
		// List<Employee>
		// em=session.createQuery("from Employee ep WHERE ep.id=1").list();
		// for(Employee e:em){
		// System.out.println("query  Fristname :"+e.getFirstName());
		// }

		// List<Employee>
		// m=session.createQuery("from Employee ep WHERE ep.firstName like '%n%'").list();
		// for(Employee e:m){
		// System.out.println("query  Fristname :"+e.getFirstName());
		// }
		//
		//
		// List<Employee>
		// mw=session.createQuery("from Employee ep WHERE ep.firstName ='name'").list();
		// for(Employee e:mw){
		// System.out.println("query  Fristname :"+e.getFirstName());
		// }
		// Criteria cr = session.createCriteria(Employee.class);
		// cr.add(Restrictions.eq("firstName", ""));

		// update employee
		// Employee ee=(Employee)session.get(Employee.class,1);
		// ee.setFirstName("John update");
		// session.update(ee);

		// List<Employee>
		// mw=session.createQuery("from Employee ep WHERE ep.firstName ='aaaaa'").list();
		// for(Employee e:mw){
		// // System.out.println("query  Fristname :"+e.getFirstName());
		// e.setFirstName("bb");
		// session.update(e);
		// }

		// //Delete employee
		// Employee ee=(Employee)session.get(Employee.class,2);
		// session.delete(ee);

		// @SuppressWarnings("unchecked")
		// List<Employee> mw=session.createCriteria(Employee.class)
		// .add(Restrictions.like("firstName","%b%"))
		// .add(Restrictions.isNotNull("address"))
		// .list();
		// // .add(Restrictions.eq("firstName", "bb"))
		// // .add(Restrictions.eq("address", "aaaa"))
		// // .add(Restrictions.like("firstName", b));
		// // .list();
		// for (Employee e : mw) {
		// System.out.println("query  Fristname :"+e.getFirstName());
		// }
		// List<Employee>
		// mw=session.createSQLQuery("SELECT * FROM EMPLOYEE").addEntity(Employee.class).list();
		// for (Employee e : mw) {
		// System.out.println("query  Fristname :"+e.getFirstName());
		// }
	}

	private void querywithNameQuery() {
		// TODO Auto-generated method stub
		session =factory.openSession();
		
		List<Employee> em=session.getNamedQuery("aa.findAll").setParameter("ID", 2).list();
		display(em);
	}

	public void addEmployee(Employee employee) {
		session = factory.openSession();
		session.beginTransaction();
		session.save(employee);
		session.getTransaction().commit();
		session.close();
	}

	public void updateEm(int id, String address) {
		session = factory.openSession();
		session.beginTransaction();
		Employee em = (Employee) session.get(Employee.class, id);
		em.setAddress(address);
		session.update(em);
		session.getTransaction().commit();
		session.close();
	}

	public void deleteEm(int id) {
		session = factory.openSession();
		session.beginTransaction();
		Employee em = (Employee) session.get(Employee.class, id);
		session.delete(em);
		session.getTransaction().commit();
		session.close();
	}

	public void selectAllCriteria() {
		session = factory.openSession();
		List<Employee> list = session.createCriteria(Employee.class).list();
		int i = 1;
		for (Employee em : list) {
			System.out.println("selectAllCriteria " + i + "."
					+ em.getFirstName() + " " + em.getLastName());
			i++;
		}
		session.close();
	}

	public void selectAllHQL() {
		session = factory.openSession();
		String hql = "FROM Employee em";
		List<Employee> list = session.createQuery(hql).list();
		int i = 1;
		for (Employee em : list) {
			System.out.println("selectAllHQL " + i + "." + em.getFirstName()
					+ " " + em.getLastName());
			i++;
		}
		session.close();
	}

	public void selectAllSQL() {
		session = factory.openSession();
		String sql = "SELECT * FROM EMPLOYEE";
		List<Employee> list = session.createSQLQuery(sql)
				.addEntity(Employee.class).list();
		int i = 1;
		for (Employee em : list) {
			System.out.println("selectAllSQL " + i + "." + em.getFirstName()
					+ " " + em.getLastName());
			i++;
		}
		session.close();
	}

	public void QueryCriteria(Map<String, String> map,
			Map<String, Integer> mapint) {
		String[] column = { "firstName", "lastName", "phoneNumber", "position",
				"email", "address" };
		Entry g = (Entry) map.entrySet();
		session = factory.openSession();
		Criteria ct = session.createCriteria(Employee.class);
		for (String key : column) {
			if (map.get(key) != null && !map.get(key).equals("")) {
				ct.add(Restrictions.like(key, '%' + map.get(key) + '%'));
			}
		}

		List<Employee> list = ct.list();
		int i = 1;
		for (Employee em : list) {
			System.out.println("QueryCriteria " + i + "." + em.getFirstName()
					+ " " + em.getLastName());
			i++;
		}

	}

	public void queryWit(Map<String, Object> criteriaMap) {
		session = factory.openSession();
		Criteria ct = session.createCriteria(Employee.class);
		for (Map.Entry<String, Object> entry : criteriaMap.entrySet()) {
			String key = (String) entry.getKey();
			if (entry.getValue() instanceof Integer) {
				if ((Integer) entry.getValue() != 0) {
					ct.add(Restrictions.eq(key, entry.getValue()));
				}

			} else if (entry.getValue() instanceof String) {
				if (entry.getValue() != null && entry.getValue() != "") {
					ct.add(Restrictions.like(key,
							'%' + String.valueOf(entry.getValue()) + '%'));
				}

			} else {
			    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-YYYY");
			    String myDate = "23-04-2014";
			    String myDate1 = "25-05-2014";
			    // Create date 17-04-2011 - 00h00
			    Date lo = null;
			    Date hi = null;
				try {
					lo = formatter.parse(myDate);
					hi = formatter.parse(myDate1);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//Date lo = new Date(2014, 04, 20,0,0,0);
//				Date hi = new Date(2014, 04, 25,0,0,0);
				if (entry.getValue() != null) {
//					ct.add(Restrictions.between(key, lo, hi));
					ct.add(Restrictions.ge(key, lo));
//					ct.add( Restrictions.lt(key, hi)); 
				}
//				ct.setFirstResult(1);  //// limit
//				ct.setMaxResults(3);

			}
		}
		List<Employee> list = ct.list();
		display(list);
	}

	public Map<String, Object> setbeMap(String firstName, String lastName,
			int salary, int age, String phoneNumber, int sex, String position,
			Date birthday, String email, String address) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("firstName", firstName);
		map.put("lastName", lastName);
		map.put("salary", salary);
		map.put("age", age);
		map.put("phoneNumber", phoneNumber);
		map.put("sex", sex);
		map.put("position", position);
		map.put("birthday", birthday);
		map.put("email", email);
		map.put("address", address);

		return map;
	}
	
	public void nativeQuery(){
		   Session session=factory.openSession();
		   session.beginTransaction();
		   String sql="SELECT * FROM EMPLOYEE WHERE FIRST_NAME = :dpname";
		   List results= session.createSQLQuery(sql)
				   .addEntity(Employee.class)
				   .setParameter("dpname", "Thanakorn").list();
		   display(results);
		   session.close();
	}
	
	public void display(List<Employee> list){
		int i = 1;
		for (Employee em : list) {
			System.out.println("display " + i + "." + em.getFirstName() + " "
					+ em.getLastName());
			i++;
		}
	}
	
}

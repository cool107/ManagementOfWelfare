package welfare.dao;

import java.util.ArrayList;


import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import welfare.vo.Aged;
import welfare.vo.Client;
import welfare.vo.Employee;
import welfare.vo.Handicap;
import welfare.vo.ShowAged;
import welfare.vo.ShowHandicap;

public class WelfareDAO {
	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory(); // 마이바티스 객체

	// 직원정보 저장
	public boolean insertEmployee(Employee employee) {
		SqlSession sessoin = null;
		int cnt = 0;
		try {
			sessoin = factory.openSession();
			WelfareMapper mapper = sessoin.getMapper(WelfareMapper.class);
			if (employee.geteName() != null && employee.getDepartment() != null && employee.getEmployeeId() != null
					&& employee.getEnterDate() != null && employee.getPosition() != null) {
				cnt = mapper.insertEmployee(employee);
			}
			sessoin.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sessoin != null)
				sessoin.close();
		}
		if (cnt == 0) {
			return false;
		} else {
			return true;
		}

	}

	public boolean insertClient(Client client) {
		SqlSession session = null;
		int cnt = 0;
		try {
			session = factory.openSession();
			WelfareMapper mapper = session.getMapper(WelfareMapper.class);
			if (client.getCtId() != null && client.getAddress() != null && client.getCtName() != null
					&& client.getCtType() != null && client.getEmployeeId() != null) {
				System.out.println(client);
				cnt = mapper.insertClient(client);
			}
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		if (cnt == 0) {
			return false;
		} else {
			return true;
		}
	}

	public boolean insertAged(Aged aged) {
		SqlSession session = null;
		int cnt = 0;
		try {
			session = factory.openSession();
			WelfareMapper mapper = session.getMapper(WelfareMapper.class);
			cnt = mapper.insertAged(aged);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		if (cnt == 0) {
			return false;
		} else {
			return true;
		}
	}

	public boolean insertHandicap(Handicap handicap) {
		SqlSession session = null;
		int cnt = 0;
		try {
			session = factory.openSession();
			WelfareMapper mapper = session.getMapper(WelfareMapper.class);
			cnt = mapper.insertHandicap(handicap);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		if (cnt == 0) {
			return false;
		} else {
			return true;
		}
	}

	public Client searchClient(String ctId) {
		SqlSession session = null;
		Client client = null;

		try {
			session = factory.openSession();
			WelfareMapper mapper = session.getMapper(WelfareMapper.class);
			client = mapper.searchClient(ctId);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return client;
	}

	public Employee searchEmployee(String employeeId) {
		SqlSession session = null;
		Employee employee = null;
		try {
			session = factory.openSession();
			WelfareMapper mapper = session.getMapper(WelfareMapper.class);
			employee = mapper.searchEmployee(employeeId);
			session.commit();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		} finally {
			if (session != null)
				session.close();
		}

		return employee;
	}

	public boolean updateClient(Client client) {
		SqlSession sesion = null;
		int cnt = 0;

		try {
			sesion = factory.openSession();
			WelfareMapper mapper = sesion.getMapper(WelfareMapper.class);
			cnt = mapper.updateClient(client);

			sesion.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sesion != null) {
				sesion.close();
			}
		}
		if (cnt == 0) {
			return false;
		} else {
			return true;
		}
	}

	public boolean updateEmployee(Employee employee) {
		SqlSession sesion = null;
		int cnt = 0;

		try {
			sesion = factory.openSession();
			WelfareMapper mapper = sesion.getMapper(WelfareMapper.class);
			cnt = mapper.updateEmployee(employee);

			sesion.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sesion != null) {
				sesion.close();
			}
		}
		if (cnt == 0) {
			return false;
		} else {
			return true;
		}
	}

	public boolean updateHandicap(Handicap ctId) {
		SqlSession session = null;
		int cnt = 0;
		try {
			session = factory.openSession();
			WelfareMapper mapper = session.getMapper(WelfareMapper.class);
			cnt = mapper.updateHandicap(ctId);
			session.commit();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		} finally {
			if (session != null)
				session.close();
		}
		if (cnt == 0) {
			return false;
		} else {
			return true;
		}
	}

	public boolean updateAged(Aged aged) {
		SqlSession session = null;
		int cnt = 0;
		try {
			session = factory.openSession();
			WelfareMapper mapper = session.getMapper(WelfareMapper.class);
			cnt = mapper.updateAged(aged);
			session.commit();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		} finally {
			if (session != null)
				session.close();
		}
		if (cnt == 0) {
			return false;
		} else {
			return true;
		}
	}

	public boolean deleteClient(String ctId) {
		SqlSession session = null;
		int cnt = 0;
		try {
			session = factory.openSession();
			WelfareMapper mapper = session.getMapper(WelfareMapper.class);
			if (searchClient(ctId) != null) {
				cnt = mapper.deleteClient(ctId);
			}
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		if (cnt == 0) {
			return false;
		} else {
			return true;
		}
	}

	public boolean deleteEmployee(String employeeId) {
		SqlSession session = null;
		int cnt = 0;
		try {
			session = factory.openSession();
			WelfareMapper mapper = session.getMapper(WelfareMapper.class);
			if (searchEmployee(employeeId) != null) {
				cnt = mapper.deleteEmployee(employeeId);
			}
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		if (cnt == 0) {
			return false;
		} else {
			return true;
		}
	}

	// 회원목록 읽기
	public ArrayList<Client> listClient() {
		SqlSession session = null;
		ArrayList<Client> list = null;

		try {
			session = factory.openSession();
			WelfareMapper mapper = session.getMapper(WelfareMapper.class);
			list = mapper.listClient();
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;
	}

	public ArrayList<Employee> listEmployee() {
		SqlSession session = null;
		ArrayList<Employee> eList = null;
		try {
			session = factory.openSession();
			WelfareMapper mapper = session.getMapper(WelfareMapper.class);
			eList = mapper.listEmployee();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		} finally {
			if (session != null)
				session.close();
		}

		return eList;
	}

	public ArrayList<ShowAged> listAged() {
		SqlSession session = null;
		ArrayList<ShowAged> list = new ArrayList<ShowAged>();

		try {
			session = factory.openSession();
			WelfareMapper mapper = session.getMapper(WelfareMapper.class);
			list = mapper.listAged();
//			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;
	}

	public ArrayList<ShowHandicap> listHandicap() {
		SqlSession session = null;
		ArrayList<ShowHandicap> list = new ArrayList<ShowHandicap>();

		try {
			session = factory.openSession();
			WelfareMapper mapper = session.getMapper(WelfareMapper.class);
			list = mapper.listHandicap();
//			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;
	}
}

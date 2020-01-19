package welfare.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import welfare.vo.Aged;
import welfare.vo.Client;
import welfare.vo.Employee;
import welfare.vo.Handicap;
import welfare.vo.ShowAged;
import welfare.vo.ShowHandicap;

public interface WelfareMapper {
	// 직원정보저장
	public int insertEmployee(Employee employee);

	// 대상자 정보 저장
	public int insertClient(Client client);

	// 장애인대상자별 서비스 등록
	public int insertAged(Aged aged);

	// 노인대상자별 서비스 등록
	public int insertHandicap(Handicap handicap);

	// 대상자 검색
	public Client searchClient(String ctId);

	// 직원 검색
	public Employee searchEmployee(String employeeId);

	// 대상자수정
	public int updateClient(Client client);

	// 직원수정
	public int updateEmployee(Employee employeeId);

	// 노인 서비스 수정
	public int updateAged(Aged aged);

	// 장애인 서비스 수정
	public int updateHandicap(Handicap handicap);

	// 대상자삭제
	public int deleteClient(String ctId);

	// 직원삭제
	public int deleteEmployee(String employeeId);

	// 회원 목록
	public ArrayList<Client> listClient();

	// 직웜 목록
	public ArrayList<Employee> listEmployee();

	// 노인서비스+대상자 테이블
	public ArrayList<ShowAged> listAged();

	// 장애인서비스+대상자 테이블
	public ArrayList<ShowHandicap> listHandicap();
	
	

}

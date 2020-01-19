package welfare.ui;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

import welfare.dao.WelfareDAO;
import welfare.vo.Aged;
import welfare.vo.Client;
import welfare.vo.Employee;
import welfare.vo.Handicap;
import welfare.vo.ShowAged;
import welfare.vo.ShowHandicap;

public class WelfareUi {
	private WelfareDAO dao = new WelfareDAO();
	private Scanner sc = new Scanner(System.in);
	private Scanner isc = new Scanner(System.in);

	public WelfareUi() {
		int num = 0;
		
		while (true) {
			try {
				printMainScreen();
				num = isc.nextInt();
				switch (num) {
				case 1:
					insert();
					break;
				case 2:
					search();
					break;
				case 3:
					update();
					break;
				case 4:
					delete();
					break;
				case 5:
					status();
					break;

				case 9:
					System.out.println("프로그램을 종료합니다.");
					System.exit(0);
					return;

				default:
					System.out.println("번호를 다시 선택하세요.");
					break;
				}

			} catch (Exception e) { // 숫자로 입력받을 수 없는 에러가 날 경우 Exception 처리.
				System.out.println("다시 입력해 주세요.");
				isc.nextLine(); // 버퍼에 남아있는 문자들 삭제
				continue;
			}
		}
	}

	public void printMainScreen() {
		System.out.println("[ 복지관관리 ]");
		System.out.println("1. 등록");
		System.out.println("2. 검색");
		System.out.println("3. 수정");
		System.out.println("4. 삭제");
		System.out.println("5. 대상자현황");
		System.out.println("9. 프로그램 종료");
		System.out.print("* 메뉴 번호를 선택하세요 > ");
	}

	void insertScreen() {
		System.out.println("[ 등록 ]");
		System.out.println("1. 대상자등록");
		System.out.println("2. 직원등록");
		System.out.println("3. 서비스등록");
		System.out.println("4. 상위메뉴");
		System.out.print("입력: ");
	}

	void serviceMenuScreen() {
		System.out.println("[ 서비스종류 ]");
		System.out.println("1. 장애인");
		System.out.println("2. 노인");
		System.out.println("3. 상위메뉴");
		System.out.print("입력: ");
	}

	void searchScreen() {
		System.out.println("[ 검색 ]");
		System.out.println("1. 대상자검색");
		System.out.println("2. 직원검색");
		System.out.println("3. 상위메뉴");
		System.out.print("입력: ");
	}

	void updateScreen() {
		System.out.println("[ 수정 ]");
		System.out.println("1. 대상자정보수정");
		System.out.println("2. 직원정보수정");
		System.out.println("3. 서비스정보수정");
		System.out.println("4. 상위메뉴");
		System.out.print("입력: ");
	}

	void serviceScreen() {
		System.out.println("[ 서비스정보수정 ]");
		System.out.println("1. 장애인");
		System.out.println("2. 노인");
		System.out.println("3. 상위메뉴");
		System.out.print("입력: ");
	}

	void deleteScreen() {
		System.out.println("[ 삭제 ]");
		System.out.println("1. 대상자");
		System.out.println("2. 직원");
		System.out.println("3. 상위메뉴");
		System.out.print("입력: ");
	}

	void statusScreen() {
		System.out.println("[ 대상자현황 ]");
		System.out.println("1. 장애인");
		System.out.println("2. 노인");
		System.out.println("3. 전체대상자");
		System.out.println("4. 직원");
		System.out.println("5. 상위메뉴");
		System.out.print("입력: ");
	}

	void insert() {
		boolean flag = true;
		int num = 0;
		while (flag) {
			try {
				insertScreen();
				num = isc.nextInt();
				switch (num) {
				case 1:
					insertClient();
					break;
				case 2:
					insertEmployee();
					break;
				case 3:
					serviceMenu();
					break;
				case 4:
					flag = false;
					break;
				default:
					System.out.println("잘 못 입력하였습니다.");
					break;
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("다시 입력해 주세요.");
				isc.nextLine();
				continue;

			}
		}
	}

	void insertEmployee() {

		String employeeId;
		boolean result;
		System.out.println("[ 직원정보 등록 ]");
		while (true) {
			System.out.print("직원ID: ");
			employeeId = sc.nextLine();
			if (searchEmployee(employeeId) != true) {
				break;
			} else {
				System.out.println("동일한 ID가 존재합니다.");
			}
		}
		System.out.print("이름: ");
		String eName = sc.nextLine();
		System.out.print("부서: ");
		String department = sc.nextLine();
		System.out.print("직위: ");
		String position = sc.nextLine();
		System.out.print("입사일 (YYYY-MM-DD) : ");
		String enterDate = getChosen();
		Date enterDate1 = Date.valueOf(enterDate);
		Employee employee = new Employee(employeeId, eName, department, position, enterDate1);
		result = dao.insertEmployee(employee);
		if (result) {
			System.out.println("저장되었습니다.");
		} else {
			System.out.println("저장 실패하였습니다.");
		}
	}

	void insertClient() {

		ArrayList<Employee> eList;
		boolean result;
		boolean flag = true;
		String ctType = null;
		String eId = null;

		eList = dao.listEmployee();
		if (eList == null && eList.size() == 0) {
			System.out.println("등록된 담당자가 없습니다.");
			System.out.println("직원을 먼저 등록해주세요.");
			return;
		}
		System.out.println("[ 대상자 등록 ]");
		System.out.print("대상자ID: ");
		String ctId = sc.nextLine();
		System.out.print("이름: ");
		String ctName = sc.nextLine();
		System.out.print("주소: ");
		String address = sc.nextLine();
		System.out.print("대상자선정일(YYYY-MM-DD): ");
		String regiDate = getChosen();
		Date enterDate1 = Date.valueOf(regiDate);

		while (flag) {
			System.out.println("대상자타입(장애인/노인): ");
			ctType = sc.nextLine();
			if (ctType.equals("장애인") || ctType.equals("노인")) {
				break;
			} else {
				System.out.println("'장애인'/'노인' 중 1가지만 입력하시오");
			}
		}
		while (true) {
			System.out.println("[ 담당직원 ]");
			listEmployee();
			System.out.print("담당직원id: ");
			eId = sc.nextLine();
			if (searchEmployee(eId)) {
				break;
			} else
				System.out.println("잘 못 입력하였습니다.");
		}
		Client client = new Client(ctId, ctName, address, enterDate1, ctType, eId);

		result = dao.insertClient(client);

		if (result) {
			System.out.println("저장되었습니다.");
		} else {
			System.out.println("저장에 실패하였습니다.");
		}
	}

	void serviceMenu() {
		boolean flag = true;
		while (flag) {
			serviceMenuScreen();
			switch (isc.nextInt()) {
			case 1:
				insertHandicap();
				break;
			case 2:
				insertAge();
				break;
			case 3:
				flag = false;
				break;

			default:
				break;
			}
		}
	}

	void insertHandicap() {
		Handicap handicap;
		String ctId = null;
		boolean handiType = false;
		String handiGrade = null;
		boolean dayCare = false;
		boolean handiHelper = false;
		ArrayList<Client> aList = dao.listClient();

		while (true) {
			System.out.println("===================");
			System.out.println("[   장애인 대상자 정보       ]");
			System.out.println("===================");
			for (Client client : aList) {
				if (client.getCtType().equals("장애인")) {
					System.out.println(client.toString());
				}
			}
			int cnt = 0;
			System.out.println("대상자ID: ");
			ctId = sc.nextLine();
			for (Client client : aList) {
				if (client.getCtType().equals("장애인")) {
					for (Client client2 : aList) {
						if (client2.getCtId().equals(ctId)) {
							cnt++;
							break;
						}
					}
				}
			}

			if (cnt == 0 || searchClient(ctId) == false) {
				System.out.print("장애인 대상자가 아니거나 등록되지 않은  id입니다. 재입력: ");
			} else
				break;

			while (true) {
				System.out.println("장애유형선택");
				System.out.println("1. 지적장애");
				System.out.println("2. 지체장애");
				System.out.print("입력: ");
				String first = sc.nextLine();
				if (first.equals("1") || first.equals("2")) {
					if (first.equals("1")) {
						handiType = true;
						break;
					} else {
						handiType = false;
						break;
					}
				} else {
					System.out.println("잘못 입력하였습니다. (y/n)중 재입력");
				}
			}
			while (true) {
				System.out.println("장애등급선택: ");
				System.out.println("1. 1급");
				System.out.println("2. 2급");
				System.out.println("3. 3급");
				System.out.println("4. 등급외");
				System.out.print("입력: ");
				handiGrade = sc.nextLine();
				if (handiGrade.equals("1") || handiGrade.equals("2") || handiGrade.equals("3")
						|| handiGrade.equals("4")) {
					if (handiGrade == "1") {
						handiGrade = "1";
					} else if (handiGrade == "2") {
						handiGrade = "2";
					} else if (handiGrade == "3") {
						handiGrade = "3";
					} else
						handiGrade = "4";
					break;
				} else {
					System.out.println("잘못 입력하였습니다. 1~4번중 선택하시오");
				}
			}
			while (true) {
				System.out.println("주간보호시설이용유무(y/n): ");
				String second = sc.nextLine();
				if (second.equalsIgnoreCase("y") || second.equalsIgnoreCase("N")) {
					if (second.equalsIgnoreCase("y")) {
						dayCare = true;
						break;
					} else {
						dayCare = false;
						break;
					}
				} else {
					System.out.println("잘못 입력하였습니다. y/n중 재입력");
				}
			}
			while (true) {
				System.out.println("활동보조인파견 여부(y/n): ");
				String third = sc.nextLine();
				if (third.equalsIgnoreCase("y") || third.equalsIgnoreCase("N")) {
					if (third.equalsIgnoreCase("y")) {
						handiHelper = true;
						break;
					} else {
						handiHelper = false;
						break;
					}
				} else {
					System.out.println("잘못 입력하였습니다. y/n중 재입력");
				}
			}
			handicap = new Handicap(handiType, handiGrade, dayCare, handiHelper, ctId);
			boolean result = dao.insertHandicap(handicap);
			if (result) {
				System.out.println("저장되었습니다.");
			} else {
				System.out.println("저장 실패하였습니다.");
			}
		}
	}

	void insertAge() {
		ArrayList<Client> aList = dao.listClient();
		Aged aged;
		String agedGrade = null;
		String ctId = null;
		boolean status = false;
		boolean food = false;
		boolean emotional = false;
		boolean agedHelper = false;

		while (true) {
			System.out.println("===================");
			System.out.println("[   노인 대상자 정보        ]");
			System.out.println("===================");
			for (Client client : aList) {
				if (client.getCtType().equals("노인")) {
					System.out.println(client.toString());
				}
			}
			int cnt = 0;
			System.out.println("대상자ID: ");
			ctId = sc.nextLine();
			for (Client client : aList) {
				if (client.getCtType().equals("노인")) {
					for (Client client2 : aList) {
						if (client2.getCtId().equals(ctId)) {
							cnt++;
							break;
						}
					}
				}
			}

			if (cnt == 0 || searchClient(ctId) == false) {
				System.out.print("장애인 대상자가 아니거나 등록되지 않은  id입니다. 재입력: ");
			} else
				break;
		}
		while (true) {
			System.out.print("거동가능 여부(y/n): ");
			String first = sc.nextLine();
			if (first.equalsIgnoreCase("y") || first.equalsIgnoreCase("N")) {
				if (first.equalsIgnoreCase("y")) {
					status = true;
					break;
				} else {
					status = false;
					break;
				}
			} else {
				System.out.print("잘못 입력하였습니다. (y/n)중 재입력");
			}
		}
		while (true) {
			System.out.print("위험등급선택(고위험/중위험/저위험): ");
			agedGrade = sc.nextLine();
			if (agedGrade.equals("고위험") || agedGrade.equals("중위험") || agedGrade.equals("저위험")) {
				break;
			} else {
				System.out.println("(고위험/중위험/저위험) 중 선택하시오");
			}
		}
		while (true) {
			System.out.print("식사지원서비스 지원 여부(y/n): ");
			String second = sc.nextLine();
			if (second.equalsIgnoreCase("y") || second.equalsIgnoreCase("N")) {
				if (second.equalsIgnoreCase("y")) {
					food = true;
					break;
				} else {
					food = false;
					break;
				}
			} else {
				System.out.print("잘못 입력하였습니다. y/n중 재입력");
			}
		}
		while (true) {
			System.out.print("정서지원서비스 지원 여부(y/n): ");
			String third = sc.nextLine();
			if (third.equalsIgnoreCase("y") || third.equalsIgnoreCase("N")) {
				if (third.equalsIgnoreCase("y")) {
					emotional = true;
					break;
				} else {
					emotional = false;
					break;
				}
			} else {
				System.out.print("잘못 입력하였습니다. y/n중 재입력");
			}
		}
		while (true) {
			System.out.print("요양보호사파견 여부(y/n): ");
			String fourth = sc.nextLine();
			if (fourth.equalsIgnoreCase("y") || fourth.equalsIgnoreCase("N")) {
				if (fourth.equalsIgnoreCase("y")) {
					agedHelper = true;
					break;
				} else {
					agedHelper = false;
					break;
				}
			} else {
				System.out.print("잘못 입력하였습니다. y/n중 재입력");
			}
		}
		aged = new Aged(status, agedGrade, food, emotional, agedHelper, ctId);
		boolean result = dao.insertAged(aged);
		if (result) {
			System.out.println("저장되었습니다.");
		} else {
			System.out.println("저장 실패하였습니다.");
		}
	}

	boolean searchClient(String ctId) {
		boolean result = false;
		if (dao.searchClient(ctId) != null) {
			result = true;
		}
		return result;
	}

	boolean searchEmployee(String employeeId) {
		boolean result = false;
		if (dao.searchEmployee(employeeId) != null) {
			result = true;
		}
		return result;
	}

	void searchCt() {
		ArrayList<Client> cList = dao.listClient();
		ArrayList<Employee> eList = dao.listEmployee();
		ArrayList<ShowAged> aList = dao.listAged();
		ArrayList<ShowHandicap> hList = dao.listHandicap();
		String emId;

		System.out.println("===================");
		System.out.println("[    전체대상자 정보         ]");
		listClient();
		System.out.print("대상자 id 입력: ");
		String input = sc.nextLine();
		System.out.println("===================");
		System.out.println("[      대상자 정보         ]");
		if (searchClient(input)) {
			for (Client client : cList) {
				if (client.getCtId().equals(input)) {
					System.out.println(client.toString());
					emId = client.getEmployeeId();
					System.out.println("===================");
					System.out.println("[      담당자 정보         ]");
					for (Employee employee : eList) {
						if (employee.getEmployeeId().equals(emId)) {
							System.out.println(employee.toString());
						}
					}
					System.out.println("===================");
					System.out.println("[     제공서비스현황         ]");
					for (ShowHandicap handi : hList) {
						if (handi.getCtId().equals(client.getCtId())) {
							System.out.println(handi.toString());
						} else {
							for (ShowAged aged : aList) {
								if (aged.getCtId().equals(input)) {
									System.out.println(aged.toString());
								}
							}
						}
					}
				}
			}
		} else
			System.out.println("입력한 대상자가 없습니다.");
	}

	void searchEm() {
		ArrayList<Client> cList = dao.listClient();

		System.out.println("===================");
		System.out.println("[    전체직원  정보         ]");
		listEmployee();
		System.out.print("직원 id 입력: ");
		String input2 = sc.nextLine();
		if (searchEmployee(input2)) {
			System.out.println(dao.searchEmployee(input2));
			System.out.println("===================");
			System.out.println("[   담당 대상자 정보        ]");
			System.out.println("===================");
			for (Client client : cList) {
				if (client.getEmployeeId().equals(input2)) {
					System.out.println(client.toString());
				}
			}
			System.out.println("담당 대상자 수: " + countClient(input2));
		} else
			System.out.println("입력한 직원이 없습니다.");
	}

	void search() {
		boolean flag = true;
		int num = 0;
		while (flag) {
			try {
				searchScreen();
				num = isc.nextInt();
				switch (num) {
				case 1:
					searchCt();
					break;
				case 2:
					searchEm();
					break;
				case 3:
					flag = false;
					break;
				default:
					System.out.println("잘 못 입력하였습니다.");
					break;
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("다시 입력해 주세요.");
				isc.nextLine();
				continue;
			}
		}
	}

	int countClient(String employeeId) {
		int cnt = 0;
		ArrayList<Client> cList = dao.listClient();
		for (Client client : cList) {
			if (client.getEmployeeId().equals(employeeId)) {
				cnt++;
			}
		}
		return cnt;

	}

	void updateClient(String input) {
		Client client;
		boolean result;
		boolean flag = true;
		String ctType = null;
		String ctName;

		System.out.println("[ 대상자 수정 ]");
		System.out.println("이름: ");
		ctName = sc.nextLine();
		System.out.println("주소: ");
		String address = sc.nextLine();
		System.out.println("대상자선정일: ");
		String regiDate = getChosen();
		Date enterDate1 = Date.valueOf(regiDate);
		while (flag) {
			System.out.println("대상자타입(장애인/노인): ");
			ctType = sc.next();
			if (ctType.equals("장애인") || ctType.equals("노인")) {
				System.out.println("입력성공");
				flag = false;
				break;
			} else {
				System.out.println("'장애인'/'노인' 중 1가지만 입력하시오");
			}
		}
		System.out.println("[ 담당직원 ]");
		listEmployee();
		System.out.println("담당직원id: ");
		String employeeId = sc.nextLine();

		client = new Client(input, ctName, address, enterDate1, ctType, employeeId);

		result = dao.updateClient(client);

		if (result) {
			System.out.println("저장되었습니다.");
		} else {
			System.out.println("저장 실패하였습니다.");
		}
	}

	void updateEmployee(String sInput) {
		Employee employee;
		boolean result;
		System.out.print("[ 직원정보 등록 ]");
		System.out.print("이름: ");
		String eName = sc.next();
		System.out.print("부서: ");
		String department = sc.next();
		System.out.print("직위: ");
		String position = sc.next();
		System.out.print("입사일: ");
		String enterDate = getChosen();
		Date enterDate1 = Date.valueOf(enterDate);
		employee = new Employee(sInput, eName, department, position, enterDate1);
		result = dao.updateEmployee(employee);
		if (result) {
			System.out.println("저장되었습니다.");
		} else {
			System.out.println("저장 실패하였습니다.");
		}
	}

	void updateHandicap() {
		Handicap handicap;
		boolean handiType = false;
		String handiGrade = null;
		boolean dayCare = false;
		boolean handiHelper = false;
		String ctId;
		ArrayList<Client> aList = dao.listClient();
		System.out.println("===================");
		System.out.println("[ 대상자별 이용서비스수정 ]");
		System.out.println("===================");
		System.out.println("[    장애인대상자 정보      ]");
		for (Client client : aList) {
			if (client.getCtType().equals("장애인")) {
				System.out.println(client.toString());
			}
		}
		while (true) {
			System.out.print("대상자ID: ");
			ctId = sc.nextLine();
			if (dao.searchClient(ctId) == null) {
				System.out.println("등록되지 않은 id입니다.위에서 id를 선택");
			} else
				break;
		}
		while (true) {
			System.out.println("장애유형선택");
			System.out.println("1. 지적장애");
			System.out.println("2. 지체장애");
			System.out.print("입력: ");
			String first = sc.nextLine();
			if (first.equals("1") || first.equals("2")) {
				if (first.equals("1")) {
					handiType = true;
					break;
				} else {
					handiType = false;
					break;
				}
			} else {
				System.out.println("잘못 입력하였습니다. (y/n)중 재입력");
			}
		}
		while (true) {
			System.out.println("장애등급선택: ");
			System.out.println("1. 1급");
			System.out.println("2. 2급");
			System.out.println("3. 3급");
			System.out.println("4. 등급외");
			System.out.print("입력: ");
			handiGrade = sc.next();
			if (handiGrade.equals("1") || handiGrade.equals("2") || handiGrade.equals("3") || handiGrade.equals("4")) {
				break;
			} else {
				System.out.println("잘못 입력하였습니다. 1~4번중 선택하시오");
			}
		}
		while (true) {
			System.out.print("주간보호시설이용유무(y/n): ");
			String second = sc.nextLine();
			if (second.equalsIgnoreCase("y") || second.equalsIgnoreCase("N")) {
				if (second.equalsIgnoreCase("y")) {
					dayCare = true;
					break;
				} else {
					dayCare = false;
					break;
				}
			} else {
				System.out.println("잘못 입력하였습니다. y/n중 재입력");
			}
		}
		while (true) {
			System.out.print("활동보조인파견 여부(y/n): ");
			String third = sc.nextLine();
			if (third.equalsIgnoreCase("y") || third.equalsIgnoreCase("N")) {
				if (third.equalsIgnoreCase("y")) {
					handiHelper = true;
					break;
				} else {
					handiHelper = false;
					break;
				}
			} else {
				System.out.println("잘못 입력하였습니다. y/n중 재입력");
			}
		}
		handicap = new Handicap(handiType, handiGrade, dayCare, handiHelper, ctId);
		boolean result = dao.updateHandicap(handicap);
		if (result) {
			System.out.println("저장되었습니다.");
		} else {
			System.out.println("저장 실패하였습니다.");
		}
	}

	void updateAge() {
		Aged aged;
		String agedGrade = null;
		boolean status = false;
		boolean food = false;
		boolean emotional = false;
		boolean agedHelper = false;
		String ctId;

		System.out.println("===================");
		System.out.println("[  노인대상자 정보수정      ]");
		ArrayList<Client> aList = dao.listClient();
		for (Client client : aList) {
			if (client.getCtType().equals("노인")) {
				System.out.println(client.toString());
			}
		}
		while (true) {
			System.out.print("대상자ID: ");
			ctId = sc.nextLine();
			if (dao.searchClient(ctId) == null) {
				System.out.print("등록되지 않은 id입니다.위에서 id 선택: ");
			} else
				break;
		}
		while (true) {
			System.out.print("거동가능 여부(y/n): ");
			String first = sc.nextLine();
			if (first.equalsIgnoreCase("y") || first.equalsIgnoreCase("N")) {
				if (first.equalsIgnoreCase("y")) {
					status = true;
					break;
				} else {
					status = false;
					break;
				}
			} else {
				System.out.print("잘못 입력하였습니다. (y/n)중 재입력: ");
			}
		}
		while (true) {
			System.out.print("위험등급선택(고위험/중위험/저위험): ");
			agedGrade = sc.nextLine();
			if (agedGrade.equals("고위험") || agedGrade.equals("중위험") || agedGrade.equals("저위험")) {
				break;
			} else {
				System.out.print("(고위험/중위험/저위험) 중 선택: ");
			}
		}
		while (true) {
			System.out.print("식사지원서비스 지원 여부(y/n): ");
			String second = sc.nextLine();
			if (second.equalsIgnoreCase("y") || second.equalsIgnoreCase("N")) {
				if (second.equalsIgnoreCase("y")) {
					food = true;
					break;
				} else {
					food = false;
					break;
				}
			} else {
				System.out.print("잘못 입력하였습니다. y/n중 재입력: ");
			}
		}
		while (true) {
			System.out.print("정서지원서비스 지원 여부(y/n): ");
			String third = sc.nextLine();
			if (third.equalsIgnoreCase("y") || third.equalsIgnoreCase("N")) {
				if (third.equalsIgnoreCase("y")) {
					emotional = true;
					break;
				} else {
					emotional = false;
					break;
				}
			} else {
				System.out.print("잘못 입력하였습니다. y/n중 재입력: ");
			}
		}
		while (true) {
			System.out.print("정서지원서비스 지원 여부(y/n): ");
			String fourth = sc.nextLine();
			if (fourth.equalsIgnoreCase("y") || fourth.equalsIgnoreCase("N")) {
				if (fourth.equalsIgnoreCase("y")) {
					agedHelper = true;
					break;
				} else {
					agedHelper = false;
					break;
				}
			} else {
				System.out.print("잘못 입력하였습니다. y/n중 재입력: ");
			}
		}
		aged = new Aged(status, agedGrade, food, emotional, agedHelper, ctId);
		boolean result = dao.updateAged(aged);
		if (result) {
			System.out.println("저장되었습니다.");
		} else {
			System.out.println("저장 실패하였습니다.");
		}
	}

	void updateService() {
		boolean flag = true;
		while (flag) {
			try {
				int num = isc.nextInt();
				switch (num) {
				case 1:
					updateHandicap();
					break;
				case 2:
					updateAge();
					break;
				case 3:
					flag = false;
					break;
				default:
					System.out.print("잘 못 입력하셨습니다. 다시입력하세요: ");
					break;
				}

			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("다시 입력해 주세요.");
				sc.nextLine(); // 버퍼에 남아있는 문자들 삭제
				continue;
			}
		}
	}

	void update() {
		boolean flag = true;
		int num = 0;
		while (flag) {
			try {
				updateScreen();
				num = isc.nextInt();
				switch (num) {
				case 1:
					listClient();
					System.out.print("대상자 id 입력: ");
					String input = sc.nextLine();
					if (searchClient(input)) {
						updateClient(input);
					} else
						System.out.println("입력한 대상자가 없습니다.");
					break;
				case 2:
					listEmployee();
					System.out.print("직원 id 입력: ");
					String sInput = sc.nextLine();
					if (searchEmployee(sInput)) {
						updateEmployee(sInput);
					} else
						System.out.println("입력한 직원이 없습니다.");
					break;
				case 3:
					serviceScreen();
					updateService();
					break;
				case 4:
					flag = false;
					break;
				default:
					System.out.println("잘 못 입력하였습니다.");
					break;
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("다시 입력해 주세요.");
				isc.nextLine();
				continue;
			}
		}
	}

	void delete() {
		boolean flag = true;
		int num = 0;
		while (flag) {
			try {
				deleteScreen();
				num = isc.nextInt();
				switch (num) {
				case 1:
					listClient();
					System.out.print("대상자 id 일력: ");
					String input = sc.nextLine();
					if (searchClient(input)) {
						dao.deleteClient(input);
					} else
						System.out.println("입력한 대상자가 없습니다.");
					break;
				case 2:
					listEmployee();
					System.out.print("직원 id 일력: ");
					String sInput = sc.nextLine();
					if (searchEmployee(sInput)) {
						dao.deleteEmployee(sInput);
					} else
						System.out.println("입력한 직원이 없습니다.");
					break;
				case 3:
					flag = false;
					break;
				default:
					System.out.println("잘 못 입력하였습니다.");
					break;
				}

			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("다시 입력해 주세요.");
				isc.nextLine();
				continue;
			}
		}
	}

	public void listClient() {
		System.out.println("[ 전체 대상자 목록 ]");
		ArrayList<Client> clist = dao.listClient();
		int cnt = 0;
		if (clist == null && clist.size() == 0) {
			System.out.println("등록된 대상자가 없습니다.");
			return;
		} else {
			for (Client client : clist) {
				System.out.println(client.toString());
				cnt++;
			}
		}
		System.out.println("전체 대상자수: " + cnt);
	}

	public void listEmployee() {
		System.out.println("[ 전체 직원 목록 ]");
		ArrayList<Employee> emlist = dao.listEmployee();
		int cnt = 0;
		if (emlist == null && emlist.size() == 0) {
			System.out.println("등록된 직원이 없습니다.");
			return;
		} else {
			for (Employee employee : emlist) {
				System.out.println(employee.toString());
				cnt++;
			}
		}
		System.out.println("전체직원수: " + cnt);
	}

	void status() {
		ArrayList<Client> clist = dao.listClient();
		int cntAge = 0;
		int cntHandicap = 0;
		boolean flag = true;

		while (flag) {
			statusScreen();
			try {
				switch (isc.nextInt()) {
				case 1:
					ArrayList<ShowHandicap> handi = dao.listHandicap();
					System.out.println("장애인 대상자 전체 목록");
					for (Client client : clist) {
						if (client.getCtType().equals("장애인")) {
							System.out.println(client.toString());
							cntHandicap++;
						}
					}
					System.out.println("전체 장애인 대상자 수: " + cntHandicap);
					break;
				case 2:
					ArrayList<ShowAged> aged = dao.listAged();
					System.out.println("노인 대상자 전체 목록");
					for (Client client : clist) {
						if (client.getCtType().equals("노인")) {
							System.out.println(client.toString());
							cntAge++;
						}
					}
					System.out.println("전체 노인 대상자 수: " + cntAge);
					break;
				case 3:
					listClient();
					break;
				case 4:
					listEmployee();
					break;
				case 5:
					flag = false;
					break;
				default:
					System.out.println("잘 못 입력하였습니다.");
					break;
				}

			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("다시 입력해 주세요.");
				isc.nextLine();
				continue;
			}
		}
	}

	// 대상자 지정 날짜 받는 형식
	private String getChosen() {
		String chosen = " ";

		while (true) {
			System.out.print("|날짜(숫자만)--예시)'2016-10-21'|: ");
			chosen = sc.nextLine();
			if (chosen.length() == 10) {
				break;
			}
			System.out.println("[에러] 입력 형식이 다릅니다");
		}
		return chosen;
	}
}

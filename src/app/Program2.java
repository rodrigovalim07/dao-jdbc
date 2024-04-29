package app;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		DepartmentDao depDao = DaoFactory.createDepartmentDao();

		System.out.println("=== TEST 1: department insert ===");
		Department dep = new Department(null, "Food");
		depDao.insert(dep);
		System.out.println("Inserido. Novo id = " + dep.getId());
		
		System.out.println("\n=== TEST 2: department update ===");
		Department dep1 = new Department(3, "Cars");
		depDao.update(dep1);
		System.out.println("Update completo.");
		
		System.out.println("\n=== TEST 3: department delete ===");
		System.out.print("Digite o id que deseja excluir: ");
		int id = teclado.nextInt();
		depDao.deleteById(id);
		System.out.println("Deleção concluída.");
		
		System.out.println("\n=== TEST 4: department findById ===");
		Department dep2 = depDao.findById(2);
		System.out.println(dep2);
		
		System.out.println("\n=== TEST 5: department findAll ===");
		List<Department> list = depDao.findAll();
		list.forEach(System.out::println);
		
		teclado.close();
	}

}

package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.dao.impl.SellerDaoJdbc;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		SellerDao sellerdao = DaoFactory.createSellerDao();

		System.out.println("==========TESTE 1: seller findById=========== ");
		Seller seller = sellerdao.findById(3);
		System.out.println(seller);

		System.out.println("\n==========TESTE 2:seller FindByDepartment==========");
		Department department = new Department(2, null);
		List<Seller> list = sellerdao.findByDepartment(department);
		for (Seller obj : list)
			System.out.println(obj);

		System.out.println("\n==========TESTE 3:seller FindAll==========");
		list = sellerdao.findAll();
		for (Seller obj : list)
			System.out.println(obj);

		System.out.println("\n==========TESTE 4:seller INSERT==========");
		Seller newSeller = new Seller(null, "Greg", "gref@gmail.com", new Date(), 4000.0, department);
		sellerdao.insert(newSeller);
		System.out.println("Inserted! new id = " + newSeller.getId());
		
		System.out.println("\n==========TESTE 5:seller update==========");
		seller = sellerdao.findById(1);
		seller.setName("Martha waine");
		sellerdao.update(seller);
		System.out.println("Update completed");
	}

}

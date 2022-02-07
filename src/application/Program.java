package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        SellerDao sellerDao = DaoFactory.createSellerDao();
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        Department department = new Department(2, null);
        List<Seller> sellerList = sellerDao.findByDepartment(department);

        for(Seller seller1 : sellerList) {
            System.out.println(seller1);
        }

        sellerList = sellerDao.findAll();

        for(Seller seller1 : sellerList) {
            System.out.println(seller1);
        }

        Seller otherSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.00, department);
        sellerDao.insert(otherSeller);
        System.out.println("Inserted! New id = " + otherSeller.getId());

        seller = sellerDao.findById(1);
        seller.setName("Martha Wayne");
        sellerDao.update(seller);
        System.out.println("Update completed");

        System.out.print("Enter id for deletion test: ");
        int id = input.nextInt();
        sellerDao.deleteById(id);
        System.out.print("Delete completed");

        input.close();
    }
}

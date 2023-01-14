package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      Car car1= new Car("Audi", 7);

      UserService userService = context.getBean(UserService.class);
      User user1=new User("User1", "Lastname1", "user1@mail.ru");
      user1.setUsersCar(car1);
      userService.add(user1);
//      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
//      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
//      userService.add(new User("User4", "Lastname4", "user4@mail.ru"))


      //carService.add(new Car("BMV", 6));
//      carService.add(new Car("Mercedes", 100));
//      carService.add(new Car("Audi", 500));
//      carService.add(new Car("Ford", 001));


      List<User> users = userService.getUserByCar(car1);
//      for (User user : users) {
//         System.out.println("Id = "+user.getId());
//         System.out.println("First Name = "+user.getFirstName());
//         System.out.println("Last Name = "+user.getLastName());
//         System.out.println("Email = "+user.getEmail());
//         System.out.println();
//      }

      context.close();
   }
}

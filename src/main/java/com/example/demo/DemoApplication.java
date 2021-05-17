package com.example.demo;

import com.example.demo.models.Order;
import com.example.demo.models.User;
import com.example.demo.repo.DiscountRepo;
import com.example.demo.repo.OrderRepo;
import com.example.demo.repo.UserRepo;
import com.example.demo.utils.ItemType;
import com.example.demo.utils.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
    @Autowired private MongoTemplate mongoTemplate;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        registerUsers();
        registerItems();
    }

    /**
     * Register users for testing.
     * @throws ParseException
     */
    private void registerUsers() throws ParseException {
        mongoTemplate.findAllAndRemove(new Query(), User.class);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

        User user1 = new User(
                "User 1",
                "user1@test.com",
                "+12345678",
                UserType.CUSTOMER,
                sdf.parse("1/1/2021")
        );

        User user2 = new User(
                "User 2",
                "user2@test.com",
                "+22345678",
                UserType.CUSTOMER,
                sdf.parse("1/1/2017")
        );

        User user3 = new User(
                "User 3",
                "user3@test.com",
                "+32345678",
                UserType.AFFILIATE,
                sdf.parse("1/1/2020")
        );

        User user4 = new User(
                "User 4",
                "user4@test.com",
                "+42345678",
                UserType.EMPLOYEE,
                sdf.parse("1/1/2016")
        );

        mongoTemplate.save(user1);
        mongoTemplate.save(user2);
        mongoTemplate.save(user3);
        mongoTemplate.save(user4);
    }

    /**
     * Register items.
     */
    private void registerItems() {
        mongoTemplate.findAllAndRemove(new Query(), Order.class);

        Order order1 = new Order("Item 1", "Description of item 1.", 1, 10, ItemType.ELECTRONICS);
        Order order2 = new Order("Item 2", "Description of item 2.", 2, 20, ItemType.GROCERIES);
        Order order3 = new Order("Item 3", "Description of item 3.", 4, 50, ItemType.GROCERIES);

        mongoTemplate.save(order1);
        mongoTemplate.save(order2);
        mongoTemplate.save(order3);
    }
}

package com.hendisantika.eda.springbooteventsourcing.repository;

import com.hendisantika.eda.springbooteventsourcing.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-event-sourcing
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-04-24
 * Time: 07:02
 */
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByStatus(String status);
}
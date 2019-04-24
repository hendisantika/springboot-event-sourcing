package com.hendisantika.eda.springbooteventsourcing.controller;

import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hendisantika.eda.springbooteventsourcing.domain.User;
import com.hendisantika.eda.springbooteventsourcing.event.EventStoreContainer;
import com.hendisantika.eda.springbooteventsourcing.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-event-sourcing
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-04-24
 * Time: 07:09
 */
@RequestMapping("/user")
@Controller
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    RedisTemplate<String, EventStoreContainer> redisTemplate;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    UserRepository userRepository;

    @Autowired
    HazelcastInstance hazelcastInstance;

    @GetMapping
    public String index(Model model) {
        ClientConfig cc = new ClientConfig();

        Collection userList = hazelcastInstance.getMap("userList").values();
        Collection deactivatedUsers = hazelcastInstance.getMap("deactivatedUsers").values();
        Collection verifiedUsers = hazelcastInstance.getMap("verifiedUsers").values();

        model.addAttribute("verifiedUsers", verifiedUsers);
        model.addAttribute("deactivatedUsers", deactivatedUsers);
        model.addAttribute("users", userList);
        model.addAttribute("user", new User());
        return "index";
    }


}

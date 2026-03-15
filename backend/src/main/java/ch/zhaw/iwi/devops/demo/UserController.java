package ch.zhaw.iwi.devops.demo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class UserController {
    private Map<Integer, User> users = new HashMap<>();

    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        users.put(1, new User(1, "Dominic", "rodel@zhaw.ch"));
        users.get(1).setIsAdmin(true); // Dominic ist Admin
        users.get(1).setPriority("high");

        users.put(2, new User(2, "Paul", "huber@zhaw.ch"));
        users.get(2).setIsAdmin(false);
        users.get(2).setPriority("medium");

        System.out.println("User Data Init");
    }

    @GetMapping("/services/user")
    public List<PathListEntry<Integer>> user() {
        var result = new ArrayList<PathListEntry<Integer>>();
        for (var user : users.values()) {
            var entry = new PathListEntry<Integer>();
            entry.setKey(user.getId(), "userKey");
            entry.setName(user.getName());
            entry.getDetails().add("Email: " + user.getEmail());
            if (user.getIsAdmin()) {
                entry.getDetails().add("👑 Admin");
            }
            entry.getDetails().add("Priority: " + (user.getPriority() != null ? user.getPriority() : "medium"));
            entry.setTooltip(user.getEmail());
            result.add(entry);
        }
        return result.stream().sorted(Comparator.comparing(PathListEntry::getName)).toList();
    }

    @GetMapping("/services/user/{key}")
    public User getUser(@PathVariable("key") Integer key) {
        return users.get(key);
    }

    @PostMapping("/services/user")
    public void createUser(@RequestBody User user) {
        var newId = users.keySet().stream().max(Comparator.naturalOrder()).orElse(0) + 1;
        user.setId(newId);
        users.put(newId, user);
    }

    @PutMapping("/services/user/{key}")
    public void updateUser(@PathVariable("key") Integer key, @RequestBody User user) {
        user.setId(key);
        users.put(key, user);
    }

    @DeleteMapping("/services/user/{key}")
    public User deleteUser(@PathVariable("key") Integer key) {
        return users.remove(key);
    }
}
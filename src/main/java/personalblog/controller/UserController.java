// package personalblog.controller;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// public class UserController {

//     @Autowired
//     private UserService userService;

//     @GetMapping("/users")
//     public ResponseEntity<List<User>> getAllUsers() {
//         List<User> users = userService.getAllUsers();
//         return new ResponseEntity<>(users, HttpStatus.OK);
//     }

//     @GetMapping("/user/{id}")
//     public ResponseEntity<User> getUserById(@PathVariable Long id) {
//         User user = userService.getUserById(id);
//         return new ResponseEntity<>(user, HttpStatus.OK);
//     }

//     @PostMapping
//     public ResponseEntity<User> createUser(@RequestBody User user) {
//         User createdUser = userService.createUser(user);
//         return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
//     }

//     @PutMapping("/user/{id}")
//     public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
//         User updatedUser = userService.updateUser(id, user);
//         return new ResponseEntity<>(updatedUser, HttpStatus.OK);
//     }

//     @DeleteMapping("/user/{id}")
//     public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
//         userService.deleteUser(id);
//         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//     }
// }
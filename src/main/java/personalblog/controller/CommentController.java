// package personalblog.controller;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// public class CommentController {

//     @Autowired
//     private CommentService commentService;

//     @GetMapping("/comments")
//     public ResponseEntity<List<Comment>> getAllComments() {
//         List<Comment> comments = commentService.getAllComments();
//         return new ResponseEntity<>(comments, HttpStatus.OK);
//     }

//     @GetMapping("/comment/{id}")
//     public ResponseEntity<Comment> getCommentById(@PathVariable Long id) {
//         Comment comment = commentService.getCommentById(id);
//         if (comment != null) {
//             return new ResponseEntity<>(comment, HttpStatus.OK);
//         } else {
//             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//         }
//     }

//     @PostMapping
//     public ResponseEntity<Comment> createComment(@RequestBody Comment comment) {
//         Comment createdComment = commentService.createComment(comment);
//         return new ResponseEntity<>(createdComment, HttpStatus.CREATED);
//     }

//     @PutMapping("/comment/{id}")
//     public ResponseEntity<Comment> updateComment(@PathVariable Long id, @RequestBody Comment comment) {
//         Comment updatedComment = commentService.updateComment(id, comment);
//         if (updatedComment != null) {
//             return new ResponseEntity<>(updatedComment, HttpStatus.OK);
//         } else {
//             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//         }
//     }

//     @DeleteMapping("/comment/{id}")
//     public ResponseEntity<HttpStatus> deleteComment(@PathVariable Long id) {
//         commentService.deleteComment(id);
//         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//     }
// }
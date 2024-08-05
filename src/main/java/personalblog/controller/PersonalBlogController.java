// package personalblog.controller;

// import org.springframework.web.bind.annotation.*;

// @RestController
// public class PersonalBlogController {

//     @Autowired
//     private BlogService blogService;

//     @GetMapping("/blogs")
//     public ResponseEntity<List<Site>> getAllBlogs() {
//         List<Site> sites = blogService.getAllBlogs();
//         return new ResponseEntity<>(sites, HttpStatus.OK);
//     }

//     @GetMapping("/blog/{id}")
//     public ResponseEntity<Site> getBlogById(@PathVariable Long id) {
//         Site site = blogService.getBlogById(id);
//         return new ResponseEntity<>(site, HttpStatus.OK);
//     }

//     @PostMapping
//     public ResponseEntity<Site> createBlog(@RequestBody Site site) {
//         Site createdBlog = blogService.createBlog(site);
//         return new ResponseEntity<>(createdBlog, HttpStatus.CREATED);
//     }

//     @PutMapping("/blog/{id}")
//     public ResponseEntity<Site> updateBlog(@PathVariable Long id, @RequestBody Site site) {
//         Site updatedSite = blogService.updateBlog(id, site);
//         return new ResponseEntity<>(updatedSite, HttpStatus.OK);
//     }

//     @DeleteMapping("/blog/{id}")
//     public ResponseEntity<Void> deleteBlog(@PathVariable Long id) {
//         blogService.deleteBlog(id);
//         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//     }
// }
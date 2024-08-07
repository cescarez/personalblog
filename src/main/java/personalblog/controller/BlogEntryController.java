package personalblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import personalblog.data.BlogEntry;
import personalblog.service.BlogEntryService;

@RestController
public class BlogEntryController {

    @Autowired
    private BlogEntryService blogEntryService;

    @GetMapping("/blog-entries")
    public ResponseEntity<List<BlogEntry>> getAllBlogEntries() {
        List<BlogEntry> blogEntries = blogEntryService.getAllBlogEntries();
        return new ResponseEntity<>(blogEntries, HttpStatus.OK);
    }

    @GetMapping("/blog-entry/{id}")
    public ResponseEntity<BlogEntry> getBlogEntryById(@PathVariable String id) {
        BlogEntry blogEntry = blogEntryService.getBlogEntryById(id);
        if (blogEntry != null) {
            return new ResponseEntity<>(blogEntry, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/blog-entry")
    public ResponseEntity<BlogEntry> createBlogEntry(@RequestBody BlogEntry blogEntry) {
        BlogEntry createdBlogEntry = blogEntryService.createBlogEntry(blogEntry);
        if (createdBlogEntry != null) {
            return new ResponseEntity<>(createdBlogEntry, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/blog-entry/{id}")
    public ResponseEntity<BlogEntry> updateBlogEntry(@PathVariable String id, @RequestBody BlogEntry blogEntry) {
        BlogEntry updatedBlogEntry = blogEntryService.updateBlogEntry(id, blogEntry);
        if (updatedBlogEntry != null) {
            return new ResponseEntity<>(updatedBlogEntry, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/blog-entry/{id}")
    public ResponseEntity<HttpStatus> deleteBlogEntry(@PathVariable String id) {
        boolean blogEntryDeleted = blogEntryService.deleteBlogEntry(id);
        if (blogEntryDeleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
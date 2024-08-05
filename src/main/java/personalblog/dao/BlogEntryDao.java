//package personalblog.dao;
//
//import personalblog.data.BlogEntry;
//
//import java.util.List;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import personalblog.data.BlogEntry;
//
//import java.util.List;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//public class BlogEntryDao {
//
//
//    public BlogEntryDao() {
//
//    }
//
//    public List<BlogEntry> getAllBlogEntries() {
//        List<BlogEntry> blogEntries;
//        String sqlQuery = "SELECT * FROM blog_entry";
//        return blogEntries;
//    }
//
//    public BlogEntry getBlogEntryById(String id) {
//        String sqlQuery = String.format("SELECT * FROM blog_entry WHERE blog_entry_id = '%s'", id);
//        BlogEntry blogEntry;
//        return blogEntry;
//    }
//
//    public BlogEntry createBlogEntry(BlogEntry blogEntry) {
//        String sqlQuery = String.format("INSERT INTO blog_entry (blog_id,title,content,isPublished)\nVALUES('%s','%s','%s','%s')", blogEntry.getBlogEntryId(), blogEntry.getTitle(), blogEntry.getContent(), blogEntry.isPublished());
//        BlogEntry createdBlogEntry;
//        return createdBlogEntry;
//    }
//
//    public BlogEntry updateBlogEntry(String id, BlogEntry blogEntry) {
//        String sqlQuery = String.format("UPDATE blog_entry SET <changes> WHERE blog_entry_id = '%s'", id);
//        BlogEntry updatedBlogEntry;
//        return updatedBlogEntry;
//    }
//
//    public void deleteBlogEntry(String id) {
//        String sqlQuery = String.format("DELETE FROM blog_entry WHERE blog_entry_id = '%s'", id);
//    }
//}
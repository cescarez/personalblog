package personalblog.service;

import com.google.common.base.Stopwatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import personalblog.dao.BlogEntryDAO;
import personalblog.data.BlogEntry;
import personalblog.util.Logger;

import java.util.List;

@Service
public class BlogEntryService {
    @Autowired
    BlogEntryDAO blogEntryDAO;
    Logger logger = Logger.getInstance();

    public List<BlogEntry> getAllBlogEntries() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        List<BlogEntry> blogEntryList = blogEntryDAO.getAll();
        long nsElapsed = stopwatch.elapsed().getNano();
        logger.log(String.format("Retrieved %s blog entries, took %s ns.", blogEntryList.size(), nsElapsed));
        return blogEntryList;
    }

    public BlogEntry getBlogEntryById(String blogEntryId) {
        Stopwatch stopwatch = Stopwatch.createStarted();
        BlogEntry retrievedBlogEntry =  blogEntryDAO.getById(blogEntryId);
        long nsElapsed = stopwatch.elapsed().getNano();
        logger.log(String.format("Retrieved blog entry, %s, took %s ns.", retrievedBlogEntry.getBlogEntryId(), nsElapsed));
        return retrievedBlogEntry;
    }

    public BlogEntry createBlogEntry(BlogEntry blogEntry) {
        Stopwatch stopwatch = Stopwatch.createStarted();
        BlogEntry createdBlogEntry = blogEntryDAO.add(blogEntry);
        long nsElapsed = stopwatch.elapsed().getNano();
        logger.log(String.format("Created new blog entry, %s, took %s ns.", createdBlogEntry.getBlogEntryId(), nsElapsed));
        return createdBlogEntry;
    }

    public BlogEntry updateBlogEntry(String blogEntryId, BlogEntry blogEntry) {
        Stopwatch stopwatch = Stopwatch.createStarted();
        BlogEntry updatedBlogEntry = blogEntryDAO.update(blogEntryId, blogEntry);
        long nsElapsed = stopwatch.elapsed().getNano();
        logger.log(String.format("Updated blog entry, %s, took %s ns.", updatedBlogEntry.getBlogEntryId(), nsElapsed));
        return updatedBlogEntry;
    }

    public boolean deleteBlogEntry(String blogEntryId) {
        Stopwatch stopwatch = Stopwatch.createStarted();
        boolean deletedBlogEntry = blogEntryDAO.delete(blogEntryId);
        long nsElapsed = stopwatch.elapsed().getNano();
        logger.log(String.format("Deleted blog entry, %s, took %s ns.", blogEntryId, nsElapsed));
        return deletedBlogEntry;
    }
}

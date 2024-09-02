package personalblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import personalblog.dao.BlogEntryDAO;
import personalblog.data.BlogEntry;

import java.util.List;

@Service
public class BlogEntryService {
    @Autowired
    BlogEntryDAO blogEntryDAO;

    public List<BlogEntry> getAllBlogEntries() {
        return blogEntryDAO.getAll();
    }

    public BlogEntry getBlogEntryById(String blogEntryId) {
        return blogEntryDAO.getById(blogEntryId);
    }

    public BlogEntry createBlogEntry(BlogEntry blogEntry) {
        return blogEntryDAO.add(blogEntry);
    }

    public BlogEntry updateBlogEntry(String blogEntryId, BlogEntry blogEntry) {
        return blogEntryDAO.update(blogEntryId, blogEntry);
    }

    public boolean deleteBlogEntry(String blogEntryId) {
        return blogEntryDAO.delete(blogEntryId);
    }
}

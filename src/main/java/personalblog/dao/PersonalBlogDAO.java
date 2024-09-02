package personalblog.dao;

import java.util.List;

public class PersonalBlogDAO extends SiteDAO {
    public PersonalBlogDAO(String url, String title) {
        super(url, title, "");
    }

    public PersonalBlogDAO(String url, String title, String description) {
        super(url, title, description);
    }

    public String createBlogEntry(String title, String content) {
        // Implement logic to create a blog entry
        // return blogId for newly created blog entry
        // add blogId to blogEntryIds
        // save to db via some private method
        return null;
    }

    public String readBlogEntry(String blogId) {
        // Implement logic to read a blog entry
        return null;
    }

    public List<String> readAllBlogEntries() {
        // Implement logic to read all blog entries
        return null;
    }

    public BlogEntryDAO updateBlogEntry(String title, String newContent) {
        // Implement logic to update a blog entry
        // return updated object
        return null;
    }

    public void deleteBlogEntry(String title) {
        // Implement logic to delete a blog entry
        // update blogEntryIds via
    }
}
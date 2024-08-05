package personalblog.data;

import java.time.Instant;
import java.util.UUID;

public class BlogEntry {

    private String blogEntryId;

    private String blogSiteId;

    private Instant createdDate;

    private String title;
    
    private String content;

    private boolean isPublished;

    public BlogEntry(String blogSiteId, String title, String content) {
        this(null, null, blogSiteId, title, content, false);
    }

    public BlogEntry(String blogEntryId, Instant createdDate, String blogSiteId, String title, String content, boolean isPublished) {
//        this.blogEntryId = blogEntryId != null ? blogEntryId : UUID.randomUUID().toString();
//        this.createdDate = createdDate != null ? createdDate : Instant.now();
        this.blogEntryId = blogEntryId;
        this.createdDate = createdDate;
        this.blogSiteId = blogSiteId;
        this.title = title;
        this.content = content;
        this.isPublished = isPublished;
    }

    public String getBlogEntryId() {
        return blogEntryId;
    }

    public String getBlogSiteId() {
        return blogSiteId;
    }

    public Instant getCreatedDate() {
        return createdDate;
    }

    public String getTitle() {
        return title;
    }

      public String setTitle(String title) {
        this.title = title;
        return title;
      }

      public String getContent() {
        return content;
      }

      public String setContent(String content) {
        this.content = content;
        return content;
      }

      public boolean isPublished() {
        return isPublished;
      }

      public String publishBlogEntry() {
        //TODO: implement
        this.isPublished = true;
        return blogEntryId;
      }

      public void archiveBlogEntry() {
        //TODO: implement
        this.isPublished = false;
      }
}
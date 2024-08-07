package personalblog.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.extern.jackson.Jacksonized;
import org.springframework.lang.NonNull;

import java.time.LocalDateTime;

@Jacksonized @Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class BlogEntry {
    private String blogEntryId;
    private LocalDateTime createdDate;
    private String blogSiteId;
    private String title;
    private String content;
    private boolean isPublished;

    public BlogEntry(@JsonProperty("blogSiteId") String blogSiteId, @JsonProperty("title") String title, @JsonProperty("content") String content) {
        this(null, null, blogSiteId, title, content, false);
    }

    public BlogEntry(String blogEntryId, LocalDateTime createdDate, @NonNull String blogSiteId, @NonNull String title, @NonNull String content, boolean isPublished) {
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

    public LocalDateTime getCreatedDate() {
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
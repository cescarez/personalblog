package personalblog.dao;

import java.time.Instant;
import java.util.UUID;

public class CommentDAO {
    private String commentId;
    private String blogEntryId;
    private String userId;
    private Instant createdDate;
    private String title;
    private String content;
    private boolean isPublished;

    public CommentDAO(String blogEntryId, String content) {
        this(blogEntryId, "", content);
    }

    public CommentDAO(String blogEntryId, String title, String content) {
        this.commentId = UUID.randomUUID().toString();
        this.createdDate = Instant.now();
        this.blogEntryId = blogEntryId;
        this.title = title;
        this.content = content;
    }

    public String getCommentId() {
        return commentId;
    }

    public String setCommentId(String commentId) {
        this.commentId = commentId;
        return commentId;
    }

    public String getBlogEntryId() {
        return blogEntryId;
    }

    public String setBlogEntryId(String blogEntryId) {
        this.blogEntryId = blogEntryId;
        return blogEntryId;
    }

    public String getUserId() {
        return userId;
    }

    public String setUserId(String userId) {
        this.userId = userId;
        return userId;
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

    public String publishComment() {
        //TODO: implement
        this.isPublished = true;
        return commentId;
    }

    public void archiveBlogEntry() {
        //TODO: implement
        this.isPublished = false;
    }
}
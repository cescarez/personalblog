package personalblog.dao;

import personalblog.data.Comment;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CommentDAO {
    public List<Comment> getAll() {
        List<Comment> commentList = new ArrayList<>();
        return commentList;
    }

    public Comment getById(String commentId) {
        return null;
    }

    public Comment add(Comment comment) {
        return null;
    }

    public Comment update(String commentId, Comment comment) {
        return null;
    }

    public Comment delete(String commentId) {
        return null;
    }
}
package personalblog.service;

import org.springframework.stereotype.Service;
import personalblog.data.BlogEntry;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Service
public class BlogEntryService {
    private final String user = "postgres";
    private final String password = "postgres";

    public List<BlogEntry> getAllBlogEntries() {
        List<BlogEntry> blogEntries = new ArrayList<>();
        String sqlQuery = "SELECT * FROM blog_entry;";
        try {
            String url = "jdbc:postgresql://localhost:5432/blog";
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(sqlQuery);
            while (resultSet.next()) {

                System.out.println(resultSet);
                System.out.println(resultSet.toString());
                BlogEntry retrievedBlogEntry =
                        new BlogEntry(
                                resultSet.getString("id"),
                                resultSet.getTimestamp("created_at").toLocalDateTime(),
                                resultSet.getString("blog_id"),
                                resultSet.getString("title"),
                                resultSet.getString("content"),
                                resultSet.getBoolean("is_published"));
                blogEntries.add(retrievedBlogEntry);
                System.out.println(retrievedBlogEntry);
            }

            System.out.println(resultSet.getFetchSize());

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return blogEntries;
    }

    public BlogEntry getBlogEntryById(String blogEntryId) {
        String sqlQuery = String.format("SELECT * FROM blog_entry WHERE id = '%s';", blogEntryId);
        BlogEntry blogEntry = null;
        try {
            String url = "jdbc:postgresql://localhost:5432/blog";
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            if (resultSet.next()) {
                blogEntry = new BlogEntry(
                        resultSet.getString("id"),
                        resultSet.getTimestamp("created_at").toLocalDateTime(),
                        resultSet.getString("blog_id"),
                        resultSet.getString("title"),
                        resultSet.getString("content"),
                        resultSet.getBoolean("is_published"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return blogEntry;
    }

    public BlogEntry createBlogEntry(BlogEntry blogEntry) {
        String sqlQuery = String.format("INSERT INTO blog_entry (blog_id,title,content)\nVALUES('%s','%s','%s');", blogEntry.getBlogSiteId(), blogEntry.getTitle(), blogEntry.getContent());
        BlogEntry createdBlogEntry = null;
        try {
            String url = "jdbc:postgresql://localhost:5432/blog";
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement statement = conn.createStatement();
            int updatedRow = statement.executeUpdate(sqlQuery);
            if (updatedRow > 0) {
                Statement getStatement = conn.createStatement();
                ResultSet getResultSet = getStatement.executeQuery(String.format("SELECT * FROM blog_entry ORDER BY created_at DESC LIMIT 1 OFFSET %s;", updatedRow - 1));
                if (getResultSet.next()) {
                    createdBlogEntry = new BlogEntry(
                            getResultSet.getString("id"),
                            getResultSet.getTimestamp("created_at").toLocalDateTime(),
                            getResultSet.getString("blog_id"),
                            getResultSet.getString("title"),
                            getResultSet.getString("content"),
                            getResultSet.getBoolean("is_published"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return createdBlogEntry;
    }

    public BlogEntry updateBlogEntry(String blogEntryId, BlogEntry blogEntry) {
        String sqlQuery = String.format("UPDATE blog_entry\nSET blog_id = '%s',title = '%s',content = '%s',is_published =%s\nWHERE id= '%s';",
                blogEntry.getBlogSiteId(), blogEntry.getTitle(), blogEntry.getContent(), blogEntry.isPublished(), blogEntryId);
        BlogEntry updatedBlogEntry = null;
        try {
            String url = "jdbc:postgresql://localhost:5432/blog";
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement statement = conn.createStatement();
            int updatedRow = statement.executeUpdate(sqlQuery);
            if (updatedRow > 0) {
                Statement getStatement = conn.createStatement();
                ResultSet getResultSet = getStatement.executeQuery(String.format("SELECT * FROM blog_entry WHERE id = '%s' LIMIT 1 OFFSET %s;", blogEntryId, updatedRow - 1));
                if (getResultSet.next()) {
                    updatedBlogEntry = new BlogEntry(
                            getResultSet.getString("id"),
                            getResultSet.getTimestamp("created_at").toLocalDateTime(),
                            getResultSet.getString("blog_id"),
                            getResultSet.getString("title"),
                            getResultSet.getString("content"),
                            getResultSet.getBoolean("is_published"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return updatedBlogEntry;
    }

    public boolean deleteBlogEntry(String blogEntryId) {
        String sqlQuery = String.format("DELETE FROM blog_entry WHERE id = '%s';", blogEntryId);

        try {
            String url = "jdbc:postgresql://localhost:5432/blog";
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement statement = conn.createStatement();
            int deletedRow = statement.executeUpdate(sqlQuery);
            return deletedRow > 0;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

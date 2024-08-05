package personalblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import personalblog.data.BlogEntry;

import java.sql.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Service
public class BlogEntryService {
    Connection conn;

    public BlogEntryService() {
        try {
            String ec2Port = "3.81.98.94:8080";
            String url = "jdbc:postgresql://localhost/test";
            Properties props = new Properties();
            props.setProperty("user", "dbuser");
            props.setProperty("password", "secret");
            props.setProperty("ssl", "true");
            props.setProperty("options", "-c search_path=test,public,pg_catalog -c statement_timeout=90000");
            Connection conn = DriverManager.getConnection(url, props);
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<BlogEntry> getAllBlogEntries() {
        List<BlogEntry> blogEntries = new ArrayList<>();
        String sqlQuery = "SELECT * FROM blog_entry";
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            while (resultSet.next()) {
                BlogEntry retrievedBlogEntry =
                        new BlogEntry(
                                resultSet.getString("blog_entry_id"),
                                resultSet.getTimestamp("created_at").toInstant(),
                                resultSet.getString("blog_id"),
                                resultSet.getString("title"),
                                resultSet.getString("content"),
                                resultSet.getBoolean("is_published"));
                blogEntries.add(retrievedBlogEntry);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return blogEntries;
    }

    public BlogEntry getBlogEntryById(String blogEntryId) {
        String sqlQuery = String.format("SELECT * FROM blog_entry WHERE blog_entry_id = '%s'", blogEntryId);
        BlogEntry blogEntry = null;
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            if (resultSet.next()) {
                blogEntry = new BlogEntry(
                        resultSet.getString("blog_entry_id"),
                        resultSet.getTimestamp("created_at").toInstant(),
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
        String sqlQuery = String.format("INSERT INTO blog_entry (blog_id,title,content,is_published)\nVALUES('%s','%s','%s','%s')", blogEntry.getBlogEntryId(), blogEntry.getTitle(), blogEntry.getContent(), blogEntry.isPublished());
        BlogEntry createdBlogEntry = null;
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            if (resultSet.next()) {
                Statement getStatement = conn.createStatement();
                ResultSet getResultSet = getStatement.executeQuery("SELECT TOP 1 * FROM blog_entry ORDER BY created_at DESC");
                if (getResultSet.next()) {
                    createdBlogEntry = new BlogEntry(
                            resultSet.getString("blog_entry_id"),
                            resultSet.getTimestamp("created_at").toInstant(),
                            resultSet.getString("blog_id"),
                            resultSet.getString("title"),
                            resultSet.getString("content"),
                            resultSet.getBoolean("is_published"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return createdBlogEntry;
    }

    public BlogEntry updateBlogEntry(String blogEntryId, BlogEntry blogEntry) {
        String sqlQuery = String.format("UPDATE blog_entry\nSET blog_id = %s,title = %s,content = %s,is_published =%s\nWHERE blog_entry_id= '%s')",
                blogEntry.getBlogSiteId(), blogEntry.getTitle(), blogEntry.getContent(), blogEntry.isPublished(), blogEntryId);
        BlogEntry updatedBlogEntry = null;
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            if (resultSet.next()) {
                Statement getStatement = conn.createStatement();
                ResultSet getResultSet = getStatement.executeQuery("SELECT TOP 1 * FROM blog_entry ORDER BY updated_at DESC");
                if (getResultSet.next()) {
                    updatedBlogEntry = new BlogEntry(
                            resultSet.getString("blog_entry_id"),
                            resultSet.getTimestamp("created_at").toInstant(),
                            resultSet.getString("blog_id"),
                            resultSet.getString("title"),
                            resultSet.getString("content"),
                            resultSet.getBoolean("is_published"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return updatedBlogEntry;
    }

    public void deleteBlogEntry(String blogEntryId) {
        String sqlQuery = String.format("DELETE FROM blog_entry WHERE blog_entry_id = '%s'", blogEntryId);

        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            if (!resultSet.next()) {
                throw new Exception("No blog entry has been deleted");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

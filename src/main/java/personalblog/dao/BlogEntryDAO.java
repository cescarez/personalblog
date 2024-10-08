package personalblog.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.extern.jackson.Jacksonized;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import personalblog.data.BlogEntry;
import personalblog.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
@Jacksonized @Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class BlogEntryDAO {

    public List<BlogEntry> getAll() {
        List<BlogEntry> blogEntries = new ArrayList<>();
        String sqlQuery = "SELECT * FROM public.blog_entry;";
        try {
            Connection conn = DatabaseConnection.getConnection();
            Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(sqlQuery);
            while (resultSet.next()) {
                BlogEntry retrievedBlogEntry =
                        new BlogEntry(
                                resultSet.getString("id"),
                                resultSet.getTimestamp("created_at").toLocalDateTime(),
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

    public BlogEntry getById(String blogEntryId) {
        String sqlQuery = String.format("SELECT * FROM public.blog_entry WHERE id = '%s';", blogEntryId);
        BlogEntry blogEntry = null;
        try {
            Connection conn = DatabaseConnection.getConnection();
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

    public BlogEntry add(BlogEntry blogEntry) {
        String sqlQuery = String.format("INSERT INTO public.blog_entry (blog_id,title,content)\nVALUES('%s','%s','%s');", blogEntry.getBlogSiteId(), blogEntry.getTitle(), blogEntry.getContent());
        BlogEntry createdBlogEntry = null;
        try {
            Connection conn = DatabaseConnection.getConnection();
            Statement statement = conn.createStatement();
            int updatedRow = statement.executeUpdate(sqlQuery);
            if (updatedRow > 0) {
                Statement getStatement = conn.createStatement();
                ResultSet getResultSet = getStatement.executeQuery(String.format("SELECT * FROM public.blog_entry ORDER BY created_at DESC LIMIT 1 OFFSET %s;", updatedRow - 1));
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

    public BlogEntry update(String blogEntryId, BlogEntry blogEntry) {
        String sqlQuery = String.format("UPDATE public.blog_entry\nSET blog_id = '%s',title = '%s',content = '%s',is_published =%s\nWHERE id= '%s';",
                blogEntry.getBlogSiteId(), blogEntry.getTitle(), blogEntry.getContent(), blogEntry.isPublished(), blogEntryId);
        BlogEntry updatedBlogEntry = null;
        try {
            Connection conn = DatabaseConnection.getConnection();
            Statement statement = conn.createStatement();
            int updatedRow = statement.executeUpdate(sqlQuery);
            if (updatedRow > 0) {
                Statement getStatement = conn.createStatement();
                ResultSet getResultSet = getStatement.executeQuery(String.format("SELECT * FROM public.blog_entry WHERE id = '%s' LIMIT 1 OFFSET %s;", blogEntryId, updatedRow - 1));
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

    public boolean delete(String blogEntryId) {
        String sqlQuery = String.format("DELETE FROM public.blog_entry WHERE id = '%s';", blogEntryId);

        try {
            Connection conn = DatabaseConnection.getConnection();
            Statement statement = conn.createStatement();
            int deletedRow = statement.executeUpdate(sqlQuery);
            return deletedRow > 0;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
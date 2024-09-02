package personalblog.dao;

import java.time.Instant;
import java.util.UUID;

public class SiteDAO {

  private String siteId;

  private String siteOwner;

  private String url;

  private String title;

  private String description;

  private Instant createdDate;

  private boolean isPublished;

  public SiteDAO(String url, String title) {
    this(url, title, "");
  }

  public SiteDAO(String url, String title, String description) {
    this.siteId = UUID.randomUUID().toString();
    this.siteOwner = ""; // implement for current user;
    this.createdDate = Instant.now();
    this.url = url;
    this.title = title;
    this.description = description;
    this.isPublished = false;
  }

  public String getSiteId() {
    return url;
  }

  public Instant getCreatedDate() {
    return createdDate;
  }
  
  public String getUrl() {
    return url;
  }

  public String setUrl(String url) {
    this.url = url;
    return url;
  }

  public String getTitle() {
    return title;
  }

  public String setTitle(String title) {
    this.title = title;
    return title;
  }

  public String getDescription() {
    return description;
  }

  public String setDescription(String description) {
    this.description = description;
    return description;
  }

  public boolean isPublished() {
    return isPublished;
  }

  public String publishSite() {
    //TODO: implement
    this.isPublished = true;
    return siteId;
  }

  public void archiveSite() {
    //TODO: implement
    this.isPublished = false;
  }
}
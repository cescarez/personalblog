// package personalblog.controller;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// public class SiteController {

//     @Autowired
//     private SiteService siteService;

//     @GetMapping("/sites")
//     public ResponseEntity<List<Site>> getAllSites() {
//         List<Site> sites = siteService.getAllSites();
//         return new ResponseEntity<>(sites, HttpStatus.OK);
//     }

//     @GetMapping("/site/{id}")
//     public ResponseEntity<Site> getSiteById(@PathVariable Long id) {
//         Site site = siteService.getSiteById(id);
//         return new ResponseEntity<>(site, HttpStatus.OK);
//     }

//     @PostMapping
//     public ResponseEntity<Site> createSite(@RequestBody Site site) {
//         Site createdSite = siteService.createSite(site);
//         return new ResponseEntity<>(createdSite, HttpStatus.CREATED);
//     }

//     @PutMapping("/site/{id}")
//     public ResponseEntity<Site> updateSite(@PathVariable Long id, @RequestBody Site site) {
//         Site updatedSite = siteService.updateSite(id, site);
//         return new ResponseEntity<>(updatedSite, HttpStatus.OK);
//     }

//     @DeleteMapping("/site/{id}")
//     public ResponseEntity<Void> deleteSite(@PathVariable Long id) {
//         siteService.deleteSite(id);
//         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//     }
// }
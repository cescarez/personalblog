## Personal blog for UW SDDE 330
   
   | Homework # | Content                         |
   |------------|---------------------------------|
   | 1          | no app work                     |
   | 2          | Data modeling                   |
   | 3          | Database setup                  |
   | 4/5        | App Server and APIs             |
   | 6          | UX                              |
   | 7          | Refactor w/ Singleton Logger    |
   | 8          | Code Review w/ SOLID principles |

### To run the app:
1. Run `mvn clean package` to build project and compile jar into target directory
2. Locally:
   1. Navigate to the target subdirectory and run `java -jar personalblog-0.1-SNAPSHOT-exec.jar`
   2. See "To utilize service" below for API calls, or use [Postman collection](https://www.postman.com/cescarez/workspace/sde-330/collection/12985570-938b3f8b-3120-4263-aa1c-923a82e6c295?action=share&creator=12985570) and [Postman environment](https://www.postman.com/cescarez/workspace/sde-330/environment/12985570-46663790-5dbd-419e-b143-2f34ef0602f4](https://www.postman.com/cescarez/workspace/sde-330/environment/12985570-edcf4111-0cff-4d88-805e-8fc4e419b809).
3. In EC2:
   1. To deploy (Note: application is already deployed and running for Christabel Escarez's SDE 330 final app submission. Confirm app is running with `sudo systemctl status personal-blog-l`. If app is not running, run `sudo systemctl start personal-blog`.
      1. Log onto EC2 instance by logging into AWS console and copying SSH command to connect to instance. `cd` into directory with your pem file before executing command. Ex: `ssh -i <pem> ec2-user@ec2-3-92-145-82.compute-1.amazonaws.com`
      2. Ensure Postgres is running: `sudo systemctl status postgresql`
      3. In local terminal, `cd` into directory with your pem file and copy jar from local target directory into home directory of ES instance: `scp -i <pem> target/personalblog-0.1-SNAPSHOT-exec.jar ec2-user@ec2-3-92-145-82.compute-1.amazonaws.com:~/.`
      4. In EC2 terminal, execute jar to run program: `java -jar personalblog-0.1-SNAPSHOT-exec.jar`
   3. To use service,see "To utilize service" below for API calls, or use [Postman collection](https://www.postman.com/cescarez/workspace/sde-330/collection/12985570-938b3f8b-3120-4263-aa1c-923a82e6c295?action=share&creator=12985570) and [Postman environment](https://www.postman.com/cescarez/workspace/sde-330/environment/12985570-d06455f2-0299-4051-8251-5357ab8a661a).

### To utilize service:

  | verb | resource  | request body |
  |------|-----------|--------------|
  | GET | `http://35.172.125.237:8080/blog-entries` | N/A |
  | GET | `http://35.172.125.237:8080/blog-entry/<blog-entry-id>` | N/A |
  | POST | `http://35.172.125.237:8080/blog-entry` | Required: UUID `blogSiteId`, String `title`, String `content`<br/><br/>Example request body:<br/>```{"blogSiteId": "0dda8e3d-f13e-4f27-9115-1c2934291a91", "title": "new blog entry","content": "contents of new blog entry"}``` |
  | PUT | `http://35.172.125.237:8080/blog-entry/<blog-entry-id>` | Example request body:<br/> ```{"title": "updated title of blog entry"}``` |
  | DELETE | `http://35.172.125.237:8080/blog-entry/<blog-entry-id>` | N/A |

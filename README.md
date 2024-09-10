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
2. Log onto EC2 instance by logging into AWS console and copying SSH command to connect to instance. `cd` into directory with your pem file before executing command. Ex: `ssh -i <pem> ec2-user@ec2-3-92-145-82.compute-1.amazonaws.com`
   1. Ensure Postgres is running: `sudo systemctl status postgresql`
3. In local terminal, `cd` into directory with your pem file and copy jar from local target directory into home directory of ES instance: `scp -i <pem> target/personalblog-0.1-SNAPSHOT-exec.jar ec2-user@ec2-3-92-145-82.compute-1.amazonaws.com:~/.`
4. In EC2 terminal, execute jar to run program: `java -jar personalblog-0.1-SNAPSHOT-exec.jar`
5. Utilize service
     1. Use Postman or curl to send API requests. See below, or use [Postman collection](https://www.postman.com/cescarez/workspace/sde-330/collection/12985570-938b3f8b-3120-4263-aa1c-923a82e6c295?action=share&creator=12985570) and [Postman environment](https://www.postman.com/cescarez/workspace/sde-330/environment/12985570-d06455f2-0299-4051-8251-5357ab8a661a)
        | verb | resource  | request body |
        |------|-----------|--------------|
        | GET | `https://35.172.125.237/blog-entries` | N/A |
        | GET | `https://35.172.125.237/blog-entry/<blog-entry-id>` | N/A |
        | POST | `https://35.172.125.237/blog-entry` | Required: UUID `blogSiteId`, String `title`, String `content`<br/><br/>Example request body:<br/>```{"blogSiteId": "0dda8e3d-f13e-4f27-9115-1c2934291a91", "title": "new blog entry","content": "contents of new blog entry"}``` |
        | PUT | `https://35.172.125.237/blog-entry/<blog-entry-id>` | Example request body:<br/> ```{"title": "updated title of blog entry"}``` |
        | DELETE | `https://35.172.125.237/blog-entry/<blog-entry-id>` | N/A |

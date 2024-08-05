package personalblog;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import personalblog.service.BlogEntryService;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public BlogEntryService blogEntryService() {
        return new BlogEntryService();
    }
}

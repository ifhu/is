package top.ifhu.api.setting.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.session.web.http.CookieSerializer;
import org.springframework.session.web.http.DefaultCookieSerializer;


@Configuration
public class SessionConfig {

    @Value("${app.domain}")
    private String domainName;
    @Bean
    public CookieSerializer cookieSerializer(){
        DefaultCookieSerializer defaultCookieSerializer = new DefaultCookieSerializer();
        defaultCookieSerializer.setCookieName("ufu_serssion_id");
        defaultCookieSerializer.setDomainName(domainName);

        defaultCookieSerializer.setCookiePath("/");
        defaultCookieSerializer.setCookieMaxAge(1800);
        return defaultCookieSerializer;
    }
}

package com.github.eljo.elasticuser;

import com.github.eljo.elasticuser.model.User;
import com.github.eljo.elasticuser.repo.UserRepository;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.elasticsearch.ElasticsearchContainer;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(initializers = { ElasticIT.Initializer.class })
public class ElasticIT {

    @ClassRule
    public static ElasticsearchContainer elasticSearch = new ElasticsearchContainer("docker.elastic.co/elasticsearch/elasticsearch:6.8.1")
            .withEnv("cluster.name", "elasticsearch");

    static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
        @Override
        public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
            TestPropertyValues.of("spring.data.elasticsearch.cluster-nodes=" +
                    elasticSearch.getContainerIpAddress() + ":" + elasticSearch.getMappedPort(9300))
                .applyTo(configurableApplicationContext.getEnvironment());
        }
    }

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testCreateUser() {
        User user = new User();
        user.setEmail("foo@example.com");
        user.setFirstName("bar");

        userRepository.save(user);

        assertEquals("bar", userRepository.findById("foo@example.com").orElseThrow().getFirstName());
    }
}

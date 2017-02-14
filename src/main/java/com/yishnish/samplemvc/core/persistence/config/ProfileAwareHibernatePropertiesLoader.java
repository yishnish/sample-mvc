package com.yishnish.samplemvc.core.persistence.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Component
@PropertySource("classpath:/hibernate.properties")
public class ProfileAwareHibernatePropertiesLoader {

    private Environment environment;
    private DeployEnvironmentProfile deployEnvironmentProfile;

    @Autowired
    public ProfileAwareHibernatePropertiesLoader(Environment environment) {
        this.environment = environment;
        this.deployEnvironmentProfile = getDeployEnvironmentProfile();
    }

    public String getProperty(String key) {
        return environment.getProperty(String.format("%s.%s", this.deployEnvironmentProfile.toString(), key));
    }

    private DeployEnvironmentProfile getDeployEnvironmentProfile() {
        final Stream<DeployEnvironmentProfile> deployProfiles = Arrays.stream(DeployEnvironmentProfile.values());
        List<String> activeProfiles = Arrays.asList(environment.getActiveProfiles());
        Optional<DeployEnvironmentProfile> anyMatchingProfile = deployProfiles.filter(deployProfile -> activeProfiles.contains(deployProfile.toString())).findFirst();

        return anyMatchingProfile.get();
    }

    private enum DeployEnvironmentProfile {
        TEST("test"), DEV("dev"), PROD("prod");

        private final String name;

        DeployEnvironmentProfile(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return this.name;
        }
    }
}

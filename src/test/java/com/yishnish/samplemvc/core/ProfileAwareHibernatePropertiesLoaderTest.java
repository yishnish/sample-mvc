package com.yishnish.samplemvc.core;

import com.yishnish.samplemvc.core.persistence.config.ProfileAwareHibernatePropertiesLoader;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.env.Environment;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ProfileAwareHibernatePropertiesLoaderTest {

    private Environment environment;
    private ProfileAwareHibernatePropertiesLoader loader;

    @Before
    public void setUp() {
        environment = mock(Environment.class);
    }

    @Test
    public void testAddsCorrectTestDevOrProdEnvironmentPrefixToProperties(){
        String[] testProfileActive = {"test"};
        String[] devProfileActive = {"dev"};
        String[] prodProfileActive = {"prod"};

        when(environment.getActiveProfiles()).thenReturn(testProfileActive);
        when(environment.getProperty("test.foo")).thenReturn("test foo value");
        loader = new ProfileAwareHibernatePropertiesLoader(environment);
        assertThat(loader.getProperty("foo"), equalTo("test foo value"));

        when(environment.getActiveProfiles()).thenReturn(devProfileActive);
        when(environment.getProperty("dev.foo")).thenReturn("dev foo value");
        loader = new ProfileAwareHibernatePropertiesLoader(environment);
        assertThat(loader.getProperty("foo"), equalTo("dev foo value"));

        when(environment.getActiveProfiles()).thenReturn(prodProfileActive);
        when(environment.getProperty("prod.foo")).thenReturn("prod foo value");
        loader = new ProfileAwareHibernatePropertiesLoader(environment);
        assertThat(loader.getProperty("foo"), equalTo("prod foo value"));
    }
}

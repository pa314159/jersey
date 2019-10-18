package org.glassfish.jersey.inject.cdi.se;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.AfterBeanDiscovery;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.Extension;

public class ScopesExtension implements Extension {
    public void registerScope(@Observes AfterBeanDiscovery abd, BeanManager beanManager) {
        abd.addBean(new RequestScopeBean(beanManager));
        abd.addBean(new ExternalRequestScopeBean());
    }
}

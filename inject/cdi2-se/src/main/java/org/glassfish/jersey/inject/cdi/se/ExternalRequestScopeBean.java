package org.glassfish.jersey.inject.cdi.se;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Set;

import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Singleton;

import static java.util.Collections.emptySet;
import static java.util.Collections.singleton;
import static java.util.Collections.unmodifiableSet;

import org.glassfish.jersey.internal.inject.InjectionManager;
import org.glassfish.jersey.server.spi.ExternalRequestContext;
import org.glassfish.jersey.server.spi.ExternalRequestScope;

public class ExternalRequestScopeBean implements Bean<ExternalRequestScope<?>> {
    private static final ExternalRequestScope<Object> NOOP_EXTERNAL_REQ_SCOPE = new ExternalRequestScope<Object>() {

        @Override
        public ExternalRequestContext<Object> open(InjectionManager injectionManager) {
            return null;
        }

        @Override
        public void close() {
        }

        @Override
        public void suspend(ExternalRequestContext<Object> o, InjectionManager injectionManager) {
        }

        @Override
        public void resume(ExternalRequestContext<Object> o, InjectionManager injectionManager) {
        }
    };

    private static final Set<Annotation> QUALIFIERS = unmodifiableSet(new HashSet<Annotation>() {
        {
            add(Any.Literal.INSTANCE);
            add(Default.Literal.INSTANCE);
        }
    });

    @Override
    public ExternalRequestScope<?> create(CreationalContext<ExternalRequestScope<?>> creationalContext) {
        return NOOP_EXTERNAL_REQ_SCOPE;
    }

    @Override
    public void destroy(ExternalRequestScope<?> instance, CreationalContext<ExternalRequestScope<?>> creationalContext) {
    }

    @Override
    public Set<Type> getTypes() {
        return singleton(ExternalRequestScope.class);
    }

    @Override
    public Set<Annotation> getQualifiers() {
        return QUALIFIERS;
    }

    @Override
    public Class<? extends Annotation> getScope() {
        return Singleton.class;
   }

    @Override
    public String getName() {
        return ExternalRequestScope.class.getName();
    }

    @Override
    public Set<Class<? extends Annotation>> getStereotypes() {
        return emptySet();
    }

    @Override
    public boolean isAlternative() {
        return false;
    }

    @Override
    public Class<?> getBeanClass() {
        return ExternalRequestScope.class;
    }

    @Override
    public Set<InjectionPoint> getInjectionPoints() {
        return emptySet();
    }

    @Override
    public boolean isNullable() {
        return false;
    }

}

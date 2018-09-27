package fx.leyu.spring.base;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class SpringLifecycleBean implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, BeanPostProcessor,
        InitializingBean, DisposableBean {
    @Override
    public void setBeanName(String name) {
        System.out.println("[Lifecycle][BeanNameAware] setBeanName + " + name);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("[Lifecycle][BeanFactoryAware] setBeanFactory + " + beanFactory);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("[Lifecycle][ApplicationContextAware] setApplicationContext + " + applicationContext);
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("[Lifecycle][BeanPostProcessor] postProcessBeforeInitialization + " + beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("[Lifecycle][BeanPostProcessor] postProcessAfterInitialization + " + beanName);
        return bean;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("[Lifecycle][InitializingBean] afterPropertiesSet");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("[Lifecycle][DisposableBean] destroy");
    }
}

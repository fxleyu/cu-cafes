package fx.leyu.spring.base;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringLifecycleBean implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, BeanPostProcessor,
        InitializingBean, DisposableBean {

    public SpringLifecycleBean() {
        System.out.println("INIT");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("[Lifecycle][BeanNameAware] setBeanName + " + name);
        //new RuntimeException("setBeanName").printStackTrace();
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("[Lifecycle][BeanFactoryAware] setBeanFactory + " + beanFactory);
        //new RuntimeException("setBeanFactory").printStackTrace();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("[Lifecycle][ApplicationContextAware] setApplicationContext + " + applicationContext);
        //new RuntimeException("setApplicationContext").printStackTrace();
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("[Lifecycle][BeanPostProcessor] postProcessBeforeInitialization + " + beanName);
        //new RuntimeException("postProcessBeforeInitialization").printStackTrace();
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("[Lifecycle][BeanPostProcessor] postProcessAfterInitialization + " + beanName + ", bean class is " + bean.getClass().getName());
        //new RuntimeException("postProcessAfterInitialization").printStackTrace();
        System.out.println(this.getClass().getName());
        return bean;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("[Lifecycle][InitializingBean] afterPropertiesSet");
        //new RuntimeException("afterPropertiesSet").printStackTrace();
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("[Lifecycle][DisposableBean] destroy");
        //new RuntimeException("destroy").printStackTrace();
    }

    public void initMethod() {
        System.out.println("[Lifecycle][init-method] initMethod");
    }

    public void destroyMethod() {
        System.out.println("[Lifecycle][destroy-method] destroyMethod");
    }
}

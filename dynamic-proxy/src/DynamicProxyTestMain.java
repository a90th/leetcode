import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxyTestMain {

    public static void main(String[] args) {
        EntityOne entityOne = new EntityOne();
        System.out.println(entityOne.getRealClassName());

        PolicyOne entityOneProxy = (PolicyOne) Proxy.newProxyInstance(entityOne.getClass().getClassLoader(),
                entityOne.getClass().getInterfaces(), new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println(proxy.getClass().getCanonicalName());
                        System.out.println(method.getName());
                        Object result=method.invoke(entityOne,args);
                        System.out.print(result);
                        return result;
                    }
                });
        entityOneProxy.getRealClassName();
    }
}

package creationalPatterns.Proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Proxy {
}
interface Speaker{
    public void speak();
}
class ZhangSan implements Speaker{
    @Override
    public void speak() {
        System.out.println("别打我");
    }
}

class LiSi{
    public void speak(){
        System.out.println("don't hit me");

    };
}
// 静态代理
class Lawyer implements Speaker{
    private ZhangSan zhangSan = new ZhangSan();
    @Override
    public void speak() {
        System.out.println("打人违法！");
        zhangSan.speak();
        System.out.println("打人不对");
    }
}

// 动态代理
class LawyerProxy implements InvocationHandler {
    private Object  obj;
    public LawyerProxy(Object obj){
        this.obj = obj;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().equals("speak")){
            System.out.println("打人违法！");
            method.invoke(obj,args); //通过反射
            System.out.println("打人不对");

        }
        return null;
    }

}
class LawyerInterceptor implements MethodInterceptor {
    private Object  obj;
    public LawyerInterceptor(Object obj){
        this.obj = obj;
    }
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        if (method.getName().equals("speak")){
            System.out.println("打人违法！");
            method.invoke(obj,objects); //通过反射
            System.out.println("打人不对");
        }
        return null;
    }
}
class Demo {
    public static void main(String[] args) {

        //静态代理
        Speaker speaker = new Lawyer();
        speaker.speak();
        //JDK-动态代理：本体必须要实现接口
        LawyerProxy lawyerProxy = new LawyerProxy(new ZhangSan());
        Speaker speaker1 = (Speaker) java.lang.reflect.Proxy.newProxyInstance(Demo.class.getClassLoader(), new Class[]{Speaker.class}, lawyerProxy);
        speaker1.speak();

        // CGLib-动态代理：不需要本体实现接口
        LawyerInterceptor lawyerInterceptor = new LawyerInterceptor(new LiSi());
        LiSi liSi = (LiSi) Enhancer.create(LiSi.class, lawyerInterceptor);
        liSi.speak();

    }
}
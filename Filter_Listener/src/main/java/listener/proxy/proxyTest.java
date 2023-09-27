package listener.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class proxyTest {



    public static void main(String[] args) {
        Lenovo lenovo = new Lenovo();
//        lenovo.sale(8000);
        //动态代理增强lenovo对象

//        三个参数：
//        类加载器：真实对象.getClass().getClassLoader()
//        接口数组：真实对象.getClass().getInterface()
//        处理器：new InvocationHandler()
        SaleComputer proxyLenovo = (SaleComputer)Proxy.newProxyInstance(lenovo.getClass().getClassLoader(), lenovo.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("该方法被执行了！");

                /**
                 * 远程代理 (Remote Proxy)：用于控制不同地址空间的对象，例如远程服务器上的对象。
                 * 远程代理可以隐藏网络通信的细节，让客户端像访问本地对象一样访问远程对象。
                 *
                 * 虚拟代理 (Virtual Proxy)：用于延迟加载（懒加载）大对象或昂贵资源的对象，以提高系统的性能。虚拟代理在真正需要对象时才创建或加载它。
                 *
                 * 保护代理 (Protection Proxy)：用于控制对敏感对象的访问。保护代理可用于权限验证，确保只有具有特定权限的用户可以访问对象。
                 *
                 * 缓存代理 (Cache Proxy)：用于缓存对象的操作结果，以提高操作的执行速度。
                 * 如果相同的请求已经执行过一次，代理可以返回缓存的结果，而不必再次执行操作。
                 *
                 * 智能引用代理 (Smart Reference Proxy)：用于添加额外的操作，例如引用计数，以跟踪对象的引用情况。这对于自动内存管理非常有用。
                 *
                 * 日志记录代理 (Logging Proxy)：用于记录对象的操作，以便进行调试或审计。日志记录代理可以在方法调用前后记录相关信息。
                 *
                 * 动态代理 (Dynamic Proxy)：在运行时创建代理对象，而不是在编译时。
                 * 这允许你在不知道对象类型的情况下创建代理，通常用于实现 AOP（面向切面编程）。
                 *
                 * 限制性代理 (Firewall Proxy)：用于控制网络资源的访问，例如防火墙。它可以过滤或拦截请求，以确保只有符合规则的请求可以通过。
                 *
                 * 复杂对象构建代理 (Complexity Hiding Proxy)：用于隐藏复杂对象的创建和初始化过程，使客户端不必关心对象的构建细节。
                 *
                 * 多线程代理 (Thread-Safe Proxy)：用于确保多个线程可以安全地访问对象，通常使用锁或同步机制来实现。
                 * */
                if(method.getName().equals("sale")){
//                  1.增强参数
                    double money = (double)args[0]*0.7;


//                  2.增强方法体
                    // 在目标对象方法执行前添加额外的逻辑
                    System.out.println("Before method execution");

                    String o = (String)method.invoke(lenovo, money);

                    // 在目标对象方法执行后添加额外的逻辑
                    System.out.println("After method execution");

//                  3.增强返回值
                    return o+" 鼠标垫";
                } else {
                    Object o = method.invoke(lenovo, args);
                    return o;
                }

            }
        });

//        String computer = lenovo.sale(8000);
//        System.out.println(computer);
        String computer = proxyLenovo.sale(7000);
        System.out.println(computer);


    }
}

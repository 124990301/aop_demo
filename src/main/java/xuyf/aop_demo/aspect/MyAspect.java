package xuyf.aop_demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

    /**
     * controller包下所有以Controller结尾的类中，有入参的方法
     * 切点表达式 给其他切面引用
     */
    @Pointcut("execution(* xuyf.aop_demo.controller.*Controller.*(..))")
    private void pointCuts(){
    }

//    //controller包下所有以Controller结尾的类中，有入参的方法
//    @Before("execution(* xuyf.aop_demo.controller.*Controller.*(*))")
//    private void before(){
//        System.out.println("before");
//    }
//
//    @After("pointCuts()")
//    private void after(JoinPoint point){
//        Object[] objects = point.getArgs();
//        for(Object object:objects){
//            System.out.println(object.toString());
//        }
//    }


    /**
     *
     * @Around的作用
     * 既可以在目标方法之前织入增强动作，也可以在执行目标方法之后织入增强动作；
     * 可以决定目标方法在什么时候执行，如何执行，甚至可以完全阻止目标目标方法的执行；
     * 可以改变执行目标方法的参数值，也可以改变执行目标方法之后的返回值； 当需要改变目标方法的返回值时，只能使用Around方法；
     */
    @Around("pointCuts()")
        private Object aroud(ProceedingJoinPoint pjp) throws Throwable {
            System.out.println("aroud1");
            /**
             * 不调用proceed()方法，目标方法不会执行
             * 环绕方法如果没有返回值，目标方法的返回值也无法返回
             * pjp.proceed()返回的是目标方法的返回值
             */
          Object object = pjp.proceed();
//        System.out.println("aroud2");
            System.out.println("aroud2"+object.toString());
            return "ttttt";
        }

//    @Around("pointCuts()")
//    private void aroud2(JoinPoint pjp) throws Throwable {
//        System.out.println("aroud1");
////        Object object = pjp.proceed();  //获取方法的返回值
//        System.out.println("aroud2");
//    }
}

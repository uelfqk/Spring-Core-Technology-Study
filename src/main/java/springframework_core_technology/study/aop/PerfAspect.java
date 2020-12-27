package springframework_core_technology.study.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerfAspect {

    // ProceedingJoinPoint joinPoint -> Advice 가 적용되는 대상
    //@Around("execution(* springframework_core_technology.study..*.EventService.*(..))") // 특정 클래스의 메소드 전체에 Advice 적용
    //@Around("@annotation(PerfLogging)") // 해당 애노테이션이 있는 메소드에만 해당 Advice 적용
    @Around("bean(simpleEventService)") // 해당 스프링 빈으로 등록된 클래스의 메소드 전체에 Advice 적용
    public Object logPerf(ProceedingJoinPoint joinPoint) throws Throwable {
        long begin = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        System.out.println(System.currentTimeMillis() - begin + " ms");
        return proceed;
    }

    @Before("bean(simpleEventService)")
    public void hello() {
        System.out.println("hello");
    }
}

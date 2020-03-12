package test.spring.aop;

        import org.apache.log4j.Logger;
        import org.aspectj.lang.ProceedingJoinPoint;
        import org.aspectj.lang.annotation.Around;
        import org.aspectj.lang.annotation.Aspect;
        import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogVerification {
    private static final Logger LOGGER = Logger.getLogger(LogVerification.class);

    @Around("@annotation(test.spring.aop.Verification)")
    public Object verification(ProceedingJoinPoint joinPoint) throws Throwable {
        LOGGER.debug("LogVerification >> verification >> joinPoint:" + joinPoint);
        Object[] method = joinPoint.getArgs();
        LOGGER.debug("LogVerification >> verification >> meythod[0]:" + method);

        LOGGER.debug("LogVerification >> verification >> joinPoint.getSignature().getDeclaringType() :" + joinPoint.getSignature().getDeclaringType());
        LOGGER.debug("LogVerification >> verification >> joinPoint.getSignature().getDeclaringType() :" + joinPoint.getSignature().getDeclaringTypeName());
        LOGGER.debug("LogVerification >> verification >> joinPoint.getSignature().getDeclaringType() :" + joinPoint.getSignature().getName());
        LOGGER.debug("LogVerification >> verification >> joinPoint.getSignature().getDeclaringType() :" + joinPoint.getSignature().getModifiers());
        // MethodSignature methodSignature = joinPoint.getSignature();
        Object object = joinPoint.proceed();
        return object;
    }
}

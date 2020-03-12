package test.spring.aop;

public enum LogOprationCode {

    EMP_CREATE("EMPCR"),
    EMP_GET("EMPGT");

    private String code;

    LogOprationCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}

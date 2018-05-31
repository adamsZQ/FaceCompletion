package cn.edu.hit.ir.entity;

/**
 * @author 袁明琛
 * @since 1.0 2018/5/3
 */
public class Param {
    private String name;  //不可为空
    private String defaultValue = ""; //可为空
    private boolean nullable = true; //可为空，默认为true
    private String hint = ""; //可为空

    public Param() {
    }

    public Param(String name) {
        this.name = name;
    }

    public Param(String name, String defaultValue, boolean nullable, String hint) {
        this.name = name;
        this.defaultValue = defaultValue;
        this.nullable = nullable;
        this.hint = hint;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public boolean isNullable() {
        return nullable;
    }

    public void setNullable(boolean nullable) {
        this.nullable = nullable;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }
}

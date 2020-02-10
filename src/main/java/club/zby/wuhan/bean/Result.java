package club.zby.wuhan.bean;

/**
 * @Author: 赵博雅
 * @Date: 2020/2/10 18:35
 */
public class Result {
    private Boolean flag;
    private Object data;
    private String message;

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    public Result(){

    }
    public Result(Boolean flag, Object data, String message) {
        this.flag = flag;
        this.data = data;
        this.message = message;
    }
}

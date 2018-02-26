package com.lx.projectschedule.bean;

/**
 * ----------Dragon be here!----------/
 * 　　　┏┓　　　┏┓
 * 　　┏┛┻━━━┛┻┓
 * 　　┃　　　　　　　┃
 * 　　┃　　　━　　　┃
 * 　　┃　┳┛　┗┳　┃
 * 　　┃　　　　　　　┃
 * 　　┃　　　┻　　　┃
 * 　　┃　　　　　　　┃
 * 　　┗━┓　　　┏━┛
 * 　　　　┃　　　┃神兽保佑
 * 　　　　┃　　　┃代码无BUG！
 * 　　　　┃　　　┗━━━┓
 * 　　　　┃　　　　　　　┣┓
 * 　　　　┃　　　　　　　┏┛
 * 　　　　┗┓┓┏━┳┓┏┛
 * 　　　　　┃┫┫　┃┫┫
 * 　　　　　┗┻┛　┗┻┛
 * ━━━━━━神兽出没━━━━━━
 * 项目名称：ProjectSchedule
 * 包名:com.lx.projectschedule.bean
 * 类描述：
 * 创建人：LX
 * 创建时间：2018/2/24 下午3:43
 * 修改人：LX
 * 修改时间：2018/2/24 下午3:43
 * 修改备注：
 */

public class BaseBean<T> {
    private T data;
    private int code;

    public T getData() {
        return data;
    }

    public BaseBean setData(T data) {
        this.data = data;
        return this;
    }

    public int getCode() {
        return code;
    }

    public BaseBean setCode(int code) {
        this.code = code;
        return this;
    }


}

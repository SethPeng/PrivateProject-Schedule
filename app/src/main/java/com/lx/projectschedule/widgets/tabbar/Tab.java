package com.lx.projectschedule.widgets.tabbar;

import android.support.annotation.DrawableRes;

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
 * 项目名称：LabelViewTest
 * 包名:com.lx.labelviewtest.tabbar
 * 类描述：
 * 创建人：LX
 * 创建时间：2018/3/9 上午10:57
 * 修改人：LX
 * 修改时间：2018/3/9 上午10:57
 * 修改备注：
 */

public class Tab {
    @DrawableRes
    private int viewUnSelect;
    @DrawableRes
    private int viewSelect;
    private int position = -1;

    public int getViewUnSelect() {
        return viewUnSelect;
    }

    public Tab setViewUnSelect(int viewUnSelect) {
        this.viewUnSelect = viewUnSelect;
        return this;
    }

    public int getViewSelect() {
        return viewSelect;
    }

    public Tab setViewSelect(int viewSelect) {
        this.viewSelect = viewSelect;
        return this;
    }

    public int getPosition() {
        return position;
    }

    public Tab setPosition(int position) {
        this.position = position;
        return this;
    }
}

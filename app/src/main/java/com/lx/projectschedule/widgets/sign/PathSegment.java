package com.lx.projectschedule.widgets.sign;

import android.graphics.Path;

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
 * 项目名称：TheSignDrawer
 * 包名:com.yyxk.signdrawer
 * 类描述：
 * 创建人：LX
 * 创建时间：2018/2/26 下午1:37
 * 修改人：LX
 * 修改时间：2018/2/26 下午1:37
 * 修改备注：
 */

public class PathSegment {
    private Path path;
    private float width;
    private int alpha;

    public Path getPath() {
        return path;
    }

    public PathSegment setPath(Path path) {
        this.path = path;
        return this;
    }

    public float getWidth() {
        return width;
    }

    public PathSegment setWidth(float width) {
        this.width = width;
        return this;
    }

    public int getAlpha() {
        return alpha;
    }

    public PathSegment setAlpha(int alpha) {
        this.alpha = alpha;
        return this;
    }
}

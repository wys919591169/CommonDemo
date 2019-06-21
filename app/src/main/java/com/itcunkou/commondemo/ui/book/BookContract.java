package com.itcunkou.commondemo.ui.book;

import com.itcunkou.commondemo.base.BaseContract;
import com.itcunkou.commondemo.model.BookModel;
import com.itcunkou.commondemo.widget.FrameLayout4Loading;


/**
 * 书本配置约定
 * @author Veer
 * @email 276412667@qq.com
 * @date 18/7/2
 */

public interface BookContract {
    interface View extends BaseContract.BaseView{
        void setBook(BookModel model);

    }
    interface Presenter extends BaseContract.BasePresenter<View>{
        void getBook(FrameLayout4Loading frameLayout4Loading, String p, String tag, String start, String end);
    }
}

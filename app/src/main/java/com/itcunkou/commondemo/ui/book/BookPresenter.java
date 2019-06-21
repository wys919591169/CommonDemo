package com.itcunkou.commondemo.ui.book;


import com.itcunkou.commondemo.base.BasePresenter;
import com.itcunkou.commondemo.model.BookModel;
import com.itcunkou.commondemo.net.RetrofitHelper;
import com.itcunkou.commondemo.net.RxSchedulers;
import com.itcunkou.commondemo.widget.FrameLayout4Loading;


import io.reactivex.functions.Consumer;

/**
 * 描述
 *
 * @author Veer
 * @email 276412667@qq.com
 * @date 18/7/2
 */

public class BookPresenter extends BasePresenter<BookContract.View> implements BookContract.Presenter{

    @Override
    public void getBook(final FrameLayout4Loading frameLayout4Loading, String p, String tag, String start, String end) {
//       mView.showLoading();
        frameLayout4Loading.showLoadingView();
        RetrofitHelper.getInstance().getServer()
                .getBooks(p,tag,start,end)
                .compose(RxSchedulers.<BookModel>applySchedulers())
                .compose(mView.<BookModel>bindToLife())
                .subscribe(new Consumer<BookModel>() {
                    @Override
                    public void accept(BookModel bookModel) throws Exception {
//                        mView.hideLoading();
                        frameLayout4Loading.hideLoadingView();
                        mView.setBook(bookModel);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
//                       mView.hideLoading();
                        frameLayout4Loading.hideLoadingView();
                        frameLayout4Loading.showDefaultExceptionView();
                    }
                });
    }
}

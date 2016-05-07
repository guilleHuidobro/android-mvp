package com.guillehuidobro.mvp.app.picture;

/**
 * Created by guille on 06/05/2016.
 */
public class PicturePresenterImpl implements PicturePresenter {

    private PictureView pictureView;

    public PicturePresenterImpl(PictureView pictureView){
        this.pictureView = pictureView;

    }

    @Override
    public void onDestroy() {
        pictureView = null;
    }

    @Override
    public void manageAction(boolean b) {
        if(b == true){
            pictureView.showMessage("Mensaje desde el presenter");
        }

    }
}

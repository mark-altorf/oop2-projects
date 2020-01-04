package views;

import controllers.BaseController;
import javafx.scene.Parent;

public abstract class BaseView<T extends BaseController>{

    protected T controller;

    private Parent root;

    public BaseView(T controller) {
        this.controller = controller;

        root = createRoot();

        setupController();

        controller.initialize();
    }

    protected abstract Parent createRoot();

    protected abstract void setupController();

    public Parent getRoot() {
        return root;
    }
}

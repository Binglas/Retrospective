package joaozao.sourcedev.com.retrospective.inductions;

import java.util.List;

import joaozao.sourcedev.com.retrospective.BasePresenter;
import joaozao.sourcedev.com.retrospective.BaseView;
import joaozao.sourcedev.com.retrospective.data.Induction;

/**
 * This specifies the contract between the view and the presenter.
 */
public interface InductionsContract {

    interface View extends BaseView<Presenter> {

        void setLoadingIndicator(boolean active);

        void showInductions(List<Induction> tasks);

        void showNoInductions();

        boolean isActive();

    }

    interface Presenter extends BasePresenter<View> {

        void loadInductions();

        void takeView(InductionsContract.View view);

        void dropView();

    }
}

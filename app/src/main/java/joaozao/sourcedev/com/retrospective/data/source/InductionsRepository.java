package joaozao.sourcedev.com.retrospective.data.source;

import android.support.annotation.NonNull;

import java.util.List;

import javax.inject.Inject;

import joaozao.sourcedev.com.retrospective.data.Induction;

public class InductionsRepository implements InductionsDataSource {

    private InductionsDataSource mInductionsRemoteDataSource;

    @Inject
    InductionsRepository(@Remote InductionsDataSource inductionsRemoteDataSource) {
        mInductionsRemoteDataSource = inductionsRemoteDataSource;
    }

    @Override
    public void getInductions(@NonNull LoadInductionsCallback callback) {
        mInductionsRemoteDataSource.getInductions(new LoadInductionsCallback() {
            @Override
            public void onInductionsLoaded(List<Induction> inductions) {
                callback.onInductionsLoaded(inductions);
            }

            @Override
            public void onDataNotAvailable() {
                callback.onDataNotAvailable();
            }
        });
    }

    @Override
    public void getInduction(@NonNull String taskId, @NonNull GetInductionCallback callback) {

    }
}

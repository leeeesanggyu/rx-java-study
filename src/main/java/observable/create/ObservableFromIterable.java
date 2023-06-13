package observable.create;

import io.reactivex.Observable;
import log.LogType;
import log.Logger;

import java.util.List;

public class ObservableFromIterable {
    public static void main(String[] args) {
        List<String> name = List.of("lee", "kim", "park", "choi");

        Observable<String> iterable = Observable.fromIterable(name);
        iterable.subscribe(data -> Logger.log(LogType.ON_NEXT, data));
    }
}

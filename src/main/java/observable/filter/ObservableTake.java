package observable.filter;

import io.reactivex.Observable;
import log.LogType;
import log.Logger;

import java.util.List;

public class ObservableTake {
    public static void main(String[] args) {
        List<String> name = List.of("lee", "lee", "kem", "aaa");

        Observable.fromIterable(name)
                .take(2)
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));
    }
}

package observable;

import io.reactivex.Observable;
import log.LogType;
import log.Logger;
import log.TimeUtil;

import java.util.concurrent.CompletableFuture;

public class ObservableFromFuture {
    public static void main(String[] args) {
        Logger.log(LogType.PRINT, "# start");

        // 처리 시간이 긴 작업
        CompletableFuture<String> completableFuture = longWork();
        // 처리 시간이 짧은 작업
        shortWork();

        Observable.fromFuture(completableFuture)
                .subscribe(data -> Logger.log(LogType.PRINT, data));
    }

    private static CompletableFuture<String> longWork() {
        return CompletableFuture.supplyAsync(() -> {
            Logger.log(LogType.PRINT, "# long work start");
            TimeUtil.sleep(10000);
            return "# long work finish";
        });
    }

    private static Boolean shortWork() {
        Logger.log(LogType.PRINT, "# short work start");
        TimeUtil.sleep(3000);
        Logger.log(LogType.PRINT, "# short work finish");
        return true;
    }
}

package xyz.auriium.opentutorial.core.stage.plainkeyword;

import xyz.auriium.opentutorial.core.tutorial.stage.AwaitStage;
import xyz.auriium.opentutorial.core.tutorial.stage.Stage;

import java.util.List;

/**
 * Stage that awaits the player saying a specific keyword before allowing them to pass. Is timed.
 */
public class PlainKeywordStage implements AwaitStage {

    private final List<String> matchables;

    private final long maxDelay;
    private final boolean cancelOnFail;

    public PlainKeywordStage(List<String> matchables, long maxDelay, boolean cancelOnFail) {
        this.matchables = matchables;
        this.maxDelay = maxDelay;
        this.cancelOnFail = cancelOnFail;
    }

    public List<String> getMatchables() {
        return matchables;
    }

    public long getMaxDelay() {
        return maxDelay;
    }

    public boolean isCancelOnFail() {
        return cancelOnFail;
    }

}

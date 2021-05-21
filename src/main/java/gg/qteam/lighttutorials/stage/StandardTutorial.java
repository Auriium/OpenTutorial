package gg.qteam.lighttutorials.stage;

import gg.qteam.lighttutorials.aspect.Startable;

import java.util.Queue;

public class StandardTutorial implements Continuable, Startable {

    private final Queue<StageConsumer> stageConsumers;

    public StandardTutorial(Queue<StageConsumer> stageConsumers) {
        this.stageConsumers = stageConsumers;
    }

    @Override
    public void markContinue() {
        stageConsumers.remove().started();
    }

    @Override
    public void start() {
        markContinue();
    }
}

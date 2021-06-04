package xyz.auriium.opentutorial.core.tutorial;

import xyz.auriium.opentutorial.core.tutorial.stage.Stage;

import java.util.Queue;
import java.util.UUID;

public class CommonTutorial implements Tutorial {

    private final UUID uuid;
    private final Queue<Stage> stageQueue;
    private final TutorialController controller;

    public CommonTutorial(UUID uuid, Queue<Stage> stageQueue, TutorialController controller) {
        this.uuid = uuid;
        this.stageQueue = stageQueue;
        this.controller = controller;
    }

    @Override
    public UUID getIdentifier() {
        return uuid;
    }

    @Override
    public void fireNext() {
        //TODO if the queue is empty, the tutorial is over

        if (stageQueue.isEmpty()) {
            //cum all over the floor uwu
            controller.cancelByUUID(uuid);

            return;

        }

        controller.consumeStage(stageQueue.remove(), this);
    }

    @Override
    public void fireCancel() {
        controller.cancelByUUID(uuid);
    }
}

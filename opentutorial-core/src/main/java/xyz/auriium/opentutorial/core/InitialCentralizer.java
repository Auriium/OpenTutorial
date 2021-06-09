package xyz.auriium.opentutorial.core;

import xyz.auriium.opentutorial.core.config.TutorialCentralizer;
import xyz.auriium.opentutorial.core.control.CommandCentralizer;
import xyz.auriium.opentutorial.core.event.outer.HookCentralizer;
import xyz.auriium.opentutorial.core.model.Cycleable;
import xyz.auriium.opentutorial.core.config.ConfigCentralizer;
import xyz.auriium.opentutorial.core.tutorial.ConsumerRegistry;
import xyz.auriium.opentutorial.core.tutorial.TutorialController;

public class InitialCentralizer implements Cycleable {

    private final ConfigCentralizer configCentralizer;
    private final ConsumerRegistry consumerRegistry;
    private final TutorialCentralizer tutorialCentralizer;
    private final TutorialController tutorialController;
    private final HookCentralizer hookCentralizer;
    private final CommandCentralizer commandCentralizer;

    public InitialCentralizer(ConfigCentralizer configCentralizer, ConsumerRegistry consumerRegistry, TutorialCentralizer tutorialCentralizer, TutorialController tutorialController, HookCentralizer hookCentralizer, CommandCentralizer commandCentralizer) {
        this.configCentralizer = configCentralizer;
        this.consumerRegistry = consumerRegistry;
        this.tutorialCentralizer = tutorialCentralizer;
        this.tutorialController = tutorialController;
        this.hookCentralizer = hookCentralizer;
        this.commandCentralizer = commandCentralizer;
    }

    @Override
    public void startup() {
        consumerRegistry.startup();
        configCentralizer.startup();
        tutorialCentralizer.startup();
        tutorialController.startup();
        hookCentralizer.startup();
        commandCentralizer.startup();
    }

    @Override
    public void reload() {
        consumerRegistry.reload();
        configCentralizer.reload();
        tutorialCentralizer.reload();
        tutorialController.reload();
        hookCentralizer.reload();
        commandCentralizer.reload();
    }

    @Override
    public void shutdown() {
        consumerRegistry.shutdown();
        configCentralizer.shutdown();
        tutorialCentralizer.shutdown();
        tutorialController.shutdown();
        hookCentralizer.shutdown();
        commandCentralizer.shutdown();
    }
}

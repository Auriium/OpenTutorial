package xyz.auriium.opentutorial.hook;

import xyz.auriium.opentutorial.PluginScheduler;
import xyz.auriium.opentutorial.centralized.Tutorial;
import xyz.auriium.opentutorial.centralized.TutorialController;
import xyz.auriium.opentutorial.centralized.registry.EventBus;
import xyz.auriium.opentutorial.stage.response.DelegateChatEvent;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.Optional;

public class EventBusHook implements Listener {

    private final EventBus bus;
    private final PluginScheduler scheduler;
    private final TutorialController controller;

    public EventBusHook(EventBus bus, PluginScheduler scheduler, TutorialController controller) {
        this.bus = bus;
        this.scheduler = scheduler;
        this.controller = controller;
    }


    public void onChatEvent(AsyncPlayerChatEvent event) {

        Optional<Tutorial> optionalTutorial = controller.getByUUID(event.getPlayer().getUniqueId());

        scheduler.runLater(() -> { /// FIXME: 5/31/2021 possibly make receiving tutorials threadsafe to allow async message w/o scheduler shit
            optionalTutorial.ifPresent(tutorial -> bus.fire(new DelegateChatEvent(event.getPlayer().getUniqueId(),event.getPlayer(),event.getMessage()),tutorial));
        }, 0L);



    }


}

package xyz.auriium.opentutorial.spigot.stage;

import space.arim.dazzleconf.error.BadValueException;
import space.arim.dazzleconf.serialiser.FlexibleType;
import xyz.auriium.opentutorial.core.config.templates.impl.Interpret;
import xyz.auriium.opentutorial.core.tutorial.stage.StageSerializer;


import java.util.Map;

public class AgeStageSerializer implements StageSerializer<AgeStage> {
    @Override
    public String identifier() {
        return "age";
    }

    @Override
    public AgeStage deserialize(Map<String, FlexibleType> map) throws BadValueException {

        String runOnFail = Interpret.getEllusive("runOnFailCommand", map, FlexibleType::getString,Interpret.NO_STRING);
        int minimumAge = Interpret.getRequired("minimumAge",map, FlexibleType::getInteger);
        int maxDelay = Interpret.getEllusive("maxDelay",map,FlexibleType::getInteger,Interpret.NO_INT);
        boolean cancelOnFail = Interpret.getEllusive("cancelOnFail",map,FlexibleType::getBoolean,true);

        return new AgeStage(runOnFail, minimumAge,maxDelay,cancelOnFail);
    }
}

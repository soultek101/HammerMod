package konals.mods.hammermod.helper;

import java.util.logging.Level;
import java.util.logging.Logger;

import cpw.mods.fml.common.FMLLog;

public class LogHelper {

    private static Logger hammerLogger = Logger.getLogger("HammerMod");

    public static void init() {

        hammerLogger.setParent(FMLLog.getLogger());
    }

    public static void log(Level logLevel, String message) {

        hammerLogger.log(logLevel, message);
    }

}
package divinerpg.utils;

import divinerpg.DivineRPG;
import net.minecraftforge.common.ForgeVersion;
import net.minecraftforge.fml.common.Loader;

public class UpdateChecker {
    private static String updateTarget = DivineRPG.VERSION;
    private static boolean updateAvailable = false;

    public static void checkForUpdates() {
        ForgeVersion.CheckResult updateCheckResult = ForgeVersion.getResult(Loader.instance().activeModContainer());

        if(updateCheckResult.status == ForgeVersion.Status.FAILED) {
            return;
        }
        else if(updateCheckResult.status == ForgeVersion.Status.OUTDATED) {
            updateTarget = updateCheckResult.target.toString();
            updateAvailable = true;
        }
    }

    public static String getUpdateTarget() {
        return updateTarget;
    }

    public static boolean isUpdateAvailable() {
        return updateAvailable;
    }
}

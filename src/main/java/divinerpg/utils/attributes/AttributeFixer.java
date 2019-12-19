package divinerpg.utils.attributes;

import org.apache.logging.log4j.core.Logger;

import divinerpg.DivineRPG;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.RangedAttribute;

public class AttributeFixer {
	static org.apache.logging.log4j.Logger LOGGER = DivineRPG.logger;
	public static void init() {
		RangedAttribute maxHealth = (RangedAttribute) SharedMonsterAttributes.MAX_HEALTH;
        if (ReflectionHelper.setValue(maxHealth, "maximumValue", Double.MAX_VALUE)) {
            LOGGER.info("Maximum mob health increased to Double.MAX_VALUE (1.7976931348623157e+308)");
        } else {
            LOGGER.warn("Can't patch max mob health");
        }
	}
}

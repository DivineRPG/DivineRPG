package divinerpg.utils.attributes;

import divinerpg.DivineRPG;
import divinerpg.api.DivineAPI;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.RangedAttribute;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

public class AttributeFixer {

    public static void patchMaximumHealth() {
	    DivineRPG.logger.info("Maximum mob health increased to Double.MAX_VALUE (1.7976931348623157e+308)");
        ObfuscationReflectionHelper.setPrivateValue((Class) RangedAttribute.class, SharedMonsterAttributes.MAX_HEALTH, Double.MAX_VALUE, 1);
	}

}

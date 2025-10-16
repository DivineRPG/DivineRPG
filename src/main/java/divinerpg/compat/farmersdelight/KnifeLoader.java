package divinerpg.compat.farmersdelight;

import net.minecraft.world.item.*;

public class KnifeLoader {
    public static Item create(Tier tier) {return new ToolKnife(tier);}
}
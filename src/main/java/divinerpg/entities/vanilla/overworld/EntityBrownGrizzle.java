package divinerpg.entities.vanilla.overworld;

import divinerpg.entities.base.Grizzle;
import divinerpg.registries.TagRegistry;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class EntityBrownGrizzle extends Grizzle {
    public EntityBrownGrizzle(EntityType<? extends EntityBrownGrizzle> type, Level worldIn) {super(type, worldIn);}
    @Override public boolean isFood(ItemStack item) {return item.is(TagRegistry.PET_FOODS_BROWN_GRIZZLE);}
    @Override protected boolean isTamingFood(ItemStack item) {return item.is(TagRegistry.PET_TAMING_FOODS_BROWN_GRIZZLE);}
}
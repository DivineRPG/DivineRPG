package divinerpg.entities.arcana;

import divinerpg.entities.base.EntityDivineTameable;
import divinerpg.registries.TagRegistry;
import divinerpg.utils.ArcanaHelper;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class EntitySeimer extends EntityDivineTameable {
    public EntitySeimer(EntityType<? extends EntitySeimer> type, Level worldIn) {super(type, worldIn, 1);}
    @Override public void tick() {
        super.tick();
        if(getOwner() != null && getOwner() instanceof ServerPlayer player) ArcanaHelper.consumeArcana(player, 1);
    }
    @Override public boolean isFood(ItemStack item) {return item.is(TagRegistry.PET_SEIMER);}
    @Override protected boolean isTamingFood(ItemStack item) {return item.is(TagRegistry.TAMING_SEIMER);}
}
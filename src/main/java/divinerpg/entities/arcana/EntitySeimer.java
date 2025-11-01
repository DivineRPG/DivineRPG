package divinerpg.entities.arcana;

import divinerpg.attachments.Arcana;
import divinerpg.entities.base.EntityDivineTameable;
import divinerpg.registries.TagRegistry;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class EntitySeimer extends EntityDivineTameable {
    public EntitySeimer(EntityType<? extends EntitySeimer> type, Level worldIn) {super(type, worldIn, 1);}
    @Override public void tick() {
        super.tick();
        if(getOwner() != null && getOwner() instanceof ServerPlayer player) Arcana.modifyAmount(player, 1);
    }
    @Override public boolean isFood(ItemStack item) {return item.is(TagRegistry.PET_FOODS_SEIMER);}
    @Override protected boolean isTamingFood(ItemStack item) {return item.is(TagRegistry.PET_TAMING_FOODS_SEIMER);}
}
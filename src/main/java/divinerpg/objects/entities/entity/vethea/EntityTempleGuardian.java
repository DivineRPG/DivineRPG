package divinerpg.objects.entities.entity.vethea;

import divinerpg.objects.entities.entity.EntityGifterNPC;
import divinerpg.registry.ItemRegistry;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityTempleGuardian extends EntityGifterNPC {

    public EntityTempleGuardian(World worldIn) {
        super(worldIn);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(35.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.32D);
    }

    @Override
    protected ItemStack getGift() {
        return new ItemStack(ItemRegistry.cermileLump, 10);
    }

    @Override
    protected String[] getMessages() {
        String[] messages = { "message.temple_guardian.1", "message.temple_guardian.2", "message.temple_guardian.3", "message.temple_guardian.4", "message.temple_guardian.5" };
        return messages;
    }

    @Override
    protected String getTranslationName() {
        return "entity.divinerpg.temple_guardian.name";
    }
}

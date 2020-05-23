package divinerpg.objects.entities.entity.vethea;

import divinerpg.objects.entities.entity.EntityGifterNPC;
import divinerpg.registry.ItemRegistry;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityCryptKeeper extends EntityGifterNPC {

    public EntityCryptKeeper(World worldIn) {
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
        return new ItemStack(ItemRegistry.amthirmisLump, 5);
    }

    @Override
    protected String[] getMessages() {
        String[] messages = { "message.crypt_keeper.1", "message.crypt_keeper.2", "message.crypt_keeper.3", "message.crypt_keeper.4", "message.crypt_keeper.5" };
        return messages;
    }

    @Override
    protected String getTranslationName() {
        return "entity.divinerpg.crypt_keeper.name";
    }
}

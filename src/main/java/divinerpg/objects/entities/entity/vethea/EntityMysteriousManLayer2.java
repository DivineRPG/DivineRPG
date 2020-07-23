package divinerpg.objects.entities.entity.vethea;

import divinerpg.objects.entities.entity.EntityGifterNPC;
import divinerpg.registry.ItemRegistry;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityMysteriousManLayer2 extends EntityGifterNPC {

    public EntityMysteriousManLayer2(World worldIn) {
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
        return new ItemStack(ItemRegistry.darvenLump, 6);
    }

    @Override
    protected String[] getMessages() {
        String[] messages = { "message.mysterious_man_layer_2.1", "message.mysterious_man_layer_2.2", "message.mysterious_man_layer_2.3", "message.mysterious_man_layer_2.4" };
        return messages;
    }

    @Override
    protected String getTranslationName() {
        return "entity.divinerpg.mysterious_man_layer_2.name";
    }

    public int getSpawnLayer() {
        return 2;
    }

    @Override
    public boolean getCanSpawnHere() {
        int spawnLayer = this.getSpawnLayer();

        if(spawnLayer == 0) {
            return super.getCanSpawnHere();
        }
        else {
            return this.posY < 48.0D * spawnLayer  && this.posY > 48.0D * (spawnLayer - 1) && super.getCanSpawnHere();
        }
    }
}

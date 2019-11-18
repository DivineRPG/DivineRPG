package divinerpg.objects.entities.entity;

import divinerpg.utils.MessageLocalizer;
import divinerpg.utils.Utils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public abstract class EntityGifterNPC extends EntityDivineRPGMob {

    public EntityGifterNPC(World worldIn) {
        super(worldIn);
    }

    @Override
    public boolean processInteract(EntityPlayer player, EnumHand hand) {
        if(this.isEntityAlive()) {
            if(!this.world.isRemote) {
                player.inventory.addItemStackToInventory(this.getGift());
                sendRandomChatMessage(player);
                this.setDead();
            }
            return true;
        } else {
            return super.processInteract(player, hand);
        }
    }

    protected void sendRandomChatMessage(EntityPlayer player) {
        String[] messages = getMessages();

        player.sendMessage(Utils.getChatComponent(MessageLocalizer.normal(getTranslationName())
                + ": " + MessageLocalizer.normal(messages[this.rand.nextInt(messages.length)])));
    }

    protected abstract ItemStack getGift();
    protected abstract String[] getMessages();
    protected abstract String getTranslationName();
}

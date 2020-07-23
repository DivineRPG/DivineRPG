package divinerpg.objects.entities.entity;

import divinerpg.utils.LocalizeUtils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public abstract class EntityGifterNPC extends EntityDivineMob {

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

        ITextComponent message = new TextComponentString("");
        message.appendSibling(LocalizeUtils.getClientSideTranslation(player, getTranslationName()));
        message.appendText(": ");
        message.appendSibling(LocalizeUtils.getClientSideTranslation(player, messages[rand.nextInt(messages.length)]));

        player.sendMessage(message);
    }

    protected abstract ItemStack getGift();
    protected abstract String[] getMessages();
    protected abstract String getTranslationName();
}

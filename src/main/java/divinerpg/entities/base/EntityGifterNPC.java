package divinerpg.entities.base;

import divinerpg.util.LocalizeUtils;
import net.minecraft.entity.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.util.text.*;
import net.minecraft.world.World;

public abstract class EntityGifterNPC extends EntityDivineMob {

    public EntityGifterNPC(EntityType<? extends MobEntity> type, World worldIn) {
    	super(type, worldIn);
    }

    @Override
    public ActionResultType mobInteract(PlayerEntity player, Hand hand) {
        if(this.isAlive()) {
            if(!this.level.isClientSide) {
                player.inventory.add(this.getGift());
                sendRandomChatMessage(player);
                this.kill();
            }
            return ActionResultType.PASS;
        } else {
        	return super.mobInteract(player, hand);
        }
    }

    protected void sendRandomChatMessage(PlayerEntity player) {
        String[] messages = getMessages();

        ITextComponent message = new TranslationTextComponent(LocalizeUtils.getClientSideTranslation(player, getTranslationName()) + ": " + LocalizeUtils.getClientSideTranslation(player, messages[random.nextInt(messages.length)]));
        player.sendMessage(message, player.getUUID());
    }

    protected abstract ItemStack getGift();
    protected abstract String[] getMessages();
    protected abstract String getTranslationName();
}
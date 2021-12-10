package divinerpg.entities.base;

import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.util.text.*;
import net.minecraft.world.*;

import java.util.*;

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
        ArrayList<String> messages = getMessages();
        String name = new TranslationTextComponent(getTranslationName()).getString();
        String messageToTranslate = new TranslationTextComponent(messages.get(random.nextInt(messages.size()))).getString();
        ITextComponent message = new StringTextComponent(name + ": " + messageToTranslate);
        player.sendMessage(message, player.getUUID());
    }

    protected abstract ItemStack getGift();
    protected abstract ArrayList<String> getMessages();
    protected abstract String getTranslationName();
}
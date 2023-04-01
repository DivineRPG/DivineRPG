package divinerpg.items.vanilla;


import divinerpg.items.base.ItemModSword;
import divinerpg.util.LocalizeUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;

import java.util.List;

public class ItemBurningSword extends ItemModSword {
    private final int burnSeconds;

    public ItemBurningSword(Tier tier, int seconds) {
        super(tier, new Item.Properties().fireResistant());
        this.burnSeconds = seconds;
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
        if(player != null && entity != null){
            entity.setSecondsOnFire(this.burnSeconds);
        }
        return super.onLeftClickEntity(stack, player, entity);
    }
    @Override
    protected void addAdditionalInformation(List<Component> list) {
        list.add(LocalizeUtils.burn(this.burnSeconds));
    }
}
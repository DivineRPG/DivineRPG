package divinerpg.items.vanilla;

import divinerpg.enums.BulletType;
import divinerpg.items.base.ItemModRanged;
import divinerpg.registries.*;
import divinerpg.util.LocalizeUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.neoforged.api.distmarker.*;
import java.util.List;

public class ItemScythe extends ItemModRanged {
    public ItemScythe() {super(BulletType.SCYTHE_SHOT, SoundRegistry.DEEP_LAUGH.get(), 0, 10);}
    @Override protected void spawnEntity(Level world, Player player, ItemStack stack, BulletType bulletType, String entityType) {super.spawnEntity(world, player, stack, isJackoman(player) ? BulletType.MEGA_SCYTHE_SHOT : BulletType.SCYTHE_SHOT, null);}
    private boolean isJackoman(Player player) {
        ItemStack stackBoots = player.getInventory().armor.get(0);
        ItemStack stackLegs = player.getInventory().armor.get(1);
        ItemStack stackBody = player.getInventory().armor.get(2);
        ItemStack stackHelmet = player.getInventory().armor.get(3);
        Item boots = stackBoots.getItem();
        Item body = stackBody.getItem();
        Item legs = stackLegs.getItem();
        Item helmet = stackHelmet.getItem();
        return boots == ItemRegistry.jack_o_man_boots.get() && body == ItemRegistry.jack_o_man_chestplate.get() && legs == ItemRegistry.jack_o_man_leggings.get() && helmet == ItemRegistry.jack_o_man_helmet.get();
    }
	@OnlyIn(Dist.CLIENT)
    @Override public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flagIn) {
        if(Minecraft.getInstance().player != null) tooltip.add(LocalizeUtils.magicDam(isJackoman(Minecraft.getInstance().player) ? (int)BulletType.MEGA_SCYTHE_SHOT.getDamage() : (int)BulletType.SCYTHE_SHOT.getDamage()));
        super.appendHoverText(stack, context, tooltip, flagIn);
    }
}
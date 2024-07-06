package divinerpg.items.vanilla;

import divinerpg.enums.BulletType;
import divinerpg.items.base.ItemModRanged;
import divinerpg.registries.*;
import divinerpg.util.LocalizeUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.*;
import javax.annotation.Nullable;
import java.util.List;

public class ItemScythe extends ItemModRanged {
    public ItemScythe() {super(BulletType.SCYTHE_SHOT, SoundRegistry.DEEP_LAUGH.get(), 0, 10);}
    @Override protected void spawnEntity(Level world, Player player, ItemStack stack, BulletType bulletType, String entityType) {super.spawnEntity(world, player, stack, isJackoman(player) ? BulletType.MEGA_SCYTHE_SHOT : BulletType.SCYTHE_SHOT, null);}
    private boolean isJackoman(Player player) {
        return player.inventory.armor.get(0).is(ItemRegistry.jack_o_man_boots.get())
        		&& player.inventory.armor.get(1).is(ItemRegistry.jack_o_man_leggings.get())
        		&& player.inventory.armor.get(2).is(ItemRegistry.jack_o_man_chestplate.get())
        		&& player.inventory.armor.get(3).is(ItemRegistry.jack_o_man_helmet.get());
    }
	@OnlyIn(Dist.CLIENT)
    @Override public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.magicDam(BulletType.SCYTHE_SHOT.getDamage()));
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }
}
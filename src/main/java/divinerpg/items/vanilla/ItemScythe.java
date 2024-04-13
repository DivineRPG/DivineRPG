package divinerpg.items.vanilla;

import divinerpg.DivineRPG;
import divinerpg.enums.BulletType;
import divinerpg.items.base.ItemModRanged;
import divinerpg.registries.SoundRegistry;
import divinerpg.util.LocalizeUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.ForgeRegistries;
import javax.annotation.Nullable;
import java.util.List;

public class ItemScythe extends ItemModRanged {
    public ItemScythe() {super(Rarity.COMMON, "shooter_bullet", BulletType.SCYTHE_SHOT, SoundRegistry.DEEP_LAUGH, SoundSource.PLAYERS, -1, 0, null, 0);}
    @Override protected void spawnEntity(Level world, Player player, ItemStack stack, BulletType bulletType, String entityType) {super.spawnEntity(world, player, stack, isJackoman(player) ? BulletType.MEGA_SCYTHE_SHOT : BulletType.SCYTHE_SHOT, null);}
    @Override public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {if(Minecraft.getInstance().player != null) tooltip.add(LocalizeUtils.rangedDam(isJackoman(Minecraft.getInstance().player) ? BulletType.MEGA_SCYTHE_SHOT.getDamage() : BulletType.SCYTHE_SHOT.getDamage()));}
    private boolean isJackoman(Player player) {
        ItemStack stackBoots = player.inventory.armor.get(0);
        ItemStack stackLegs = player.inventory.armor.get(1);
        ItemStack stackBody = player.inventory.armor.get(2);
        ItemStack stackHelmet = player.inventory.armor.get(3);
        Item boots = stackBoots.getItem();
        Item body = stackBody.getItem();
        Item legs = stackLegs.getItem();
        Item helmet = stackHelmet.getItem();
        return boots == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "jack_o_man_boots")) && body == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "jack_o_man_chestplate")) && legs == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "jack_o_man_leggings")) && helmet == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "jack_o_man_helmet"));
    }
}
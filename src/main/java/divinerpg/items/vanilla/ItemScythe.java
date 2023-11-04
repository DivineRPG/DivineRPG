package divinerpg.items.vanilla;

import divinerpg.DivineRPG;
import divinerpg.enums.BulletType;
import divinerpg.items.base.ItemModRanged;
import divinerpg.registries.*;
import divinerpg.util.LocalizeUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.*;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.List;

public class ItemScythe extends ItemModRanged {
    private static Item boots, body = null, legs = null, helmet = null;

    public ItemScythe() {
        super(Rarity.COMMON,
                "shooter_bullet",
                BulletType.SCYTHE_SHOT,
                () -> SoundRegistry.DEEP_LAUGH.get(),
                SoundSource.MASTER,
                -1,
                0,
                null,
                0);
    }

    @Override
    protected void spawnEntity(Level world, Player player, ItemStack stack, BulletType bulletType, String entityType) {
        super.spawnEntity(world, player, stack, isJackoman(player)
                        ? BulletType.MEGA_SCYTHE_SHOT
                        : BulletType.SCYTHE_SHOT,
                null);
    }

    @SuppressWarnings("resource")
	@OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        if (Minecraft.getInstance().player != null)
            tooltip.add(LocalizeUtils.rangedDam(isJackoman(Minecraft.getInstance().player)
                    ? BulletType.MEGA_SCYTHE_SHOT.getDamage()
                    : BulletType.SCYTHE_SHOT.getDamage()));

        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }

    private boolean isJackoman(Player player) {

        ItemStack stackBoots = player.inventory.armor.get(0);
        ItemStack stackLegs = player.inventory.armor.get(1);
        ItemStack stackBody = player.inventory.armor.get(2);
        ItemStack stackHelmet = player.inventory.armor.get(3);

        if (stackBoots != null) boots = stackBoots.getItem();
        else boots = null;

        if (stackBody != null) body = stackBody.getItem();
        else body = null;

        if (stackLegs != null) legs = stackLegs.getItem();
        else legs = null;

        if (stackHelmet != null) helmet = stackHelmet.getItem();
        else helmet = null;


        return boots == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "jack_o_man_boots")) && body == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "jack_o_man_chestplate")) && legs == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "jack_o_man_leggings")) && helmet == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "jack_o_man_helmet"));
    }
}
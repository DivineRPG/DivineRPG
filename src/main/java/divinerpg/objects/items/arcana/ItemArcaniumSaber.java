package divinerpg.objects.items.arcana;

import divinerpg.api.DivineAPI;
import divinerpg.api.arcana.IArcana;
import divinerpg.objects.items.base.ItemModSword;
import divinerpg.registry.SoundRegistry;
import divinerpg.utils.LocalizeUtils;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

public class ItemArcaniumSaber extends ItemModSword {

    public ItemArcaniumSaber(String name, ToolMaterial var2) {
        super(var2, name);
        this.maxStackSize = 1;
        this.setMaxDamage(-1);
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
        IArcana arcana = DivineAPI.getArcana(player);
        if (arcana.getArcana() < 12) {
            return false;
        } else {
            player.playSound(SoundRegistry.ARCANIUM_SABER, 1, 1);
            arcana.consume(player, 12);
            return true;
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.arcanaConsumed(12));
        tooltip.add(LocalizeUtils.meleeDam(22));
    }
}
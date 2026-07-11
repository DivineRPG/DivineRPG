package divinerpg.items.iceika;

import divinerpg.blocks.base.PortalBlock;
import divinerpg.items.base.ItemMod;
import divinerpg.registries.*;
import divinerpg.util.LocalizeUtils;
import net.minecraft.core.*;
import net.minecraft.core.Direction.Axis;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.*;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.neoforged.api.distmarker.*;

import java.util.List;

public class ItemSnowGlobe extends ItemMod {
    public ItemSnowGlobe() {super(new Properties().stacksTo(1));}
    @OnlyIn(Dist.CLIENT)
    @Override public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.i18n("snow_globe"));
    }
}
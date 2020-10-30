package divinerpg.items.arcana;

import divinerpg.DivineRPG;
import divinerpg.entities.base.EntityDivineTameable;
import divinerpg.items.base.ItemMod;
import divinerpg.util.LocalizeUtils;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.*;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.*;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.*;

import javax.annotation.Nullable;
import java.util.*;

public class ItemSpawnEgg extends ItemMod {
    private final EntityType<?> typeIn;
    private final String langId;
    public ItemSpawnEgg(String name, EntityType<?> typeIn) {
        super(name, new Item.Properties().maxStackSize(1).group(DivineRPG.tabs.spawners));
        this.typeIn = typeIn;
        langId = "tooltip." + name;
    }

    public ActionResultType onItemUse(ItemUseContext context) {
        World world = context.getWorld();
        ItemStack stack = context.getItem();
        BlockPos pos = context.getPos();
        int x = pos.getX(), y = pos.getY(), z = pos.getZ();
        if (!world.isRemote) {
            EntityType entitytype = typeIn;
            Entity e = entitytype.create(world);
            e.setLocationAndAngles(x, y + 1, z, 0.0F, 0.0F);
            if(e instanceof EntityDivineTameable) {
                EntityDivineTameable ent = ((EntityDivineTameable)e);
                ent.setTamedBy(context.getPlayer());
            }
            world.addEntity(e);
            if(!context.getPlayer().isCreative()) {
                stack.shrink(1);
            }

        }
        return ActionResultType.FAIL;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.i18n(langId));
    }
}

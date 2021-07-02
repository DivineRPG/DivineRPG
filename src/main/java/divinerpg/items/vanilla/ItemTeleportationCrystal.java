package divinerpg.items.vanilla;

import divinerpg.*;
import divinerpg.items.base.*;
import divinerpg.util.*;
import divinerpg.util.teleport.*;
import net.minecraft.client.util.*;
import net.minecraft.entity.player.*;
import net.minecraft.inventory.*;
import net.minecraft.item.*;
import net.minecraft.server.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.util.text.*;
import net.minecraft.world.*;
import net.minecraft.world.gen.*;
import net.minecraftforge.common.util.*;

import javax.annotation.*;
import java.util.*;

public class ItemTeleportationCrystal extends ItemMod {

    public ItemTeleportationCrystal() {
        super("teleportation_crystal", new Item.Properties().durability(10).tab(DivineRPG.tabs.utilities));
    }

    public ItemTeleportationCrystal(String name, int durability) {
        super(name, new Item.Properties().durability(durability).tab(DivineRPG.tabs.utilities));
    }

    /**
     * Teleports player to current pos on current dimension
     *
     * @param player    - player
     * @param dimension - dimension to travel
     * @param pos       - pos to travel
     */
    public static void teleportToDimension(PlayerEntity player, RegistryKey<World> dimension, BlockPos pos) {
        if (player == null || dimension == null || pos == null)
            return;

        MinecraftServer server = player.getServer();
        if (server == null)
            return;


        if (player.level.dimension() != dimension) {
            ITeleporter teleporter = new SecondaryTeleporter(server.getLevel(dimension), pos.getX(), pos.getY(), pos.getZ());

            player.changeDimension(server.getLevel(dimension), teleporter);
        }

        player.moveTo(pos.getX(), pos.getY(), pos.getZ());
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.i18n("tooltip.teleport_bed_spawn"));
        tooltip.add(LocalizeUtils.usesRemaining(stack.getMaxDamage() - stack.getDamageValue()));
    }

    /**
     * Returns teleporting block position
     *
     * @param player - current player
     * @param stack  - curret item stack
     * @return
     */
    @Nullable
    protected BlockPos getSavedPos(PlayerEntity player, ItemStack stack) {
        BlockPos bedLocation = player.getSleepingPos().get();

        if (bedLocation != null) {
            if (player.getSleepingPos() == null) {
                bedLocation = player.level.getHeightmapPos(Heightmap.Type.WORLD_SURFACE, bedLocation);
            }
        } else {

            if (player.getServer() != null)
                bedLocation = player.getSleepingPos().get();
        }


        return bedLocation;
    }

    /**
     * Returns saved dimenstion to travel
     *
     * @param player - current player
     * @param stack  - current stack
     * @return
     */
    protected RegistryKey<World> getSavedDimType(PlayerEntity player, ItemStack stack) {
        return World.OVERWORLD;
    }

    @Override
    public ActionResult<ItemStack> use(World worldIn, PlayerEntity player, Hand hand) {

        ItemStack stack = player.getItemInHand(hand);

        if (!player.level.isClientSide) {
            BlockPos pos = getSavedPos(player, stack);
            RegistryKey<World> dimType = getSavedDimType(player, stack);

            teleportToDimension(player, dimType, pos);

            if (!player.isCreative()) {
                stack.hurtAndBreak(2, player, (p_220044_0_) -> {
                    p_220044_0_.broadcastBreakEvent(EquipmentSlotType.MAINHAND);
                });
            }
        }

        return new ActionResult<>(ActionResultType.SUCCESS, stack);
    }
}

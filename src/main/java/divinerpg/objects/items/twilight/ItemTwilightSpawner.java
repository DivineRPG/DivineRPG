package divinerpg.objects.items.twilight;

import divinerpg.objects.items.base.ItemMod;
import divinerpg.registry.DivineRPGTabs;
import divinerpg.registry.ModDimensions;
import divinerpg.utils.LocalizeUtils;
import divinerpg.utils.log.Logging;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ItemTwilightSpawner extends ItemMod {

    private final ResourceLocation[] entitiesIds;

    public ItemTwilightSpawner(String name, ResourceLocation... entitiesIds) {
        super(name);
        this.entitiesIds = entitiesIds;
        setMaxStackSize(1);
        this.setCreativeTab(DivineRPGTabs.spawner);
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing,
                                      float hitX, float hitY, float hitZ) {
        if (world.provider.getDimensionType().getId() != ModDimensions.mortumDimension.getId()) {
            Logging.message(player, LocalizeUtils.normal("tooltip.mortum_only", TextFormatting.AQUA));

            return EnumActionResult.FAIL;
        }

        List<Entity> entities = Arrays.stream(entitiesIds).map(x -> {
            try {
                Entity e = EntityList.createEntityByIDFromName(x, world);

                if (e != null) {
                    e.setPosition(pos.getX(), pos.getY() + 1, pos.getZ());
                }

                return e;
            } catch (Exception e) {
                e.printStackTrace();

            }
            return null;

        }).filter(Objects::nonNull).collect(Collectors.toList());

        if (!entities.isEmpty() && entities.stream().allMatch(x -> world.getCollisionBoxes(x, x.getEntityBoundingBox()).isEmpty())) {
            ItemStack stack = player.getHeldItem(hand);

            entities.forEach(x -> {
                world.spawnEntity(x);

                if (!player.isCreative()) {
                    stack.shrink(1);
                }
            });

            return EnumActionResult.SUCCESS;
        }

        return EnumActionResult.FAIL;
    }
}
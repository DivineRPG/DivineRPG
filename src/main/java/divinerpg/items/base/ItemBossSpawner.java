package divinerpg.items.base;

import divinerpg.*;
import divinerpg.registries.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.util.text.*;
import net.minecraft.world.*;
import net.minecraftforge.server.command.*;

public class ItemBossSpawner extends ItemMod {

    private RegistryKey<World> dimensionID;
    private final EntityType[] ents;
    private final String langKey;

    public ItemBossSpawner(String name, String langKey, RegistryKey<World> dimensionID, EntityType<?>... ents) {
        super(name, new Item.Properties().tab(DivineRPG.tabs.spawners).stacksTo(1));
        this.dimensionID = dimensionID;
        this.ents = ents;
        this.langKey = langKey;
    }

    @Override
    public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        if (!world.isClientSide) {
            if(dimensionID == null){
                dimensionID = KeyRegistry.MORTUM_WORLD;
            }
            if (world.dimension() != dimensionID) {
                TextComponent message = TextComponentHelper.createComponentTranslation(player, langKey);
                message.getStyle().withColor(TextFormatting.AQUA);
                player.sendMessage(message, player.getUUID());
                return ActionResult.fail(player.getItemInHand(hand));
            } else {
                for (EntityType<?> entType : ents) {
                    Entity entity = entType.create(world);
                    entity.moveTo(player.getX(), player.getY() + 1, player.getZ());
                    world.addFreshEntity(entity);
                    DivineRPG.LOGGER.info("spawned " + entType.getDescriptionId() + " at " + entity.blockPosition());
                    if(!player.isCreative())
                        player.getMainHandItem().shrink(1);
                    return ActionResult.success(player.getItemInHand(hand));
                }
            }
        }

        return ActionResult.fail(player.getItemInHand(hand));
    }
}
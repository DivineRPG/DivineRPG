package divinerpg.items.base;

import divinerpg.DivineRPG;
import divinerpg.registries.KeyRegistry;
import divinerpg.util.RarityList;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.text.TextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.server.command.TextComponentHelper;

public class ItemBossSpawner extends ItemMod {

    private RegistryKey<World> dimensionID;
    private final EntityType[] ents;
    private final String langKey;

    public ItemBossSpawner(String name, String langKey, RegistryKey<World> dimensionID, EntityType<?>... ents) {
        super(name, new Item.Properties().tab(DivineRPG.tabs.spawners).stacksTo(1).rarity(RarityList.BOSS));
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
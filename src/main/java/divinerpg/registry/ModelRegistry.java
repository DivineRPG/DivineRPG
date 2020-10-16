package divinerpg.registry;

import divinerpg.DivineRPG;
import divinerpg.client.render.*;
import divinerpg.objects.blocks.tile.entity.*;
import divinerpg.objects.blocks.tile.render.*;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.tileentity.TileEntityItemStackRenderer;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

import java.util.Arrays;
import java.util.Objects;

@Mod.EventBusSubscriber(value = Side.CLIENT, modid = DivineRPG.MODID)
public class ModelRegistry {

    @SubscribeEvent
    public static void registerItemModels(ModelRegistryEvent event) {
        for (Item item : ItemRegistry.itemMap.values()) {
            ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
        }
        registerTESRs();
    }

    public static void registerTESRs() {
        Item.getItemFromBlock(BlockRegistry.boneChest).setTileEntityItemStackRenderer(new RenderItemBoneChest());
        Item.getItemFromBlock(BlockRegistry.edenChest).setTileEntityItemStackRenderer(new RenderItemEdenChest());
        Item.getItemFromBlock(BlockRegistry.frostedChest).setTileEntityItemStackRenderer(new RenderItemFrostedChest());
        Item.getItemFromBlock(BlockRegistry.presentBox).setTileEntityItemStackRenderer(new RenderItemPresentBox());
        Item.getItemFromBlock(BlockRegistry.demonFurnace).setTileEntityItemStackRenderer(new RenderItemDemonFurnace());
        Item.getItemFromBlock(BlockRegistry.arcaniumExtractor).setTileEntityItemStackRenderer(new RenderItemArcaniumExtractor());
        Item.getItemFromBlock(BlockRegistry.dramixAltar).setTileEntityItemStackRenderer(new RenderItemDramixAltar());
        Item.getItemFromBlock(BlockRegistry.parasectaAltar).setTileEntityItemStackRenderer(new RenderItemParasectaAltar());
        Item.getItemFromBlock(BlockRegistry.frostedChest).setTileEntityItemStackRenderer(new RenderItemFrostedChest());
        ItemRegistry.nightmareBed.setTileEntityItemStackRenderer(new RenderItemNightmareBed());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDramixAltar.class, new RenderDramixAltar());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityParasectaAltar.class, new RenderParasectaAltar());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFrostedChest.class, new RenderFrostedChest());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAyeracoBeam.class, new RenderAyeracoBeam());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAyeracoSpawn.class, new RenderAyeracoSpawn());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDemonFurnace.class, new RenderDemonFurnace());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityArcaniumExtractor.class, new RenderArcaniumExtractor());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPresentBox.class, new RenderPresentBox());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBoneChest.class, new RenderBoneChest());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAltarOfCorruption.class, new RenderAltarOfCorruption());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityStatue.class, new RenderStatue());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityEdenChest.class, new RenderEdenChest());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityNightmareBed.class, new RenderNightmareBed());

        registerRenders(new RenderItemStatue(),
                BlockRegistry.ancientEntityStatue,
                BlockRegistry.ayeracoRedStatue,
                BlockRegistry.ayeracoGreenStatue,
                BlockRegistry.ayeracoBlueStatue,
                BlockRegistry.ayeracoYellowStatue,
                BlockRegistry.ayeracoPurpleStatue,
                BlockRegistry.densosStatue,
                BlockRegistry.dramixStatue,
                BlockRegistry.eternalArcherStatue,
                BlockRegistry.karotStatue,
                BlockRegistry.kingOfScorchersStatue,
                BlockRegistry.parasectaStatue,
                BlockRegistry.soulFiendStatue,
                BlockRegistry.reyvorStatue,
                BlockRegistry.theWatcherStatue,
                BlockRegistry.twilightDemonStatue,
                BlockRegistry.vamacheronStatue,
                BlockRegistry.termasect_statue,
                BlockRegistry.sunstorm_statue,
                BlockRegistry.experienced_cori_statue
        );

        registerRenders(new ShieldsRender(),
                ItemRegistry.arlemite_shield,
                ItemRegistry.realmite_shield,
                ItemRegistry.rupee_shield,
                ItemRegistry.halite_shield,
                ItemRegistry.eden_shield,
                ItemRegistry.wildwood_shield,
                ItemRegistry.apalachia_shield,
                ItemRegistry.skythern_shield,
                ItemRegistry.mortum_shield
        );
    }

    private static void registerRenders(TileEntityItemStackRenderer teisr, Block... items) {
        if (teisr == null || items == null)
            return;

        registerRenders(teisr, Arrays.stream(items).map(Item::getItemFromBlock).toArray(Item[]::new));
    }

    private static void registerRenders(TileEntityItemStackRenderer teisr, Item... items) {
        if (teisr == null || items == null)
            return;

        Arrays.stream(items).filter(Objects::nonNull).forEach(x -> x.setTileEntityItemStackRenderer(teisr));
    }
}
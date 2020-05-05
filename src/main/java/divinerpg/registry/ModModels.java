package divinerpg.registry;

import divinerpg.api.Reference;
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

@Mod.EventBusSubscriber(value = Side.CLIENT, modid = Reference.MODID)
public class ModModels {

    @SubscribeEvent
    public static void registerItemModels(ModelRegistryEvent event) {
        for (Item item : ModItems.itemMap.values()) {
            ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
        }
        registerTESRs();
    }

    public static void registerTESRs() {
        Item.getItemFromBlock(ModBlocks.boneChest).setTileEntityItemStackRenderer(new RenderItemBoneChest());
        Item.getItemFromBlock(ModBlocks.edenChest).setTileEntityItemStackRenderer(new RenderItemEdenChest());
        Item.getItemFromBlock(ModBlocks.frostedChest).setTileEntityItemStackRenderer(new RenderItemFrostedChest());
        Item.getItemFromBlock(ModBlocks.presentBox).setTileEntityItemStackRenderer(new RenderItemPresentBox());
        Item.getItemFromBlock(ModBlocks.demonFurnace).setTileEntityItemStackRenderer(new RenderItemDemonFurnace());
        Item.getItemFromBlock(ModBlocks.arcaniumExtractor).setTileEntityItemStackRenderer(new RenderItemArcaniumExtractor());
        Item.getItemFromBlock(ModBlocks.dramixAltar).setTileEntityItemStackRenderer(new RenderItemDramixAltar());
        Item.getItemFromBlock(ModBlocks.parasectaAltar).setTileEntityItemStackRenderer(new RenderItemParasectaAltar());
        Item.getItemFromBlock(ModBlocks.frostedChest).setTileEntityItemStackRenderer(new RenderItemFrostedChest());
        ModItems.nightmareBed.setTileEntityItemStackRenderer(new RenderItemNightmareBed());
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
                ModBlocks.ancientEntityStatue,
                ModBlocks.ayeracoRedStatue,
                ModBlocks.ayeracoGreenStatue,
                ModBlocks.ayeracoBlueStatue,
                ModBlocks.ayeracoYellowStatue,
                ModBlocks.ayeracoPurpleStatue,
                ModBlocks.densosStatue,
                ModBlocks.dramixStatue,
                ModBlocks.eternalArcherStatue,
                ModBlocks.karotStatue,
                ModBlocks.kingOfScorchersStatue,
                ModBlocks.parasectaStatue,
                ModBlocks.soulFiendStatue,
                ModBlocks.reyvorStatue,
                ModBlocks.theWatcherStatue,
                ModBlocks.twilightDemonStatue,
                ModBlocks.vamacheronStatue,
                ModBlocks.termasect_statue,
                ModBlocks.sunstorm_statue,
                ModBlocks.experienced_cori_statue
        );

        registerRenders(new ShieldsRender(),
                ModItems.arlemite_shield,
                ModItems.realmite_shield,
                ModItems.rupee_shield,
                ModItems.halite_shield,
                ModItems.eden_shield,
                ModItems.wildwood_shield,
                ModItems.apalachia_shield,
                ModItems.skythern_shield,
                ModItems.mortum_shield
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
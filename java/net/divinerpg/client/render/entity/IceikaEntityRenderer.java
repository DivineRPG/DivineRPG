package net.divinerpg.client.render.entity;

import net.divinerpg.blocks.iceika.container.tile_entity.TileEntityFrostedChest;
import net.divinerpg.client.render.EntityResourceLocation;
import net.divinerpg.client.render.RenderDivineMob;
import net.divinerpg.client.render.RenderProjectile;
import net.divinerpg.client.render.RenderSizeable;
import net.divinerpg.client.render.block.RenderTileEntityFrostedChest;
import net.divinerpg.client.render.block.item_renderer.ItemRendererFrostedChest;
import net.divinerpg.client.render.entity.iceika.model.ModelAlicanto;
import net.divinerpg.client.render.entity.iceika.model.ModelFractite;
import net.divinerpg.client.render.entity.iceika.model.ModelGlacide;
import net.divinerpg.client.render.entity.iceika.model.ModelHastreus;
import net.divinerpg.client.render.entity.iceika.model.ModelRollum;
import net.divinerpg.client.render.entity.iceika.model.ModelWorkshop;
import net.divinerpg.entities.iceika.EntityAlicanto;
import net.divinerpg.entities.iceika.EntityFractite;
import net.divinerpg.entities.iceika.EntityFrostArcher;
import net.divinerpg.entities.iceika.EntityGlacide;
import net.divinerpg.entities.iceika.EntityHastreus;
import net.divinerpg.entities.iceika.EntityRollum;
import net.divinerpg.entities.iceika.EntityWorkshopMerchant;
import net.divinerpg.entities.iceika.EntityWorkshopTinkerer;
import net.divinerpg.entities.iceika.projectile.EntityCarol;
import net.divinerpg.entities.iceika.projectile.EntityFrostclaw;
import net.divinerpg.entities.iceika.projectile.EntityMusic;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.blocks.IceikaBlocks;
import net.minecraft.client.model.ModelBiped;
import net.minecraftforge.client.MinecraftForgeClient;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class IceikaEntityRenderer {

    public static void init() {

        RenderingRegistry.registerEntityRenderingHandler(EntityCarol.class, new RenderProjectile(EntityResourceLocation.music));
        RenderingRegistry.registerEntityRenderingHandler(EntityMusic.class, new RenderProjectile(EntityResourceLocation.music));
        RenderingRegistry.registerEntityRenderingHandler(EntityFrostclaw.class, new RenderProjectile(EntityResourceLocation.frostclaw));

        RenderingRegistry.registerEntityRenderingHandler(EntityAlicanto.class, new RenderDivineMob(new ModelAlicanto(), 0.0F, EntityResourceLocation.ALICANTO));
        RenderingRegistry.registerEntityRenderingHandler(EntityFractite.class, new RenderDivineMob(new ModelFractite(), 0.5F, EntityResourceLocation.FRACTITE));
        RenderingRegistry.registerEntityRenderingHandler(EntityGlacide.class, new RenderSizeable(new ModelGlacide(), 0.0F, 1.0F, EntityResourceLocation.GLACON));
        RenderingRegistry.registerEntityRenderingHandler(EntityHastreus.class, new RenderDivineMob(new ModelHastreus(), 0.0F, EntityResourceLocation.HASTERUS));
        RenderingRegistry.registerEntityRenderingHandler(EntityFrostArcher.class, new RenderDivineMob(new ModelBiped(), 0.0F, EntityResourceLocation.FROZEN_ARCHER));
        RenderingRegistry.registerEntityRenderingHandler(EntityRollum.class, new RenderDivineMob(new ModelRollum(), 0.0F, EntityResourceLocation.ROLLUM));
        RenderingRegistry.registerEntityRenderingHandler(EntityWorkshopTinkerer.class, new RenderDivineMob(new ModelWorkshop(), 0.0F, EntityResourceLocation.WORKSHOP_TINKER));
        RenderingRegistry.registerEntityRenderingHandler(EntityWorkshopMerchant.class, new RenderDivineMob(new ModelWorkshop(), 0.0F, EntityResourceLocation.WORKSHOP_MERCHANT));

        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFrostedChest.class, new RenderTileEntityFrostedChest());
        MinecraftForgeClient.registerItemRenderer(Util.toItem(IceikaBlocks.frostedChest), new ItemRendererFrostedChest());

    }
}

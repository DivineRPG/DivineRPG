package net.divinerpg.registries;

import net.divinerpg.entities.projectile.DivineThrownItem;
import net.divinerpg.entities.projectile.Tomato;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.registries.DeferredHolder;

import static net.divinerpg.DivineRPG.MODID;
import static net.divinerpg.registries.DivineRegistries.ENTITIES;

public class EntityRegistry {

    public static final DeferredHolder<EntityType<?>, EntityType<DivineThrownItem>> THROWN_ITEM = registerProjectile(DivineThrownItem::new, "thrown_item");
    public static final DeferredHolder<EntityType<?>, EntityType<Tomato>> TOMATO = registerProjectile(Tomato::new, "tomato");

    private static ResourceKey<EntityType<?>> key(String name) {
        return ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath(MODID, name));
    }

    private static <T extends Entity> DeferredHolder<EntityType<?>, EntityType<T>> registerProjectile(EntityType.EntityFactory<T> factory, String name) {
        return ENTITIES.register(name, () -> EntityType.Builder.of(factory, MobCategory.MISC).build(key(name)));
    }

    private static <T extends Entity> DeferredHolder<EntityType<?>, EntityType<T>> registerArrowProjectile(EntityType.EntityFactory<T> factory, String name) {
        return ENTITIES.register(name, () -> EntityType.Builder.of(factory, MobCategory.MISC).build(key(name)));
    }

    private static <T extends Entity> DeferredHolder<EntityType<?>, EntityType<T>> registerFireImmuneArrowProjectile(EntityType.EntityFactory<T> factory, String name) {
        return ENTITIES.register(name, () -> EntityType.Builder.of(factory, MobCategory.MISC).fireImmune().build(key(name)));
    }

    private static <T extends Entity> DeferredHolder<EntityType<?>, EntityType<T>> registerFireballProjectile(EntityType.EntityFactory<T> factory, String name) {
        return ENTITIES.register(name, () -> EntityType.Builder.of(factory, MobCategory.MISC).build(key(name)));
    }

    private static <T extends Entity> DeferredHolder<EntityType<?>, EntityType<T>> registerEntity(EntityType.EntityFactory<T> factory, String name, float width, float height, float eyeHeight) {
        return ENTITIES.register(name, () -> EntityType.Builder.of(factory, MobCategory.MONSTER).sized(width, height).build(key(name)));
    }

    private static <T extends Entity> DeferredHolder<EntityType<?>, EntityType<T>> registerEntity(EntityType.EntityFactory<T> factory, String name, float width, float height, float eyeHeight, int eggPrimary, int eggSecondary) {
        return ENTITIES.register(name, () -> EntityType.Builder.of(factory, MobCategory.MONSTER).sized(width, height).build(key(name)));
    }

    private static <T extends Entity> DeferredHolder<EntityType<?>, EntityType<T>> registerEntity(EntityType.EntityFactory<T> factory, String name, float width, float height, float eyeHeight, int eggPrimary, int eggSecondary, MobCategory category) {
        return ENTITIES.register(name, () -> EntityType.Builder.of(factory, category).sized(width, height).build(key(name)));
    }

    private static <T extends Entity> DeferredHolder<EntityType<?>, EntityType<T>> registerEntity(EntityType.EntityFactory<T> factory, String name, float width, float height, float eyeHeight, MobCategory category) {
        return ENTITIES.register(name, () -> EntityType.Builder.of(factory, category).sized(width, height).build(key(name)));
    }

    private static <T extends Entity> DeferredHolder<EntityType<?>, EntityType<T>> registerEntityFireImmune(EntityType.EntityFactory<T> factory, String name, float width, float height, float eyeHeight, int eggPrimary, int eggSecondary) {
        return ENTITIES.register(name, () -> EntityType.Builder.of(factory, MobCategory.MONSTER).fireImmune().sized(width, height).build(key(name)));
    }

    private static <T extends Entity> DeferredHolder<EntityType<?>, EntityType<T>> registerEntityFireImmune(EntityType.EntityFactory<T> factory, String name, float width, float height, float eyeHeight, MobCategory category) {
        return ENTITIES.register(name, () -> EntityType.Builder.of(factory, category).fireImmune().sized(width, height).build(key(name)));
    }


    @SubscribeEvent
    public static void registerRenders(EntityRenderersEvent.RegisterRenderers event){
        event.registerEntityRenderer(THROWN_ITEM.get(), ThrownItemRenderer::new);
        event.registerEntityRenderer(TOMATO.get(), ThrownItemRenderer::new);
    }

    public static void load() {}
}